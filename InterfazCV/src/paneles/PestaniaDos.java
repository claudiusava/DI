
package paneles;

import interfazcv.Ventana;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PestaniaDos extends JPanel implements ActionListener {
    
   
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
        acciones();
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
        modeloAnios = new SpinnerNumberModel(1, 1, 50, 1);
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

    private void acciones() {
        btnBuscar.setActionCommand("Buscar");
        btnSalir.setActionCommand("Salir");
        btnBuscar.addActionListener(this);
        btnSalir.addActionListener(this);
        txtDni.addActionListener(this);
        txtEstudios.addActionListener(this);
        txtResult.addActionListener(this);
        txtTelf.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salir":
                System.exit(0);
                break;
            case "Buscar":
                buscarPersona();
                break;
        }
    }

    public void buscarPersona() {

        String cadena = "";
        String experiencia = aniosExperiencia.getModel().getValue().toString();
        String telefono = txtTelf.getText();
        String DNI = txtDni.getText();
        String profesion = trabajos.getSelectedItem().toString();

        for (int i = 0; i < Ventana.listadoPersonas.size(); i++) {
            String experiencia1 = Ventana.listadoPersonas.get(i).getAniosExperiencia();
            String telefono1 = Ventana.listadoPersonas.get(i).getTelefono();
            String DNI1 = Ventana.listadoPersonas.get(i).getTelefono();
            String profesion1 = Ventana.listadoPersonas.get(i).getTelefono();

            if (experiencia.equals(experiencia1) || telefono.equals(telefono1) || DNI.equals(DNI1) || profesion.equals(profesion1)) {
                cadena += Ventana.listadoPersonas.get(i).getNombre() + ", " + experiencia1 + ", " + telefono1 + ", " + DNI1 + ", " + profesion + "\n";

            }

        }

        if (cadena.equals("")) {
            JOptionPane.showMessageDialog(null, "No encontro personas con los criterios de busqueda propocionados");
        } else {
            resultados.setText(cadena);
        }
    }
}
