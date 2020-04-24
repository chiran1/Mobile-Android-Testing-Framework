package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInPage extends BaseTest {

	@AndroidFindBy(id = "com.spirit.customerapp:id/confirm_button")
	private static MobileElement notification;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
	private static MobileElement location;

	@AndroidFindBy(id = "com.spirit.customerapp:id/tv_signin")
	private static MobileElement signIn;

	@AndroidFindBy(id = "com.spirit.customerapp:id/edit_email")
	private static MobileElement email;

	@AndroidFindBy(id = "com.spirit.customerapp:id/edit_password")
	private MobileElement password;

	@AndroidFindBy(id = "com.spirit.customerapp:id/btn_sign_in")
	private static MobileElement btnSignIn;

	@AndroidFindBy(id = "com.spirit.customerapp:id/tv_error_msg")
	private static MobileElement errTxt;

	@AndroidFindBy(id = "com.spirit.customerapp:id/confirm_button")
	private static MobileElement TouchIdAllow;
	
	@AndroidFindBy(id = "com.spirit.customerapp:id/header")
	private static MobileElement header;
	

	// MobileElement Notifications = (MobileElement)
	// driver.findElement(By.id("com.spirit.customerapp:id/confirm_button"));

	// MobileElement location = (MobileElement)
	// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button"));

	// MobileElement SignIn = (MobileElement)
	// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView\n"
	// +
	// ""));

	// MobileElement email = (MobileElement)
	// driver.findElement(By.id("com.spirit.customerapp:id/edit_email"));

	// MobileElement password = (MobileElement)
	// driver.findElement(By.id("com.spirit.customerapp:id/edit_password"));

	// MobileElement btnSignIn = (MobileElement)
	// driver.findElement(By.id("com.spirit.customerapp:id/btn_sign_in"));

	public static SignInPage clickNotification() {
		click(notification);
		return new SignInPage();

	}

	public static SignInPage clickLocation() {
		click(location);
		return new SignInPage();

	}

	public static SignInPage clickSignIn() {
		click(signIn);
		return new SignInPage();

	}

	public static SignInPage enterEmailId(String email) {
		sendKeys(new SignInPage().email, email);
		return new SignInPage();

	}

	public static SignInPage enterPassword(String password) {
		sendKeys(new SignInPage().password, password);
		return new SignInPage();

	}

	public static CustomerPage clickBtnSignIn() {
		click(btnSignIn);
		return new CustomerPage();

	}

	public static String getErrText() {
		return getAttribute(errTxt, "text");
	}
	
	public static String getHeaderText() {
		return getAttribute(header, "text");
	}
	

	public static boolean getBol() {
		return getAttributeBoolean(CustomerPage.userImage);
	}

	public static SignInPage clearEmailField() {
		clear(email);
		return new SignInPage();
	}

	public static SignInPage clickTouchId() {
		click(TouchIdAllow);
		return new SignInPage();
	}
	
	public static CustomerPage clickImage() {
		click(CustomerPage.userImage);
		return new CustomerPage();
	}

}
