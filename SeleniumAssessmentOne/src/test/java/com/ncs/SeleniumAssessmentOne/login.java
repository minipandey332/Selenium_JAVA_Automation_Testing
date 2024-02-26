package com.ncs.SeleniumAssessmentOne;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	@Test
	public void init() {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("--remote-allow-origins=*"); 
		options.addArguments("start-maximized");
		
		// Browser set to headless
		 
		options.addArguments("--headless");
		
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		 
		// Implicit wait
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
