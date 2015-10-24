package ar.edu.unlp.hermes2.monitor;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.JTextField;

import ar.edu.unlp.hermes2.dao.HermesDao;
import ar.edu.unlp.hermes2.dao.HermesDaoMockImpl;
import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;

public class MonitorCore extends Observable{
	private Logger logger = Logger.getLogger(MonitorCore.class.getName());
	private static MonitorCore instance;
	private HermesDao hermesDao = new HermesDaoMockImpl();

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

	public List<TransferObject> getListaMensajes() {
		return (List<TransferObject>) getHermesDao().getListaMensajes();
	}

	public List<TransferObject> getListaContextos() {
		return getHermesDao().getListaContextos();
	}

	public List<TransferObject> getListaNinios() {
		return getHermesDao().getListaNinios();

	}

	public List<TransferObject> getListaCategorias() {
		return getHermesDao().getListaCategorias();

	}

	public List<TransferObject> getListaEtiquetas() {
		return getHermesDao().getListaEtiquetas();
	}

	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
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

	public void eliminarEtiqueta(Etiqueta etiqueta) {
		getHermesDao().eliminarEtiqueta(etiqueta);
	}

	public void asignarEtiqueta(Etiqueta etiqueta, List<Long> idsNotificaciones) {
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

	public void recibirNotificacion(Notificacion n){
		n.fechaRecibido = new Date();
		this.setChanged();
		this.notifyObservers();
	}
}
