package ar.edu.unlp.hermes2.model;

public class Mensaje extends TransferObject {

	private String nombre;
	private String descripcion;
	private String imagen;
	
	public Mensaje(String nombre, String descripcion, String imagen) {
		this.setNombre(nombre);
		this.setDescripcion(nombre);
		this.setImagen(imagen);
	}
	
	public Mensaje(long id,String nombre, String descripcion, String imagen) {
		super(id);
		this.setNombre(nombre);
		this.setDescripcion(nombre);
		this.setImagen(imagen);
	}


	public Mensaje(String nombreMensaje) {
		nombre=nombreMensaje;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
