package ar.edu.unlp.hermes.notificacion;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

public class ClientHTTPJSONListener {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:55555/applications/myapp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			String test = "{notificacion:{'idCategoria':'2','idContexto':'2','idMensaje':'2','idNinio':'2','fecha':'20151117192105','fechaEnviado':'20151117192054'}}";
			byte[] bytes = test.getBytes();
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
