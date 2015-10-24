package ar.edu.unlp.hermes2.gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.unlp.hermes2.model.Notificacion;

public class ModelTablaNotificaciones extends DefaultTableModel {

	private static final Object[][] DATA = new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
			{ null, null, null, null, null, null }, { null, null, null, null, null, null },
			{ null, null, null, null, null, null }, };
	private static final String[] COLUMN_NAMES = new String[] { "Fecha/Hora env\u00EDo", "Contenido", "Contexto", "Categor\u00EDa", "Ni\u00F1@",
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
			
			this.setValueAt(notificacion.getNombre(), i, 0);
			this.setValueAt(notificacion.getId(), i, 1);
			i++;
		}
		
		
	}
	

}
