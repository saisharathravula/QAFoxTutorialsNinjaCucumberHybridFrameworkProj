package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public  Properties intializeProperties() {
		
		Properties prop = new Properties();
		File propFile = new File(".\\src\\test\\resources\\config\\Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	
	

}

