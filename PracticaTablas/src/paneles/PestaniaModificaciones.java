package paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PestaniaModificaciones extends JPanel implements ActionListener{

    JLabel clave, nombre, apellidos, edad, calle, numero, codigoPostal;
    
    JTextField textoNombre, textoApellido, textoEdad, textoCalle, textoNumero, textoCodigoPostal;

    JPanel panelCentro, panelInferior, panelSuperior, panelDatos, panelDireccion; 
    
    Border bordeDatos, bordeDireccion, bordeSeleccion;
    
    JComboBox<String> ComboClave;
    
    DefaultComboBoxModel modeloClaves;
    
    JButton botonModificar, botonLimpiar;

    public PestaniaModificaciones() {
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
        panelDatos.add(apellidos);
        panelDatos.add(textoApellido);
        panelDatos.add(edad);
        panelDatos.add(textoEdad);

        return panelDatos;
    }

    private JPanel configCentroDireccion() {
        panelDireccion.setLayout(new GridLayout(3, 2));
        panelDireccion.setBorder(bordeDireccion);
        panelDireccion.add(calle);
        panelDireccion.add(textoCalle);
        panelDireccion.add(numero);
        panelDireccion.add(textoNumero);
        panelDireccion.add(codigoPostal);
        panelDireccion.add(textoCodigoPostal);

        return panelDireccion;
    }

    private JPanel configInferior() {
        panelInferior.add(botonModificar);
        panelInferior.add(botonLimpiar);
        return panelInferior;
    }

    private void acciones() {
        botonLimpiar.addActionListener(this);
        textoEdad.addKeyListener(new ManejoTeclas());
        textoNumero.addKeyListener(new ManejoTeclas());
        textoCodigoPostal.addKeyListener(new ManejoTeclas());
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

        botonModificar = new JButton("Modificar");
        botonLimpiar = new JButton("Limpiar");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLimpiar){
            textoNombre.setText("");
            textoApellido.setText("");
            textoEdad.setText("");
            textoCalle.setText("");
            textoNombre.setText("");
            textoNumero.setText("");
            textoCodigoPostal.setText("");
        }
    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (e.getSource() == textoEdad) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoEdad.getText().length() > 2) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == textoNumero) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (textoNumero.getText().length() > 8) {
                        e.consume();
                    }
                }
            }else if (e.getSource() == textoCodigoPostal) {
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
