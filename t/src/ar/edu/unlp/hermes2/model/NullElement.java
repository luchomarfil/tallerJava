package ar.edu.unlp.hermes2.model;

public class NullElement extends TransferObject {
	
	private String descripcion; 
	
	public NullElement(String descripcion) {
		this.setId(null);
		this.setDescripcion(descripcion);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return getDescripcion();
	}
}
