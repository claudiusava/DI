
package ejercicioalumno;

public class Alumno {
    String dni,nombre,apellido;
    int matricula;

    public Alumno() {
    }

    public Alumno(String dni, String nombre, String apellido, int matricula) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Alumno{" + "Nombre: " + nombre + ", Apellido: " + apellido + ", Dni: " + dni + ", Matricula: " + matricula + '}';
    }
    
    
}
