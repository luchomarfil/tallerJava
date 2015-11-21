package ar.edu.unlp.hermes2.notification;

import java.util.Date;

import ar.edu.unlp.hermes2.gui.HermesException;

public interface IEventosExternosListener {

	void procesarNotificacion(String categoria, String contexto, String ninio, String mensaje, Date fecha,
			Date fechaEnviado) throws HermesException;
	
	void run();
	void cerrarConexion();
}
