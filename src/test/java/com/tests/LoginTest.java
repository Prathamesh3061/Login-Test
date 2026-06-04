package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest {

	WebDriver driver;
	
	LoginPage loginPage;  // <--Page object
	
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	
		loginPage = new LoginPage(driver); // pass driver to page
	}
	
	// Test 1 - Valid Login
	@Test(priority = 1)
	public void validLoginTest() {
		
		loginPage.login("tomsmith", "SuperSecretPassword!");
		
		String msg = loginPage.getSuccessMessage();
		System.out.println(msg);
		
		Assert.assertTrue(msg.contains("You logged into a secure area!"),
										"Valid login failed!");
		
		driver.navigate().back();
		
	}
	
	
//	Test 2 - Invalid Login
	@Test(priority = 2)
	public void invalidLoginTest() {
		loginPage.login("user","pass");
		
		String msg = loginPage.getErrorMessage();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Your username is invalid!"),"Error message not shown for invalid login!");
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
