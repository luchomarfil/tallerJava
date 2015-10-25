package ar.edu.unlp.hermes2.notification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.edu.unlp.hermes2.monitor.MonitorCore;

public class ArchivoNotificacionListener implements IEventosExternosListener, Runnable {
	private static final Logger logger = Logger.getLogger(ArchivoNotificacionListener.class.getName());
	private static final int CAMPO_MENSAJE_ID = 3;
	private static final int CAMPO_NINIO_ID = 2;
	private static final int CAMPO_CONTEXTO_ID = 1;
	private static final int CAMPO_CATEGORIA_ID = 0;
	File repositorio;

	public ArchivoNotificacionListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		String line = null;
		FileReader fileReader;
		try {
			Thread.sleep(2000);
			URL resource = getClass().getClassLoader().getResource("ar/edu/unlp/hermes2/resources/notificaciones.txt");
			repositorio = new File(resource.getPath());
			fileReader = new FileReader(repositorio);
			BufferedReader br = new BufferedReader(fileReader);
			
			
			// if no more lines the readLine() returns null
			while ((line = br.readLine()) != null) {
				// reading lines until the end of the file
				try {
					System.out.println(line);
					String[] campos = line.split(",");
					Long idCategoria = Long.parseLong(campos[CAMPO_CATEGORIA_ID]);
					Long idContexto = Long.parseLong(campos[CAMPO_CONTEXTO_ID]);
					Long idNinio = Long.parseLong(campos[CAMPO_NINIO_ID]);
					Long idMensaje = Long.parseLong(campos[CAMPO_MENSAJE_ID]);
					//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHss");
				    Date fecha = formatter.parse(campos[4]);
				    Date fechaEnviado = formatter.parse(campos[5]);
					procesarNotificacion(idCategoria, idContexto, idNinio, idMensaje, fecha, fechaEnviado);	
				} catch (Exception e) {
					logger.log(Level.SEVERE,"No se pudo procesar correctamente la linea",e);
				}				
				Thread.sleep(6000);
			}

		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE,"El archivo no encontrado",e);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Error de entrada salida",e);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE,"Error en thread",e);
		}

	}

	@Override
	public void procesarNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado) {
		MonitorCore.instance().recibirNotificacion(idCategoria,idContexto,idNinio,idMensaje,fecha,fechaEnviado);

	}

}
