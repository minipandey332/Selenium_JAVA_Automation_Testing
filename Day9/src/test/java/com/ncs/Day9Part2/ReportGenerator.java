package com.ncs.Day9Part2;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGenerator extends BaseClass {
	
	public static void reportCreation() {
		 
		// to create report 
		extent = new ExtentReports();
		 
		//publish/ build the report 
		spark = new ExtentSparkReporter("reports/testreports.html");
		 
		// attaching reporter 
		extent.attachReporter(spark);
		 
		}
		 
		public static void finishReportAfterTest(ITestResult itr) {
		 
		// object to add logs /messages
		 
		extenttest = extent.createTest("Test Reports");
		 
		if(itr.getStatus() == ITestResult.SUCCESS) {
		 
		extenttest.log(Status.INFO, ("Test "+ itr.getName() + "execution successful"));
		 
		}
		
		else if(itr.getStatus() == ITestResult. FAILURE) {
		 
		extenttest.log(Status.FAIL, ("Test" + itr.getName()+"execution failed"));
		 
		}
		else if(itr.getStatus() == ITestResult.SKIP) {
		 
		extenttest.log(Status.SKIP, ("Test "  + itr.getName()+"execution skipped"));
		}
    }
}
