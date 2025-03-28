package com.emicalculator.runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/features/loan.feature",
		glue = {"com.emicalculator.hooks","com.emicalculator.stepDefinitions"},
		
		plugin = {
				"pretty",
				"html:target/cucumber-reports"
		},
		
		monochrome = true
		
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
	public static String browser;
	public static String appUrl;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void setUp(String browserParam , String urlParam) {
		
		browser = browserParam;
		appUrl = urlParam;
	}
}
