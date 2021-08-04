package com.upgrade.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.upgrade.automation.common.ConfigLoader;
import com.upgrade.automation.common.constants.AppConstants;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class BasePage<W extends WebDriver> {

    protected W driver;
    private ConfigLoader orProperties;
    private ConfigLoader appProperties;
    private ConfigLoader defaultProperties;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public BasePage(W driver) {
        this.driver = driver;
        orProperties = ConfigLoader.load(AppConstants.OBJECT_REPO_PROPS_PATH);
        appProperties = ConfigLoader.load(AppConstants.APP_PROPS_PATH, AppConstants.DEFAULT_APP_PROPS_PATH);
        defaultProperties = ConfigLoader.load(AppConstants.DEFAULT_APP_PROPS_PATH);
    }

    protected String getObjectRepoProperty(String propName) {
        return orProperties.getProperty(propName);
    }

    protected String getObjectRepoProperty(String propName, String defaultValue) {
        return orProperties.getProperty(propName, defaultValue);
    }

    protected String getAppProperty(String propName) {
	  if (appProperties.getProperty(propName).contains("$"))
		  return defaultProperties.getProperty(propName);

    	return appProperties.getProperty(propName);
    }

    protected int getAppPropertyAsInt(String propName) {
	  if (appProperties.getProperty(propName).contains("$"))
		  return Integer.valueOf(defaultProperties.getProperty(propName));

    	return Integer.valueOf(appProperties.getProperty(propName));
    }

    protected String getAppProperty(String propName, String defaultValue) {
  	  if (appProperties.getProperty(propName).contains("$"))
		  return defaultProperties.getProperty(propName);
        
    	return appProperties.getProperty(propName, defaultValue);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    protected WebDriverWait webDriverWait(long timeOutInSeconds) {
      return new WebDriverWait(driver, timeOutInSeconds);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
