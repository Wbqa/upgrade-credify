package com.upgrade.automation.ui.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfferPage extends BasePage<WebDriver>{

	private static final Logger logger = Logger.getLogger(OfferPage.class);	

	public OfferPage(WebDriver driver) {
		super(driver);
	    logger.debug("Webdriver initialized");		
	}

	
    public Map<String, String> saveOffer(){
        Map<String,String> offerDetails = new HashMap<String, String>();
        webDriverWait(getAppPropertyAsInt("app.webdriver.wait")).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getObjectRepoProperty("offer_header"))));
        String loanAmount=getDriver().findElement(By.cssSelector(getObjectRepoProperty("loan_amount_offer"))).getText();
        String monthlyPayment=getDriver().findElement(By.cssSelector(getObjectRepoProperty("monthly_payment_offer"))).getText();
        String term=getDriver().findElement(By.cssSelector(getObjectRepoProperty("term_offer"))).getText();
        String interestRate=getDriver().findElement(By.cssSelector(getObjectRepoProperty("interest_rate_offer"))).getText();
        String apr=getDriver().findElement(By.cssSelector(getObjectRepoProperty("apr_offer"))).getText();

        offerDetails.put("loan_amount", loanAmount);
        offerDetails.put("monthly_payment", monthlyPayment);
        offerDetails.put("term", term);
        offerDetails.put("interest_rate", interestRate);
        offerDetails.put("apr", apr);
        return offerDetails;
    }

    public void signOut(){

        webDriverWait(getAppPropertyAsInt("app.webdriver.wait")).until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(getObjectRepoProperty("menu")))));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()", getDriver().findElement(By.cssSelector(getObjectRepoProperty("menu"))));
        webDriverWait(getAppPropertyAsInt("app.webdriver.wait")).until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(getObjectRepoProperty("sign_out")))));
        js.executeScript("arguments[0].click()", getDriver().findElement(By.xpath(getObjectRepoProperty("sign_out"))));
    }

    public boolean isOfferPage(){
        webDriverWait(getAppPropertyAsInt("app.webdriver.wait")).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getObjectRepoProperty("offer_header"))));
        return getDriver().getCurrentUrl().endsWith("/offer-page");
    }
}
