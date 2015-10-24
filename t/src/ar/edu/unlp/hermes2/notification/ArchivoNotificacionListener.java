package ar.edu.unlp.hermes2.notification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import ar.edu.unlp.hermes2.monitor.MonitorCore;

public class ArchivoNotificacionListener implements IEventosExternosListener, Runnable {

	File repositorio;

	public ArchivoNotificacionListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		FileReader fileReader;
		try {
			Thread.sleep(2000);
			URL resource = getClass().getClassLoader().getResource("ar/edu/unlp/hermes2/resources/notificaciones.txt");
			repositorio = new File(resource.getPath());

			fileReader = new FileReader(repositorio);

			BufferedReader br = new BufferedReader(fileReader);

			String line = null;
			// if no more lines the readLine() returns null
			while ((line = br.readLine()) != null) {
				// reading lines until the end of the file
				System.out.println(line);
				String[] campos = line.split(",");
				Long idCategoria = Long.parseLong(campos[0]);
				Long idContexto = Long.parseLong(campos[1]);
				Long idNinio = Long.parseLong(campos[2]);

//				recibirNotificacion();
				Thread.sleep(6000);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void recibirNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Long fecha,
			Long fechaEnviado) {
		// TODO Auto-generated method stub

	}

}
