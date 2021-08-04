package com.upgrade.automation.common;

import java.util.Properties;

public class ConfigLoader {

	private Properties props;
		
	
	private ConfigLoader(Properties props) {
		this.props = props;
	}

	public static ConfigLoader load(String file, String defaultFile) {
		ConfigLoader configLoader = load(file);
				
		if (configLoader.getProperties() == null || configLoader.getProperties().size() == 0)
			return load(defaultFile);
		
		return configLoader;
	}

	public static ConfigLoader load(String file) {
		return new ConfigLoader(PropertyUtils.load(file));
	}
	
	public String getProperty(String propName) {
		return props.getProperty(propName);
	}
	
	public String getProperty(String propName, String defaultValue) {
		return props.getProperty(propName, defaultValue);
	}

	public Properties getProperties() {
		return props;
	}
	
	@Override
	public String toString() {
		return "ConfigLoader [props=" + props + "]";
	}
	
}
