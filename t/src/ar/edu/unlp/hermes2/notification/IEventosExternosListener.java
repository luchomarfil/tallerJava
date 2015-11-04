package ar.edu.unlp.hermes2.notification;

import java.util.Date;

public interface IEventosExternosListener {

	void procesarNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado);
	
	void run();
	void cerrarConexion();
}
