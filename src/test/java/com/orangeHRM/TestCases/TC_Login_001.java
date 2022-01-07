package com.orangeHRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangeHRM.PageObjects.LoginPage;
import jdk.internal.org.jline.utils.Log;

public class TC_Login_001 extends BaseClass{
		
	@Test
	public void login() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("username is entered");
				
		lp.setPassword(password);
		log.info("password is entered");
		
		lp.clickLogin();
		log.info("Login button is clicked");
		
		Assert.assertEquals("OrangeHRM",driver.getTitle());
	}

}
