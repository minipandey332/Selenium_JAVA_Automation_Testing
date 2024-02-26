package com.ncs.Day6;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Implicit wait ------- Set time delay without condition, it will wait till element is found.
//If element not found then "Nosuchelementpresent" exception thrown


//Explicit wait ----------- Set time delay with condition, Timeout exception will be thrown             
               
//Fluent wait -------------  Enhanced explicit wait , & set the freq. polling
          
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class t{
	WebDriver driver;

	@Before
	public void init() throws InterruptedException
	{
		System.out.println("Initialize method...");
				ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);

	}

	@After
	public void destroy() {
		System.out.println("driver close");
		driver.close();
	}
	@Test
	//Run | Debug
	public void explicitwaitTest() throws InterruptedException {
		System.out.println("Test Run ....");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//input")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/span/i")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul/li/span/i")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/auth/logout']")));
		driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();

		Thread.sleep(3000);

	}
}