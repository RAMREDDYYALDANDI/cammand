package resources;

import java.io.File;

import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	public WebDriver driver;
	public Properties pop;

	public WebDriver initilizer() throws IOException {

		pop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\ramya\\eclipse-workspace\\a\\src\\main\\java\\resources\\browser.properties");
		pop.load(file);
		String broname = pop.getProperty("browser");
		System.out.println(broname);

		if (broname.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ramya\\Downloads\\chromedriver97ver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		} else if (broname.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\ramya\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	}

	public void screenshot(String Testcasename,WebDriver driver	) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
	String destinationpath=	System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
	FileUtils.copyFile(source,new File(destinationpath));
	

	}

}
