
package ejercicioalumno;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Colegio {

    private Hashtable<String, Alumno> listadoAlumnos;
    private Hashtable<String, Alumno> listadoDnis;
    ArrayList<Integer> listadoMatriculas = new ArrayList();

    public Colegio() {
        listadoAlumnos = new Hashtable();
    }

    public void agregarAlumno(Alumno alumno) {
        listadoAlumnos.put(alumno.getDni(), alumno);
        listadoMatriculas.add(alumno.getMatricula());
    }

    public boolean estaAlumno(String dni) {
        return listadoAlumnos.containsKey(dni);
    }

    public boolean estaMatricula(int matricula) {
        if (listadoMatriculas.contains(matricula)) {
            return true;
        } else {
            return false;
        }

    }

    public void eliminarAlumno(String dni) {
        listadoAlumnos.remove(dni);
    }

    public void buscarAlumno(String dnibuscar) {
        Alumno alumnobuscar = listadoAlumnos.get(dnibuscar);
        System.out.println(alumnobuscar.toString());
    }

    public void listarAlumnos() {
        if (!listadoAlumnos.isEmpty()) {
            Enumeration<Alumno> alumnos = listadoAlumnos.elements();
            while (alumnos.hasMoreElements()) {
                Alumno a = alumnos.nextElement();
                System.out.println(a);
            }
        } else {
            System.out.println("Todavía no existen alumnos registrados.");
        }
    }

    public void listarDnis() {
        Enumeration<Alumno> dnis = listadoDnis.elements();
        while (dnis.hasMoreElements()) {
            Alumno a = dnis.nextElement();
            System.out.println(a.getDni());
        }
    }
}
