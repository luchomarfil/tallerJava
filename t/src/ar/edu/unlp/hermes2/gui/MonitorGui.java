package ar.edu.unlp.hermes2.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import javax.swing.JFrame;

import ar.edu.unlp.hermes2.notification.ArchivoNotificacionListener;
import ar.edu.unlp.hermes2.notification.HttpServerNotificacionListener;
import ar.edu.unlp.hermes2.notification.IEventosExternosListener;
import ar.edu.unlp.hermes2.notification.JSONNotificacionListener;

public class MonitorGui extends JFrame implements WindowListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8242603121100243154L;
	private IEventosExternosListener threadListener;

	public MonitorGui() {		
		
	}

	public static void main(String[] args) {		
		MonitorGui monitorGui = new MonitorGui();
		monitorGui.config();
		monitorGui.setVisible(true);		
		//monitorGui.setThreadListener(new ArchivoNotificacionListener());
		//monitorGui.setThreadListener(new JSONNotificacionListener());
		monitorGui.setThreadListener(new HttpServerNotificacionListener());

		monitorGui.getThreadListener().run();


	}

	private void config() {
		try {
			InputStream res = MonitorGui.class.getClassLoader().getResourceAsStream("ar/edu/unlp/hermes2/resources/logging.properties");			
			LogManager.getLogManager().readConfiguration(res);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setSize(new Dimension(970, 600));
			setPreferredSize(new Dimension(970, 600));

			MonitorGuiPanel monitorGuiPanel = new MonitorGuiPanel();
			monitorGuiPanel.actualizarEstadoDefault();
			getContentPane().add(monitorGuiPanel, BorderLayout.CENTER);		
			
			setTitle("Monitor");
			
			this.addWindowListener(this);
			
		} catch (SecurityException | IOException e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(getThreadListener()!=null){
			getThreadListener().cerrarConexion();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	public IEventosExternosListener getThreadListener() {
		return threadListener;
	}

	public void setThreadListener(IEventosExternosListener threadListener) {
		this.threadListener = threadListener;
	}

}
