package procesadortextos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener, ItemListener {

    static JTextArea texto;
    Container container;
    
    JPanel panelCentro, panelSuperior;
    JButton botonNuevo, botonAbrir, botonGuardar, botonImprimir, botonCortar, botonPegar, botonCopiar;
    JPopupMenu menuEmergente;
    JMenuBar menuEditor;
    JMenu menuArchivo, menuEdicion, menuEstilo;
    JMenuItem itemNuevo, itemAbrir, itemCerrar, itemGuardar, itemGuardarcomo,
            itemImprimir, itemBold, itemNormal, itemCursiva, itemCopiar, itemCortar, itemPegar;


    static JComboBox comboLetra, comboTamanio, comboTipo;
    static DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo;

    Funciones funciones = new Funciones();



    public Ventana() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarMenu();
        configurarVentana();
        rellenarLetras();
        rellenarTamanio();
        rellenarTipo();
        cambiarLetras();
        acciones();
        this.setSize(new Dimension(700, 400));
        this.setTitle("Procesador de textos");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    public void instancias() {

        container = this.getContentPane();
        panelCentro = new JPanel();
        panelSuperior = new JPanel();
        texto = new JTextArea();
        menuEditor = new JMenuBar();
        menuEmergente = new JPopupMenu();
        
        

        menuArchivo = new JMenu("Archivo");

        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNuevo.setToolTipText("Ctrl + N");
        itemNuevo.setIcon(new ImageIcon(getClass().getResource("../recursos/new.png")));

        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        itemAbrir.setToolTipText("Ctrl + A");
        itemAbrir.setIcon(new ImageIcon(getClass().getResource("../recursos/open.png")));

        itemCerrar = new JMenuItem("Cerrar");
        itemCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        itemCerrar.setToolTipText("Alt + F4");
        itemCerrar.setIcon(new ImageIcon(getClass().getResource("../recursos/close.png")));

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        itemGuardar.setToolTipText("Ctrl + G");
        itemGuardar.setIcon(new ImageIcon(getClass().getResource("../recursos/save.png")));

        itemGuardarcomo = new JMenuItem("Guardar como...");
        itemImprimir = new JMenuItem("Imprimir");
        itemImprimir.setIcon(new ImageIcon(getClass().getResource("../recursos/print.png")));


        
        menuEdicion = new JMenu("Edición");

        itemCopiar = new JMenuItem("Copiar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + C");
        itemCopiar.setIcon(new ImageIcon(getClass().getResource("../recursos/copy.png")));

        itemCortar = new JMenuItem("Cortar");
        itemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        itemCortar.setToolTipText("Ctrl + X");
        itemCortar.setIcon(new ImageIcon(getClass().getResource("../recursos/cut.png")));

        itemPegar = new JMenuItem("Pegar");
        itemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        itemPegar.setToolTipText("Ctrl + V");
        itemPegar.setIcon(new ImageIcon(getClass().getResource("../recursos/paste.png")));


        
        menuEstilo = new JMenu("Estilo de la fuente");
        itemBold = new JMenuItem("Negrita");
        itemBold.setIcon(new ImageIcon(getClass().getResource("../recursos/bold.png")));

        itemNormal = new JMenuItem("Normal");
        itemNormal.setIcon(new ImageIcon(getClass().getResource("../recursos/normal.png")));

        itemCursiva = new JMenuItem("Cursiva");
        itemCursiva.setIcon(new ImageIcon(getClass().getResource("../recursos/italic.png")));


        
        modeloLetra = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();

        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        comboTipo = new JComboBox(modeloTipo);


        
        botonNuevo = new JButton();
        botonNuevo.setPreferredSize(new Dimension(24, 24));
        botonNuevo.setIcon(new ImageIcon(getClass().getResource("../recursos/new.png")));

        botonAbrir = new JButton();
        botonAbrir.setPreferredSize(new Dimension(24, 24));
        botonAbrir.setIcon(new ImageIcon(getClass().getResource("../recursos/open.png")));

        botonGuardar = new JButton();
        botonGuardar.setPreferredSize(new Dimension(24, 24));
        botonGuardar.setIcon(new ImageIcon(getClass().getResource("../recursos/save.png")));

        botonImprimir = new JButton();
        botonImprimir.setPreferredSize(new Dimension(24, 24));
        botonImprimir.setIcon(new ImageIcon(getClass().getResource("../recursos/print.png")));

        botonCopiar = new JButton();
        botonCopiar.setPreferredSize(new Dimension(24, 24));
        botonCopiar.setIcon(new ImageIcon(getClass().getResource("../recursos/copy.png")));

        botonCortar = new JButton();
        botonCortar.setPreferredSize(new Dimension(24, 24));
        botonCortar.setIcon(new ImageIcon(getClass().getResource("../recursos/cut.png")));

        botonPegar = new JButton();
        botonPegar.setPreferredSize(new Dimension(24, 24));
        botonPegar.setIcon(new ImageIcon(getClass().getResource("../recursos/paste.png")));
    }
    
    
    
    private void acciones() {
        
        //TEXTO
        texto.addMouseListener(new ManejoRaton());
        
        //MENÚ
        itemNuevo.addActionListener(this);
        itemCerrar.addActionListener(this);
        itemAbrir.addActionListener(this);
        itemGuardar.addActionListener(this);
        itemCopiar.addActionListener(this);
        itemCortar.addActionListener(this);
        itemPegar.addActionListener(this);
        
        //BOTONES
        botonGuardar.addActionListener(this);
        botonNuevo.addActionListener(this);
        botonAbrir.addActionListener(this);
        botonCopiar.addActionListener(this);
        botonCortar.addActionListener(this);
        botonPegar.addActionListener(this);
        
        //COMBOS
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        comboTipo.addItemListener(this);
    }
    
    
    
    private void configurarVentana() {
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(texto, BorderLayout.CENTER);

    }
    
    
    
    private Component configurarPanelSuperior() {
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(botonNuevo);
        panelSuperior.add(botonAbrir);
        panelSuperior.add(botonGuardar);
        panelSuperior.add(botonImprimir);
        panelSuperior.add(botonCopiar);
        panelSuperior.add(botonCortar);
        panelSuperior.add(botonPegar);
        panelSuperior.add(comboLetra);
        panelSuperior.add(comboTamanio);
        panelSuperior.add(comboTipo);
        return panelSuperior;
    }
    
    

    private void configurarMenu() {
        menuEditor.add(menuArchivo);

        menuArchivo.add(itemNuevo); 
        menuArchivo.add(itemAbrir); 
        menuArchivo.add(itemCerrar);
        menuArchivo.add(itemGuardar); 
        menuArchivo.add(itemGuardarcomo); 
        menuArchivo.add(itemImprimir); 

        menuEditor.add(menuEdicion);

        menuEdicion.add(itemCopiar); 
        menuEdicion.add(itemCortar); 
        menuEdicion.add(itemPegar);

        menuEdicion.add(menuEstilo);
        menuEstilo.add(itemBold); 
        menuEstilo.add(itemNormal);
        menuEstilo.add(itemCursiva); 

        this.setJMenuBar(menuEditor);
    }

    

    private void cambiarLetras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTipo.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
        Component[] components = this.getComponents();
        texto.setFont(fuente);
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (Font item : fuentes) {
            modeloLetra.addElement(item.getName());
        }
    }

    private void rellenarTamanio() {
        for (int i = 12; i <= 80; i++) {
            modeloTamanio.addElement(i);
        }
    }

    private void rellenarTipo() {
        modeloTipo.addElement("NORMAL");
        modeloTipo.addElement("BOLD");
        modeloTipo.addElement("ITALIC");
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemNuevo || e.getSource() == botonNuevo) {
            Ventana v = new Ventana();
            v.initGUI();

        } else if (e.getSource() == itemAbrir || e.getSource() == botonAbrir) {
            funciones.abrirArchivo();

        } else if (e.getSource() == itemGuardar || e.getSource() == botonGuardar) {
            funciones.guardarArchivo();

        } else if (e.getSource() == itemCortar || e.getSource() == botonCortar) {
            funciones.cortartexto();

        } else if (e.getSource() == itemCopiar || e.getSource() == botonCopiar) {
            funciones.copiartexto();

        } else if (e.getSource() == itemPegar || e.getSource() == botonPegar) {
            funciones.pegartexto();

        } else if (e.getSource() == itemCerrar) {
            this.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarLetras();
        } else if (e.getSource() == comboTamanio) {
            cambiarLetras();
        } else if (e.getSource() == comboTipo) {
            cambiarLetras();
        }
    }

    class ManejoRaton extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getButton() == MouseEvent.BUTTON3) {
                menuEmergente.show(texto, e.getX(), e.getY());
            }
        }
    }
}