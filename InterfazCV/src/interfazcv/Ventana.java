
package interfazcv;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import paneles.PestaniaDos;
import paneles.PestaniaUno;
import utils.Persona;

public class Ventana extends JFrame{
     Container container;
    public static ArrayList<Persona> listadoPersonas;
    PestaniaUno pestaniaEntrega;
    PestaniaDos pestaniaBuscador;
    JTabbedPane panelPestanias;

    public void initGUI() {

        instancias();
        configurarContainer();
        this.setSize(new Dimension(700, 250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Datos", pestaniaEntrega);
        panelPestanias.addTab("Buscador", pestaniaBuscador);
    }

    private void instancias() {

        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaEntrega = new PestaniaUno();
        pestaniaBuscador = new PestaniaDos();
        listadoPersonas = new ArrayList<>();
    }
}
