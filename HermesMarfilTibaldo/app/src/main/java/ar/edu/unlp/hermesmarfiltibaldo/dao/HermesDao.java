package ar.edu.unlp.hermesmarfiltibaldo.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;

/**
 * Created by luciano on 14/12/15.
 */
public class HermesDao {
    private static HermesDao instance;

    public static synchronized HermesDao instancia(){
        if(instance==null){
            instance = new HermesDao();
        }
        return instance;
    }

    private HermesDao(){

    }

    public List<Alumno> getAlumnos(){
        List<Alumno> l = new ArrayList<Alumno>();
        l.add(new Alumno("Roberto","Perez"));
        l.add(new Alumno("Guillote","Coppola"));
        l.add(new Alumno("Diego","Maradona"));
        return l;
    }
}
