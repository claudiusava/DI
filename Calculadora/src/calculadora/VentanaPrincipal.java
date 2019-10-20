package calculadora;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Scanner;

public class VentanaPrincipal extends JFrame implements ActionListener {

    Scanner sc = new Scanner(System.in);
    
    JButton bIgual, bSuma, bResta, bMultiplicacion, bDivision, bBorrar, bCE, bCientifica, bPunto;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bNull;
    JButton bRaiz, bSin, bCos, bTan;
    
    JTextField pantalla;

    Container container;
    JPanel panelSuperior, panelCentro, panelIzquierda;
    
    CardLayout cardLayout;
    
    boolean operando = false;
    Double op1, op2, op3, op4;
    int tipoOperacion;


    public void initGUI() {
        instancias();
        acciones();
        this.setTitle("CLAUCULADORA");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 500, 500);
        this.setLocationRelativeTo(null);
        configurarContainer();
        bNull.setEnabled(false);
        this.setVisible(true);
        
    }

    private void acciones() {
        
        bCE.addActionListener(this);
        bBorrar.addActionListener(this);
        bCientifica.addActionListener(this);
        bDivision.addActionListener(this);
        
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bMultiplicacion.addActionListener(this);
        
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bResta.addActionListener(this);
        
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bSuma.addActionListener(this);
        
        b0.addActionListener(this);
        bPunto.addActionListener(this);
        bIgual.addActionListener(this);
        
        bRaiz.addActionListener(this);
        bSin.addActionListener(this);
        bCos.addActionListener(this);
        bTan.addActionListener(this);
         
    }

    private void instancias() {
        
        pantalla = new JTextField();

        bCE = new JButton("CE");
        bBorrar = new JButton("<<<<");
        bCientifica = new JButton("Simple / Cientifica");
        
        bDivision = new JButton("÷");
        bMultiplicacion = new JButton("x");
        bResta = new JButton("-");
        bSuma = new JButton("+");
        bIgual = new JButton("=");
        bPunto = new JButton(".");

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        
        bNull = new JButton("");
        
        bRaiz = new JButton("√");
        bSin = new JButton("Sin");
        bCos = new JButton("Cos");
        bTan = new JButton("Tan");
        
        container = this.getContentPane();

        panelSuperior = new JPanel();

        panelCentro = new JPanel();

        panelIzquierda = new JPanel();
        
        cardLayout = new CardLayout();
    }

    private void configurarContainer() {
        
        container.add(configurarSuperior(), BorderLayout.NORTH);
        container.add(configurarCentro(), BorderLayout.CENTER);
    }
    
    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(pantalla, BorderLayout.CENTER);
        return panelSuperior;
    }

    private JPanel configurarCentro() {
  
        
        panelCentro.setPreferredSize(new Dimension(500, 600));
        panelCentro.setLayout(new GridLayout(5, 4, 10, 10));
        
        panelCentro.add(bCE);
        bCE.setActionCommand(Constantes.ACC_CE);
        panelCentro.add(bBorrar);
        bBorrar.setActionCommand(Constantes.ACC_BB);
        panelCentro.add(bCientifica);
        bCientifica.setActionCommand(Constantes.ACC_C);
        panelCentro.add(bDivision);
        
        panelCentro.add(b7);
        panelCentro.add(b8);
        panelCentro.add(b9);
        panelCentro.add(bMultiplicacion);
        
        panelCentro.add(b4);
        panelCentro.add(b5);
        panelCentro.add(b6);
        panelCentro.add(bResta);
        
        panelCentro.add(b1);
        panelCentro.add(b2);
        panelCentro.add(b3);
        panelCentro.add(bSuma);
        
        panelCentro.add(bNull);
        panelCentro.add(b0);
        panelCentro.add(bPunto);
        panelCentro.add(bIgual);

        return panelCentro;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case Constantes.ACC_C:
                if (panelIzquierda.isShowing()) {
                    container.remove(panelIzquierda);
                } else {
                    container.add(panelIzquierda, BorderLayout.WEST);
                    panelIzquierda.setPreferredSize(new Dimension(100, 100));
                    panelIzquierda.setLayout(new GridLayout(4, 1, 0, 0));
                    panelIzquierda.add(bRaiz);
                    panelIzquierda.add(bSin);
                    panelIzquierda.add(bCos);
                    panelIzquierda.add(bTan);
                }
                pack();
                break;
                
            case Constantes.ACC_CE:
                pantalla.setText("");
                break;
                
            case Constantes.ACC_BB:
                String cadena;
                cadena = pantalla.getText();
                
                if (cadena.length()>0){
                    cadena = cadena.substring(0, cadena.length()-1);
                    pantalla.setText(cadena);
                }
                break;
        }
        
        Double resultado = null;
        
        //0
        if (e.getSource() == b0) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "0");
            }
            else{
                pantalla.setText("0");
                operando=false;
            }
        }
        
        //1
        else if (e.getSource() == b1) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "1");
            }
            else
                pantalla.setText("1");
                operando = false;

        } 
        
        //2
        else if (e.getSource() == b2) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "2");
            }
            else
                pantalla.setText("2");
                operando = false;
        } 
        
        //3
        else if (e.getSource() == b3) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "3");
            }
            else
                pantalla.setText("3");
                operando = false;
        } 
        
        //4
        else if (e.getSource() == b4) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "4");
            }
            else{
                pantalla.setText("4");
                    operando = false;
            }
        } 
        
        //5
        else if (e.getSource() == b5) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "5");
            }
            else{
                pantalla.setText("5");
                operando = false;
            }
        }
        
        
        //6
        else if (e.getSource() == b6) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "6");
            }
            else{
                pantalla.setText("6");
                operando = false;
            }
        }
        
        
        //7
        else if (e.getSource() == b7) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "7");
            }
            else{
                pantalla.setText("7");
                operando = false;
            }
        }
        
        
        //8
        else if (e.getSource() == b8) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "8");
            }
            else{
                pantalla.setText("8");
                operando = false;
            }
        }
        
        
        //9
        else if (e.getSource() == b9) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "9");
            }
            else{
                pantalla.setText("9");
                operando=false;
            }
        }
        
        
        
        //Suma
        else if (e.getSource() == bSuma) {
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 1;
        } 
        
        
        //Resta
        else if (e.getSource() == bResta) { 
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 2;   
        } 
        
        
        //Multiplicacion
        else if (e.getSource() == bMultiplicacion) { 
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 3;   
        }
        
        
        //Division
        else if (e.getSource() == bDivision) { 
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 4;   
        }
        
        
        //Raiz √
        else if (e.getSource() == bRaiz) {
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 5;   
        }
        
        //Seno
        else if (e.getSource() == bSin) {
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 6;   
        }
        
        //Coseno
        else if (e.getSource() == bCos) {
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 7;   
        }
        
        //Tangente
        else if (e.getSource() == bTan) {
            operando = true;
            op1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 8;   
        }
        
        
        
        //Igual
        else if (e.getSource() == bIgual) {
            op2 = Double.valueOf(pantalla.getText());
            //Double resultado = null;
            switch (tipoOperacion){
                case 1:
                    resultado =  (op1+op2);
                    break;
                case 2:
                    resultado = (op1-op2);
                    break;
                    
                case 3:
                    resultado = (op1 * op2);
                    break;
                    
                case 4:
                    resultado = (op1 / op2); 
                    break;
                    
                case 5:
                    resultado = Math.sqrt(op1);
                    pantalla.setText(Double.toString(resultado));
                    break;
                    
                case 6:
                    resultado = Math.sin(op1);
                    pantalla.setText(Double.toString(resultado));
                    break;
                case 7:
                    resultado = Math.cos(op1);
                    pantalla.setText(Double.toString(resultado));
                    break;
                    
                case 8:
                    resultado = Math.tan(op1);
                    pantalla.setText(Double.toString(resultado));
                    break;
            }

        pantalla.setText(Double.toString(resultado));
    }
    }
}
//.