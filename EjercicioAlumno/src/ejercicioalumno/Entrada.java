
package ejercicioalumno;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Colegio colegio = new Colegio();
        int matricula;

        int eleccionMenuPrincipal = 0;
        do {
            System.out.println("=========================");
            System.out.println("1. Agregar alumno.");
            System.out.println("2. Buscar alumno.");
            System.out.println("3. Borrar alumno.");
            System.out.println("4. Listar alumnos.");
            System.out.println("5. Listar DNI.");
            System.out.println("6. Salir.");
            System.out.println("=========================");
            eleccionMenuPrincipal = sc.nextInt();

            switch (eleccionMenuPrincipal) {
                case 1:
                    matricula = (int) (Math.random() * 10000);
                    String nombre,
                     apellido,
                     dni;
                    System.out.println("\nDNI: ");
                    dni = sc.next();
                    if (!colegio.estaAlumno(dni)) {
                        System.out.println("Nombre:");
                        nombre = sc.next();
                        System.out.println("Apellido:");
                        apellido = sc.next();
                        if (!colegio.estaMatricula(matricula)) {
                            Alumno alumno = new Alumno(dni, nombre, apellido, matricula);
                            colegio.agregarAlumno(alumno);
                            System.out.println("\nAlumno introducido con exito. \n");
                        } else {
                            matricula = (int) (Math.random() * 10000);
                        }
                    } else {
                        System.out.println("\nAlumno no introducido, porque ya existe.\n");
                    }
                    break;
                    
                case 2:
                    String dnibuscar;
                    System.out.println("\nIntroduzca el DNI:");
                    dnibuscar = sc.next();
                    if (colegio.estaAlumno(dnibuscar)) {
                        colegio.buscarAlumno(dnibuscar);
                        System.out.println("");
                    } else {
                        System.out.println("\nIntroduzca el DNI de un alumno existente: \n");
                    }
                    break;
                    
                case 3:
                    String dnieliminar;
                    System.out.println("\nIntroduce el DNI:");
                    dnieliminar = sc.next();
                    if (colegio.estaAlumno(dnieliminar)) {
                        colegio.eliminarAlumno(dnieliminar);
                        System.out.println("\nEl alumno ha sido eliminado con éxito. \n");
                    } else {
                        System.out.println("\nIntroduzca el DNI de un alumno existente. \n");
                    }

                    break;
                    
                case 4:
                    System.out.println("\nLista de Alumnos: ");
                    colegio.listarAlumnos();
                    System.out.println("");
                    break;
                    
                case 5:
                    System.out.println("\nLista de DNI: ");
                    colegio.listarDnis();
            }
        } while (eleccionMenuPrincipal != 6);

    }

}
