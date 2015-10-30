package ar.edu.unlp.hermes2.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public class HermesDaoMockImpl implements HermesDao {

	private HashMap<Long,Mensaje> mensajes = new HashMap<Long, Mensaje>();
	private HashMap<Long,Contexto> contextos = new HashMap<Long, Contexto>();
	private HashMap<Long,Ninio> ninios = new HashMap<Long, Ninio>();
	private HashMap<Long,Categoria> categorias = new HashMap<Long, Categoria>();
	private HashMap<Long,Etiqueta> etiquetas = new HashMap<Long, Etiqueta>();
	private HashMap<Long,Notificacion> notificaciones = new HashMap<Long, Notificacion>();

	public HermesDaoMockImpl() {
		this.inicializarListas();
	}

	private void inicializarListas() {
//		Mensaje mensaje1 = new Mensaje("Entusiasmado");
//		getMensajes().put(mensaje1.getId(),mensaje1);
//		Mensaje mensaje2 = new Mensaje("Contento");
//		getMensajes().put(mensaje2.getId(),mensaje2);
//		Mensaje mensaje3 = new Mensaje("Hambriento");
//		getMensajes().put(mensaje3.getId(),mensaje3);		
//		Mensaje mensaje4 = new Mensaje("Jugar");
//		getMensajes().put(mensaje4.getId(),mensaje4);
//		
		Contexto contexto = new Contexto("Patio");
		getContextos().put(contexto.getId(),contexto);
		Contexto contexto2 = new Contexto("Sum");
		getContextos().put(contexto2.getId(),contexto2);
		Contexto contexto3 = new Contexto("Hogar");
		getContextos().put(contexto3.getId(),contexto);
		Contexto contexto4 = new Contexto("Escuela");
		getContextos().put(contexto4.getId(),contexto4);
//		
//		Ninio ninio = new Ninio("Juan");
//		getNinios().put(ninio.getId(),ninio);
//		Ninio n2 = new Ninio("Maria");
//		getNinios().put(n2.getId(),n2);
//		Ninio n3 = new Ninio("Dario");
//		getNinios().put(n3.getId(),n3);		
//		Ninio n4 = new Ninio("Fernando");
//		getNinios().put(n4.getId(),n4);
//		Ninio n5 = new Ninio("Susana");
//		getNinios().put(n5.getId(),n5);
//		Ninio n6 = new Ninio("Roberto");
//		getNinios().put(n6.getId(),n6);
		
		Categoria c1 = new Categoria("Categoria1");
		getCategorias().put(c1.getId(),c1);
		Categoria c2 = new Categoria("Categoria2");
		getCategorias().put(c2.getId(),c2);
		
		Etiqueta e1 = new Etiqueta("Importante");
		getEtiquetas().put(e1.getId(),e1);
		Etiqueta e2 = new Etiqueta("Prestar atención");
		getEtiquetas().put(e2.getId(),e2);
		Etiqueta e3 = new Etiqueta("Progreso");
		getEtiquetas().put(e3.getId(),e3);
		Etiqueta e4= new Etiqueta("Retroceso");
		getEtiquetas().put(e4.getId(),e4);
		
//		Notificacion nn1 = new Notificacion(mensaje1);
//		getNotificaciones().put(nn1.getId(),nn1);
//		Notificacion nn2 = new Notificacion(mensaje2);
//		getNotificaciones().put(nn2.getId(),nn2);
//		Notificacion nn3 = new Notificacion(mensaje3);
//		getNotificaciones().put(nn3.getId(),nn3);
//		Notificacion nn4 = new Notificacion(mensaje4);
//		getNotificaciones().put(nn4.getId(),nn4);
	}

	public List<TransferObject> getListaMensajes() {
		List<TransferObject> l = new ArrayList<TransferObject>();
		l.addAll(getMensajes().values());
		return l;		
	}

	public List<TransferObject> getListaContextos() {		
		List<TransferObject> l = new ArrayList<TransferObject>();
		l.addAll(getContextos().values());
		return l;
	}

	public List<TransferObject> getListaNinios() {
		List<TransferObject> l = new ArrayList<TransferObject>();
		l.addAll(getNinios().values());
		return l;

	}

	public List<TransferObject> getListaCategorias() {
		List<TransferObject> l = new ArrayList<TransferObject>();
		l.addAll(getCategorias().values());
		return l;
	}

	public List<TransferObject> getListaEtiquetas() {
		List<TransferObject> l = new ArrayList<TransferObject>();
		l.addAll(getEtiquetas().values());
		return l;

	}

	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
		List<Notificacion> nt = new ArrayList<Notificacion>();
		Collection<Notificacion> notificacionesSistema = getNotificaciones().values();
		// si es una condicion que se tiene que cumplir porque es distinta de
		// null
		// y no se cumple, se descarta la notificacion
		for (Notificacion notificacion : notificacionesSistema) {

			if (filtro.getCategoria() != null && !filtro.getCategoria().equals(notificacion.categoria)) {
				continue;
			}
			if (filtro.getContexto() != null && !filtro.getContexto().equals(notificacion.contexto)) {
				continue;
			}
			if (filtro.getEtiqueta() != null && !notificacion.getEtiquetas().contains(filtro.getEtiqueta())) {
				continue;
			}
			if (filtro.getMensaje() != null && !filtro.getMensaje().equals(notificacion.getMensaje())) {
				continue;
			}
			if (filtro.getNinio() != null && !filtro.getNinio().equals(notificacion.ninio)) {
				continue;
			}
			if (filtro.getFechaDesde()!=null && !filtro.getFechaDesde().before(notificacion.getFecha())){
				continue;
			}
			if (filtro.getFechaHasta()!=null && !filtro.getFechaHasta().after(notificacion.getFecha())){
				continue;
			}
			nt.add(notificacion);
		}		
		return nt;
	}

	public void agregarEtiqueta(Etiqueta etiqueta) {
		this.getEtiquetas().put(etiqueta.getId(),etiqueta);
	}

	@Override
	public Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) {
		return existeEtiquetaPara(nombreNuevaEtiqueta, null);
	}
	
	@Override
	public Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaExcluir) {
		
		//cuando modifico nombre no etiqueta.
		
		Collection<Etiqueta> etiquetasValues = getEtiquetas().values();
		for (Etiqueta etiqueta : etiquetasValues) {

			if (!etiqueta.equals(etiquetaExcluir) && etiqueta.getNombre().equalsIgnoreCase(nuevoNombre)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public TransferObject getTransferObject(Class clazz, Long id){
		String lista = armarNombreLista(clazz);
		Field field;
		try {
			field = this.getClass().getDeclaredField(lista);
			HashMap listaEntidades = (HashMap) field.get(this);
			return (TransferObject) listaEntidades.get(id);			
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("rawtypes")
	private String armarNombreLista(Class clazz) {
		//si termina en vocal, solo agregamos s
		if(clazz.getSimpleName().matches("^.*[aeiou]$")){
			return clazz.getSimpleName().toLowerCase() + "s";
		}
		else{
			return clazz.getSimpleName().toLowerCase() + "es";
		}
	}

	@Override
	public void eliminarEtiqueta(Etiqueta etiqueta) {
		this.getEtiquetas().remove(etiqueta.getId());
	}

	@Override
	public void asignarEtiqueta(Etiqueta etiqueta, List<Long> idsNotificaciones) {
		for (Long id : idsNotificaciones) {
			Notificacion n = (Notificacion) getTransferObject(Notificacion.class, id);
			if(!n.getEtiquetas().contains(etiqueta)){
				n.getEtiquetas().add(etiqueta);
			}
		}
	}
	
	@Override
	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) {
		this.getEtiquetas().get(etiquetaARenombrar.getId()).setNombre(nuevoNombre);		
	}

	public HashMap<Long,Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(HashMap<Long,Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public HashMap<Long,Contexto> getContextos() {
		return contextos;
	}

	public void setContextos(HashMap<Long,Contexto> contextos) {
		this.contextos = contextos;
	}

	public HashMap<Long,Ninio> getNinios() {
		return ninios;
	}

	public void setNinios(HashMap<Long,Ninio> ninios) {
		this.ninios = ninios;
	}

	public HashMap<Long,Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(HashMap<Long,Categoria> categorias) {
		this.categorias = categorias;
	}

	public HashMap<Long,Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(HashMap<Long,Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public HashMap<Long,Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(HashMap<Long,Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	@Override
	public void nuevaNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido) {
//		Notificacion n = new Notificacion();
//		n.setMensaje((Mensaje) getTransferObject(Mensaje.class, idMensaje));
		
	}


	
	

}
