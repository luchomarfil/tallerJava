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
	
	public Notificacion (Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
	Date fechaEnviado, Date fechaRecibido)
	{}
	
	public Notificacion(Long idCategoria, String nombreContexto, String nombreNinio, String nombreMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido)
			{}
	/*select n.id,ni.nombre, co.nombre, me.nombre, ca.nombre,n.fecha,n.fechaEnviado, n.fechaRecibido
	from 'hermes.notificaciones'  AS n 
	inner join 'hermes.ninios' AS ni on n.idNinio = ni.id
	inner join 'hermes.contextos' AS co on co.id= n.idContexto
	inner join 'hermes.categorias' AS ca on ca.id= n.idCategoria
	inner join 'hermes.mensajes' AS me on me.id= n.idMensaje;
*/
	
	public Notificacion(long id,Mensaje mensaje) {		
		super(id);
		this.setMensaje(mensaje);
		this.fecha = new Date();
		this.setEtiquetas(new ArrayList<Etiqueta>());
	}

	public Notificacion(long id) {
		super(id);
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
