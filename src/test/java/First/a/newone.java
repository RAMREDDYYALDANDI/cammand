package First.a;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;

public class newone extends Base {
	
	@Test
	public void oncepractice() throws IOException
	{
		driver=initilizer();
		driver.get("https://www.rediff.com");
		anotherpage aa=new anotherpage(driver);
		aa.signin().click();
		
	}

	@AfterTest
	public void throwa()
	{
		driver.close();
	}
}
