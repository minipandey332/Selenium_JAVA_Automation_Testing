package com.ncs.Day5Part1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class AmazonTest {
	WebDriver driver;

	@Before
	public void init() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);

		// driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
	}

	@Test
	public void AmazonSearchTest() throws InterruptedException {
	
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung");
		WebElement dropdownelement = driver.findElement(By.id("searchDropdownBox"));
		Select categories = new Select(dropdownelement);
		categories.selectByVisibleText("Electronics");
//categories.selectByIndex(15);
//categories.selectByValue("search-alias=electronics");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		assertTrue(true);
	}

	/*
	 * @Test()
	 * 
	 * public void AmazonSearchFailedTest() {
	 * driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung"
	 * ); WebElement dropdownelement =
	 * driver.findElement(By.id("searchDropdownBox")); Select categories = new
	 * Select(dropdownelement); categories.selectByVisibleText("Mobiles");
	 * driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
	 * assertTrue(true); }
	 */

//@Test
//public void getAlloptionsTest() {
//
//	WebElement dropdownelement = driver.findElement(By.id("searchDropdownBox"));
//Select categories = new Select(dropdownelement);
//List<WebElement> catylist = categories.getOptions();
//
//for (WebElement category:catylist) 
//{
//System.out.println("Category Value - "+category.getAttribute("value")); 
//System.out.println("Category Nam "+ category.getText());
//
//}
//assertTrue(true);
//}

@AfterMethod
public void aftereverymethod(ITestResult itr) throws IOException {
	System.out.println("Inside screenshot method");
	if (itr.isSuccess()) {
		System.out.println("Test method : " + itr.getMethod().getMethodName() + " execution is successful");
	}

	else {
		// Capture screenshot
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(filepath);
		FileUtils.copyFile(source, destination);

		System.out.println("Test method : " + itr.getMethod().getMethodName() + " execution is unsuccessful");
	}
}

@After
public void destroy() {
	driver.close();
}

}
