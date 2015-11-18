package ar.edu.unlp.hermes2.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ManejadorPedidosHandler implements HttpHandler, IEventosExternosListener {

	public static SimpleDateFormat formatter = MonitorUtils.formatterFechaPersistencia;
	private static final Logger logger = Logger
			.getLogger(ManejadorPedidosHandler.class.getName());

	@Override
	public void handle(HttpExchange t) throws IOException {
		// se recupera el input stream del body en utf-8
		InputStreamReader isr = new InputStreamReader(t.getRequestBody(),
				"utf-8");
		BufferedReader br = new BufferedReader(isr);
		// se lee la primer linea
		t.getRequestHeaders();
		// se lee el dato enviado por post
		String params = br.readLine();

		long idCategoria;

		JSONObject jsonObj = null;
		String response = "";
		try {
			jsonObj = new JSONObject(params);
			try {
				if (!jsonObj.getJSONObject("notificacion")
						.getString("idCategoria").isEmpty()) {
					idCategoria = jsonObj.getJSONObject("notificacion")
							.getLong("idCategoria");
				} else {
					idCategoria = 1;
				}
			} catch (JSONException e) {
				idCategoria = 1;
			}

			long idContexto = jsonObj.getJSONObject("notificacion").getLong(
					"idContexto");
			long idNinio = jsonObj.getJSONObject("notificacion").getLong(
					"idNinio");
			long idMensaje = jsonObj.getJSONObject("notificacion").getLong(
					"idMensaje");
			Date fecha = formatter.parse(jsonObj.getJSONObject("notificacion")
					.getString("fecha"));
			Date fechaEnviado = formatter.parse(jsonObj.getJSONObject(
					"notificacion").getString("fechaEnviado"));

			procesarNotificacion(idCategoria, idContexto, idNinio, idMensaje,
					fecha, fechaEnviado);

			System.out.println(jsonObj); // .. read the request body
			response = "Los datos fuerons agregados con exito!";
			t.sendResponseHeaders(200, response.length());
		} catch (JSONException | ParseException e) {
			logger.severe("El JSON no tiene el formato correcto");
			response = "Hubo un error al parsear el pedido";
			t.sendResponseHeaders(500, response.length());
		} catch (HermesException e) {
			response = e.getMessage();
			t.sendResponseHeaders(500, response.length());
		}

		OutputStream os = t.getResponseBody();
		os.write(response.toString().getBytes());
		os.close();
	}

	public void procesarNotificacion(Long idCategoria, Long idContexto,
			Long idNinio, Long idMensaje, Date fecha, Date fechaEnviado)
			throws HermesException {
		try {
			MonitorCore.instance().recibirNotificacion(idCategoria, idContexto,
					idNinio, idMensaje, fecha, fechaEnviado);
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
