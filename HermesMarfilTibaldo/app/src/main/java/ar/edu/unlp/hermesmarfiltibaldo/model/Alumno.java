package ar.edu.unlp.hermesmarfiltibaldo.model;

import java.util.Enumeration;
import java.util.List;

/**
 * Created by luciano on 14/12/15.
 */
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private String sexo;
    private String tamanioPictograma;



    public Alumno(String nombre, String apellido, String sexo) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSexo(sexo);
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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTamanioPictograma() {
        return tamanioPictograma;
    }

    public void setTamanioPictograma(String tamanioPictograma) {
        this.tamanioPictograma = tamanioPictograma;
    }

    @Override
    public String toString() {
        return this.getNombre() +" "+this.getApellido();
    }
}
