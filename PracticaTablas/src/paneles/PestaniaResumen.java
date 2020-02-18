package paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloSimple;
import utils.Persona;

public class PestaniaResumen extends JPanel {

    ArrayList<Persona> personas;

    JLabel clave, nombre, apellidos, edad, calle, numero, codigoPostal;
    
    JTextField textoClave, textoNombre, textoApellido, textoEdad, textoCalle, textoNumero, textoCodigoPostal;

    JButton botonAlta, botonBaja;
    
    JPanel panelCentro, panelInferior, panelSuperior;

    Border bordeDatos;
    
    JTable tabla;
    
    ModeloSimple modeloSimple;

    JScrollPane scroll;

    public PestaniaResumen() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(scroll, BorderLayout.NORTH);
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInferior(), BorderLayout.SOUTH);
    }

    private JPanel configCentro() {
        panelCentro.setLayout(new GridLayout(7, 2));
        panelCentro.setBorder(bordeDatos);
        panelCentro.add(clave);
        panelCentro.add(textoClave);
        panelCentro.add(nombre);
        panelCentro.add(textoNombre);
        panelCentro.add(apellidos);
        panelCentro.add(textoApellido);
        panelCentro.add(edad);
        panelCentro.add(textoEdad);
        panelCentro.add(calle);
        panelCentro.add(textoCalle);
        panelCentro.add(numero);
        panelCentro.add(textoNumero);
        panelCentro.add(codigoPostal);
        panelCentro.add(textoCodigoPostal);

        return panelCentro;
    }

    private JPanel configInferior() {
        panelInferior.add(botonAlta);
        panelInferior.add(botonBaja);
        return panelInferior;
    }

    private void acciones() {
        textoClave.addKeyListener(new ManejoTeclas());
        textoEdad.addKeyListener(new ManejoTeclas());
        textoNumero.addKeyListener(new ManejoTeclas());
        textoCodigoPostal.addKeyListener(new ManejoTeclas());
    }

    private void instancias() {

        ArrayList personas = new ArrayList();

        clave = new JLabel("Clave");
        nombre = new JLabel("Nombre:");
        apellidos = new JLabel("Apellidos:");
        edad = new JLabel("Edad:");
        calle = new JLabel("Calle:");
        numero = new JLabel("Número");
        codigoPostal = new JLabel("Código Postal:");

        textoClave = new JTextField();
        textoNombre = new JTextField();
        textoApellido = new JTextField();
        textoEdad = new JTextField();
        textoCalle = new JTextField();
        textoNumero = new JTextField();
        textoCodigoPostal = new JTextField();

        botonAlta = new JButton("Dar de Alta");
        botonBaja = new JButton("Dar de Baja");

        panelCentro = new JPanel();
        panelInferior = new JPanel();
        panelSuperior = new JPanel();

        bordeDatos = new TitledBorder(new EtchedBorder(), "Datos Personales");

        modeloSimple = new ModeloSimple(personas);
        tabla = new JTable(modeloSimple);

        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(100, 100));
    }
    
    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (e.getSource() == textoClave) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoClave.getText().length() > 4) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == textoEdad) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoEdad.getText().length() > 2) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == textoNumero){
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoNumero.getText().length() > 8) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == textoCodigoPostal){
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoCodigoPostal.getText().length() > 4) {
                        e.consume();
                    }
                }
            }
        }
    }
}