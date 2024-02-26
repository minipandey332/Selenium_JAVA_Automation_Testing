package Demo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ncs.Day7.util.CaptureScreenshot;

import org.junit.Test;

public class KeyboardActionDemo {

	WebDriver driver;

	@Test
	public void testchildwindow() throws InterruptedException {
		String parentwindowid = "";
		String childwindowid = "";
		driver.findElement(By.partialLinkText("Orange")).click();

		Thread.sleep(3000);
		for (String handle : driver.getWindowHandles()) {
			System.out.println("Browser Handle ---------  " + handle);
		}

		Iterator itr = driver.getWindowHandles().iterator();
		parentwindowid = (String) itr.next();
		childwindowid = (String) itr.next();
		// print
		System.out.println(parentwindowid);
		System.out.println(childwindowid);

		driver.switchTo().window(childwindowid);
		Thread.sleep(3000);

		System.out.println(driver.getCurrentUrl()); // get current url
		driver.switchTo().window(parentwindowid);// here we can switch back to Parent Window
		Thread.sleep(3000);

		System.out.println(driver.getCurrentUrl());

		// driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://amazon.com");
		System.out.println(driver.getCurrentUrl());

	}

	@Before
	public void beforeClass() throws InterruptedException {
		System.out.println("Inside Before Class...");
		// option object created
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
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

		System.out.println("Inside after class...");
		CaptureScreenshot.takeScreenshot(driver);

		System.out.println("Screenshot Taken !! ");
		driver.close();
	}

}
