package ar.edu.unlp.hermes2.gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.unlp.hermes2.model.Notificacion;

public class ModelTablaNotificaciones extends DefaultTableModel {

	private static final int COLUMNA_ETIQUETAS = 6;
	private static final int COLUMNA_MENSAJE = 2;
	private static final int COLUMNA_FECHA = 1;
	private static final int COLUMNA_ID = 0;
	private static final Object[][] DATA = new Object[][]{};
	private static final String[] COLUMN_NAMES = new String[] {"Id", "Fecha/Hora env\u00EDo", "Contenido", "Contexto", "Categor\u00EDa", "Ni\u00F1@",
			"Etiquetas" };
	

	public ModelTablaNotificaciones() {
		super(DATA,COLUMN_NAMES);
	}
	
	public ModelTablaNotificaciones(List<Notificacion> notificaciones){
		super(COLUMN_NAMES,notificaciones.size());
		iniciarConLista(notificaciones);
	}

	private void iniciarConLista(List<Notificacion> notificaciones) {
		int i = 0;
		for (Notificacion notificacion : notificaciones) {
			this.setValueAt(notificacion.getId(), i, COLUMNA_ID);
			this.setValueAt(notificacion.getFecha(), i, COLUMNA_FECHA);
			this.setValueAt(notificacion.getMensaje(), i, COLUMNA_MENSAJE);
			this.setValueAt(notificacion.getEtiquetas().toString(), i, COLUMNA_ETIQUETAS);
			
			i++;
		}
		
		
	}
	

}
