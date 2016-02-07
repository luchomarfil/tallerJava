package ar.edu.unlp.hermesmarfiltibaldo.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Notificacion {
	private static SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");

	private static final String CATEGORIA_PREDETERMINADA = "Predeterminada";
	private Date fecha;
	
	private String categoria;
	
	private String contexto;
	
	private String mensaje;
	
	private String ninio;

	public Notificacion() {
	}
	
	public Notificacion(Date fecha, String categoria, String contexto,
			String mensaje, String ninio) {
		this.fecha = fecha;
		this.categoria = categoria;
		this.contexto = contexto;
		this.mensaje = mensaje;
		this.ninio = ninio;
	}

	public Notificacion(Date fecha, String contexto, String mensaje,
			String ninio) {

		this.fecha = fecha;
		this.categoria = CATEGORIA_PREDETERMINADA;
		this.contexto = contexto;
		this.mensaje = mensaje;
		this.ninio = ninio;
	}

//	public Notificacion(Date fecha, String categoria, String contexto,
//			String mensaje, String ninio) {
//		//SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//		//this.fecha = Long.parseLong(formatter.format(fecha));
//		this.fecha = fecha;
//		this.categoria = categoria;
//		this.contexto = contexto;
//		this.mensaje = mensaje;
//		this.ninio = ninio;
//	}
//
//	public Notificacion(Date fecha, String contexto,
//			String mensaje, String ninio) {
//		//SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//		this.fecha = fecha;
//		//this.fecha = Long.parseLong(formatter.format(fecha));
//		this.categoria = CATEGORIA_PREDETERMINADA;
//		this.contexto = contexto;
//		this.mensaje = mensaje;
//		this.ninio = ninio;
//	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNinio() {
		return ninio;
	}

	public void setNinio(String ninio) {
		this.ninio = ninio;
	}
	
	public String toJson() {
		return "{'categoria':'" + getCategoria() + "','contexto':'"
				+ getContexto() + "','mensaje':'" + getMensaje()
				+ "','ninio':'" + getNinio() + "','fecha':'" + formatter.format(getFecha())
				+ "','fechaEnviado':'"
				+ formatter.format(new Date())
				+ "'}";
		
	}
}
