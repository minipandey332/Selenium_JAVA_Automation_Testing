package com.ncs.Day9Part2;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class DemoReportsTest extends BaseClass {

	@BeforeTest
	 
	public void init() {
	 
	ReportGenerator.reportCreation();
	 
	}
	 
	@Test
	 
	public void demolTest() {
	 
	assert(false);
	}
	 
	@Test 
	public void demo2Test() {
	 
	assert(true);
	}
	 
	@Test 
	public void demo3Test() {
	 
	assert(true);
	}
	
	@AfterMethod
	public void posttest(ITestResult itr) {
		ReportGenerator.finishReportAfterTest(itr);
	}
	
	@AfterTest
	public void end() {
		extent.flush();
	}
}
