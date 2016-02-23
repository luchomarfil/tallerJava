package ar.edu.unlp.hermesmarfiltibaldo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import ar.edu.unlp.hermesmarfiltibaldo.comunicadorjson.ClientHTTPJSONListener;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.exception.ComunicarNotificacionException;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 14/12/15.
 */
public class HermesCore {

    private static Logger logger = Logger.getLogger(HermesCore.class.getName());
    public static boolean MODO_ALUMNO = false;
    public static boolean MODO_AJUSTE = true;
    public static final String CONFIG_KEY_PORT = "PORT";
    public static final String CONFIG_KEY_IP = "IP";

    private boolean modoAjuste = false;
    private static HermesCore instance;
    private Alumno alumnoActual;
    private HermesDao hermesDao;
    private boolean hayMensajesNoEnviado;

    public static synchronized HermesCore instancia(){
        if(instance==null){
            instance = new HermesCore();
        }
        return instance;
    }

    private HermesCore(){
        Runnable resendUnsended = new Runnable() {
            public void run() {
                HermesCore.instancia().comunicarNotificacionesNoEnviadas();

            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(resendUnsended, 1, 30, TimeUnit.SECONDS);
    }



    public List<Alumno> getAlumnos(){
        List<Alumno> als = getHermesDao().getAlumnos();
        for (Alumno a: als) {
            a.setCategorias(HermesCore.instancia().getCategorias(a));
        }
        return als;

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


    public List<Pictograma> getPictogramas(Categoria cat, String sexo){
        return this.getHermesDao().getPictogramas(cat, sexo);
    }

    public List<Pictograma> getPictogramas(Alumno alumno){
            return this.getHermesDao().getPictogramas(alumno);
    }

    public void comunicarNotificacionesNoEnviadas(){
        boolean enviado;
        List<Notificacion> notificaciones = hermesDao.getNotificacionesNoEnviadas();
        if (!notificaciones.isEmpty()){
            logger.info("Enviando "+notificaciones.size()+" notificaciones pendientes");
            for(Iterator<Notificacion> i = notificaciones.iterator(); i.hasNext(); ) {
                Notificacion n = null;
                try {
                    n = i.next();
                    enviado = ClientHTTPJSONListener.comunicarNotificacion(n);
                    if (enviado) {
                        hermesDao.setNotificacionToEnviada(n);
                    }
                } catch (ComunicarNotificacionException e) {
                    // HermesCore.instancia().marcarNotificacionComoPendiente(n);
                    //e.printStackTrace();
                    logger.log(Level.SEVERE,"Error al comunicar: " +n+ "  Error: "+e.getMessage());
                }
             }
        }
    }
    public void comunicarNotificacion(Pictograma p){
        Notificacion n = null;
        try {
            n = new Notificacion( new java.util.Date(), Categoria.getCategoriaByID(p.getCategoriaID()).getNombre(),"Mi contexto", p.getNombre(), this.getAlumnoActual().toString());
            Boolean enviado = ClientHTTPJSONListener.comunicarNotificacion(n);
            if (enviado) {
                hermesDao.createNewNotificacion(n,true);

            }else{
                hermesDao.createNewNotificacion(n,false);
                this.hayMensajesNoEnviado = true;
            }


           // HermesCore.instancia().marcarNotificacionComoRecibida(n);
        } catch (ComunicarNotificacionException e) {
            // HermesCore.instancia().marcarNotificacionComoPendiente(n);
            //e.printStackTrace();
            hermesDao.createNewNotificacion(n,false);
            this.hayMensajesNoEnviado = true;
            logger.log(Level.SEVERE, "Error al comunicar: " + n + "  Error: " + e.getMessage());
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
        this.getAlumnoActual().setId(this.getHermesDao().createNewAlumno(alumnoActual));
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
        List<Pictograma> ps = new ArrayList<>();
      //  if (alumnoActual.getCategorias().contains(categoria)) {
            ps.addAll(this.getHermesDao().getPictogramas(categoria, alumnoActual.getSexo()));
      //  }
        return ps;
    }

    public List<Pictograma> getPictogramasPorCat(Alumno alumnoActual, Categoria categoria) {


        return hermesDao.getPictogramas(alumnoActual,categoria);
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
    public void setNoEnviados (boolean noEnviados) {
        this.hayMensajesNoEnviado = noEnviados;
    }


    public Pictograma getPictogramaPorNombre(String nombre) {
        return this.getHermesDao().getPictogramaPorNombre(nombre);
    }

}
