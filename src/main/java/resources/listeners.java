package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports	extent= Extentreports.reports();
	private static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	extenttest.get().log(Status.PASS, "Sucessfull");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
	extenttest.get().fail(result.getThrowable());
	String testmethodname=  result.getMethod().getMethodName();
	
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
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
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
