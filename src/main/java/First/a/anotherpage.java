package First.a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class anotherpage {
	public WebDriver driver;
	
	By signin= By.xpath("//a[contains(text(),'Sign in')]");
	
	public anotherpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement signin()
	{
		return driver.findElement(signin);
	}

}
