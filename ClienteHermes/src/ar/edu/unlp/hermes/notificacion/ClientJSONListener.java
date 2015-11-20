package ar.edu.unlp.hermes.notificacion;
import ar.edu.unlp.hermes.model.*;
/*
 * Client.java
 * Just sends stdin read data to and receives back some data from the server
 *
 * usage:
 * java Client serverhostname port
 */
//http://jsoneditoronline.org/
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


//http://jsoneditoronline.org/?id=0ea73b0c8d909f34e3680d98450aaec7
public class ClientJSONListener
{
//  public static void main(String[] args) throws IOException
//  {
//	 final String HOST = "localhost";
//	 final String PORT = "55555";
//	  
//	 Integer valueOf = Integer.valueOf(PORT);
//	 
////	 if ((args.length != 2) || (valueOf.intValue()<=0) )
////	 {
////	      System.out.println("2 arguments needed: serverhostname port");
////	      System.exit(1);
////	  }
//	 ClientJSONListener objetct = new ClientJSONListener();
//	 
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 1, 1, 1, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 2, 2, 2, 2));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 3, 3, 3));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 3, 3, 3));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 3, 3, 3));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 1, 2, 3, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 2, 1, 2, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 2, 3, 3, 2));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 3, 1, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 1, 2, 2, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 1, 3, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 2, 3, 3, 1));
//	 objetct.enviarNotificacion(HOST,PORT,new Notificacion(new Date(), 3, 1, 1, 2));
//  }
//  
//  public void test(Notificacion notificacion){
//	  /*Get some input from user */
//	    Map<String, String> myMap = new HashMap<String, String>();
//	    myMap.put("idCategoria", "" +notificacion.getIdCategoria());
//	    myMap.put("idContexto", "" +notificacion.getIdContexto());
//	    myMap.put("idNinio", "" +notificacion.getIdNinio());
//	    myMap.put("idMensaje", "" +notificacion.getIdMensaje());
//	    myMap.put("fecha", "" +notificacion.getFecha());
//	    
//			
//	    myMap.put("fechaEnviado", ( (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())));
//	    
//	    
//	    JSONObject jobj = new JSONObject(myMap);
//	    JSONObject jobj2 = new JSONObject();
//	    jobj2.put("notificacion", jobj);
//	  
//	  
//	  
//	  System.out.println(jobj2);
//	  
//	  
//  }
//  
//  
//  
//  public void enviarNotificacion(String to, String port, Notificacion notificacion){
//    /* Check the number of command line parameters */
//	  
//    /* The socket to connect to the echo server */
//    Socket socketwithserver = null;
//
//    try /* Connection with the server */
//    { 
//      socketwithserver = new Socket(to, Integer.valueOf(port));
//    }
//    catch (Exception e)
//    {
//      System.out.println("ERROR connecting");
//      System.exit(1);
//    } 
//
//    /* Streams from/to server */
//    DataInputStream  fromserver;
//    DataOutputStream toserver;
//
//    /* Streams for I/O through the connected socket */
//    try {
//
//	
//
//		
//	
//    
//		
//    /* Buffer to use with communications (and its length) */
//    byte[] buffer;
//    
//    /* Get some input from user */
//    Map<String, String> myMap = new HashMap<String, String>();
//    myMap.put("idCategoria", "" +notificacion.getIdCategoria());
//    myMap.put("idContexto", "" +notificacion.getIdContexto());
//    myMap.put("idNinio", "" +notificacion.getIdNinio());
//    myMap.put("idMensaje", "" +notificacion.getIdMensaje());
//    myMap.put("fecha", "" +notificacion.getFecha());
//    
//		
//    myMap.put("fechaEnviado", ( (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())));
//    
//    
//    JSONObject jobj = new JSONObject(myMap);
//    JSONObject jobj2 = new JSONObject();
//    jobj2.put("notificacion", jobj);
//
//    
//    String inputline =  jobj2.toString();
//
//
//    /* Get the bytes... */
//    buffer = inputline.getBytes();
//	fromserver = new DataInputStream(socketwithserver.getInputStream());
//	toserver   = new DataOutputStream(socketwithserver.getOutputStream());
//    /* Send read data to server */
//    toserver.write(buffer, 0, buffer.length);
//    
//    /* Recv data back from server (get space) */
//    buffer = new byte[256];
//    fromserver.read(buffer);
//
//    /* Show data received from server */
//    String resp = new String(buffer);
//    System.out.println(resp);
//	fromserver.close();
//    toserver.close();
//    socketwithserver.close();
//
//  	} catch (IOException e) {
//  		e.printStackTrace();
//  }
//
//  }
}
