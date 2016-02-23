package ar.edu.unlp.hermesmarfiltibaldo.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;

/**
 * Created by luciano on 14/12/15.
 */
public class Alumno {
    public static final String GRANDE = "grande";
    public static final String NORMAL = "normal";
    public static final String MASCULINO = "masculino";
    public static final String FEMENINO = "femenino";
    public static final String UNISEX = "unisex";
    private Long id;
    private String nombre;
    private String apellido;
    private String sexo;
    private String tamanioPictograma;
    private List<Categoria> categorias;

    public Alumno(){

    }

    public Alumno(long id, String nombre, String apellido, String sexo, String tamanioPictograma ) {
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSexo(sexo);
        this.setTamanioPictograma(tamanioPictograma);
        this.setCategorias(new ArrayList<Categoria>());
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


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String descripcion() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", tamanioPictograma='" + tamanioPictograma + '\'' +
                ", categorias=" + categorias +
                '}';
    }


}
