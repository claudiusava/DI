package utils;

public class Persona {

    Integer clave;
    String nombre, apellidos;
    Integer edad;
    String calle;
    Integer numero, codpostal;

    public Persona(Integer clave, String nombre, String apellidos, Integer edad, String calle, Integer numero, Integer codpostal) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.calle = calle;
        this.numero = numero;
        this.codpostal = codpostal;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", codpostal=" + codpostal +
                '}';
    }
}