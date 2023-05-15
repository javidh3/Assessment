package loginAndLogout;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.RickyandmortyLoginPage;

public class TC4 extends BaseClass{
	
	@Test
	public void successfulLoginRefresh() throws FileNotFoundException, IOException, InterruptedException {
		
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String url=driver.getCurrentUrl();
		String expurl= "https://ricky-morty-fan-page.vercel.app/home";
		Reporter.log("After LOGIN : the user is not asked to enter the email and password again on page refresh",true);
		Assert.assertEquals(url,expurl);
		
		}

}
