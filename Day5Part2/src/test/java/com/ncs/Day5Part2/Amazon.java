package com.ncs.Day5Part2;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
//import org.junit.Rule;
import org.junit.Test;
//import org.junit.rules.TestWatcher;
//import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Amazon {

    WebDriver driver;

    @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");
    }

    @Test
    public void AmazonSearchTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung");
        WebElement dropdownelement = driver.findElement(By.id("searchDropdownBox"));
        Select categories = new Select(dropdownelement);
        categories.selectByVisibleText("Electronics");
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void AmazonSearchFailedTest() {
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung");
        WebElement dropdownelement = driver.findElement(By.id("searchDropdownBox"));
        Select categories = new Select(dropdownelement);
        categories.selectByVisibleText("Mobiles");
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        assertTrue(false); // Intentionally failing the test for demonstration
    }

    @Test
    public void getAlloptionsTest() {
    	System.out.println("List of displayed Items :  ");
    	System.out.println();
        WebElement dropdownelement = driver.findElement(By.id("searchDropdownBox"));
        Select categories = new Select(dropdownelement);
        List<WebElement> catylist = categories.getOptions();

        for (WebElement category : catylist) {
            System.out.println("Category Value - " + category.getAttribute("value"));
            System.out.println("Category Name " + category.getText());
        }
        assertTrue(true);
    }
    
    // Method to take screenshot of failed test in Junit.

//    @Rule
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description) {
//        	
//        	System.out.println("failed test !!");
//            // Capture screenshot on test failure
//            TakesScreenshot ts = ((TakesScreenshot) driver);
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            String filepath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
//            File destination = new File(filepath);
//            try {
//            	System.out.println("under TRY block!!");
//                FileUtils.copyFile(source, destination);
//                System.out.println("Test method : " + description.getMethodName() + " execution is unsuccessful");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//    };

    @AfterMethod
    public void aftereverymethod(ITestResult itr) throws IOException {
    	System.out.println("Inside screenshot method");
    	if (itr.isSuccess()) {
    		System.out.println("If condition RUN !");
    		System.out.println("Test method : " + itr.getMethod().getMethodName() + " execution is successful");
    	}

    	else {
    		System.out.println("Else condition RUN !");
    		// Capture screenshot
    		TakesScreenshot ts = ((TakesScreenshot) driver);
    		File source = ts.getScreenshotAs(OutputType.FILE);
    		String filepath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
    		File destination = new File(filepath);
    		FileUtils.copyFile(source, destination);

    		System.out.println("Test method : " + itr.getMethod().getMethodName() + " execution is unsuccessful");
    	}
    }
    
    @After
    public void destroy() {
        // Close the browser
        driver.close();
    }
    
}
