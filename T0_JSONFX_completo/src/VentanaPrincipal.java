import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VentanaPrincipal extends JFrame implements ActionListener, ListSelectionListener {
    JButton loadData;
    JLabel trophy, image;
    JList leaguelist;
    JTextArea dataList;
    DefaultListModel listModel;
    JPanel centralPanel, upPanel, centralPanelCentre;
    Container container;

    public VentanaPrincipal() {
    }

    public void initGUI() {
        instances();
        setContainer();
        actions();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(1700, 800));
        this.setLocationRelativeTo(null);
    }

    private void instances() {
        container = this.getContentPane();
        loadData = new JButton("Load teams");
        trophy = new JLabel("Teams of England");
        image = new JLabel("");
        dataList = new JTextArea();
        listModel = new DefaultListModel();
        leaguelist = new JList(listModel);
        centralPanel = new JPanel();
        upPanel = new JPanel();
        centralPanelCentre = new JPanel();
    }

    private void actions() {
        loadData.addActionListener(this);
        leaguelist.addListSelectionListener(this);
    }


    private void setContainer() {
        this.setLayout(new BorderLayout());
        this.add(setUp(), BorderLayout.NORTH);
        this.add(setCentre(), BorderLayout.CENTER);
    }

    private JPanel setUp() {
        upPanel.setLayout(new FlowLayout());
        upPanel.add(trophy, BorderLayout.NORTH);
        return upPanel;
    }

    private JPanel setCentre() {
        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(setCentralCentre(), BorderLayout.CENTER);
        centralPanel.add(loadData, BorderLayout.SOUTH);
        return centralPanel;
    }

    private JPanel setCentralCentre() {
        centralPanelCentre.setLayout(new GridLayout(1, 3));
        centralPanelCentre.setBackground(Color.red);
        centralPanelCentre.add(new JScrollPane(leaguelist));
        centralPanelCentre.add(image);
        centralPanelCentre.add(new JScrollPane(dataList));
        return centralPanelCentre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadData) {
            listModel.clear();
            new MiWorker().execute();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == leaguelist) {
            Leagues selection = (Leagues) listModel.getElementAt(leaguelist.getSelectedIndex());
            String link = String.format("%s", selection.getStrTeamBadge());
            String link2 = String.format("Name of the team: " + "%s" + "%n%n Liga: " + "%s" + "%n%n Name of the stadium: " + "%s" + "%n%n Description: " + "%s", selection.getStrTeam(),selection.getStrLeague(),selection.getStrStadium(),selection.getStrDescriptionEN());
            URL urlImage;
            try {
                urlImage = new URL(link);
                BufferedImage imageInternet = ImageIO.read(urlImage);
                image.setIcon(new ImageIcon(imageInternet));
                dataList.setText(link2);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    class MiWorker extends SwingWorker<Boolean, Void> {
        URL url;
        HttpURLConnection connection;
        BufferedReader reader;
        StringBuilder stringBuilder = new StringBuilder();

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                url = new URL("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=England");
                connection = (HttpURLConnection) url.openConnection();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject jsonComplete = new JSONObject(stringBuilder.toString());
            JSONArray jsonArrayResults = jsonComplete.getJSONArray("teams");
            for (int i = 0; i < jsonArrayResults.length(); i++) {
                if (i == 0) {
                    loadData.setEnabled(false);
                } else if (i == jsonArrayResults.length() - 1) {
                    loadData.setEnabled(true);
                }
                JSONObject objeto = jsonArrayResults.getJSONObject(i);
                Gson gson = new Gson();
                Leagues leagues = gson.fromJson(objeto.toString(), Leagues.class);
                listModel.addElement(leagues);
                Thread.sleep(100);
            }
            return true;
        }
    }
}