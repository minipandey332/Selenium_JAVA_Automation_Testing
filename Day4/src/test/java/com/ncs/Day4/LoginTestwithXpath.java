package com.ncs.Day4;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTestwithXpath {

WebDriver driver;
	
// This executes before the class
	@Before
	public void init() {
		
			//WebDriverManager.chromedriver().setup();	
		
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--remote-allow-origins=*");
			
			options.addArguments("start-maximized");  // Maximize the window
		
			
			driver = new ChromeDriver(options); 
			driver.manage().window().maximize();
			 
			// Implicit wait : if element not found within provided time, then, it throw ELEMENTNOTFOUND error.
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	
	// This executes after the class
	@After
	public void destroy() {
		// This will close the current window only
		// quit() will close all associated window like all child opening windows..
		driver.close();
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(StoreData.uname);
		driver.findElement(By.name("password")).sendKeys(StoreData.pass); 
		driver.findElement(By.className("oxd-button")).click();
		
		// NoSuchElementException will be thrown if the element is not present
		 
		// can also use : driver.findElement(By.className("oxd-userdropdown1")).click(); 
		driver.findElement(By.xpath("//li/ul/li[4]/a")).click();
		
	
		}
	
	

}
