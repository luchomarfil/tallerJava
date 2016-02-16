package ar.edu.unlp.hermesmarfiltibaldo.model;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;

/**
 * Created by luciano on 15/12/15.
 */
public class Categoria {
    private Long id;
    private String nombre;
    public static final Long ID_CATEGORIA_EMOCIONES =  1L;
    public static final Long ID_CATEGORIA_ESTABLO = 2L;
    public static final Long ID_CATEGORIA_NECESIDADES = 3L;
    public static final Long ID_CATEGORIA_PISTA = 4L;
    private static HermesContract.Categoria categoriaByID;

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

    public static Categoria getCategoriaEmociones() {
        return new Categoria(Categoria.ID_CATEGORIA_EMOCIONES,"Emociones");
    }

    public static Categoria getCategoriaEstablo() {
        return new Categoria(Categoria.ID_CATEGORIA_ESTABLO,"Establo");
    }

    public static Categoria getCategoriaByID(long id) {
        Categoria returned = null;
        if (id == ID_CATEGORIA_EMOCIONES) {returned = getCategoriaEmociones();}
        if (id == ID_CATEGORIA_ESTABLO) {returned = getCategoriaEstablo();}
        if (id == ID_CATEGORIA_NECESIDADES) {returned = getCategoriaNecesidades();}
        if (id == ID_CATEGORIA_PISTA) {returned = getCategoriaPista();}
        return returned;
    }

    public static Categoria getCategoriaNecesidades() {
        return new Categoria(Categoria.ID_CATEGORIA_NECESIDADES,"Necesidades");
    }

    public static Categoria getCategoriaPista() {
        return new Categoria(Categoria.ID_CATEGORIA_PISTA,"Pista");
    }
}
