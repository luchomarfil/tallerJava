package ar.edu.unlp.hermes2.dao;

import java.util.List;

import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public class HermesDaoImpl implements HermesDao{

	@Override
	public List<TransferObject> getListaMensajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferObject> getListaContextos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferObject> getListaCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferObject> getListaNinios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferObject> getListaEtiquetas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarEtiqueta(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarEtiqueta(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarEtiqueta(Etiqueta selectedItem, List<Long> idsNotificaciones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) {
		// TODO Auto-generated method stub
		
	}


}
