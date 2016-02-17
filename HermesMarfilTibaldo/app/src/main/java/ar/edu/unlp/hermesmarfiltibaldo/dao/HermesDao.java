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
    public List<Alumno> getAlumnos();
    public void createNewAlumno(Alumno alumno);
    public void createNewPictograma(Pictograma pictograma);
    public void createNewCategoria(Categoria categoria);
    public void createNewAlumnoPictograma(Alumno alumno, Pictograma pictograma);
    public List<Categoria> getCategorias();
    public List<Categoria> getCategorias(Alumno alumno);
    public List<Pictograma> getPictogramas(Categoria cat);
    public List<Pictograma> getPictogramasAlumno(Alumno alumno);
    public String getPortComunicadorJSON();
    public String getIP();
    public void updateConfig(String name, String value);
    public void updateAlumno(Alumno alumno);
    public void removeAlumno(Alumno alumno);
    public void removeAlumnoPictograma(Alumno alumno, Pictograma pictograma);
    public List<Pictograma> getPictogramas(Alumno alumno) throws Exception;
    public List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria);
}
