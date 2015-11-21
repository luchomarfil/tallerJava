package ar.edu.unlp.hermes2.notification;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import ar.edu.unlp.hermes2.config.PropertiesHandler;
import ar.edu.unlp.hermes2.gui.HermesException;

import com.sun.net.httpserver.HttpServer;

public class HttpServerNotificacionListener implements Runnable, IEventosExternosListener {
	
	private static final String APPLICATIONS_CONTEXT = "/applications/hermes";
	private static final Logger logger = Logger.getLogger(HttpServerNotificacionListener.class.getName());
	private static final int portNo = new Integer(PropertiesHandler.getInstance().getProperties().getProperty("portNo"));
	
	
		  
		@Override
		public void run() {
			new HttpServerNotificacionListener().start();
		}

		
		public static void main(String[] args) {			
			new HttpServerNotificacionListener().start();
		}
		
		
		private void start(){
			try {
				HttpServer server = HttpServer.create(new InetSocketAddress(portNo), 10);
				server.createContext(APPLICATIONS_CONTEXT,	new ManejadorPedidosHandler());				
				server.setExecutor(Executors.newCachedThreadPool()); // creates a default executor
				logger.info("Iniciando http server...");
				server.start();
				logger.info("Server iniciado en http://localhost:" + server.getAddress().getPort() + APPLICATIONS_CONTEXT);
				
			   	}
			
				 catch (IOException e) {
					e.printStackTrace();
				}	
		}

		
		@Override
		public void cerrarConexion() {
			
		}


		@Override
		public void procesarNotificacion(String categoria, String contexto,
				String ninio, String mensaje, Date fecha, Date fechaEnviado)
				throws HermesException {
			// TODO Auto-generated method stub
			
		}
}


