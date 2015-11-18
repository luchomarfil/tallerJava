package ar.edu.unlp.hermes2.notification;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.monitor.MonitorCore;
import ar.edu.unlp.hermes2.monitor.MonitorUtils;

public class HttpServerNotificacionListener implements HttpHandler, Runnable, IEventosExternosListener {
	
	SimpleDateFormat formatter = MonitorUtils.formatterFechaPersistencia;
	private static final Logger logger = Logger.getLogger(JSONNotificacionListener.class.getName());
	private static final int portNo = 55555;
	
	
		   @Override
		   public void handle(HttpExchange t) throws IOException {


		   
	            InputStreamReader isr =
                new InputStreamReader(t.getRequestBody(),"utf-8");
	            BufferedReader br = new BufferedReader(isr);

				String params = br.readLine();

	            
			   
			   
			   
			   long idCategoria;

				JSONObject jsonObj = new JSONObject(params);
				try{
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
			   			   
				} catch (JSONException | ParseException e) {
					logger.severe("El JSON no tiene el formato correcto");
				}
			   
	           System.out.println(jsonObj); // .. read the request body
	           String response = params;
	           t.sendResponseHeaders(200, response.length());
	           OutputStream os = t.getResponseBody();
	           
				
	           os.write(response.toString().getBytes());
	           os.close();
	       }

		@Override
		public void run() {
			// TODO Auto-generated method stub
			new HttpServerNotificacionListener().start();
		}

		
		public static void main(String[] args) {			
			new HttpServerNotificacionListener().start();
		}
		
		
		private void start(){
			   //HttpServer server = HttpServer.create(   new InetSocketAddress(8000));

			try {
				HttpServer server = HttpServer.create(new InetSocketAddress(portNo), 10);
				HttpContext context = server.createContext("/applications/myapp", new HttpServerNotificacionListener());
				
				
			   server.createContext("/applications/myapp", new HttpServerNotificacionListener());
			   server.setExecutor(null); // creates a default executor
			   server.start();
			   
				}
			
				 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			// TODO Auto-generated method stub
			
		}
}


