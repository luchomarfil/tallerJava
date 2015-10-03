package practica4.app;

import java.util.ArrayList;
import java.util.List;

import practica4.gui.DuracionNota;
import practica4.gui.EntonacionNota;

public class Melodia {
	private String melodia;
	
	public Melodia() {
		this.melodia = "";
	}
	
	public void agregarNota(EntonacionNota tono, DuracionNota duracion){
		this.melodia = this.melodia + tono.name()+duracion.getFugue();
	}
	
	public String getMelodia(){
		return this.melodia;
	}
}
