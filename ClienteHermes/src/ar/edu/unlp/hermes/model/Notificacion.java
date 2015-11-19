package ar.edu.unlp.hermes.model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Notificacion {
	
	
	public Notificacion(long fecha, long idCategoria, long idContexto, long idCensaje, long idNinio) {
		this.fecha = fecha;
		this.idCategoria = idCategoria;
		this.idContexto = idContexto;
		this.idMensaje = idCensaje;
		this.idNinio = idNinio;
	}
	
	public Notificacion(long fecha, long idContexto, long idCensaje, long idNinio) {

		this.fecha = fecha;
		this.idCategoria = 1;
		this.idContexto = idContexto;
		this.idMensaje = idCensaje;
		this.idNinio = idNinio;
	}
	
	public Notificacion(Date fecha, long idCategoria, long idContexto, long idCensaje, long idNinio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		this.fecha = Long.parseLong(formatter.format(fecha));
		this.idCategoria = idCategoria;
		this.idContexto = idContexto;
		this.idMensaje = idCensaje;
		this.idNinio = idNinio;
	}
	 
	public Notificacion(Date fecha, long idContexto, long idCensaje, long idNinio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		this.fecha = Long.parseLong(formatter.format(fecha));
		this.idCategoria = 1;
		this.idContexto = idContexto;
		this.idMensaje = idCensaje;
		this.idNinio = idNinio;
	}
	 
	private long fecha;
	private long idCategoria;
	private long idContexto;
	private long idMensaje;
	private long idNinio;
	public long getFecha() {
		return fecha;
	}
	public void setFecha(long fecha) {
		this.fecha = fecha;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public long getIdContexto() {
		return idContexto;
	}
	public void setIdContexto(long idContexto) {
		this.idContexto = idContexto;
	}
	public long getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(long idCensaje) {
		this.idMensaje = idCensaje;
	}
	public long getIdNinio() {
		return idNinio;
	}
	public void setIdNinio(long idNinio) {
		this.idNinio = idNinio;
	}
	
	public String toJson(){
		return "{'idCategoria':'"+ getIdCategoria() +"','idContexto':'"+ getIdContexto() +"','idMensaje':'"+getIdMensaje() +"','idNinio':'"+ getIdNinio()+"','fecha':'"+getFecha() +"','fechaEnviado':'"+(new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()) +"'}";
	}
}


