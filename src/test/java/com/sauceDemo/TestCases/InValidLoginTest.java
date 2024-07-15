package com.sauceDemo.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauceDemo.TestBase.TestBase;

public class InValidLoginTest extends TestBase {

	
	public InValidLoginTest() throws IOException {
		super();
	
	}

	public WebDriver driver;
	public ChromeOptions options;
	
	@BeforeMethod 
	public void setup() {
	driver = initializeBrowserAndOpenApplication("Chrome");		
	}
	
	@Test(priority = 1)
	public void invalidLogin() throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("invalidpassword"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		
		String expected = "Username and password do not match any user in this service";
		String actual = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test(priority = 2)
	public void invalidBlankPasswordLogin() throws Exception {
		
	
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		String expected = "Epic sadface: Password is required";
		String actual = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test(priority = 3)
	public void invalidBlankUsernameLogin() throws Exception {
		
	
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		String expected = "Epic sadface: Username is required";
		String actual = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test(priority =4 )
	public void invalidBlankUsernameAndPasswordLogin() throws Exception {
		
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		String expected = "Username is required";
		String actual = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
