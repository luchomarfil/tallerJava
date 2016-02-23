package ar.edu.unlp.hermesmarfiltibaldo.dao;


import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 16/02/16.
 */
public interface HermesDao {


    List<Alumno> getAlumnos();

    List<Categoria> getCategorias(Alumno alumno);

    List<Pictograma> getPictogramas(Categoria cat, String sexo);

    List<Pictograma> getPictogramas(Alumno alumno);

    String getPortComunicadorJSON();

    String getIP();

    long createNewAlumno(Alumno alumno);

    void createNewPictograma(Pictograma pictograma);

    void createNewCategoria(Categoria categoria);

    void createNewAlumnoPictograma(Alumno alumno, Pictograma pictograma);

    List<Categoria> getCategorias();

    List<Pictograma> getPictogramasAlumno(Alumno alumno);

    void updateConfig(String name, String value);

    void updateAlumno(Alumno alumno);

    void removeAlumno(Alumno alumno);

    void removeAlumnoPictograma(Alumno alumno, Pictograma pictograma);

    void removeAlumnoTodosPictogramas(Alumno alumno);

    List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria);

    void removeAlumnoTodasCategoria(Alumno alumno);

    void createNewCategoriaAlumno(Categoria categoria, Alumno alumno);

    void createNewNotificacion(Notificacion n, boolean b);

    List<Notificacion> getNotificacionesNoEnviadas();

    void setNotificacionToEnviada(Notificacion n);

    Pictograma getPictogramaPorNombre(String nombre);

}

