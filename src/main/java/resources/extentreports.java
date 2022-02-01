package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	public static ExtentReports report;

	public static ExtentReports reports()
	{
		
	String rip=	System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter extent= new ExtentSparkReporter(rip);
	extent.config().setReportName("web automation results");
	extent.config().setDocumentTitle("TEST RESULTS");
	
	report= new ExtentReports();
	report.attachReporter(extent);
	report.setSystemInfo("Ram Reddy", " PRACTICE");
	
	return report;
	
	}
}
