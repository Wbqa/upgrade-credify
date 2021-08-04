package com.upgrade.automation.ui;
 
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.upgrade.automation.common.ConfigLoader;
import com.upgrade.automation.common.constants.AppConstants;
import com.upgrade.automation.ui.constants.EWebDriverType;

/**
 * Loads test suite configuration from resource files.
 */
public class TestSuiteConfiguration {

  private Properties properties;
  private ConfigLoader defaultProperties;
  private static final Logger logger = Logger.getLogger(TestSuiteConfiguration.class);	

  public TestSuiteConfiguration() throws IOException {
  	this(System.getProperty("application.properties", AppConstants.DEFAULT_APP_PROPS_PATH));
  }

  public TestSuiteConfiguration(String fromResource) throws IOException {
    properties = new Properties();
    properties.load(TestSuiteConfiguration.class.getResourceAsStream(fromResource));
    defaultProperties = ConfigLoader.load(AppConstants.DEFAULT_APP_PROPS_PATH);
  }
  
  public Capabilities getCapabilities() throws IOException {
    String capabilitiesFile = properties.getProperty("capabilities");

    Properties capsProps = new Properties();
    capsProps.load(TestSuiteConfiguration.class.getResourceAsStream(capabilitiesFile));
    
    EWebDriverType webDriverType = EWebDriverType.valueByCapabilitiesFile(capabilitiesFile);
    if (webDriverType != null)
    	System.setProperty(webDriverType.getSysProperty(), webDriverType.getDriverPath());
    else
    	logger.error("No WebDriver system init property found for selected capabilities file "  + capabilitiesFile);
    
    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
      } else {
        capabilities.setCapability(name, value);
      }
    }

    return capabilities;
  }
  
  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  public String getProperty(String name) {
	  if (properties.getProperty(name).contains("$"))
		  return defaultProperties.getProperty(name);
	  
	  return properties.getProperty(name);
  }
}
