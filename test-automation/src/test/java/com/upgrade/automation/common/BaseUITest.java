package com.upgrade.automation.common;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.upgrade.automation.ui.TestSuiteConfiguration;
import com.upgrade.automation.ui.pages.BasePage;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public abstract class BaseUITest extends BaseTest {

	protected static URL gridHubUrl = null;
	protected static String siteBaseUrl;
	protected static String implicitWait;
	protected static Capabilities capabilities;

	protected WebDriver driver;

	@BeforeSuite
	public void initTestSuite() throws IOException {
		TestSuiteConfiguration config = new TestSuiteConfiguration();
		siteBaseUrl = config.getProperty("site.base.url");
		if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
			gridHubUrl = new URL(config.getProperty("grid.url"));
		}
		capabilities = config.getCapabilities();
		implicitWait = config.getProperty("app.implicit.wait");
	}

	@BeforeMethod
	public void initWebDriver() {
		driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitWait),
                TimeUnit.SECONDS);		
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebDriverPool.DEFAULT.dismissAll();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected <T extends BasePage<?>> T getPage(Class<T> clazz) {
		try {
			Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
			return (T) constructor.newInstance(getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
