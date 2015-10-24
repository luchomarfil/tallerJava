package ar.edu.unlp.hermes2.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ar.edu.unlp.hermes2.dao.HermesDao;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;

public class MonitorCore {
	private Logger logger = Logger.getLogger(MonitorCore.class.getName());
	private static MonitorCore instance;
	
	private MonitorCore() {

	}

	public synchronized static MonitorCore instance() {
		if(instance==null){
			instance = new MonitorCore();
		}
		return instance;
	}

	public List<TransferObject> getListaMensajes() {
		return HermesDao.instance().getListaMensajes();
	}

	public List<TransferObject> getListaContextos() {
		return HermesDao.instance().getListaContextos();
	}

	public List<TransferObject> getListaNinios() {
		return HermesDao.instance().getListaNinios();

	}

	public List<TransferObject> getListaCategorias() {
		return HermesDao.instance().getListaCategorias();

	}

	public List<TransferObject> getListaEtiquetas() {
		return HermesDao.instance().getListaEtiquetas();
	}

	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
		logger.info("El filtro recibido es");
		logger.info("Filtro:"+filtro);
		return HermesDao.instance().obtenerNotificacionesFiltradas(filtro);
	}

}
