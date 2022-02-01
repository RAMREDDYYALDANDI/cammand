package resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;

	public WebDriver initilizer() throws IOException {
		Properties pop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\ramya\\eclipse-workspace\\side\\src\\main\\java\\resources\\data.properties");
		pop.load(file);
		String browser = pop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ramya\\Downloads\\chromedriver97ver\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			
			option.addArguments("headless");
		
			driver = new ChromeDriver(option);

		}
		return driver;

	}

	public void screenshot(String Testcasename, WebDriver driver) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir") + "\\reports\\" + Testcasename + ".png";
		FileUtils.copyFile(source, new File(destinationpath));

	}
}
