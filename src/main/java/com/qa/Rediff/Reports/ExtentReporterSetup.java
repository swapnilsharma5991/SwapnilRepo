package com.qa.Rediff.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.Rediff.base.base;
import utilities.TestUtil;

public class ExtentReporterSetup extends base {
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;
	
	public static ExtentReports extentReportSetup()
	{
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+"/TestAutomationSuite/"+"/DWEBSExtentReport/"+TestUtil.getSystemDate()+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Web Automation Results");
		sparkReporter.config().setDocumentTitle("Test Results DWEBS");
		
		
		extent.setSystemInfo("Tester", "Rahul Shetty");
		return extent;
		
	}
}
