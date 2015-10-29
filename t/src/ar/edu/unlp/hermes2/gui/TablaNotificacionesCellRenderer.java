package ar.edu.unlp.hermes2.gui;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableCellRenderer;

import ar.edu.unlp.hermes2.monitor.MonitorUtils;

public class TablaNotificacionesCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DateFormat formatter = MonitorUtils.formatterFechaVisual;

	public TablaNotificacionesCellRenderer() {
		super();
	}

	public void setValue(Object value) {
		if(value==null){
			this.setText("");
		}
		if(value instanceof Date){
			setText((value == null) ? "" : formatter.format(value));
		}
		else{
			super.setValue(value);
		}
	}
}