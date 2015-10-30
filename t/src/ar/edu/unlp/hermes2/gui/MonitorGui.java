package ar.edu.unlp.hermes2.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import javax.swing.JFrame;

import ar.edu.unlp.hermes2.notification.ArchivoNotificacionListener;

public class MonitorGui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8242603121100243154L;

	public MonitorGui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setSize(new Dimension(970, 600));
		setPreferredSize(new Dimension(970, 600));

		MonitorGuiPanel monitorGuiPanel = new MonitorGuiPanel();
		getContentPane().add(monitorGuiPanel, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {		
		MonitorGui monitorGui = new MonitorGui();
		monitorGui.config();
		monitorGui.setVisible(true);		
		new ArchivoNotificacionListener().run();

	}

	private void config() {
		try {
			InputStream res = MonitorGui.class.getClassLoader().getResourceAsStream("ar/edu/unlp/hermes2/resources/logging.properties");			
			LogManager.getLogManager().readConfiguration(res);
		} catch (SecurityException | IOException e) {			
			e.printStackTrace();
		}
	}
}
