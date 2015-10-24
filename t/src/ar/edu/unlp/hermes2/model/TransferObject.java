package ar.edu.unlp.hermes2.model;

import java.util.Random;

public class TransferObject {

	private Long id;
	
	public TransferObject() {
		id = new Random().nextLong();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getId().toString(); 
	}
}
