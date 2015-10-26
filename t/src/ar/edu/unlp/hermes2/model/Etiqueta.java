package ar.edu.unlp.hermes2.model;

public class Etiqueta extends TransferObject {
	private String nombre;
	private String descripcion;
	//private int idTerapeuta; -> Nombre pls

	public Etiqueta(String nombre) {
		this.setNombre(nombre);
	}

	public Etiqueta(String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}	
	
	public Etiqueta(long id,String nombre) {
		super(id);
		this.setNombre(nombre);
	}

	public Etiqueta(long id,String nombre, String descripcion) {
		super(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
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
}
