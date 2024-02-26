package Demo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.ncs.Day7.util.CaptureScreenshot;

public class FluentWaitTest {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();

		// We can also use simply :
		// driver.findElement(By.className("oxd-userdropdown")).click();

		WebElement element = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(30L))

				.pollingEvery(Duration.ofMillis(5L))

				.ignoring(NoSuchElementException.class)

				.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-userdropdown")));

		element.click();

		assertTrue(true);
		Thread.sleep(4000);

		// fluent wait
//Thread.sleep(2000);
//try {
//	driver.findElement(By.className("oxd-userdropdown")).click();
//	}
//catch(Exception e) {
//	assertTrue(false);	}

//			Thread.sleep(2000);

	}

	@Before

	public void beforeClass() throws InterruptedException {

		System.out.println("inside before class");
// Create option Object
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");

		Thread.sleep(2000);

	}

	@After

	// ITestResult itr didn't work here in Junit. We need to install TestNG from
	// Marketplace.

	public void afterClass() throws IOException {

		// if(!(itr.isSucess()))
		// As we can't able to use interface of testng, In every cases it will take SS,
		// either in case of success or failer.

		System.out.println("Inside after class");

		CaptureScreenshot.takeScreenshot(driver);

		System.out.println("Screenshot Taken !! ");
		driver.close();

	}

}
