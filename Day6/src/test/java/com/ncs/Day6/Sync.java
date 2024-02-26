package com.ncs.Day6;

import org.junit.Test;

import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
 
//Implicit wait ------- Set time delay without condition, it will wait till element is found.
//If element not found then "Nosuchelementpresent" exception thrown


//Explicit wait ----------- Set time delay with condition, Timeout exception will be thrown             
             
//Fluent wait -------------  Enhanced explicit wait , & set the freq. polling
 
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
 
import io.github.bonigarcia.wdm.WebDriverManager;
//Run All
public class Sync {
	WebDriver driver;
 
	@Before
	public void init() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    option.addArguments("start-maximized");

		driver = new ChromeDriver(option);
		// Maximize screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com");
 
		Thread.sleep(3000);
	}
 
	@After
	public void destroy() {
		System.out.println("Inside after class");
		driver.close();
	}
	@Test
	//Run | Debug
	public void explicitwaitTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//input")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/span/i")));
		
		driver.findElement(By.xpath("//ul/li/span/i")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/auth/logout']")));
		driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();

		Thread.sleep(3000);
		WebElement we1=driver.findElement(By.xpath("//ul[@data-v-f0c5131f]"));
		System.out.println( we1.isDisplayed());
		
		WebElement we2=we1.findElement(By.xpath("//li[@data-v-429cfcf3]"));
		System.out.println( we2.isDisplayed());
		List<WebElement> we3=(List<WebElement>) we2.findElement(By.cssSelector("span ul > li"));
		System.out.println(we3.size());
		for(WebElement we0:we3)
		{
			System.out.println(we0.getTagName());
		}
 
	}
}