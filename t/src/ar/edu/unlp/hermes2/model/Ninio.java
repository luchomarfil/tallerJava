package ar.edu.unlp.hermes2.model;

public class Ninio extends TransferObject {

	private String nombre;
	private String apellido;
	
	public Ninio(String nombre, String apellido) {		
		this.nombre = nombre;
		this.setApellido(apellido);
	}

	public Ninio(long id,String nombre, String apellido) {		
		super(id);
		this.nombre = nombre;
		this.setApellido(apellido);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
