package ar.edu.unlp.hermes.notificacion;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.hermes.model.Notificacion;

public class ClientHTTPJSONListener {

	public static void main(String[] args) {
		try {
			List<Notificacion> notificaciones = MockGenerator.createMockInstances(Notificacion.class, 40);
			
			URL url = new URL("http://localhost:55555/applications/myapp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			
			
			//String JSONArray = "[{'idCategoria':'1','idContexto':'2','idMensaje':'2','idNinio':'2','fecha':'20171117192105','fechaEnviado':'20171117192054'},{'idCategoria':'2','idContexto':'3','idMensaje':'2','idNinio':'2','fecha':'20171218192105','fechaEnviado':'20171218192054'}]";
			
			//Aca deberia pedir las notificaciones !
//			notificaciones.add(new Notificacion(new Date(), "uno", "uno", "uno", "uno"));
//			notificaciones.add(new Notificacion(new Date(), "tres", "tres", "tres", "tres"));
//			notificaciones.add(new Notificacion(new Date(), "uno", "dos", "uno", "dos"));
//			notificaciones.add(new Notificacion(new Date(), "uno", "tres", "dos", "tres"));
			
			//aca las tranformamos en un arreglo JSON en forma de string.
			String jSONArray = "[";
			int i = 0;
			for (Notificacion notificacion : notificaciones) {
				jSONArray = jSONArray + notificacion.toJson();
				i++;
				if (i != notificaciones.size())
				{jSONArray +=",";}
			}
			jSONArray += "]";
			
			byte[] bytes = jSONArray.getBytes();
			con.setRequestProperty("Content-length",
					String.valueOf(bytes.length));
			con.setRequestProperty("Content-type", "text/html");
			OutputStream out = con.getOutputStream();
			out.write(bytes);
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String temp;
			while ((temp = in.readLine()) != null)
				System.out.println(temp);
			out.close();
			in.close();
			con.disconnect();
			
			
			/**
			 *  //List<Notificacion> notificacion = MockGenerator.getLista(Notificacion.class); // Esto va a estar cuando este el otro modulo
			 *  Por ahora armar una lista simulada
			 *  for each notificaciones
			 *  	armar json que representa a la notificacion
			 *  	agregarlo a al arreglo que se va a enviar por post
			 * 
			 *  con el arreglo de jsons de las notificaciones enviarlo por post
			 * 
			 * 
			 * 
			 */
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	

}
