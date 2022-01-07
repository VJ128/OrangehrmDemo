package com.orangeHRM.TestCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.orangeHRM.Utilities.Readconfig;

public class BaseClass {
	Readconfig rc=new Readconfig();
	public String baseURL = rc.getBaseURL();
	public String username = rc.getUserName();
	public String password = rc.getPassword();
	public String chromepath = rc.getChromePath();
	//System.getProperty("user.dir") + "/Drivers/chromedriver.exe"
	public String iepath = "";
	public String firefoxpath = "";
	static WebDriver driver;
	public Logger log = LogManager.getLogger();

	@Parameters("browser")
	@BeforeClass
	public void setUpBrowser(String br) throws InterruptedException {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", iepath);
			driver = new InternetExplorerDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		Thread.sleep(3000);
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
