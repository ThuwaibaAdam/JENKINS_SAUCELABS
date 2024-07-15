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

public class ValidLoginTest extends TestBase {

	
	public ValidLoginTest() throws IOException {
		super();
	
	}

	public WebDriver driver;
	public ChromeOptions options;
	
	@BeforeMethod 
	public void setup() {
	driver = initializeBrowserAndOpenApplication("Chrome");		
	}
	
	@Test (priority = 1)
	public void loginWithValidCredentials() throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
		
		driver.findElement(By.xpath("//div[@class = 'bm-burger-button']")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		WebElement swagLabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		System.out.println(swagLabs.getText());
		Assert.assertTrue(swagLabs.isDisplayed());
	}
	
	@Test (priority = 2)
	public void loginWithSecondUsername() throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username2"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);

		String expected = "Epic sadface: Sorry, this user has been locked out.";
		String actual = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test(priority = 3)
	public void loginWithThirduserName() throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username3"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class = 'bm-burger-button']")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		WebElement swagLabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		System.out.println(swagLabs.getText());
		Assert.assertTrue(swagLabs.isDisplayed());
	}
	
	@Test(priority = 4)
	public void loginWithForthuserName() throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username4"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		/*
		 * Alert alert = driver.switchTo().alert(); System.out.println(alert.getText());
		 * alert.accept();
		 */
		
		driver.findElement(By.className("bm-burger-button")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		WebElement swagLabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		System.out.println(swagLabs.getText());
		Assert.assertTrue(swagLabs.isDisplayed());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
