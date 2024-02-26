package com.ncs.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
//Import Edge driver
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

public class EdgeLoginTest {

	@Test
	public void EdgeTest() throws InterruptedException {
	 
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("start-maximized"); // Maximize the screen size
		WebDriver driver = new EdgeDriver(options); // Open Edge Browser
		
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
