package com.ncs.Day9Part2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
@Listeners(TestListeners.class)
public class DemoReportsTest2 {
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
	//	extent.flush();
	}
}
