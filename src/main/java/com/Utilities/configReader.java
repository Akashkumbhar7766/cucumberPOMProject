package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	private Properties prop;
	//this method is used to load property file and read it
	
	public Properties readProp() {
		
		prop= new Properties();
		try {
			FileInputStream fi= new FileInputStream("C:\\Users\\akash\\eclipse-workspace\\cucumberPOMproject\\src\\test\\resources\\Configfiles\\config.properties");
			prop.load(fi);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
}
