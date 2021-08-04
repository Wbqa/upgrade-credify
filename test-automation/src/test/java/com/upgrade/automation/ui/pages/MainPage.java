package com.upgrade.automation.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage<WebDriver> {

	private static final Logger logger = Logger.getLogger(MainPage.class);	

    public MainPage(WebDriver webDriver) {
		super(webDriver);
	    logger.debug("Webdriver initialized");	
	    navigateTo(getAppProperty("site.base.url"));
	    logger.debug("Navigated to: " + getAppProperty("site.base.url"));	
	}

	//To-do's - select code in helper

	public GetStartedPage doCheckYourRate(String loanAmount, String loanPurpose) {
        getDriver().findElement(By.cssSelector(getObjectRepoProperty("loan_amount"))).sendKeys(loanAmount);
        Select select = new Select(getDriver().findElement(By.cssSelector(getObjectRepoProperty("loan_purpose"))));
        select.selectByVisibleText(loanPurpose);
        getDriver().findElement(By.xpath((getObjectRepoProperty("check_your_rate_main_page_btn")))).click();
        logger.debug("Selecting from an element : " + "" + " value as : " + "");
        return new GetStartedPage(getDriver());
    }

}

