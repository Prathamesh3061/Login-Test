package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
//	Locators
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton = By.xpath("//button[@type='submit']");
	By successMsg = By.cssSelector(".flash.success");
	By errorMsg = By.cssSelector(".flash.error");
	
	
//	constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver; // receives driver from test class
	}
	
// actions (reusable methods)
	public void enterUsername(String username) {
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	public String getSuccessMessage() {
		return driver.findElement(successMsg).getText();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}	
	
}
