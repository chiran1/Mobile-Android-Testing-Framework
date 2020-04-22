package com.qa.tests;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SignInPageTests extends BaseTest  {
	
	SignInPage signInPage;
	CustomerPageTest customerPage;

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		signInPage = new SignInPage();
		System.out.println('\n'+ "*********"+ m.getName()+"***********"+'\n');
		
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void invalidUserName() {
		SignInPage.clickNotification();
		SignInPage.clickLocation();
		SignInPage.clickSignIn();
		SignInPage.enterEmailId("ram@hotmail.com");
		SignInPage.enterPassword("Simple@123");
		SignInPage.clickBtnSignIn();
		String actual= SignInPage.getErrText();
		String expected="Sorry, this email address could not be found.";
		System.out.println("actual error txt =  "+ actual + '\n'+ "expected error txt =  "+ expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void validUserName() {
		
		SignInPage.clearEmailField();
		SignInPage.enterEmailId("gurkhalies@hotmail.com");
		SignInPage.enterPassword("Simple@123");
		SignInPage.clickBtnSignIn();
		SignInPage.clickTouchId();
		
		boolean actual = SignInPage.getBol();
		boolean expected = true;
		System.out.println("actual displayed."+ actual + '\n'+ "expected displayed --"+ expected);
		Assert.assertEquals(actual, expected);
		
		
	}

}
