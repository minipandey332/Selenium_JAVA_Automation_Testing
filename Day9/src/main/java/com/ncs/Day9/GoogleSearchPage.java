package com.ncs.Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	WebDriver driver;
	
	// Work as AND operator
//	@FindBys({
//	
//	@FindBy(className = "RNmpXc"),
//	 
//	@FindBy(xpath="//center/input[2][@value=\"I'm Feeling Lucky\"")
//	 
//	})

	 
	// Work as OR Operator

//	@FindAll({
//
//	@FindBy(),
//	 
//	@FindBy()
//	 
//	})
//	 
	
	 
	//WebElement searchbtn;
	
//	@FindBy(xpath="//center/input[2]")
	 
//	WebElement feelingluckybtn;
	 
	public GoogleSearchPage(WebDriver driver) {
	 
	this.driver = driver;
	PageFactory.initElements(driver, this);
	 
	}
	 
	
	 
	public GoogleDoodlesPage clickFeelingLuckybtn() {
	 
	//feelingluckybtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()",driver.findElement(By.name("btnI")));
	
	return new GoogleDoodlesPage(driver);
	
}
}
