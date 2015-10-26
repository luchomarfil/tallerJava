package ar.edu.unlp.hermes2.model;


public class Contexto extends TransferObject {

	private String nombre;
	private String descripcion;
	
	public Contexto(String nombre) {		
		this.nombre = nombre;
	}
	
	public Contexto(String nombre, String descripcion) {		
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Contexto(long id,String nombre) {		
		super(id);
		this.nombre = nombre;
	}
	
	public Contexto(long id,String nombre, String descripcion) {		
		super(id);
		this.nombre = nombre;
		this.descripcion = descripcion;
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
