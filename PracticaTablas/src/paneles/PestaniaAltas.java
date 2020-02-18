package paneles;

import practicatablas.Ventana;
import utils.Persona;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PestaniaAltas extends JPanel implements ActionListener {

    JLabel clave, nombre, apellidos, edad, calle, numero, codigoPostal;
    
    JTextField textoClave, terxtoNombre, textoApellidos, textoEdad, textoCalle, textoNumero, textoCodigoPostal;

    JButton botonAlta;
    
    JPanel panelCentro, panelInferior, panelSuperior;

    Border bordeDatos, bordeDireccion;

    static Persona persona_registro;
    
    Ventana ventana;

    public PestaniaAltas() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configSuperior(), BorderLayout.NORTH);
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInferior(), BorderLayout.SOUTH);
    }

    private JPanel configSuperior() {
        panelSuperior.setLayout(new GridLayout(4, 2));

        panelSuperior.setBorder(bordeDatos);

        panelSuperior.add(clave);
        panelSuperior.add(textoClave);
        panelSuperior.add(nombre);
        panelSuperior.add(terxtoNombre);
        panelSuperior.add(apellidos);
        panelSuperior.add(textoApellidos);
        panelSuperior.add(edad);
        panelSuperior.add(textoEdad);

        return panelSuperior;
    }

    private JPanel configCentro() {
        panelCentro.setLayout(new GridLayout(3, 2));
        panelCentro.setBorder(bordeDireccion);
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
        return panelInferior;
    }

    private void acciones() {
        botonAlta.addActionListener(this);
        textoClave.addKeyListener(new ManejoTeclas());
        textoEdad.addKeyListener(new ManejoTeclas());
        textoNumero.addKeyListener(new ManejoTeclas());
        textoCodigoPostal.addKeyListener(new ManejoTeclas());
    }

    private void instancias() {

        clave = new JLabel("Clave:");
        nombre = new JLabel("Nombre:");
        apellidos = new JLabel("Apellidos:");
        edad = new JLabel("Edad:");
        calle = new JLabel("Calle:");
        numero = new JLabel("Número");
        codigoPostal = new JLabel("Código Postal:");

        textoClave = new JTextField();
        terxtoNombre = new JTextField();
        textoApellidos = new JTextField();
        textoEdad = new JTextField();
        textoCalle = new JTextField();
        textoNumero = new JTextField();
        textoCodigoPostal = new JTextField();

        botonAlta = new JButton("Dar de Alta");

        panelCentro = new JPanel();
        panelInferior = new JPanel();
        panelSuperior = new JPanel();

        bordeDatos = new TitledBorder(new EtchedBorder(), "Datos Personales");
        bordeDireccion = new TitledBorder(new EtchedBorder(), "Dirección");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!textoClave.getText().toString().isEmpty() && !terxtoNombre.getText().toString().isEmpty()
                && !textoApellidos.getText().toString().isEmpty() && !textoEdad.getText().toString().isEmpty()
                && !textoCalle.getText().toString().isEmpty() && !textoNumero.getText().toString().isEmpty() && !textoCodigoPostal.getText().toString().isEmpty()){

            if (e.getSource() == botonAlta){
                int clave_alta = Integer.valueOf(textoClave.getText().toString());
                String nombre_alta = terxtoNombre.getText().toString();
                String apellido_alta = textoApellidos.getText().toString();
                int edad_alta = Integer.valueOf(textoEdad.getText().toString());
                String calle_alta = textoCalle.getText().toString();
                int numero_alta = Integer.valueOf(textoNumero.getText().toString());
                int CP_alta  = Integer.valueOf(textoCodigoPostal.getText().toString());

                persona_registro = new Persona(clave_alta, nombre_alta, apellido_alta, edad_alta, calle_alta, numero_alta, CP_alta);
                ventana.getListaEmpleados().add(persona_registro);
                ventana.getModeloClaves().addElement(persona_registro);
                ventana.getComboClaves().setModel(ventana.getModeloClaves());
            }
        } else {
            JOptionPane.showMessageDialog(PestaniaAltas.this,"Atención, faltan datos", "Advertencia",JOptionPane.WARNING_MESSAGE, null);
        }
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