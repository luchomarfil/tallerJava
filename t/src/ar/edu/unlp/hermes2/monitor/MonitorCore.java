package ar.edu.unlp.hermes2.monitor;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.JTextField;

import ar.edu.unlp.hermes2.dao.HermesDao;
import ar.edu.unlp.hermes2.dao.HermesDaoImpl;
//import ar.edu.unlp.hermes2.dao.HermesDaoMockImpl;
import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;

public class MonitorCore extends Observable{
	private Logger logger = Logger.getLogger(MonitorCore.class.getName());
	private static MonitorCore instance;
	private HermesDao hermesDao = new HermesDaoImpl();

	private MonitorCore() {

	}

	public synchronized static MonitorCore instance() {
		if (instance == null) {
			instance = new MonitorCore();
		}
		return instance;
	}

	public HermesDao getHermesDao() {
		return this.hermesDao;
	}

	public void setHermesDao(HermesDao hermesDao) {
		this.hermesDao = hermesDao;
	}

	public List<TransferObject> getListaMensajes() throws HermesException {
		return (List<TransferObject>) getHermesDao().getListaMensajes();
	}

	public List<TransferObject> getListaContextos() throws HermesException {
		return getHermesDao().getListaContextos();
	}

	public List<TransferObject> getListaNinios() throws HermesException {
		return getHermesDao().getListaNinios();

	}

	public List<TransferObject> getListaCategorias() throws HermesException {
		return getHermesDao().getListaCategorias();

	}

	public List<TransferObject> getListaEtiquetas() throws HermesException {
		return getHermesDao().getListaEtiquetas();
	}

	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) throws HermesException {
		logger.info("El filtro recibido es:" + filtro);
		return getHermesDao().obtenerNotificacionesFiltradas(filtro);
	}

	public void agregarEtiqueta(String nombreNuevaEtiqueta) throws HermesException {
		// realiza controles sobre la nueva etiqueta, por ejemplo que no este
		// vacia
		if (!getHermesDao().existeEtiquetaPara(nombreNuevaEtiqueta)) {
			getHermesDao().agregarEtiqueta(new Etiqueta(nombreNuevaEtiqueta));
		} else {
			throw new HermesException("Ya existe una etiqueta con ese nombre");
		}
	}

	public void eliminarEtiqueta(Etiqueta etiqueta) throws HermesException {
		getHermesDao().eliminarEtiqueta(etiqueta);
	}

	public void asignarEtiqueta(Etiqueta etiqueta, List<Long> idsNotificaciones) throws HermesException {
		getHermesDao().asignarEtiqueta(etiqueta,idsNotificaciones);
		
	}

	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) throws HermesException {
		// realiza controles sobre la nueva etiqueta, por ejemplo que no este
		// vacia
		if (!getHermesDao().existeEtiquetaPara(nuevoNombre,etiquetaARenombrar)) {
			getHermesDao().renombrarEtiqueta(etiquetaARenombrar,nuevoNombre);
		} else {
			throw new HermesException("Ya existe otra etiqueta con ese nombre");
		}
	}

	
	/**
	 * Metodo que recibe desde los listeners nuevos datos a transformar en notificacion
	 * @param idCategoria
	 * @param idContexto
	 * @param idNinio
	 * @param idMensaje
	 * @param fecha
	 * @param fechaEnviado
	 * @throws HermesException 
	 */
	public void recibirNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado) throws HermesException {
		Date fechaRecibido = new Date();
		getHermesDao().nuevaNotificacion(idCategoria,idContexto,idNinio,idMensaje,fecha,fechaEnviado,fechaRecibido);
		this.setChanged();
		this.notifyObservers();
	}
}
