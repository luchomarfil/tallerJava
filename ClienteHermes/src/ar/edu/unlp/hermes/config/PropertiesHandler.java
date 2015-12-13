package ar.edu.unlp.hermes.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesHandler {

	private Properties prop;
	private static PropertiesHandler instance = null;
	private static Logger logger = Logger.getLogger(PropertiesHandler.class.getSimpleName());
	
	private PropertiesHandler() {

		InputStream inputStream = null;
		String propFileName = "./conf.properties";
		try {
			inputStream = new FileInputStream(propFileName);

			prop = new Properties();
			if (inputStream != null) {
				prop.load(inputStream);
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE,"El archivo no se encuentra disponible",e);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Error de I/O",e);
		} finally {
			try {
				if(inputStream!=null){
					inputStream.close();
				}
			} catch (IOException e) {
				 logger.log(Level.SEVERE,"Error cerrando el archivo",e);
			}
		}
	}

	public Properties getProperties() {
		return prop;
	}

	public static PropertiesHandler getInstance() {
		if (instance == null) {
			instance = new PropertiesHandler();
		}
		return instance;
	}

}
