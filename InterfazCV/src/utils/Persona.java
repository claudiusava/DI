
package utils;

public class Persona {
    
     private String nombre;
    private String telefono;
    private String DNI;
    private String direccion;
    private String estadoCivil;
    private String profesion;
    private String aniosExperiencia;
    
      public Persona(String nombre, String telefono, String DNI, String direccion, String estadoCivil, String profesion, String aniosExperiencia) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.DNI = DNI;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(String aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    
}

