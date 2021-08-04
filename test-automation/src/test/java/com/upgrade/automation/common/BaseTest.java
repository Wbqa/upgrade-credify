package com.upgrade.automation.common;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.upgrade.automation.common.constants.AppConstants;

/**
 * Base class for TestNG-based test classes
 */
public abstract class BaseTest {

  private ConfigLoader appProperties;	

  @BeforeTest
  public void initializeTest() throws IOException {
	  appProperties = ConfigLoader.load(AppConstants.APP_PROPS_PATH,AppConstants.DEFAULT_APP_PROPS_PATH);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
  }
  
  public String getAppProperty(String propName) {
	  return appProperties.getProperty(propName);
  }

  public String getAppProperty(String propName, String defaultValue) {
	  return appProperties.getProperty(propName,defaultValue);
  }

}
