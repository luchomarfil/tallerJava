package ar.edu.unlp.hermes2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.management.monitor.Monitor;

import ar.edu.unlp.hermes2.database.DatabaseUtil;
import ar.edu.unlp.hermes2.gui.HermesException;
import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;
import ar.edu.unlp.hermes2.monitor.MonitorUtils;

public class HermesDaoImpl implements HermesDao {
	private static Logger logger = Logger.getLogger(HermesDaoImpl.class
			.getName());

	/**
	 * Para sqls que tienen que retornar informacion, devuelven un resultset
	 * con el resultado del select
	 * @param c 
	 * @param sql
	 * @return
	 * @throws HermesException
	 */
	private static ResultSet getResult(Connection c, String sql) throws HermesException {
		return DatabaseUtil.ejecutarSelect(c,sql);		
	}
	
	/**
	 * Para sqls que modifican la base de datos: INSERT, UPDATE, DELETE
	 * Retornan la cantidad de tuplas afectadas 
	 * @param c 
	 * @param sql
	 * 
	 * @throws HermesException
	 */
	private static int executeScript(Connection c, String sql) throws HermesException{		
		return DatabaseUtil.executeScript(c,sql);
	}

	/**
	 * Ejecuta una lista de comandos INSERT, DELETE Y UPDATE
	 * 
	 * @param sql
	 * @return Retorna el numero de tuplas afectadas
	 * @throws HermesException 
	 */
	private static int[] executeBatch(Connection c, String sql) throws HermesException{
		return DatabaseUtil.executeBatch(c,  sql);
	}
	
	private static Connection getConnection() throws HermesException{
		return DatabaseUtil.getConnection();
	}
	


	private static void cerrarConexion(Connection c) throws HermesException {
		try {
			if(c!=null && !c.isClosed()){				
					c.close();			
			}			
		} catch (SQLException e) {
			throw new HermesException("Error cerrando la conexion",e);
		}
	}
	
	@Override
	public List<TransferObject> getListaMensajes() throws HermesException {
		List<TransferObject> l = new ArrayList<TransferObject>();

		String sql = "select id,nombre,descripcion, imagen from 'hermes.mensajes'";
		Connection c = getConnection();		
		try {
			ResultSet resultSet = getResult(c,sql);
			while (resultSet.next())
				l.add(new Mensaje(resultSet.getLong("id"), resultSet
						.getString("nombre"), resultSet
						.getString("descripcion"), resultSet
						.getString("imagen")));
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		}
		finally{
			cerrarConexion(c);
		}
		
		return l;
	}


	@Override
	public List<TransferObject> getListaContextos() throws HermesException {
		List<TransferObject> l = new ArrayList<TransferObject>();

		String sql = "select id,nombre,descripcion from 'hermes.contextos'";
		Connection c = getConnection();
		ResultSet resultSet = getResult(c,sql);
		try {
			while (resultSet.next())
				l.add(new Contexto(resultSet.getLong("id"), resultSet
						.getString("nombre"), resultSet
						.getString("descripcion")));
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}

	@Override
	public List<TransferObject> getListaCategorias() throws HermesException {
		List<TransferObject> l = new ArrayList<TransferObject>();

		String sql = "select id,nombre from 'hermes.categorias'";
		Connection c = getConnection();
		ResultSet resultSet = getResult(c,sql);
		try {
			while (resultSet.next())
				l.add(new Categoria(resultSet.getLong("id"), resultSet
						.getString("nombre")));
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}

	@Override
	public List<TransferObject> getListaNinios() throws HermesException {
		List<TransferObject> l = new ArrayList<TransferObject>();

		String sql = "select id, nombre, apellido from 'hermes.ninios'";
		Connection c = getConnection();
		ResultSet resultSet = getResult(c,sql);
		try {
			while (resultSet.next())
				l.add(new Ninio(resultSet.getLong("id"), resultSet
						.getString("nombre"), resultSet.getString("apellido")));
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}

	@Override
	public List<TransferObject> getListaEtiquetas() throws HermesException {
		List<TransferObject> l = new ArrayList<TransferObject>();

		String sql = "select id, nombre, descripcion from 'hermes.etiquetas'";
		Connection c = getConnection();

		ResultSet resultSet = getResult(c,sql);
		try {
			while (resultSet.next())
				l.add(new Etiqueta(resultSet.getLong("id"), resultSet
						.getString("nombre"), resultSet
						.getString("descripcion")));
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}

	@Override
	public List<Notificacion> obtenerNotificacionesFiltradas(
			FiltroNotificacion filtro) throws HermesException {
		SimpleDateFormat sd = MonitorUtils.formatterFechaPersistencia;
		List<Notificacion> l = new ArrayList<Notificacion>();

		String sql = "select n.id as n_id, n.fecha as n_fecha, ca.id as ca_id, ca.nombre as ca_nombre, co.id as co_id,"
				+ "  	co.nombre as co_nombre, co.descripcion as co_descripcion, me.id as me_id, me.nombre as me_nombre,"
				+ "		me.descripcion as me_descripcion, me.imagen as me_imagen, ni.id as ni_id, ni.nombre as ni_nombre,"
				+ "		ni.apellido as ni_apellido, n.fechaRecibido as n_fechaRecibido, n.fechaEnviado as n_fechaEnviado"	
				+ "		from 'hermes.notificaciones'  AS n "
				+ "		left join 'hermes.ninios' AS ni on n.idNinio = ni.id"
				+ "		left join 'hermes.contextos' AS co on co.id= n.idContexto"
				+ "		left join 'hermes.categorias' AS ca on ca.id= n.idCategoria"
				+ "		left join 'hermes.mensajes' AS me on me.id= n.idMensaje";
		
		sql += " where 1=1";

		if(filtro.getCategoria()!=null){
			sql += " and ca.id = ?";		
		}
		if(filtro.getContexto()!=null){
			sql += " and co.id = ?";		
		}

		if(filtro.getEtiqueta()!=null){
			sql += " and n.id in (select idNotificacion from 'hermes.notificaciones.etiquetas' where idEtiqueta = ? )";	
		}
		
		if(filtro.getMensaje()!=null){
			sql += " and me.id = ?";		
		}
		if(filtro.getNinio()!=null){
			sql += " and ni.id = ?";			
		}
		
		if(filtro.getFechaDesde()!=null){
			sql += " and CAST(n.fecha AS INTEGER) >=  ? ";
		}
		if(filtro.getFechaHasta()!=null){
			sql += " and CAST(n.fecha AS INTEGER) <=  ? ";
		}
		
		sql += " ;";
		Connection c = getConnection();
		int i = 1;
		try {
		PreparedStatement prep = c.prepareStatement(sql);

		if(filtro.getCategoria()!=null){
			prep.setLong(i, filtro.getCategoria().getId());
			i++;
		}
		if(filtro.getContexto()!=null){
			prep.setLong(i, filtro.getContexto().getId());
			i++;
		}
		
		if(filtro.getEtiqueta()!=null){
			prep.setLong(i, filtro.getEtiqueta().getId());
			i++;
		}
		
		if(filtro.getMensaje()!=null){
			prep.setLong(i, filtro.getMensaje().getId());
			i++;
		}
		if(filtro.getNinio()!=null){
			prep.setLong(i, filtro.getNinio().getId());
			i++;
		}
		
		if(filtro.getFechaDesde()!=null){
			prep.setString(i, sd.format(filtro.getFechaDesde()));
			i++;
		}
		if(filtro.getFechaHasta()!=null){
			prep.setString(i, sd.format(filtro.getFechaHasta()));	
			i++;
		}
		
		
		
		
		ResultSet resultSet = prep.executeQuery();
		//istanciamos todas las variables de notificaciones
		long id;Date fecha;	List<Etiqueta> etiquetas;Categoria categoria;Contexto contexto;
		Mensaje mensaje;Ninio ninio;Date fechaRecibido;	Date fechaEnviado;
		
		
		
			while (resultSet.next()) {
				id = resultSet.getLong("n_id");				
				fecha = sd.parse(resultSet.getString("n_fecha"));
				categoria = new Categoria(resultSet.getLong("ca_id"),
						resultSet.getString("ca_nombre"));
				contexto = new Contexto(resultSet.getLong("co_id"),
						resultSet.getString("co_nombre"),
						resultSet.getString("co_descripcion"));
				mensaje = new Mensaje(resultSet.getLong("me_id"),
						resultSet.getString("me_nombre"),
						resultSet.getString("me_descripcion"),
						resultSet.getString("me_imagen"));
				ninio = new Ninio(resultSet.getLong("ni_id"),
						resultSet.getString("ni_nombre"),
						resultSet.getString("ni_apellido"));

				fechaRecibido = sd.parse(resultSet.getString("n_fechaRecibido"));
				//fechaRecibido = new Date(resultSet.getString("n_fechaRecibido"));
				fechaEnviado = sd.parse(resultSet.getString("n_fechaEnviado"));
				//fechaEnviado = new Date(resultSet.getString("n_fechaEnviado"));
				etiquetas = getEtiquetas(id);

				l.add(new Notificacion(id, fecha, etiquetas, categoria,
						contexto, mensaje, ninio, fechaRecibido, fechaEnviado));
			}
		} catch (SQLException e) {
			throw new HermesException("Error leyendo el conjunto de resultados de la query",e);
		} catch (ParseException e) {
			throw new HermesException("Error parseando la fecha",e);
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}

	@Override
	public void agregarEtiqueta(Etiqueta etiqueta) throws HermesException {
		String etiquetaAux;
		if (etiqueta.getDescripcion() == null){
			etiquetaAux = null;
		}
		else{
			etiquetaAux = etiqueta.getDescripcion();
		}
		String sql = "INSERT INTO 'hermes.etiquetas' VALUES (null,?,?,0);";
		Connection c = getConnection();
		PreparedStatement prep;
		
		try {
		prep = c.prepareStatement(sql);			
		prep.setString(1, etiqueta.getNombre());
		prep.setString(2, etiquetaAux);
		prep.executeUpdate();
		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}

	}

	@Override
	public Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) throws HermesException {
		String sql = "select count(*) from 'hermes.etiquetas' where nombre = ? ;";
		Connection c = getConnection();
		PreparedStatement prep;
		
		try{
			prep = c.prepareStatement(sql);
			prep.setString(1, nombreNuevaEtiqueta);
			prep.executeQuery();
			if (prep.executeQuery().getInt(1) == 0) return false;
		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}
		return true;

	}

	@Override
	public void eliminarEtiqueta(Etiqueta etiqueta) throws HermesException {

		String sql = "DELETE FROM 'hermes.etiquetas' WHERE id = ? ;";
		PreparedStatement prep;
		Connection c = getConnection();
		try {
			prep = c.prepareStatement(sql);
			prep.setLong(1, etiqueta.getId());
			prep.executeUpdate();

		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}

	}

	@Override
	public void asignarEtiqueta(Etiqueta selectedItem,
			List<Long> idsNotificaciones) throws HermesException {

		String sql = "INSERT INTO 'hermes.notificaciones.etiquetas' VALUES (null,?,?);";

		PreparedStatement prep;
		Connection c = getConnection();
		try {
			
			for (Long long1 : idsNotificaciones) {
				prep = c.prepareStatement(sql);
				prep.setLong(2, selectedItem.getId());
				prep.setLong(1, long1);
				prep.executeUpdate();
			}			


		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}

	}

	@Override
	public Boolean existeEtiquetaPara(String nuevoNombre,
			Etiqueta etiquetaARenombrar) throws HermesException {
		
		String sql = "select count(*) from 'hermes.etiquetas' where nombre = ? and id <> ?;";
		Connection c = getConnection();
		PreparedStatement prep;
		
		try{
			prep = c.prepareStatement(sql);
			prep.setString(1, nuevoNombre);
			prep.setLong(2, etiquetaARenombrar.getId());
			prep.executeQuery();
			if (prep.executeQuery().getInt(1) == 0) return false;
		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}
		return true;

	}

	@Override
	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar,
			String nuevoNombre) throws HermesException {

		String sql = "UPDATE 'hermes.etiquetas' SET nombre= ?  WHERE id= ?;";
		Connection c = getConnection();
		PreparedStatement prep;
		try {
			prep = c.prepareStatement(sql);
			prep.setString(1, nuevoNombre);
			prep.setLong(2,etiquetaARenombrar.getId());
			prep.executeUpdate();

		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}

	}

	@Override
	public void nuevaNotificacion(Long idCategoria, Long idContexto,
			Long idNinio, Long idMensaje, Date fecha, Date fechaEnviado,
			Date fechaRecibido) throws HermesException {
		
		SimpleDateFormat formatterFecha = MonitorUtils.formatterFechaPersistencia;
		String sql = "INSERT INTO 'hermes.notificaciones' VALUES (null,?,?,?,?,?,?,?);";
		Connection c = getConnection();
		PreparedStatement prep;

		try {
			prep = c.prepareStatement(sql);
			prep.setLong(1, idCategoria);
			prep.setLong(2, idContexto);
			prep.setLong(3, idNinio);
			prep.setLong(4, idMensaje);
			prep.setString(5, formatterFecha.format(fecha));
			prep.setString(6, formatterFecha.format(fechaEnviado));
			prep.setString(7, formatterFecha.format(fechaEnviado));
			prep.executeUpdate();
			

		} catch (Exception e) {
			throw new HermesException("Error agregando la etiqueta");
		}		
		finally{
			cerrarConexion(c);
		}

	}

	private List<Etiqueta> getEtiquetas(long id) throws HermesException {
		List<Etiqueta> l = new ArrayList<Etiqueta>();

		String sql = "select e.* From 'hermes.etiquetas' AS e"
				+ "		inner join 'hermes.notificaciones.etiquetas' AS ne"
				+ "		on e.id = ne.idEtiqueta" + "		where idNotificacion = ?;";
		Connection c = getConnection();
		PreparedStatement prep;
		ResultSet resultSet = getResult(c,sql);
		try {
			prep = c.prepareStatement(sql);
			prep.setLong(1, id);
			resultSet = prep.executeQuery();
						
			
			while (resultSet.next())
				l.add(new Etiqueta(resultSet.getLong("id"), resultSet
						.getString("nombre"), resultSet
						.getString("descripcion")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			cerrarConexion(c);
		}
		return l;
	}
}
