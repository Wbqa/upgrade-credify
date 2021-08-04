package com.upgrade.automation.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

	public static Properties load(String file) {
						
		Properties props = new Properties();
		
		try {
			InputStream in = PropertyUtils.class.getResourceAsStream(file);
			props.load(in);
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("failed to load properties file: " + file); 
		}

		return props;
	}	
}
