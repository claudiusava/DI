
package calculadora;

import javax.swing.SwingUtilities;

public class Entrada {

    public static void main(String[] args) {
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.initGUI();
            }
        });    
        
    }
    
}
