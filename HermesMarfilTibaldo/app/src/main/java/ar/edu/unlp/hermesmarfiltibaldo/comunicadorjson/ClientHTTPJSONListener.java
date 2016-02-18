package ar.edu.unlp.hermesmarfiltibaldo.comunicadorjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.exception.ComunicarNotificacionException;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;

public class ClientHTTPJSONListener {

	private static final String PORT = HermesCore.instancia().getPortComunicadorJSON();
	private static final String IP   = HermesCore.instancia().getIP();
	private static final String APPLICATIONS_CONTEXT = "/applications/hermes";

	private static Logger logger = Logger.getLogger(ClientHTTPJSONListener.class.getSimpleName());

	public static void main(String[] args) {
		try {
			URL url = new URL("http://"+IP+":"+PORT+APPLICATIONS_CONTEXT);
			
			//List<Notificacion> notificaciones = MockGenerator.createMockInstances(Notificacion.class, 40);
			List<Notificacion> notificaciones = new ArrayList<Notificacion>();
			
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setUseCaches(false);
			
			//aca las tranformamos en un arreglo JSON en forma de string.
			String jSONArray = crearArregloJSON(notificaciones);
			
			byte[] bytes = jSONArray.getBytes();
			httpConnection.setRequestProperty("Content-length",String.valueOf(bytes.length));
			httpConnection.setRequestProperty("Content-type", "text/html");
			OutputStream out = httpConnection.getOutputStream();
			
			out.write(bytes);
			out.flush();
			//esperamos la respuesta
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			imprimirResponse(httpConnection);
			String lineaLeida;
			while ((lineaLeida = in.readLine()) != null){
				logger.info(lineaLeida);
			}			
			out.close();
			in.close();
			httpConnection.disconnect();
			
			
		} catch (Exception e) {			
			logger.log(Level.SEVERE,"Error enviando mensajes al servidor",e);
		}
	}

	private static void imprimirResponse(HttpURLConnection httpConnection) throws IOException {
		for (String header : httpConnection.getHeaderFields().keySet()) {
			if (header != null) {
				for (String value : httpConnection.getHeaderFields().get(header)) {
					logger.info(header + ":" + value);
				}
			}
		}
		logger.info("Status code:"+httpConnection.getResponseCode());
		logger.info("Response message:"+httpConnection.getResponseMessage());
	}

	private static String crearArregloJSON(List<Notificacion> notificaciones) {
		String jSONArray = "[";
		int i = 0;
		for (Notificacion notificacion : notificaciones){
			jSONArray = jSONArray + notificacion.toJson();
			i++;
			if (i != notificaciones.size()){
				jSONArray +=",";
			}
		}
		jSONArray += "]";
		return jSONArray;
	}

	private static String crearArregloJSON(Notificacion notificacion) {
		String jSONArray = "[";
		jSONArray = jSONArray + notificacion.toJson();
		jSONArray += "]";
		return jSONArray;
	}

	public static boolean comunicarNotificacion(Notificacion notificacion) throws ComunicarNotificacionException {
		try{
			URL url = new URL("http://"+IP+":"+PORT+APPLICATIONS_CONTEXT);

			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setUseCaches(false);

			//aca las tranformamos en un arreglo JSON en forma de string.
			String jSONArray = crearArregloJSON(notificacion);
			//preparamos los bytes y los headers del request
			byte[] bytes = jSONArray.getBytes();
			httpConnection.setRequestProperty("Content-length",String.valueOf(bytes.length));
			httpConnection.setRequestProperty("Content-type", "text/html");
			//lo escribimos
			OutputStream out = httpConnection.getOutputStream();
			out.write(bytes);
			out.flush();
			//esperamos la respuesta
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			imprimirResponse(httpConnection);
			String lineaLeida;
			while ((lineaLeida = in.readLine()) != null){
				logger.info(lineaLeida);
			}
			out.close();
			in.close();
			httpConnection.disconnect();
			return true;

	} catch (Exception e) {

			logger.log(Level.SEVERE,"Error enviando mensajes al servidor",e);
			return false;
		//throw new ComunicarNotificacionException();
	}

	}
	
	

}
