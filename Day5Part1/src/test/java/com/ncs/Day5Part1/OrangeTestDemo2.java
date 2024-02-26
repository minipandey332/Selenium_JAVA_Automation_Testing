package com.ncs.Day5Part1;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/////////////////////// Here we test google Image text & CSS selector test ///////////////////

public class OrangeTestDemo2 {
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
	
	@Test
	public void checkImages() throws InterruptedException {
		 
		driver.navigate().to("https://google.com");
		 
		driver.findElement(By.linkText("Images")).click();
		System.out.println(driver.getCurrentUrl() + " Image text is successfully works!! ");
		driver.findElement(By.partialLinkText("Ima")).click();
		 
		
		assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.google.com/imghp?hl=en&ogbl"));
		
		}
	
	@Test
	public void cssCheck() {
		 
		driver.get("C:\\Users\\p1357950\\Documents\\SeleniumDemo.html");
		 
		String p1 = driver.findElement(By.cssSelector("p.newstyle")).getText();
		 
		String p2 = driver.findElement(By.cssSelector("p#secondstyle")).getText();
		 
		assertTrue(p1.trim().equals("Welcome"));
		
		System.out.println("Welcome");
		 
		assertTrue(p2.trim().equals("yes, please"));
		System.out.println("yes, please");
		
	}
	
}
