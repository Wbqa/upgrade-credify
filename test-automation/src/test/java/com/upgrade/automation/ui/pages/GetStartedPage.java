package com.upgrade.automation.ui.pages;

import com.upgrade.automation.ui.constants.PageConstants;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;

public class GetStartedPage extends BasePage<WebDriver> {

	private static final Logger logger = Logger.getLogger(GetStartedPage.class);	

    public GetStartedPage(WebDriver driver) {
		super(driver);
	    logger.debug("Webdriver initialized");		
	}

    public OfferPage submitIndividualForm(Hashtable<String, String> userData){
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.FIRST_NAME))).sendKeys(userData.get(PageConstants.FIRST_NAME));
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.LAST_NAME))).sendKeys(userData.get(PageConstants.LAST_NAME));
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.ADDRESS))).sendKeys(userData.get(PageConstants.ADDRESS));
        WebElement dropdown = getDriver().findElement(By.cssSelector(getObjectRepoProperty("address_list")));
        List<WebElement> addressList = dropdown.findElements(By.tagName("li"));
        for (WebElement address : addressList){
            if (getDriver().findElement(By.xpath(getObjectRepoProperty("address_line"))).getText().equalsIgnoreCase(userData.get(PageConstants.ADDRESS))){
                address.click();
                break;
            }
        }
        String[] date= userData.get(PageConstants.DOB).split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        LocalDate birthDate = new LocalDate( year, month, day);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedBirthDate = dateFormat.format(birthDate.toDate());
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.DOB))).sendKeys(formattedBirthDate);
        getDriver().findElement(By.xpath(getObjectRepoProperty(PageConstants.CONTINUE_BTN))).click();
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.ANNUAL_INCOME))).sendKeys(userData.get(PageConstants.ANNUAL_INCOME));
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.ADDITIONAL_INCOME))).sendKeys(userData.get(PageConstants.ADDITIONAL_INCOME), Keys.ENTER);
        //getDriver().findElement(By.xpath(getObjectRepoProperty(Constants.CONTINUE_BTN))).click();
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.EMAIL_ADDRESS))).sendKeys(userData.get(PageConstants.EMAIL_ADDRESS));
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.PASSWORD))).sendKeys(userData.get(PageConstants.PASSWORD));
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.TERMS))).click();
        getDriver().findElement(By.cssSelector(getObjectRepoProperty(PageConstants.CHECK_RATE_LAST_STEP))).click();
        return new OfferPage(getDriver());
    }

    public boolean isTitlePresent(){
        return getDriver().findElement(By.xpath(getObjectRepoProperty("get_started_title"))).isDisplayed();
    }
}
