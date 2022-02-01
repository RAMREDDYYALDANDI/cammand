package right.side;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.Base;

public class Homepage extends Base {

	@Test
	public void basepagenavigation() throws IOException
	{
	driver=	initilizer();
	driver.get("https://www.facebook.com");
	}
}
