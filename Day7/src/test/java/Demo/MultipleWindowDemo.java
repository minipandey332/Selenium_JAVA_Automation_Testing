package Demo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.ncs.Day7.util.CaptureScreenshot;

import org.junit.Test;

public class MultipleWindowDemo {
	WebDriver driver;

	/////////////////////////////////// Test - 1 /////////////////////////////////// /////

	@Test
	public void testKeyboardActions() throws InterruptedException {
		WebElement searchfield = driver.findElement(By.id("APjFqb"));

		Actions action = new Actions(driver);
		action.moveToElement(searchfield).click().keyDown(Keys.SHIFT).sendKeys("Selenium").keyUp(Keys.SHIFT)
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("c")
				.keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL)
				.sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		Thread.sleep(5000);

	}

	////////////////////////////// Test - 2 ////////////////////////////// ////////////////////
//		@Test
//		public void testmouseActions() throws InterruptedException {
//			driver.switchTo().frame(0);
//			
//			WebElement draggable= driver.findElement(By.id("draggable"));
//			WebElement droppable= driver.findElement(By.id("droppable"));
//			
//			Actions action= new Actions(driver);
//		//	action.dragAndDrop(draggable, droppable).perform();
//			
//			Thread.sleep(2000);
//			
//			action.moveToElement(draggable)
//		          .clickAndHold()
//		          .moveToElement(droppable)
//		          .release()
//		          .clickAndHold()
//		          .moveByOffset(30, 20)
//		          .release()
//		          .build()
//		          .perform();
//			
//			Thread.sleep(4000);
//			
//		}

	@Before
	public void init() throws InterruptedException {
		System.out.println("Inside Before Class...");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// test 1, navigate here
		driver.navigate().to("https://google.com");

		// test 2, navigate here
//			driver.get("https://jqueryui.com/droppable/");
//			driver.manage().window().maximize();

		Thread.sleep(4000);

	}

	@After
	public void destroy() throws IOException {
		// if(!(itr.isSucess()))
		// As we can't able to use interface of testng, In every cases it will take SS,
		// either in case of success or failer.

		System.out.println("Inside After Class...");
		CaptureScreenshot.takeScreenshot(driver);

		System.out.println("Screenshot Taken !! ");
		driver.quit();
	}

}
