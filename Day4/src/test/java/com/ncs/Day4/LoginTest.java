package com.ncs.Day4;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
import io.github.bonigarcia.wdm.WebDriverManager;

//Steps for code :
//First, Launch the browser
// Navigate to app url
// Enter username
// enter pwd
// click on login btn
// check if home page is displayed
// close the browser

public class LoginTest{

	@Test
	public void Login() throws InterruptedException {
	
	//	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options); // Open Chrome 
		Thread.sleep(3000);
		 
		// WebDriver interface provides specification for browser actions driver obj.
		 
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(3000);
		 
		String uname = "Admin"; 
		String pass = "admin123";
		 
		WebElement usernamefield = driver.findElement(By.name("username")); 
		WebElement passwordfield = driver.findElement(By.name("password"));
		 
		WebElement loginbtn= driver.findElement(By.className("oxd-button"));
		 
		usernamefield.sendKeys(uname); 
		passwordfield.sendKeys(pass); 
		loginbtn.click();
		 
		Thread.sleep(3000);
		
		driver.close();

		}
	
	
}
