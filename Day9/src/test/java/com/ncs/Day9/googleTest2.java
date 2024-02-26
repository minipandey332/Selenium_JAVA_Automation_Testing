package com.ncs.Day9;

import java.time.Duration;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

import org.junit.Test;

public class googleTest2 {
	
	static WebDriver driver;
	@Before
	public void init() throws Exception {
		System.out.println("inside before class");
		// Create option Object
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");

				driver = new ChromeDriver(option);
				//Maximize window
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.navigate().to("https://google.com");

				Thread.sleep(2000);
		
	}

	@After
	public void end() throws Exception {
		System.out.println("Execution Done");
		driver.close();
	}

	@Test
	public void LoginTest2() throws InterruptedException {
		
		Thread.sleep(3000);
		GoogleSearchPage gsp = new GoogleSearchPage(driver);
		GoogleDoodlesPage gdp= gsp.clickFeelingLuckybtn();
		
		assertTrue(gdp.ddleslinktext().trim().equalsIgnoreCase("Doodles Archive")); // Check whether the text "Doodles Archives" is visible on window or not
		assertTrue(gdp.isDisplayed());
}
	
//	@Test
//	public void postmethodtest(ITestResult ITR) {
//		Reporter.setCurrentTestResult(ITR);
//		Reporter.log("logs post test execution");
//	if(ITR.getStatus()==ITestResult.SUCCESS) {
//		Reporter.log("Test execution is successful");
//		
//	}
//	else if(ITR.getStatus()==ITestResult.FAILURE) {
//		Reporter.log(ITR.getName()+"failed");
//	}
//	else {
//		Reporter.log("execution is failed");
//	}
//		
//	}

}
