package ar.edu.unlp.hermes2.monitor;

import java.util.Date;

import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;

public class FiltroNotificacion {

	private Categoria categoria;
	private Contexto contexto;
	private Etiqueta etiqueta;
	private Mensaje mensaje;
	private Ninio ninio;
	private Date fechaDesde;
	private Date fechaHasta;

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

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public Ninio getNinio() {
		return ninio;
	}

	public void setNinio(Ninio ninio) {
		this.ninio = ninio;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	@Override
	public String toString() {
		return "FiltroNotificacion [categoria=" + categoria + ", contexto=" + contexto + ", etiqueta=" + etiqueta
				+ ", mensaje=" + mensaje + ", ninio=" + ninio + ", fechaDesde=" + fechaDesde + ", fechaHasta="
				+ fechaHasta + "]";
	}

}
