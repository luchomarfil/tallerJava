package ar.edu.unlp.hermes2.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class PropertiesHandler {

	private Properties prop;
	private static PropertiesHandler instance = null; 
	
	private PropertiesHandler() {
		
		InputStream inputStream;
		String propFileName = "./conf.properties";
		try{
		inputStream = new FileInputStream(propFileName);


		prop = new Properties();
		if (inputStream != null) {
			prop.load(inputStream);
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{}
	}
	
	
	public Properties getProperties()
	{return prop;}
	
	public static PropertiesHandler getInstance(){
		if (instance == null)
		{instance = new PropertiesHandler();}
		return instance;
	}

}

/**
 * 
 * 		Path propFileName2 = Paths.get(propFileName);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(propFileName2)) {
		    for (Path file : stream) {
		        System.out.print(file);
		    }
		}
 * 
 * 
 * */
