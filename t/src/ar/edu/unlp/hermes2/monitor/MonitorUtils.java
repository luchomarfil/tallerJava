package ar.edu.unlp.hermes2.monitor;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ar.edu.unlp.hermes2.model.NullElement;
import ar.edu.unlp.hermes2.model.TransferObject;

public class MonitorUtils {

	public static ComboBoxModel<TransferObject> crearModelCombobox(List<TransferObject> lista) {
		DefaultComboBoxModel<TransferObject> defaultComboBoxModel = new DefaultComboBoxModel<TransferObject>();
		for (TransferObject t : lista) {
			defaultComboBoxModel.addElement(t);
		}
		return defaultComboBoxModel;
	}
	
	public static ComboBoxModel<TransferObject> crearModelCombobox(List<TransferObject> lista, Boolean conSeleccione) {
		DefaultComboBoxModel<TransferObject> defaultComboBoxModel = new DefaultComboBoxModel<TransferObject>();
		if(conSeleccione){
			defaultComboBoxModel.addElement(new NullElement("Seleccione"));
		}
		for (TransferObject t : lista) {
			defaultComboBoxModel.addElement(t);
		}
		return defaultComboBoxModel;		
	}

	public static TransferObject getSiSeleccionado(JComboBox<TransferObject> comboBoxCategoria) {
		if (comboBoxCategoria.getSelectedItem() != null && !(comboBoxCategoria.getSelectedItem() instanceof NullElement)){
			return (TransferObject) comboBoxCategoria.getSelectedItem();
		}
		return null;
	}

}
