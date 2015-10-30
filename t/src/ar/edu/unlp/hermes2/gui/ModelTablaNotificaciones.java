package ar.edu.unlp.hermes2.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ar.edu.unlp.hermes2.model.Notificacion;

public class ModelTablaNotificaciones extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COLUMNA_ETIQUETAS = 6;
	private static final int COLUMNA_MENSAJE = 2;
	private static final int COLUMNA_FECHA = 1;
	private static final int COLUMNA_ID = 0;
	private Object[][] data = new Object[][] {};
	private String[] columnNames = new String[] { "Id", "Fecha/Hora env\u00EDo", "Contenido", "Contexto",
			"Categor\u00EDa", "Ni\u00F1@", "Etiquetas" };
	private List<Notificacion> notificaciones;

	// public ModelTablaNotificaciones() {
	// super(DATA,COLUMN_NAMES);
	// }

	public ModelTablaNotificaciones(List<Notificacion> notificaciones) {
		//super(COLUMN_NAMES, notificaciones.size());
		//this.setDataVector(dataVector, columnIdentifiers);
		this.notificaciones = notificaciones;
		//this.setRowCount(notificaciones.size());
		iniciarConLista(this.notificaciones);
	}

	private void iniciarConLista(List<Notificacion> notificaciones) {
		int i = 0;
		if(notificaciones.size()==0){
			data = new Object[18][18];
		}
		else{	
			data = new Object[notificaciones.size()][columnNames.length];
			fireTableDataChanged();
			for (Notificacion notificacion : notificaciones) {			
				this.setValueAt(notificacion.getId(), i, COLUMNA_ID);
				this.setValueAt(notificacion.getFecha(), i, COLUMNA_FECHA);
				this.setValueAt(notificacion.getMensaje(), i, COLUMNA_MENSAJE);
				this.setValueAt(notificacion.getEtiquetas().toString(), i, COLUMNA_ETIQUETAS);
				i++;
			}
		}
	}

	public void setTableData(List<Notificacion> tableData) {
		//this.setRowCount(notificaciones.size());
		iniciarConLista(tableData);
		fireTableDataChanged();
	}

	public String getColumnName(int col) {
		return columnNames[col].toString();
	}

	public int getRowCount() {
		return data.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
