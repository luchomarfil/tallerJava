package ar.edu.unlp.hermes.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.monitor.Monitor;

import ar.edu.unlp.hermes.annotations.Mock;
import ar.edu.unlp.hermes.annotations.MockStringAttribute;
import ar.edu.unlp.hermes.annotations.MockTodayAttribute;

@Mock
public class Notificacion {
	private static SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");

	private static final String CATEGORIA_PREDETERMINADA = "Predeterminada";
	@MockTodayAttribute
	private Date fecha;
	
	@MockStringAttribute ({"Predeterminada", "Emociones", "Alimentos","Actividades y Paseos"})
	private String categoria;
	
	@MockStringAttribute ({"Establo-­Terapia", "Pista", "Hogar", "Casa-Juegos"})  
	private String contexto;
	
	@MockStringAttribute ({"Contento", "Hambre", "Feliz", "Enojado", "Cansado", "Jugar", "Caballo", 
						   "Papa", "Mama", "Casa", "Miedo"})  
	private String mensaje;
	
	@MockStringAttribute({"Rodrigo","Susana","Juan", "Pedro", "Juana", "Manuela", "Eduardo", 
						  "Jose", "Roberto", "Marcelo", "Veronica", "Rosa", "Clara"})  
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
