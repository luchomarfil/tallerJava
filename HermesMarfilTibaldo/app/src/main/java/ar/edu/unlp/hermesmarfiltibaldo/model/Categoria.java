package ar.edu.unlp.hermesmarfiltibaldo.model;

/**
 * Created by luciano on 15/12/15.
 */
public class Categoria {
    private Long id;
    private String nombre;

    public Categoria(long l, String n) {
        setId(l);
        setNombre(n);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
