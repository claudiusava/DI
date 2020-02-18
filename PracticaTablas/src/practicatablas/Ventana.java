package practicatablas;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paneles.*;
import utils.Persona;

public class Ventana extends JFrame {

    Container container;
    PestaniaAltas pestaniaAltas;
    PestaniaBajas pestaniaBajas;
    PestaniaModificaciones pestaniaModificaciones;
    PestaniaResumen pestaniaResumen;
    JTabbedPane panelPestanias;
    JComboBox comboClaves;
    DefaultComboBoxModel modeloClaves;
    ArrayList<Persona> listaPersonas;

    public void initGUI() {
        instancias();
        configurarContainer();
        this.setSize(new Dimension(450, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaAltas = new PestaniaAltas();
        pestaniaBajas = new PestaniaBajas();
        pestaniaModificaciones = new PestaniaModificaciones();
        pestaniaResumen = new PestaniaResumen();
        modeloClaves = new DefaultComboBoxModel();
        comboClaves = new JComboBox();
        listaPersonas = new ArrayList();
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Altas", pestaniaAltas);
        panelPestanias.addTab("Bajas", pestaniaBajas);
        panelPestanias.addTab("Modificaciones", pestaniaModificaciones);
        panelPestanias.addTab("Resumen", pestaniaResumen);
    }

    public DefaultComboBoxModel getModeloClaves() {
        return modeloClaves;
    }

    public void ModeloClaves(DefaultComboBoxModel modeloClaves) {
        this.modeloClaves = modeloClaves;
    }

    public JComboBox getComboClaves() {
        return comboClaves;
    }
    
    public ArrayList<Persona> getListaEmpleados() {
        return getListaEmpleados();
    }
}