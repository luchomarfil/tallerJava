package ar.edu.unlp.hermesmarfiltibaldo.core;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;

/**
 * Created by luciano on 14/12/15.
 */
public class HermesCore {

    private static HermesCore instance;

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
}
