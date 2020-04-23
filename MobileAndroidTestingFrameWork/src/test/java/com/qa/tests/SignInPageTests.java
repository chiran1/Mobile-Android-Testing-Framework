package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SignInPageTests extends BaseTest {

	SignInPage signInPage;
	CustomerPageTest customerPage;
	InputStream datais;
	JSONObject signupUser;

	@BeforeClass
	public void beforeClass() throws IOException {

		try {
			String dataFileName = ".\\data\\signUsers.json";
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(datais);
			signupUser = new JSONObject(tokener);
		} catch (Exception e) {
			e.printStackTrace();
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

	@Test
	public void invalidUserName() {
		SignInPage.clickNotification();
		SignInPage.clickLocation();
		SignInPage.clickSignIn();
		SignInPage.enterEmailId(signupUser.getJSONObject("invalidUser").getString("username"));
		SignInPage.enterPassword(signupUser.getJSONObject("invalidUser").getString("password"));
		SignInPage.clickBtnSignIn();
		String actual = SignInPage.getErrText();
		String expected = "Sorry, this email address could not be found.";
		System.out.println("actual error txt =  " + actual + '\n' + "expected error txt =  " + expected);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void validUserName() {

		SignInPage.clearEmailField();
		SignInPage.enterEmailId(signupUser.getJSONObject("validUser").getString("username"));
		SignInPage.enterPassword(signupUser.getJSONObject("validUser").getString("password"));
		SignInPage.clickBtnSignIn();
		SignInPage.clickTouchId();

		boolean actual = SignInPage.getBol();
		boolean expected = true;
		System.out.println("actual displayed." + actual + '\n' + "expected displayed --" + expected);
		Assert.assertEquals(actual, expected);

	}

}
