package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CustomerPage extends BaseTest{
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView\r\n" + 
			"") 
	public static MobileElement userImage;
	
	//com.spirit.customerapp:id/iv_user_image
	
	
	
	public MyProfile pressUserImage() {
		click(userImage);
		return new MyProfile();
	}
	
	

}

