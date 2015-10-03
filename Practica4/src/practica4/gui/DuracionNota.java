package practica4.gui;

public enum DuracionNota {
	REDONDA("redonda","w"),BLANCA("blanca","h"),NEGRA("negra","q"),
	CORCHEA("corchea","i"),SEMICORCHEA("semicorchea","s"),
	FUSA("fusa","t"),SEMIFUSA("semifusa","x");
	
	private String nombre;
	private String fugue;

	private DuracionNota(String nombre, String fugue) {
		this.nombre = nombre;
		this.fugue = fugue;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFugue() {
		return fugue;
	}

	
}
