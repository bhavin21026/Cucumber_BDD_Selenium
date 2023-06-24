package shaip_utilitiescomponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import shaip_base.DriverFactoryShaip;
import shaip_base.ExtentFactoryShaip;
import shaip_base.ExtentReportngShaip;



public class ListenersImplementation implements ITestListener{
	//JiraOperations jiraOps = new JiraOperations();
	static ExtentReports report;
		   ExtentTest test;
		   
	public void onTestStart(ITestResult result) {
		//before each test case
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactoryShaip.getInstance().setExtent(test);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("In listenr pass");
		ExtentFactoryShaip.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		ExtentFactoryShaip.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {
		ExtentFactoryShaip.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		ExtentFactoryShaip.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test.
		File src = ((TakesScreenshot)DriverFactoryShaip.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String testcaseName=result.getMethod().getMethodName();
		String screenshotPath = System.getProperty("user.dir")+
				"\\Shaip_Resources\\Screenshots\\"+testcaseName+".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentFactoryShaip.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
		ExtentFactoryShaip.getInstance().removeExtentObject();

	}

	public void onTestSkipped(ITestResult result) {
		ExtentFactoryShaip.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
		ExtentFactoryShaip.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		try {
			 report = ExtentReportngShaip.setupExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		//close extent
		report.flush();
	}

}
