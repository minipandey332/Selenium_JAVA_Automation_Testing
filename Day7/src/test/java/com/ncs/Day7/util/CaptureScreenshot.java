package com.ncs.Day7.util;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static void takeScreenshot(WebDriver driver) throws IOException
	{
		String filepath= System.getProperty("user.dir")+"/screenshots/"+"MyScreenshot.png";
		TakesScreenshot takess=((TakesScreenshot)driver);
		File sourcefile=takess.getScreenshotAs(OutputType.FILE);
		File destfile= new File(filepath);
		FileUtils.copyFile(sourcefile, destfile);
	}
 

}
