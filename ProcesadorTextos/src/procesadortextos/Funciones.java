package procesadortextos;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static procesadortextos.Ventana.texto;

public class Funciones extends Component {

    final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public void cortartexto() {
        String textocortar = texto.getSelectedText();
        StringSelection selection = new StringSelection(textocortar);
        clipboard.setContents(selection, selection);
        texto.replaceRange("", texto.getSelectionStart(), texto.getSelectionEnd());
    }

    public void copiartexto() {
        String textocopiar = texto.getSelectedText();
        StringSelection selection = new StringSelection(textocopiar);
        clipboard.setContents(selection, selection);
    }

    public void pegartexto() {
        Transferable transferable = clipboard.getContents(clipboard);
        try {
            if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String s = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                texto.replaceSelection(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void guardarArchivo() {
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.showSaveDialog(this);
        File archivoF = fileChoser.getSelectedFile();
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(archivoF);
            BufferedWriter salida = new BufferedWriter(fileWriter);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void abrirArchivo(){
        JFileChooser fileChooser = new JFileChooser();
        int i = fileChooser.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            String f = fileChooser.getSelectedFile().getName();
            String ex = f.substring(f.indexOf(".") + 1);
            System.out.println(ex);
        }
    }

}