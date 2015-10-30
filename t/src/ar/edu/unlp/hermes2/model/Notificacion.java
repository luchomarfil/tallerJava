package ar.edu.unlp.hermes2.model;

import java.util.Date;
import java.util.List;

public class Notificacion extends TransferObject {




	private Date fecha;
	private List<Etiqueta> etiquetas;
	public Categoria categoria;
	public Contexto contexto;
	private Mensaje mensaje;
	public Ninio ninio;
	public Date fechaRecibido;
	public Date fechaEnviado;
	
	public Notificacion(long id,Date fecha, List<Etiqueta> etiquetas,
			Categoria categoria, Contexto contexto, Mensaje mensaje,
			Ninio ninio, Date fechaRecibido, Date fechaEnviado) {
		super(id);
		this.fecha = fecha;
		this.etiquetas = etiquetas;
		this.categoria = categoria;
		this.contexto = contexto;
		this.mensaje = mensaje;
		this.ninio = ninio;
		this.fechaRecibido = fechaRecibido;
		this.fechaEnviado = fechaEnviado;
	}


	
	@Override
	public String toString() {
		return getMensaje() + " de " + getNinio();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Contexto getContexto() {
		return contexto;
	}

	public void setContexto(Contexto contexto) {
		this.contexto = contexto;
	}

	public Ninio getNinio() {
		return ninio;
	}

	public void setNinio(Ninio ninio) {
		this.ninio = ninio;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}
}
