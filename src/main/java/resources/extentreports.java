package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreports {

	public static ExtentReports extentreporte()
	{
	String path=	System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter spark= new ExtentSparkReporter(path);
		spark.config().setReportName("WEB ELEMENTS");
		spark.config().setDocumentTitle("ADAVHJNKM,");
		
		ExtentReports reports= new  ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Y RAM REDDY", "documents");
		return reports;
	}
	
	
	
	
}
