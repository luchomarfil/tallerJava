package ar.edu.unlp.hermes2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	      connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	      return statement.executeQuery(sql);
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
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
				l.add(new Mensaje(resultSet.getString("nombre"), resultSet.getString("descripcion"),resultSet.getString("imagen")));
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
				l.add(new Contexto(resultSet.getString("nombre"), resultSet.getString("descripcion")));
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
				l.add(new Categoria(resultSet.getString("nombre")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaNinios() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id,nombre, apellido from 'hermes.categorias'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Ninio(resultSet.getString("nombre"),resultSet.getString("apellido")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<TransferObject> getListaEtiquetas() {
		List<TransferObject> l = new ArrayList<TransferObject>();		
		
		String sql = "select id,nombre, apellido from 'hermes.categorias'";
		ResultSet resultSet = getResult(sql);
		try {
			while (resultSet.next())
				l.add(new Etiqueta(resultSet.getString("nombre"),resultSet.getString("apellido")));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<Notificacion> obtenerNotificacionesFiltradas(FiltroNotificacion filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarEtiqueta(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existeEtiquetaPara(String nombreNuevaEtiqueta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarEtiqueta(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarEtiqueta(Etiqueta selectedItem, List<Long> idsNotificaciones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existeEtiquetaPara(String nuevoNombre, Etiqueta etiquetaARenombrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renombrarEtiqueta(Etiqueta etiquetaARenombrar, String nuevoNombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevaNotificacion(Long idCategoria, Long idContexto, Long idNinio, Long idMensaje, Date fecha,
			Date fechaEnviado, Date fechaRecibido) {
		// TODO Auto-generated method stub
		
	}


}
