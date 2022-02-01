package First.a;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Landingpage {
public WebDriver driver;
	By username = By.id("email");
	By password =By.id("pass");
	By submit =By.cssSelector("button[type='submit']");
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement username()
	{
		return driver.findElement(username);
		
	}
	public WebElement password()
	{
		
		return driver.findElement(password);
	}
	public WebElement submit()
	{
		
		return driver.findElement(submit);
	}
	}
