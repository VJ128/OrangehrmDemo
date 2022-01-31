package com.orangeHRM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.orangeHRM.PageObjects.LoginPage;
import com.orangeHRM.Utilities.XLUtils;

import jdk.internal.org.jline.utils.Log;
@Listeners(com.orangeHRM.Utilities.Reporting.class)
public class TC_Login_001 extends BaseClass {

	XLUtils xlutil=new XLUtils();
    //dataprovider
    @DataProvider(name="DP1")
    public Object[][] createData1() throws Exception
    {
     Object[][] retObjArr=xlutil.getTableArray("C:/Users/vedas/eclipse-workspace/OrangeHRM_Framework/src/test/java/com/orangeHRM/TestData/LoginData.xls","Sheet1", "login");
     return(retObjArr);
    }
	
	@Test(dataProvider="DP1")
	public void login(String username,String password) throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("username is entered");

		lp.setPassword(password);
		log.info("password is entered");

		lp.clickLogin();
		log.info("Login button is clicked");

		log.info(driver.getCurrentUrl());
		// Assert.assertEquals("OrangeHRM",driver.getTitle());

		if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"))
		{
			Assert.assertTrue(true);
		}
		else
		{ captureScreen(driver, "loginTest");
		 Assert.assertTrue(false); 
		 log.info("login failed"); }
		
		/*
		 * if (driver.getTitle().equals("OrangeHRM")) { Assert.assertTrue(true);
		 * log.info("Login test passed"); } else { captureScreen(driver, "loginTest");
		 * Assert.assertTrue(false); log.info("Title is wrong/login failed"); }
		 */

	}

}
