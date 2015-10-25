package ar.edu.unlp.hermes2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notificacion extends TransferObject {


	private String nombre;
	private Date fecha;
	private List<Etiqueta> etiquetas;
	public Categoria categoria;
	public Contexto contexto;
	private Mensaje mensaje;
	public Ninio ninio;
	public Date fechaRecibido;
	
	public Notificacion(Mensaje mensaje) {		
		this.setMensaje(mensaje);
		this.fecha = new Date();
		this.setEtiquetas(new ArrayList<Etiqueta>());
	}

	public Notificacion() {
		this.fecha = new Date();
		this.setEtiquetas(new ArrayList<Etiqueta>());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return getNombre();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
}
