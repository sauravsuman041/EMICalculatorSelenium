package com.emicalculator.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.emicalculator.runners.TestNGRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

   public static  WebDriver driver;
	
    
     
	@Before
	public void setUp() {
		String browser = TestNGRunner.browser;
		String url = TestNGRunner.appUrl;
		switch(browser.toLowerCase()) {
		
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver =  new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser not supported");
		}
		
		driver.get(url);
		driver.manage().window().maximize();

	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
	 public static WebDriver getWebDriver() {
	 		return driver;
	 	}
	 
}