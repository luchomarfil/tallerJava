package ar.edu.unlp.hermes2.gui;

import javax.swing.JFrame;

import ar.edu.unlp.hermes2.notification.ArchivoNotificacionListener;
import ar.edu.unlp.hermes2.notification.IEventosExternosListener;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
		new MonitorGui().setVisible(true);		
		new ArchivoNotificacionListener().run();

	}
}
