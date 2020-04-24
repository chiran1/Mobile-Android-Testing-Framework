package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.CustomerPage;
import com.qa.pages.MyProfile;
import com.qa.pages.SignInPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertThrows;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SignInPageTests extends BaseTest {

	SignInPage signInPage;
	CustomerPageTest customerPage;
	InputStream datais;
	JSONObject signupUser;

	@BeforeClass
	public void beforeClass() throws Exception {

		try {
			String dataFileName = ".\\data\\signUsers.json";
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(datais);
			signupUser = new JSONObject(tokener);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (datais != null) {
				datais.close();
			}
		}

	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		signInPage = new SignInPage();
		System.out.println('\n' + "*********" + m.getName() + "***********" + '\n');

	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test(priority = 1)
	public void invalidUserName() {
		SignInPage.clickNotification();
		SignInPage.clickLocation();
		SignInPage.clickSignIn();
		SignInPage.enterEmailId(signupUser.getJSONObject("invalidUser").getString("username"));
		SignInPage.enterPassword(signupUser.getJSONObject("invalidUser").getString("password"));
		SignInPage.clickBtnSignIn();
		String actual = SignInPage.getErrText();
		String expected = "Sorry, this email address could not be found.";// strings.get("errorText_invalid_username_or_password");
		System.out.println("actual error txt =  " + actual + '\n' + "expected error txt =  " + expected);
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void validUserName() {

		SignInPage.clearEmailField();
		SignInPage.enterEmailId(signupUser.getJSONObject("validUser").getString("username"));
		SignInPage.enterPassword(signupUser.getJSONObject("validUser").getString("password"));
		SignInPage.clickBtnSignIn();
		SignInPage.clickTouchId();

		boolean actual = SignInPage.getBol();
		boolean expected = Boolean.valueOf(strings.get("display"));
		System.out.println("actual displayed." + actual + '\n' + "expected displayed --" + expected);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 3)
	public void signOut() {
		new CustomerPage().pressUserImage();
		System.out.println("image clicked");
		
		/*
		 * new MyProfile().clickSignOut(); new MyProfile().pressYesSignOutBtn();
		 */
			/*
			 * String actual = SignInPage.getHeaderText(); String expected =
			 * "Coronavirus Information"; System.out.println("actual header txt =  " +
			 * actual + '\n' + "expected header txt =  " + expected);
			 * Assert.assertEquals(actual, expected);
			 */
		 
	}

}
