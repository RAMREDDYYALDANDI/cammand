package resources;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent= extentreports.extentreporte();
  private static   ThreadLocal<ExtentTest> report= new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		 test= extent.createTest(result.getMethod().getMethodName());
		 report.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.get().log(Status.PASS, "test run sucess fully 123");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		report.get().fail(result.getThrowable());
		WebDriver driver = null;
	String testmethodname=	result.getMethod().getMethodName();
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e)
	{
		
	}
	try {
		screenshot(testmethodname,driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
