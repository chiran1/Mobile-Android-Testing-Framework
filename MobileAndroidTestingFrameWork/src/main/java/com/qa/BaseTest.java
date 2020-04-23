package com.qa;

import org.testng.annotations.Test;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	static AppiumDriver driver;
	static Properties props;
	InputStream inputStream;
	InputStream stringsis;
	protected static HashMap<String, String> strings = new HashMap<String, String>();
	TestUtils utils;
	
	 public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Parameters({ "platformName", "platformVersion", "deviceName" })
	@BeforeTest
	public void beforeTest(String platformName, String platformVersion, String deviceName) throws IOException {

		try {

			props = new Properties();
			String propFileName = "config.properties";
			String xmlFileName = ".\\strings\\strings.xml";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			utils = new TestUtils();
			strings= utils.parseStringXML(stringsis);
			
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("deviceName", deviceName);
			// desiredCapabilities.setCapability("udid", "96DAX0GYK7");
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("platformVersion", platformVersion);
			desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
			desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
			desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
			URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
			//desiredCapabilities.setCapability("app", appUrl);

			URL url = new URL(props.getProperty("appiumURL"));

			driver = new AndroidDriver(url, desiredCapabilities);
			String sessionId = driver.getSessionId().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(stringsis != null) {
				stringsis.close();
			}
			
		}
	}

	// explicit wait
	public static void waitForTheVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));

	}

	public static void click(MobileElement e) {
		waitForTheVisibility(e);
		e.click();
	}

	public static void sendKeys(MobileElement e, String txt) {
		waitForTheVisibility(e);
		e.sendKeys(txt);
	}

	public static String getAttribute(MobileElement e, String attribute) {
		waitForTheVisibility(e);
		return e.getAttribute(attribute);
		
	}
	
	public static boolean getAttributeBoolean(MobileElement e) {
		waitForTheVisibility(e);
		return e.isDisplayed();
	}
	
	public static void clear(MobileElement e) {
		waitForTheVisibility(e);
		e.clear();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
