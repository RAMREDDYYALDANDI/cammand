package First.a;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



import resources.Base;
public class homepage extends Base{

	@Test
	public void stay() throws IOException
	{
	
		
	driver=	initilizer();
	driver.get(pop.getProperty("url"));
   Landingpage ll=new Landingpage(driver);
   ll.username().sendKeys("ramyaldandi@gmail.com");
ll.password().sendKeys("789");
ll.submit().click();
	}
	
	@AfterTest
	public void throwa()
	{
		driver.close();
	}
	
	
}
