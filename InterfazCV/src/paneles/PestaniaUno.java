
package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PestaniaUno extends JPanel implements ActionListener{
    JLabel etiquetaPrincipal, etiquetaNombre, etiquetaDireccion, etiquetaTelefono, etiquetaDNI, seleccionEstudios, añosExperiencia;
    JTextField textoDireccion, textoNombre, textoTelefono, textoDNI;
    JButton botonInsertarDatos, botonSalir;
    JPanel panelCentro, panelTitulo;
    JSpinner aniosExperiencia;
    JComboBox<String> trabajos;
    Container container;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;
    
     public PestaniaUno() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarContainer();
    }
    
    private void instancias() {
        etiquetaPrincipal = new JLabel("POR FAVOR, RELLENA LOS DATOS DE TU CURRIULUM");
        etiquetaNombre = new JLabel("Nombre");
        etiquetaDireccion = new JLabel("Direccion");
        etiquetaTelefono = new JLabel("Telefono");
        etiquetaDNI = new JLabel("DNI");
        seleccionEstudios = new JLabel("Selecciona sus estudios");
        añosExperiencia = new JLabel("Años de experiencia");
        textoNombre = new JTextField();
        textoTelefono = new JTextField();
        textoDNI = new JTextField();
        textoDireccion = new JTextField(); 
        botonInsertarDatos = new JButton("Insertar datos");
        botonSalir = new JButton("Salir");
        panelCentro = new JPanel();
        panelTitulo = new JPanel();
        aniosExperiencia = new JSpinner();
        radioButton1 = new JRadioButton("Soltero", false);
        radioButton2 = new JRadioButton("Casado", true);
        radioButton3 = new JRadioButton("Divorciado", false);
        trabajos = new JComboBox();
        trabajos.addItem("Ingenieria Informatica");
        trabajos.addItem("Ingenieria Industrial");
        trabajos.addItem("Ingenieria Telecomunicaciones");
        trabajos.addItem("Arquitectura");
        trabajos.addItem("Derecho");
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
    
    private void configurarContainer() { 
        this.setLayout(new BorderLayout());
        panelCentro.setLayout(new GridBagLayout());
        configurarConstrait(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaPrincipal);
        configurarConstrait(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaNombre);
        configurarConstrait(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, seleccionEstudios);
        configurarConstrait(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textoNombre);        
        configurarConstrait(1, 2, 3, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, trabajos);
        configurarConstrait(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaTelefono);
        configurarConstrait(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textoTelefono);
        configurarConstrait(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaDNI);
        configurarConstrait(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton1);
        configurarConstrait(2, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton2);
        configurarConstrait(3, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton3);
        configurarConstrait(0, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textoDNI);
        configurarConstrait(1, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, añosExperiencia);
        configurarConstrait(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, aniosExperiencia);
        configurarConstrait(0, 7, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaDireccion);
        configurarConstrait(0, 8, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textoDireccion);
        configurarConstrait(1, 8, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, botonInsertarDatos);
        configurarConstrait(2, 8, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, botonSalir);
        this.add(panelCentro, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        switch (e.getActionCommand()) {
//            case :
//                break;
//            case "textoNombre":
//                break;
//            case "textoTelefono":
//                break;
//            case "textoDNI":
//                break;
//        }
    }

    private void acciones() {
    textoDireccion.addActionListener(this);
    textoNombre.addActionListener(this);
    textoTelefono.addActionListener(this);   
    textoDNI.addActionListener(this);
    
    
    }
}
