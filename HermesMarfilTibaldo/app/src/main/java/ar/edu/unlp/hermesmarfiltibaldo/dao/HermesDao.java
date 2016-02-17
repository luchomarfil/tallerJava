package ar.edu.unlp.hermesmarfiltibaldo.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 16/02/16.
 */
public interface HermesDao {


    List<Alumno> getAlumnos();

    List<Categoria> getCategorias(Alumno alumno);

    List<Pictograma> getPictogramas(Categoria cat);

    List<Pictograma> getPictogramas(Alumno alumno);

    String getPortComunicadorJSON();

    String getIP();

    void createNewAlumno(Alumno alumno);

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

    public void removeAlumnoTodasCategoria(Alumno alumno);

    public void createNewCategoriaAlumno(Categoria categoria, Alumno alumno);
}

