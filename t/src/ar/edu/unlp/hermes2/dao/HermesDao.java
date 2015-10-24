package ar.edu.unlp.hermes2.dao;

import java.util.Collection;
import java.util.List;

import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public interface HermesDao {

	Collection<TransferObject> getListaMensajes();

	List<TransferObject> getListaContextos();

	List<TransferObject> getListaCategorias();

	List<TransferObject> getListaNinios();

	List<TransferObject> getListaEtiquetas();

	List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro);

	void agregarEtiqueta(Etiqueta etiqueta);

	Boolean existeEtiquetaPara(String nombreNuevaEtiqueta);

	void eliminarEtiqueta(Etiqueta etiqueta);

	void asignarEtiqueta(Etiqueta selectedItem, List<Long> idsNotificaciones);

	Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar);

	void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre);

}
