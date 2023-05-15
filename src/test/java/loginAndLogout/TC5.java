package loginAndLogout;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.Rickandmortymainpage;
import pomPage.RickyandmortyLoginPage;

public class TC5 extends BaseClass {
	
	@Test
	public void logoutrefresh() throws FileNotFoundException, IOException, InterruptedException {
		
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		rm.EnterUserName(pfd.getData("username2"));
		rm.EnterPassword(pfd.getData("password2"));
		rm.loginclick();
		
		Thread.sleep(3000);
		
		rmm.logoutclick();
		driver.navigate().refresh();
		String url=driver.getCurrentUrl();
		String expurl= "https://ricky-morty-fan-page.vercel.app/login";
		Reporter.log("After LOGOUT: the user is asked to enter the email and password again on page refresh",true);
		Assert.assertEquals(url,expurl);
		
		
	}
	
	
	
	

}
