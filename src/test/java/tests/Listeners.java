package tests;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import utilities.TestUtil;
import com.qa.Rediff.Reports.ExtentReporterSetup;

public class Listeners extends ExtentReporterSetup implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		
		extentTest= extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, "Test Passed is ::: "+result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(TestUtil.getScreenShot(driver,result.getMethod().getMethodName()));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test Case Failed is ::: "+result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getThrowable());
		
		try {
			extentTest.addScreenCaptureFromPath(TestUtil.getScreenShot(driver,result.getMethod().getMethodName()));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Case Skipped is ::: "+result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		extent = ExtentReporterSetup.extentReportSetup();
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
