package com.ncs.Day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleDoodlesPage {
	WebDriver driver;
	 
	@FindBy(css="a#archive-link-link")
	 
	WebElement doodlesarchivelink;
	 
	public GoogleDoodlesPage(WebDriver driver) {
	 
	this.driver = driver;
	 
	PageFactory.initElements(driver, this);
	 
	}
	 
	public String ddleslinktext() 
	{ return doodlesarchivelink.getText();}
	
	public boolean isDisplayed() {
		return doodlesarchivelink.isDisplayed();
	}
}