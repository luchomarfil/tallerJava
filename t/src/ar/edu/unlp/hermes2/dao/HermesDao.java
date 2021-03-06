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

	Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) throws HermesException;

	void eliminarEtiqueta(Etiqueta etiqueta) throws HermesException;

	void asignarEtiqueta(Etiqueta selectedItem, List<Notificacion> notificaciones) throws HermesException;

	Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar) throws HermesException;

	void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) throws HermesException;

	void nuevaNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido) throws HermesException;

	Boolean existeNotificacion(Long idNinio, Long idMensaje, Long idCategoria, Long idContexto, Date fecha, Date fechaEnviado) throws HermesException;
	
	/**
	 * Obtiene la categoria con nombreCategoria, sino existe la crea y devuelve el id que le corresponde a su creacion
	 * 
	 * @param categoria
	 * @return
	 * @throws HermesException 
	 */
	Long obtenerOCrearCategoria(String categoria) throws HermesException;

	Long obtenerOCrearContexto(String nombreContexto) throws HermesException;

	Long obtenerOCrearNinio(String nombreNinio) throws HermesException;

	Long obtenerOCrearMensaje(String nombreMensaje) throws HermesException;

}
