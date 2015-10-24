package ar.edu.unlp.hermes2.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public class HermesDao {

	private static HermesDao instance;
	
	private HermesDao() {

	}

	public synchronized static HermesDao instance() {
		if(instance==null){
			instance = new HermesDao();
		}
		return instance;
	}

	public List<TransferObject> getListaMensajes() {
		List<TransferObject> tf = new ArrayList<TransferObject>();
		tf.add(new Mensaje("Entusiasmado"));
		tf.add(new Mensaje("Contento"));
		tf.add(new Mensaje("Hambriento"));
		tf.add(new Mensaje("Jugar"));
		return tf;
	}

	public List<TransferObject> getListaContextos() {
		List<TransferObject> tf = new ArrayList<TransferObject>();
		tf.add(new Contexto("Patio"));
		tf.add(new Contexto("Sum"));
		tf.add(new Contexto("Hogar"));
		tf.add(new Contexto("Escuela"));
		return tf;
	}

	public List<TransferObject> getListaNinios() {
		List<TransferObject> tf = new ArrayList<TransferObject>();
		tf.add(new Ninio("Juan"));
		tf.add(new Ninio("Maria"));
		tf.add(new Ninio("Dario"));
		tf.add(new Ninio("Fernando"));
		tf.add(new Ninio("Susana"));
		tf.add(new Ninio("Roberto"));		
		return tf;
	}

	public List<TransferObject> getListaCategorias() {
		List<TransferObject> tf = new ArrayList<TransferObject>();
		tf.add(new Categoria("Categoria1"));
		tf.add(new Categoria("Categoria2"));						
		return tf;
	}

	public List<TransferObject> getListaEtiquetas() {
		List<TransferObject> tf = new ArrayList<TransferObject>();
		tf.add(new Etiqueta("Importante"));
		tf.add(new Etiqueta("Prestar atención"));
		tf.add(new Etiqueta("Progreso"));
		tf.add(new Etiqueta("Retroceso"));						
		return tf;
	}

	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
		List<Notificacion> nt = new ArrayList<Notificacion>();
		nt.add(new Notificacion("Uno"));
		nt.add(new Notificacion("Dos"));
		nt.add(new Notificacion("Tres"));
		nt.add(new Notificacion("Cuatro"));
		return nt;
	}
	
}
