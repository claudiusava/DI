package practicatablas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Entrada {

    public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
                v.initGUI();
            }
        });
    }
}