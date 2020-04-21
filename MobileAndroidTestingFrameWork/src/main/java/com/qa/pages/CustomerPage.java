package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CustomerPage extends BaseTest{
	@AndroidFindBy(id = "com.spirit.customerapp:id/iv_user_image")
	public static MobileElement userImage;

}
