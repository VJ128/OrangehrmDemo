package com.orangeHRM.TestCases;

import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestDemo {
	static WebDriver driver;

	@Test
	public void logIn() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/vedas/eclipse-workspace/OrangeHRM_Framework/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement txtUsername = driver.findElement(ByName.name("txtUsername"));
		txtUsername.sendKeys("Admin");
		WebElement txtPassword = driver.findElement(ByName.name("txtPassword"));
		txtPassword.sendKeys("admin123");
		WebElement Submit = driver.findElement(ByName.name("Submit"));
		Submit.click();
	}
}
