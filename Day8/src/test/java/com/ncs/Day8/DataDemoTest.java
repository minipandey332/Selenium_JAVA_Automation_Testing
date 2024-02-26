package com.ncs.Day8;

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

//Test File 
//- Test Steps 
//    - Web Element
//    - Actions
//    
//Test Data    
//Page Object

public class DataDemoTest {

	WebDriver driver;

	private static final By USERNAMEFIELD = By.name("username");
	private static final By PASSWORDFIELD = By.name("password");
	private static final By LOGINBTN = By.xpath("//button");
	private static final int IMPWAIT = 10; // Implicit Wait

//'Properties' is a class, it is sub-class of hash table, it stores key-value pair.
	Properties prop;

//prop object taken all properties from the data folder.
	FileInputStream fis;

//We have to read the file (config.properties) &get the data of it.

//	 @BeforeSuite
//	 public void init() throws IOException {
//  
//user.dir = Root level of project
//	 String configfilepath = System.getProperty("user.dir")+"/data/config.properties";
//	  
//	 fis = new FileInputStream(configfilepath);
//	  

//	 prop = new Properties();
//	  
//	 prop.load(fis);
//	  
//	 }
//
//	  @BeforeClass
//	  public void beforeClass() {
//	    	
//	    if(prop.getProperty("browser").equalsIgnoreCase("chrome")){ 
//	    	WebDriverManager.chromedriver().setup(); 
//	    	driver = new ChromeDriver();
//	    }
//	    else {
//	    	 
//	    	WebDriverManager.edgedriver().setup();
//	    	 
//	    	driver = new EdgeDriver();
//	    	 
//	    	}
//	    	 
//	    	driver.get(prop.getProperty("app_url")); // app-url taken from the data folder via prop object
//	    	 
//	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPWAIT)); 
//	    	driver.manage().window().maximize();
//	    }

	@Before
	public void setUp() throws IOException {

		//user.dir is Root level of project
		String configFilePath = System.getProperty("user.dir") + "/data/config.properties";
		FileInputStream fis = new FileInputStream(configFilePath);
		//prop object created from property class, in-built class, key-value pair
		prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		System.out.println(prop.getProperty("app-url"));

		// Navigate to the application URL
		driver.get(prop.getProperty("app-url"));
		
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPWAIT)); // Implicit wait
		driver.manage().window().maximize();
	}

	// @Parameters(value={"username","password"})
	// set the parameters in testng.xml file & use here..

	@Test
	public void loginTest() {

		//testng.xml use
//		driver.findElement(USERNAMEFIELD).sendKeys("username");
//		driver.findElement(PASSWORDFIELD).sendKeys("password"); only if we are following testng.xml

		driver.findElement(USERNAMEFIELD).sendKeys(prop.getProperty("username"));
		driver.findElement(PASSWORDFIELD).sendKeys(prop.getProperty("password"));
		driver.findElement(LOGINBTN).click();

		System.out.println("Logged In Successfull using Data.config");
		assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@After
	public void destroy() {
//driver.close();
		driver.quit();
	}

}
