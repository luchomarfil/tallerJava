package ar.edu.unlp.hermes2.notification;

public interface IEventosExternosListener {

	public void recibirNotificacion(Long idCategoria,Long idContexto, Long idNinio, Long idMensaje, Long fecha, Long fechaEnviado);
	
}
