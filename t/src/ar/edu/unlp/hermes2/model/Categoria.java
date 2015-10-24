package ar.edu.unlp.hermes2.model;

public class Categoria extends TransferObject {


	private String nombre;
	
	public Categoria(String nombre) {		
		this.nombre = nombre;
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
}
