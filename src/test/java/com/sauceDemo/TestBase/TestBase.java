package com.sauceDemo.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public Properties prop ;
	public FileInputStream ip;
	public ChromeOptions options;
	public WebDriver driver;	
	
	public TestBase() throws IOException {
		 prop = new Properties();
		 ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\sauceDemo\\TestCases\\config.properties");
		 prop.load(ip);
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browsernName) {
		
		if(browsernName.equals("Chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}else if(browsernName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browsernName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	
		}
	}

