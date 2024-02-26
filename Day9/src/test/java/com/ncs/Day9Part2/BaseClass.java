package com.ncs.Day9Part2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	// to create report
	static ExtentReports extent;
	 
	// publish / build the report 
	static ExtentSparkReporter spark;
	 
	// to add logs / messages 
	static ExtentTest extenttest;
}
