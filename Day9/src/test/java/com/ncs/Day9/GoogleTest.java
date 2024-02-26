package com.ncs.Day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	WebDriver driver;
	 
	@BeforeClass
	 
	public void init() {
	 
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	 
	driver.get("https://www.google.com");
	}
	 
	@AfterClass
	 
	public void end() {
	 
	driver.close();
	}
	 

	@Test
	public void ddlesTest() {
	 
	GoogleSearchPage gsp= new GoogleSearchPage(driver);
	GoogleDoodlesPage gdp = gsp.clickFeelingLuckybtn();
	assert(gdp.ddleslinktext().trim().equalsIgnoreCase("Doodles Archive"));
	assert(gdp.isDisplayed());
}
}