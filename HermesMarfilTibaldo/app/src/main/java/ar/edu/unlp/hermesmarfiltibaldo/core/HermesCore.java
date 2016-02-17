package ar.edu.unlp.hermesmarfiltibaldo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.text.Editable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.comunicadorjson.ClientHTTPJSONListener;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoDB;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoImpl;
import ar.edu.unlp.hermesmarfiltibaldo.exception.ComunicarNotificacionException;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 14/12/15.
 */
public class HermesCore {

    public static boolean MODO_ALUMNO = false;
    public static boolean MODO_AJUSTE = true;
    public static final String CONFIG_KEY_PORT = "port";
    public static final String CONFIG_KEY_IP = "ip";

    private boolean modoAjuste = false;
    private static HermesCore instance;
    private Alumno alumnoActual;
    private HermesDao hermesDao;

    public static synchronized HermesCore instancia(){
        if(instance==null){
            instance = new HermesCore();
        }
        return instance;
    }

    private HermesCore(){

    }



    public List<Alumno> getAlumnos(){

        return getHermesDao().getAlumnos();

    }

    /**
     * Obtiene las categorias habilitadas para el alumno pasado como parametro
     * @param alumno
     * @return
     */
    public List<Categoria> getCategorias(Alumno alumno){
        return this.getHermesDao().getCategorias(alumno);
    }

    public void setAlumnoActual(Alumno alumno){
        alumnoActual = alumno;
    }

    public Alumno getAlumnoActual(){
        return alumnoActual;
    }

    public String getPortComunicadorJSON() {
        return this.getHermesDao().getPortComunicadorJSON();
    }

    public String getIP() {
        return this.getHermesDao().getIP();
    }


    public List<Pictograma> getPictogramas(Categoria cat){
        return this.getHermesDao().getPictogramas(cat);
    }

    //TODO hacer!!!
    public List<Pictograma> getPictogramas(Alumno alumno){
            return this.getHermesDao().getPictogramas(alumno);
    }

    public void comunicarNotificacion(Notificacion n){
        try {
            ClientHTTPJSONListener.comunicarNotificacion(n);
           // HermesCore.instancia().marcarNotificacionComoRecibida(n);
        } catch (ComunicarNotificacionException e) {
           // HermesCore.instancia().marcarNotificacionComoPendiente(n);
            e.printStackTrace();
        }

    }


    public boolean isModoAjuste()
    {return this.modoAjuste;}

    public void setModoAlumno()
    {this.modoAjuste = this.MODO_ALUMNO;}

    public void setModoAjuste()
    {this.modoAjuste = this.MODO_AJUSTE;}



    public boolean deleteAlumnoActual() {
        try{
            this.getHermesDao().removeAlumnoTodosPictogramas(HermesCore.instancia().getAlumnoActual());
            this.getHermesDao().removeAlumno(HermesCore.instancia().getAlumnoActual());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    public void updateAlumno(Alumno alumnoActual) {
        this.getHermesDao().updateAlumno(alumnoActual);
        this.getHermesDao().removeAlumnoTodasCategoria(alumnoActual);
        Iterator<Categoria> iterator =  alumnoActual.getCategorias().iterator();
        for (Categoria c: alumnoActual.getCategorias()) {
            this.getHermesDao().createNewCategoriaAlumno(c,alumnoActual);
        }
    }

    public void createNewAlumno(Alumno alumnoActual) {
        this.getHermesDao().createNewAlumno(alumnoActual);
        Iterator<Categoria> iterator =  alumnoActual.getCategorias().iterator();
        for (Categoria c: alumnoActual.getCategorias()) {
            this.getHermesDao().createNewCategoriaAlumno(c,alumnoActual);
        }
    }

    public void updateConfiguracion(String ip, String puerto) {
        this.getHermesDao().updateConfig(CONFIG_KEY_IP, ip);
        this.getHermesDao().updateConfig(CONFIG_KEY_PORT, puerto);
    }

    public List<Categoria> getCategorias(){
        return this.getHermesDao().getCategorias();
    }

    public HermesDao getHermesDao() {
        return hermesDao;
    }

    public void setHermesDao(HermesDao hermesDao) {
        this.hermesDao = hermesDao;
    }

    public List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria) {
        if (alumnoActual.getCategorias().contains(categoria)) {
            return this.getHermesDao().getPictogramas(alumnoActual, categoria);
        } else {
            return null;
        }
    }

    public void playAudio(Pictograma pictograma, Context mContext) {


            MediaPlayer mp = new MediaPlayer();
            try {
                File imgFile = new  File(pictograma.getAudioFilename());
                AssetFileDescriptor descriptor = mContext.getAssets().openFd(imgFile.getPath());
                mp.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                mp.prepare();
                mp.setLooping(false);
                mp.start();
                //mp.setVolume(3, 3);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
