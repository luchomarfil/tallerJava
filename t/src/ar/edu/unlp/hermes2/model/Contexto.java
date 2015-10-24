package ar.edu.unlp.hermes2.model;

import java.util.Random;

public class Contexto extends TransferObject {

	private String nombre;
	
	public Contexto(String nombre) {		
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
