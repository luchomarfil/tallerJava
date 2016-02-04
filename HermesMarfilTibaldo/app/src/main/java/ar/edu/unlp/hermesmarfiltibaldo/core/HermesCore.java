package ar.edu.unlp.hermesmarfiltibaldo.core;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;

/**
 * Created by luciano on 14/12/15.
 */
public class HermesCore {

    private static HermesCore instance;
    private Alumno alumnoActual;
    public static synchronized HermesCore instancia(){
        if(instance==null){
            instance = new HermesCore();
        }
        return instance;
    }

    private HermesCore(){

    }



    public List<Alumno> getAlumnos(){
        return HermesDao.instancia().getAlumnos();
    }

    /**
     * Obtiene las categorias habilitadas para el alumno pasado como parametro
     * @param alumno
     * @return
     */
    public List<Categoria> getCategorias(Alumno alumno){
        return HermesDao.instancia().getCategorias(alumno);
    }

    public void setAlumnoActual(Alumno alumno){
        alumnoActual = alumno;
    }

    public Alumno getAlumnoActual(){
        return alumnoActual;
    }
}
