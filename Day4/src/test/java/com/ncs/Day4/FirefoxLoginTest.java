package com.ncs.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Import Edge driver
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import org.junit.Test;

public class FirefoxLoginTest {

	@Test
	public void FireFoxTest() throws InterruptedException {
	 
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new FirefoxDriver(options); // Open FireFox Browser
		Thread.sleep(3000);
		 
		// WebDriver interface provides specification for browser actions driver obj.
		 
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(3000);
		
		WebElement usernamefield = driver.findElement(By.name("username")); 
		WebElement passwordfield = driver.findElement(By.name("password"));
		 
		WebElement loginbtn= driver.findElement(By.className("oxd-button"));
		 
		usernamefield.sendKeys(StoreData.uname); // Keeping Test Data in separate File
		passwordfield.sendKeys(StoreData.pass); //Keeping the test data in separate file
		loginbtn.click();
		 
		Thread.sleep(5000);
		
		driver.close();
	}
}
