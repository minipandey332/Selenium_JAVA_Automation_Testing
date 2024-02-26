package com.ncs.Day5Part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeTest {
	WebDriver driver;
	
	@Before
	public void init() {
		
				 ChromeOptions options = new ChromeOptions(); 
					options.addArguments("--remote-allow-origins=*");
					
					options.addArguments("start-maximized");
					
					driver = new ChromeDriver(options);
					
					//driver.manage().window().maximize();
					 
					// Implicit wait
					 
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
	}
	
	@After
	public void destroy() {
		driver.close();
	}
	
	// Test1 : Whether dashboard opens successfull or not, else print errormessage
	@Test
	public void ValidLoginTest() throws InterruptedException {
            driver.get("https://opensource-demo.orangehrmlive.com");
			Thread.sleep(3000);
			
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.tagName("button")).submit();
			
		  String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		  String expectedtest = "Dashboard";
		  
		  WebElement dashboard = driver.findElement(By.xpath("//h6"));
		  
		  //////// Working of asertEquals ////////
		  //if first & second parameter matches then proceed to next statement.
		  // if first & second parameter doesn't matches, then execution stop & 3rd parameter "Login unsuccessful" is printed.
		 
//		  assertEquals(driver.getCurrentUrl(),expectedurl,"I am not getting expected url!! LOGIN UNSUCCESSFUL"); 
//		  assertTrue(dashboard.isDisplayed());
//		  assertEquals(dashboard.getText(), expectedtest,"I am not getter expected h6 text!! DASHBOARD IS NOT DISPLAYED!");

		  Thread.sleep(3000);
		  
		  driver.findElement(By.className("oxd-userdropdown")).click();
		  Thread.sleep(3000);
			driver.findElement(By.xpath("//li/ul/li[4]/a")).click();
			Thread.sleep(2000);
	}
	
	@Test
	public void InvalidLoginTest() throws InterruptedException {
		
		// We can also use :
		// driver.navigate().To.("https://opensource-demo.orangehrmlive.com");
		driver.get("https://opensource-demo.orangehrmlive.com");

		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("Incorrect");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).submit();
		
		WebElement errormsg = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		Thread.sleep(3000);
		assertTrue(errormsg.isDisplayed());
	assertEquals(errormsg.getText(), "Invalid credentials", "Dashboard isn't display");
		
}
}
