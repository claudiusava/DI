
package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;

public class PestaniaDos extends JPanel implements ActionListener, ChangeListener {
    JLabel telf, dni, aniosEx, estudios, resulBus;
    JTextField txtTelf, txtDni, txtEstudios, txtResult;
    JButton btnBuscar, btnSalir;
    JComboBox<String> trabajos;
    JSpinner aniosExperiencia;
    SpinnerNumberModel modeloAnios;
    JTextArea resultados;

    JPanel panelCentro, panelInf;
    Container container;

    public PestaniaDos() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
    }

    private void instancias() {
        telf = new JLabel("Teléfono");
        dni = new JLabel("DNI");
        aniosEx = new JLabel("Años de experiencia");
        estudios = new JLabel("Seleciona tus estudios");
        resulBus = new JLabel("Resultados de búsqueda");
        txtTelf = new JTextField();
        txtDni = new JTextField();
        txtEstudios = new JTextField();
        txtResult = new JTextField();
        resultados = new JTextArea();
        btnBuscar = new JButton("Buscar");
        btnSalir = new JButton("Salir");
        modeloAnios = new SpinnerNumberModel(0, 0, 50, 1);
        aniosExperiencia = new JSpinner(modeloAnios);
        trabajos = new JComboBox();
        trabajos.addItem("Ingenieria Informatica");
        trabajos.addItem("Ingenieria Industrial");
        trabajos.addItem("Ingenieria Telecomunicaciones");
        trabajos.addItem("Arquitectura");
        trabajos.addItem("Derecho");
        panelCentro = new JPanel();
        panelInf = new JPanel();

    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInf(), BorderLayout.SOUTH);

    }

    private void configurarConstrait(int x, int y, int tx, int ty, double px, double py, int anchor, int fill, Component c) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.anchor = anchor;
        constraints.fill = fill;
        panelCentro.add(c, constraints);
    }

    private JPanel configCentro() {
        this.setLayout(new BorderLayout());
        panelCentro.setLayout(new GridBagLayout());
        configurarConstrait(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, telf);
        configurarConstrait(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtTelf);
        configurarConstrait(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, dni);
        configurarConstrait(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtDni);
        configurarConstrait(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, aniosEx);
        configurarConstrait(1, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, aniosExperiencia);
        configurarConstrait(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, estudios);
        configurarConstrait(0, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, trabajos);
        configurarConstrait(0, 7, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, resulBus);
        configurarConstrait(0, 8, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, resultados);

        return panelCentro;
    }

    public JPanel configInf() {
        panelInf.add(btnBuscar);
        panelInf.add(btnSalir);
        return panelInf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
