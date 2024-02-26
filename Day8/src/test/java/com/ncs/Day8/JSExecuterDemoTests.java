package com.ncs.Day8;
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

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

import org.junit.Test;

public class JSExecuterDemoTests {
	WebDriver driver;
	
	@Before

	public void beforeClass() throws InterruptedException {

		System.out.println("inside before class");
// Create option Object
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://google.com");

		Thread.sleep(2000);

	}
@Test
public void Javascript_Execution_Test() throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	js.executeScript("document.getElementById('APjFqb').value='Selenium'");
	Thread.sleep(3000);
	//Reload th page
	js.executeScript("location.reload()");
	System.out.println("Google Page Reload");
	Thread.sleep(3000);
	js.executeScript("document.getElementById('APjFqb').value='NCS Pune'");
	js.executeScript("document.getElementsByName('btnK')[0].click()");
	//Submit button
	//js.executeAsyncScript("arguments[0].click()", driver.findElement(By.name("btnK)));
  
	Thread.sleep(3000);
	js.executeScript("window.scrollTo(0, 1500)");
	System.out.println("Search, Submit & Scrolled!");
	Thread.sleep(5000);

	
//	WebElement searchBtn = driver.findElements(By.name("RNmpXc")).get(1);
	
	/////// JAVASCRIPT Codes , can try on console
//	js.executeAsyncScript("arguments[0].click()", searchBtn);
	
	
//	js.executeScript("document.getElementsByName('username')[0].value='Admin'");
//	Thread.sleep(5000);
//
//	js.executeScript("document.getElementsByName('password')[0].value='admin123'");
//	Thread.sleep(5000);
//
//	js.executeScript("document.getElementsByClassName('oxd-button')[0].click()");
	
	//// In case of Xpath, we can use driver (selenium code), it will be easy.
	// Submit Button
//	//js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button")));
	
}

@After
public void destroy() {
	  //driver.close();
	System.out.println("Execution Done");
	  	driver.quit();
}
}
