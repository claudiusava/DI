package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PestaniaBajas extends JPanel {

    JLabel clave, nombre, apellidos, edad, calle, numero, codigoPostal;
    
    JTextField textoNombre, textoApellido, textoEdad, textoCalle, textoNumero, textoCodigoPostal;

    JPanel panelCentro, panelInferior, panelSuperior, panelDatos, panelDireccion;
    
    Border bordeDatos, bordeDireccion, bordeSeleccion;
    
    JComboBox<String> ComboClave;
    
    DefaultComboBoxModel modeloClaves;
    
    JButton botonBaja;

    public PestaniaBajas() {
        initGUI();
    }

    private void initGUI() {

        instancias();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configSuperior(), BorderLayout.NORTH);
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInferior(), BorderLayout.SOUTH);
    }

    private JPanel configSuperior() {
        panelSuperior.setLayout(new GridLayout(1, 1));
        panelSuperior.setBorder(bordeSeleccion);
        panelSuperior.add(clave);
        panelSuperior.add(ComboClave);
        return panelSuperior;
    }

    private JPanel configCentro() {
        panelCentro.setLayout(new GridLayout(2, 1));
        panelCentro.add(configCentroDatos());
        panelCentro.add(configCentroDireccion());
        return panelCentro;
    }

    private JPanel configCentroDatos() {

        panelDatos.setLayout(new GridLayout(3, 2));
        panelDatos.setBorder(bordeDatos);
        panelDatos.add(nombre);
        panelDatos.add(textoNombre);
        textoNombre.setEditable(false);
        
        panelDatos.add(apellidos);
        panelDatos.add(textoApellido);
        textoApellido.setEditable(false);

        panelDatos.add(edad);
        panelDatos.add(textoEdad);
        textoEdad.setEditable(false);

        return panelDatos;
    }

    private JPanel configCentroDireccion() {

        panelDireccion.setLayout(new GridLayout(3, 2));
        panelDireccion.setBorder(bordeDireccion);
        panelDireccion.add(calle);

        panelDireccion.add(textoCalle);
        textoCalle.setEditable(false);

        panelDireccion.add(numero);

        panelDireccion.add(textoNumero);
        textoNumero.setEditable(false);

        panelDireccion.add(codigoPostal);
        panelDireccion.add(textoCodigoPostal);
        textoCodigoPostal.setEditable(false);

        return panelDireccion;
    }

    private JPanel configInferior() {
        panelInferior.add(botonBaja);
        return panelInferior;
    }

    private void instancias() {

        clave = new JLabel("Clave");
        nombre = new JLabel("Nombre:");
        apellidos = new JLabel("Apellidos:");
        edad = new JLabel("Edad:");
        calle = new JLabel("Calle:");
        numero = new JLabel("Número");
        codigoPostal = new JLabel("Código Postal:");

        textoNombre = new JTextField();
        textoApellido = new JTextField();
        textoEdad = new JTextField();
        textoCalle = new JTextField();
        textoNumero = new JTextField();
        textoCodigoPostal = new JTextField();

        botonBaja = new JButton("Dar de Baja");
        ComboClave = new JComboBox();
        modeloClaves = new DefaultComboBoxModel();

        panelCentro = new JPanel();
        panelDatos = new JPanel();
        panelDireccion = new JPanel();
        panelInferior = new JPanel();
        panelSuperior = new JPanel();

        bordeDatos = new TitledBorder(new EtchedBorder(), "Datos Personales");
        bordeDireccion = new TitledBorder(new EtchedBorder(), "Direccion");
        bordeSeleccion = new TitledBorder(new EtchedBorder(), "Selección clave");
    }

}