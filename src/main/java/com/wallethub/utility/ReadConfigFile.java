package com.wallethub.utility;

import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfigFile {
	private String filename;
	
	public ReadConfigFile(String filename){
		this.filename=filename;
	}

    public String getProperty(String propertyName){
        Properties property = new Properties();
        String propertyValue = null;
            try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				        + "\\"+filename);
				property.load(fis);
				propertyValue = property.getProperty(propertyName);
			} catch (Exception e) {
			}
        return propertyValue;
    }
}
