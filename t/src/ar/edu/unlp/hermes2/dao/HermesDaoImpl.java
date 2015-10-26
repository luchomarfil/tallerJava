package ar.edu.unlp.hermes2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;

public class HermesDaoImpl implements HermesDao{
	private static ResultSet getResult(String sql){
		try{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e) {System.err.println(e.getMessage());}
		
	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:t/hermes");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	      ResultSet returnValues = statement.executeQuery(sql);
	      return returnValues;
	    }
	    
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    
	    finally
	    {

	        //if(connection != null)connection.close();
	    }
		return null;

	};

	@Override
	public List<TransferObject> getListaMensajes() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id,nombre,descripcion, imagen from 'hermes.mensajes'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Mensaje(resultSet.getLong("id"),resultSet.getString("nombre"), resultSet.getString("descripcion"),resultSet.getString("imagen")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaContextos() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id,nombre,descripcion from 'hermes.contextos'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Contexto(resultSet.getLong("id"),resultSet.getString("nombre"), resultSet.getString("descripcion")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaCategorias() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id,nombre from 'hermes.categorias'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Categoria(resultSet.getLong("id"),resultSet.getString("nombre")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaNinios() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id, nombre, apellido from 'hermes.ninios'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Ninio(resultSet.getLong("id"),resultSet.getString("nombre"),resultSet.getString("apellido")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaEtiquetas() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id, nombre, descripcion from 'hermes.etiquetas'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Etiqueta(resultSet.getLong("id"),resultSet.getString("nombre"),resultSet.getString("descripcion")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
	
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select * from 'hermes.notificaciones'  AS n inner join 'hermes.notificaciones.etiquetas' AS ne on n.id = ne.idNotificacion where ne.idNotificacion <> '2'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Notificacion(resultSet.getLong("id"),resultSet.getString("nombre"),resultSet.getString("descripcion")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public void agregarEtiqueta(Etiqueta etiqueta) {
		String etiquetaAux;
		if (etiqueta.getDescripcion() == null) 
			etiquetaAux = null;
		else
			etiquetaAux = etiqueta.getDescripcion();
		
		String sql = "INSERT INTO 'hermes.etiquetas' VALUES (null,'" + etiqueta.getNombre() + "','" + etiquetaAux +"',0);";

		getResult(sql);

	}

	@Override
	public Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) {
		return true;
		//TODO  No la termino de entender !!!
	}
	
	@Override
	public void eliminarEtiqueta(Etiqueta etiqueta) {
		
		String sql = "DELETE FROM 'hermes.etiquetas' WHERE id = " + etiqueta.getId() + " ;";

		getResult(sql);
		
	}

	@Override
	public void asignarEtiqueta(Etiqueta selectedItem, List<Long> idsNotificaciones) {
		
		
		for (Long long1 : idsNotificaciones) {
			String sql = "INSERT INTO 'hermes.notificaciones.etiquetas' VALUES (null,'" + long1 + "','" + selectedItem.getId() +";";
			getResult(sql);
		}

	}

	@Override
	public Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar) {
		return true;
		// TODO No la termino de entender !!!
	}

	@Override
	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) {

		String sql = "UPDATE 'hermes.etiquetas' SET nombre= "+ nuevoNombre +"  WHERE id='"+ etiquetaARenombrar.getId() + "';";
		getResult(sql);
		
		
	}

	@Override
	public void nuevaNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido) {
		
		String sql = "INSERT INTO 'hermes.notificaciones' VALUES (null,'" + idCategoria + "','" + idContexto +
				"','" + idNinio + "','" + idMensaje + "','" + fecha + "','" + fechaEnviado + "','" +fechaRecibido +";";
		getResult(sql);
		
	}


}
