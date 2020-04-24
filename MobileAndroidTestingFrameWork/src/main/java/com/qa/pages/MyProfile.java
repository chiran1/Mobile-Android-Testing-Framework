package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyProfile extends BaseTest {
	@AndroidFindBy(id = "com.spirit.customerapp:id/tv_done")
	public static MobileElement signOut;
	
	@AndroidFindBy(id = "com.spirit.customerapp:id/confirm_button")
	public static MobileElement confirmSignOut;
	
	public MyProfile clickSignOut() {
		click(signOut);
		return new MyProfile();
	}
	
	public MyProfile pressYesSignOutBtn() {
		click(confirmSignOut);
		return new MyProfile();
	}
}
