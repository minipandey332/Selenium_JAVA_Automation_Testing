import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;

import com.ncs.Day7.util.CaptureScreenshot;

public class FileUploadDemo {
	WebDriver driver;

	@Test
	public void file_Upload_Demo_Test() throws InterruptedException, AWTException {

//		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\p1357950\\Desktop\\Folder\\file.txt");
//		driver.findElement(By.id("file-submit")).click();

		// driver.findElement(By.id("file-upload")).click();

		new Actions(driver).moveToElement(driver.findElement(By.id("file-upload"))).click().build().perform();
		Thread.sleep(3000);

		StringSelection stringselection = new StringSelection("C:\\Users\\p1357950\\Downloads\\mini.txt");
		Clipboard cboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		cboard.setContents(stringselection, null);

		Thread.sleep(3000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(6000);

	}

	@Before
	public void init() throws InterruptedException {
		System.out.println("Inside Before Class");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@After
	public void destroy() throws IOException {
		// if(!(itr.isSucess()))
		// As we can't able to use interface of testng, In every cases it will take SS,
		// either in case of success or failer.

		System.out.println("Inside After Class");
		CaptureScreenshot.takeScreenshot(driver);

		System.out.println("Screenshot Taken !! ");
		driver.quit();
		// driver.close();
	}

}
