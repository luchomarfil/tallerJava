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

	private static final Logger logger = Logger.getLogger(JSONNotificacionListener.class.getName());
	private static final int portNo = 55555;
	
	public JSONNotificacionListener() {
	}
	

	public void run() {
		
	
		ServerSocket serverSocket = null;
		SimpleDateFormat formatter = MonitorUtils.formatterFechaPersistencia;
		try {
	        serverSocket = new ServerSocket(portNo); 
	    } catch (IOException e) 
	           {
	             System.err.println("No se pude abrir el puerto : " + portNo + " para escuchar.");
	             System.exit(1);
	       }
	    DataInputStream fromclient;
	    DataOutputStream toclient;
	    Socket clientSocket = null; 
	    try {

	    
	    /* Buffer to use with communications (and its length) */
	    byte[] buffer;

		while (true){
			buffer = new byte[256];
	   
	          clientSocket = serverSocket.accept();

	          if(clientSocket != null)                
	              System.out.println("Connected");

	       
	      
	  	    fromclient = new DataInputStream(clientSocket.getInputStream());
		    toclient   = new DataOutputStream(clientSocket.getOutputStream());
	    



	    /* Recv data from client */
	    fromclient.read(buffer);

	    /* Convert to string */
	    String str = new String(buffer);

	   
	    JSONObject jsonObj = new JSONObject(str);
	    procesarNotificacion(jsonObj.getJSONObject("notificacion").getLong("idCategoria"),
	    		jsonObj.getJSONObject("notificacion").getLong("idContexto"),
	    		jsonObj.getJSONObject("notificacion").getLong("idNinio"),
	    		jsonObj.getJSONObject("notificacion").getLong("idMensaje"),
	    		formatter.parse(jsonObj.getJSONObject("notificacion").getString("fecha")), 
	    		formatter.parse(jsonObj.getJSONObject("notificacion").getString("fechaEnviado")));

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
            System.err.println("Hubo algún problema en aceptar la conexión.");
            System.exit(1);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}
	
	
	
	@Override
	public void procesarNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado) {
		try{
			MonitorCore.instance().recibirNotificacion(idCategoria,idContexto,idNinio,idMensaje,fecha,fechaEnviado);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}


}
