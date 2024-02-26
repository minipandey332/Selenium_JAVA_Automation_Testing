package com.ncs.Day8;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDemoTest2 {
	WebDriver driver;

	private static final By USERNAMEFIELD = By.name("username");
	private static final By PASSWORDFIELD = By.name("password");
	private static final By LOGINBTN = By.xpath("//button");
	private static final int IMPWAIT = 10; 
//'Properties' is a class, it is sub-class of hash table, it stores key-value pair.
	Properties prop;

//prop object taken all properties from the data folder.
	FileInputStream fis;

	 @BeforeSuite
	 public void init() throws IOException {
  
	 String configfilepath = System.getProperty("user.dir")+"/data/config.properties";
	  
	 fis = new FileInputStream(configfilepath);
	  
	 prop = new Properties();
	  
	 prop.load(fis);
	  
	 }

	  @BeforeClass
	  public void beforeClass() {
	    	
	    if(prop.getProperty("browser").equalsIgnoreCase("chrome")){ 
	    	WebDriverManager.chromedriver().setup(); 
	    	driver = new ChromeDriver();
	    }
	    else {
	    	 
	    	WebDriverManager.edgedriver().setup();
	    	 
	    	driver = new EdgeDriver();
	    	 
	    	}
	    	 
	    	driver.get(prop.getProperty("app_url")); // app-url taken from the data folder via prop object
	    	 
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPWAIT)); 
	    	driver.manage().window().maximize();
	    }
	  
	  @After
		public void destroy() {
	//driver.close();
			driver.quit();
		}

}
