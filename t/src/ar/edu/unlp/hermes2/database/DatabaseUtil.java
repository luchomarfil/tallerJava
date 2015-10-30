package ar.edu.unlp.hermes2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.edu.unlp.hermes2.gui.HermesException;

public class DatabaseUtil {

	public DatabaseUtil() {

	}

	public static Connection getConnection() throws HermesException {
		String driverName = "org.sqlite.JDBC";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new HermesException("No se encuentra el driver " + driverName);
		}
		// create a database connection
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:sqlite:hermes");
			return connection;
		} catch (SQLException e) {
			throw new HermesException("Error de conexion con la base de datos",	e);
		}

	}
	
	public static ResultSet ejecutarSelect(Connection c, String sql) throws HermesException {
		Connection connection = c;
		try {			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			ResultSet returnValues = statement.executeQuery(sql);
			return returnValues;
		}
		catch (SQLException e) {//if the error message is "out of memory", it probably means no database file is found
			throw new HermesException("Error obteniendo el result set para la query " + sql, e);
		}
	}

	public static int executeScript(Connection c, String sql) throws HermesException {
		Connection connection = c;
		try {			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			int tuplasAfectadas = statement.executeUpdate(sql);
			return tuplasAfectadas;
		}
		catch (SQLException e) {//if the error message is "out of memory", it probably means no database file is found
			throw new HermesException("Error obteniendo el result set para la query " + sql, e);
		}

		finally {
			if (connection != null){
//				try {
//				//	connection.close();
//				} catch (SQLException e) {
//					throw new HermesException("Error intentando cerrar la conexion con la base de datos");
//				}
			}
			
		}
	}

	public static int[] executeBatch(Connection c, String sql) throws HermesException {
		Connection connection = c;
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(130); // set timeout to 30 sec.
			statement.addBatch(sql);
			return statement.executeBatch();
			
		}
		catch (SQLException e) {//if the error message is "out of memory", it probably means no database file is found
			throw new HermesException("Error obteniendo el result set para la query " + sql, e);
		}

		finally {
//			if (connection != null){
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					throw new HermesException("Error intentando cerrar la conexion con la base de datos");
//				}
//			}
			
		}
	}


}
