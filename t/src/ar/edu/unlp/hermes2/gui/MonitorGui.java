package ar.edu.unlp.hermes2.gui;

import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.JXBusyLabel;
import org.jdesktop.swingx.auth.JDBCLoginService;
import org.jdesktop.swingx.JXErrorPane;

public class MonitorGui extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242603121100243154L;

	public MonitorGui() {
		
		JXDatePicker datePicker = new JXDatePicker();
		add(datePicker);
		// TODO Auto-generated constructor stub
	}

}
