package ficheros;

import ficheros.Alumno;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {

        ArrayList<Alumno> alumnos = new ArrayList();

        alumnos.add(new Alumno("nombre1","apellido1","123",123));
        alumnos.add(new Alumno("nombre2","apellido1","123",123));
        alumnos.add(new Alumno("nombre3","apellido1","123",123));
        alumnos.add(new Alumno("nombre4","apellido1","123",123));
        alumnos.add(new Alumno("nombre5","apellido1","123",123));

        File ficheroObjeto = new File("src/documentos/fichero.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroObjeto));
            oos.writeObject(alumnos);
        } catch (IOException e) {
            e.printStackTrace();
            // el archivo ha provocado el fallo
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
                // el cerrado ha provocado el fallo
            }
        }
    }
}
