package ar.edu.unlp.hermesmarfiltibaldo.model;

/**
 * Created by luciano on 14/12/15.
 */
public class Alumno {
    private String nombre;
    private String apellido;

    public Alumno(String nombre, String apellido) {
        this.setNombre(nombre);
        this.setApellido(apellido);
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

    @Override
    public String toString() {
        return this.getNombre() +" "+this.getApellido();
    }
}
