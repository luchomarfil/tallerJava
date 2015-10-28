package ar.edu.unlp.hermes2.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public interface HermesDao {

	Collection<TransferObject> getListaMensajes() throws HermesException;

	List<TransferObject> getListaContextos() throws HermesException;

	List<TransferObject> getListaCategorias() throws HermesException;

	List<TransferObject> getListaNinios() throws HermesException;

	List<TransferObject> getListaEtiquetas() throws HermesException;

	List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) throws HermesException;

	void agregarEtiqueta(Etiqueta etiqueta) throws HermesException;

	Boolean existeEtiquetaPara(String nombreNuevaEtiqueta);

	void eliminarEtiqueta(Etiqueta etiqueta) throws HermesException;

	void asignarEtiqueta(Etiqueta selectedItem, List<Long> idsNotificaciones) throws HermesException;

	Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar);

	void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) throws HermesException;

	void nuevaNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido) throws HermesException;

}
