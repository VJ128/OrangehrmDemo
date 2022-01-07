package com.orangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Identify all webelements in Login Page

	@FindBy(name = "txtUsername")
	// @FindBy(name="uid")
	WebElement txtUsername;

	@FindBy(name = "txtPassword")
	// @FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name = "Submit")
	// @FindBy(name="btnLogin")
	WebElement Submit;

	// Methods to set values for Webelements and their respective actions

	public void setUserName(String username) {
		txtUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		Submit.click();
	}
}
