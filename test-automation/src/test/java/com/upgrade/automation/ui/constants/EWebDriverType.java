package com.upgrade.automation.ui.constants;

import java.util.Objects;

public enum EWebDriverType {

	Chrome("webdriver.chrome.driver","drivers/chromedriver.exe", "/config/capabilities/chrome.capabilities"), 
	FireFox("webdriver.gecko.driver","drivers/geckodriver.exe","/config/capabilities/firefox.capabilities"), 
	IE("webdriver.ie.driver","drivers/IEDriverServer.exe","/config/capabilities/ie.capabilities"), 
	Opera("","","/config/capabilities/opera.capabilities"), 
	Safari("","","/config/capabilities/safari.capabilities");
	
	private String sysProperty;
	private String driverPath;
	private String capabilitiesFilePath;
	
	private EWebDriverType (String sysProperty, String driverPath, String capabilitiesFilePath) {
		this.sysProperty = sysProperty;
		this.driverPath = driverPath;
		this.capabilitiesFilePath = capabilitiesFilePath;
	}

	public String getDriverPath() {
		return driverPath;
	}
	
	public String getSysProperty() {
		return sysProperty;
	}

	public String getCapabilitiesFilePath() {
		return capabilitiesFilePath;
	}

	public static EWebDriverType valueByCapabilitiesFile(String capabilitiesFile) {
		
		if (Objects.isNull(capabilitiesFile)) 
			return null;
		
		for(EWebDriverType item: values()) {
			if (item.getCapabilitiesFilePath().equalsIgnoreCase(capabilitiesFile))
				return item;
		}
		
		return null;
	}
}
