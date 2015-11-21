package ar.edu.unlp.hermes2.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.monitor.MonitorCore;
import ar.edu.unlp.hermes2.monitor.MonitorUtils;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ManejadorPedidosHandler implements HttpHandler, IEventosExternosListener {

	public static SimpleDateFormat formatterFechaPersistencia = MonitorUtils.formatterFechaPersistencia;
	private static final Logger logger = Logger.getLogger(ManejadorPedidosHandler.class.getName());

	@Override
	public void handle(HttpExchange t) throws IOException {
		List<String> errores = new ArrayList<String>();
		Integer exitos = 0;
		// se recupera el input stream del body en utf-8
		InputStreamReader isr = new InputStreamReader(t.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		// se lee la primer linea
		t.getRequestHeaders();
		// se lee el dato enviado por post
		String params = br.readLine();

		//long idCategoria;
		String categoria;

		JSONArray jsonArr = null;
		String response = "";
		try {
			jsonArr = new JSONArray(params);
			for (Object object : jsonArr) {
				JSONObject jsonObj = (JSONObject) object;
				//la �nica cagada es la siguiente : si la primer notificaci�n ya existe el resto se descarta,
				//dado que la primera levanta la excepci�n,
				//en cambio, si es la �ltima la que ya existe, entonces tira la excepci�n, pero las primeras las guard�
				//habr�a que pensar alg�n mecanismo para manejar estos casos.
				//quiz�s acumular en una lista los �ndices del array json que fallaron y retornarlos al cliente
				//?? y el resto insertarlos, o no s� . . . porque si ya existen al cliente no deber�a importarle,
				//ya que �ste lo que quiere es insertar sus datos, si ya est� en la BD es suficiente para el cliente.
				//se entiende? jaja
				try {
					if (!jsonObj.getString("categoria").isEmpty()) {
						categoria = jsonObj.getString("categoria");
					} else {
						categoria = "";
					}
				} catch (JSONException e) {
					categoria = "";
				}

				String contexto = jsonObj.getString("contexto");
				String ninio = jsonObj.getString("ninio");
				String mensaje = jsonObj.getString("mensaje");
				Date fecha = formatterFechaPersistencia.parse(jsonObj.getString("fecha"));
				Date fechaEnviado = formatterFechaPersistencia.parse(jsonObj.getString("fechaEnviado"));
				try {
					procesarNotificacion(categoria, contexto, ninio, mensaje, fecha, fechaEnviado);
					exitos++;
				} catch (HermesException e) {
					errores.add(jsonObj.toString());
				}
				
				//System.out.println(jsonObj); // .. read the request body

			}
			if(errores.size()>0 && exitos>0){
				response = "Los datos fueron agregados con exito! Hubo algunas notificaciones que ya existian";
				t.sendResponseHeaders(200, response.length());
			}
			else if(exitos > 0){
				response = "Los datos fueron agregados con exito en su totalidad!";
				t.sendResponseHeaders(200, response.length());

			}
			else{
				response = "No se pudieron agregar las notificaciones!";
				t.sendResponseHeaders(500, response.length());
			}
			
		} catch (JSONException | ParseException e) {
			logger.severe("El JSON no tiene el formato correcto");
			response = "Hubo un error al parsear el pedido";
			t.sendResponseHeaders(500, response.length());
		}

		OutputStream os = t.getResponseBody();
		os.write(response.toString().getBytes());
		os.close();
	}

	public void procesarNotificacion(String categoria, String contexto, String ninio, String mensaje, Date fecha,
			Date fechaEnviado) throws HermesException {
		try {
			MonitorCore.instance().recibirNotificacion(categoria, contexto, ninio, mensaje, fecha,fechaEnviado);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public void run() {
	}

	@Override
	public void cerrarConexion() {
	}

}
