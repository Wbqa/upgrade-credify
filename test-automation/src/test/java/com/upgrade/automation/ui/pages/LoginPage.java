package com.upgrade.automation.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.upgrade.automation.ui.constants.PageConstants;

public class LoginPage extends BasePage<WebDriver>{

	private static final Logger logger = Logger.getLogger(LoginPage.class);	

    public LoginPage(WebDriver driver) {
		super(driver);
	    logger.debug("Webdriver initialized");		
	}

	public OfferPage doLogin(String username, String password){
		getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.EMAIL_ADDRESS))).sendKeys(username);
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.PASSWORD))).sendKeys(password);
        getDriver().findElement(By.xpath(getObjectRepoProperty("sign_in_btn"))).click();
		return new OfferPage(getDriver());
    }
}
