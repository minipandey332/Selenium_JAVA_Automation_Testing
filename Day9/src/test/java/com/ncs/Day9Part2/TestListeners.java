package com.ncs.Day9Part2;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
	 
	@Override
	 
	public void onTestSkipped(ITestResult result) {
	 
	ReportGenerator.finishReportAfterTest(result);
	}

}