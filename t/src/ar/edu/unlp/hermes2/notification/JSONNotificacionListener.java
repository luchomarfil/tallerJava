package ar.edu.unlp.hermes2.notification;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.monitor.MonitorCore;
import ar.edu.unlp.hermes2.monitor.MonitorUtils;

public class JSONNotificacionListener implements IEventosExternosListener, Runnable {

	private static final int tamanioBuffer = 256;
	private static final Logger logger = Logger.getLogger(JSONNotificacionListener.class.getName());
	private static final int portNo = 55555;
	private ServerSocket serverSocket;

	public JSONNotificacionListener() {
	}

	public static void main(String[] args) {
		new JSONNotificacionListener().run();
	}

	public void run() {

		serverSocket = null;
		SimpleDateFormat formatter = MonitorUtils.formatterFechaPersistencia;
		try {
			serverSocket = new ServerSocket(portNo);
		} catch (IOException e) {
			//System.err.println("No se pude abrir el puerto : " + portNo + " para escuchar.");
			logger.severe("No se pude abrir el puerto : " + portNo + " para escuchar.");
			System.exit(1);
		}
		DataInputStream fromclient;
		DataOutputStream toclient;
		Socket clientSocket = null;
		try {
			
			/* Buffer to use with communications (and its length) */
			byte[] buffer;

			while (true) {
				Thread.sleep(6000);
				buffer = new byte[tamanioBuffer];

				clientSocket = serverSocket.accept();

				if (clientSocket != null){
					logger.info("Cliente se ha conectado al servidor");
				}

				fromclient = new DataInputStream(clientSocket.getInputStream());
				toclient = new DataOutputStream(clientSocket.getOutputStream());

				/* Recv data from client */
				fromclient.read(buffer);
				
				/* Convert to string */
				String str = new String(buffer);
				logger.info("String recibido desde el cliente : "+ str);
				long idCategoria;
				JSONObject jsonObj = new JSONObject(str);
				try {
					if (!jsonObj.getJSONObject("notificacion").getString("idCategoria").isEmpty()) {
						idCategoria = jsonObj.getJSONObject("notificacion").getLong("idCategoria");
					} else {
						idCategoria = 1;
					}
				} catch (JSONException e) {
					idCategoria = 1;
				}

				long idContexto = jsonObj.getJSONObject("notificacion").getLong("idContexto");
				long idNinio = jsonObj.getJSONObject("notificacion").getLong("idNinio");				
				long idMensaje = jsonObj.getJSONObject("notificacion").getLong("idMensaje");				
				Date fecha = formatter.parse(jsonObj.getJSONObject("notificacion").getString("fecha"));				
				Date fechaEnviado = formatter.parse(jsonObj.getJSONObject("notificacion").getString("fechaEnviado"));
				
				procesarNotificacion(idCategoria, idContexto, idNinio,	idMensaje, fecha, fechaEnviado);

				/* Respuesta al cliente */
				String strresp = "recibido !";
				buffer = strresp.getBytes();
				toclient.write(buffer, 0, buffer.length);

				/* Close everything related to the client connection */
				fromclient.close();
				toclient.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			//System.err.println("Hubo algun problema en aceptar la conexion.");
			//System.exit(1);
			logger.log(Level.SEVERE,"Hubo algun problema en aceptar la conexion",e);
		} catch (JSONException e) {
			logger.log(Level.SEVERE,"Error al armar el objeto json",e);
		} catch (ParseException e) {
			logger.log(Level.SEVERE,"Error parseando la informacion",e);
		} catch (InterruptedException e1) {
			logger.log(Level.SEVERE,"Error ejecutando el sleep",e1);
		} finally {
			try {
				if(serverSocket!=null && !serverSocket.isClosed()){
					serverSocket.close();
				}
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Error cerrando el socket",e);				
			}
		}

	}

	@Override
	public void procesarNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado) {
		try {
			MonitorCore.instance().recibirNotificacion(idCategoria, idContexto, idNinio, idMensaje, fecha,
					fechaEnviado);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	public void cerrarConexion() {
		logger.info("Cerrando conexion");
		try {
			serverSocket.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Error cerrando el socket",e);
		}
	}

}
