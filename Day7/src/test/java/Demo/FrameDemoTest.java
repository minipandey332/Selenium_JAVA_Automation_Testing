package Demo;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.IOException;
import java.time.Duration;
 
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ncs.Day7.util.CaptureScreenshot;

public class FrameDemoTest {

	WebDriver driver;
	 @Test 
		public void Signup() throws InterruptedException {
			driver.manage().window().fullscreen();
			driver.findElement(By.xpath("//div[@class='_1YPz_']/child::span")).click();
			
			Thread.sleep(3000);
	
//			We can also use, driver.findElement(By.xpath("//a[@class='_2jZ45']/img")).click();
			driver.findElement(By.xpath("//a[@title='Close']")).click();

			Thread.sleep(3000);
}
		@Before
		public void init() throws InterruptedException {
			System.out.println("Inside Before Class");
			// option Object created
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
	 
			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
			driver.navigate().to("https://paytm.com");
			driver.manage().window().maximize();
	 Thread.sleep(2000);
	 
		}
	 
	 
		@After
		// ITestResult itr didn't work here in Junit. We need to install TestNG from
		// Marketplace.
 
		public void destroy() throws IOException {
			// if(!(itr.isSucess()))
			// As we can't able to use interface of testng, In every cases it will take SS,
			// either in case of success or failer.

			System.out.println("Inside after class");
			CaptureScreenshot.takeScreenshot(driver);

			System.out.println("Screenshot Taken !! ");
			driver.close();
		}
}
