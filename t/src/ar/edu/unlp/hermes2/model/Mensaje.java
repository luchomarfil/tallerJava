package ar.edu.unlp.hermes2.model;

public class Mensaje extends TransferObject {

	private String nombre;

	public Mensaje(String nombre) {
		this.setNombre(nombre);
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
