package loginAndLogout;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.Rickandmortymainpage;
import pomPage.RickyandmortyLoginPage;

public class TC1 extends BaseClass {
	
	
	@Test
	public void login() throws FileNotFoundException, IOException {
		
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();
		Reporter.log("Login is successfully with given username and password",true);
		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		String url=driver.getCurrentUrl();
		String expurl= "https://ricky-morty-fan-page.vercel.app/home";
		Assert.assertEquals(url,expurl);
		rmm.logoutclick();
		
		rm.EnterUserName(pfd.getData("username2"));
		rm.EnterPassword(pfd.getData("password2"));
		rm.loginclick();
		Reporter.log("Login is successfully with given username and password",true);
		String url1=driver.getCurrentUrl();
		String expurl1= "https://ricky-morty-fan-page.vercel.app/home";
		Assert.assertEquals(url1,expurl1);
		rmm.logoutclick();
		
		
		rm.EnterUserName(pfd.getData("incorrectusername"));
		rm.EnterPassword(pfd.getData("incorrectpassword"));
		rm.loginclick();
		Reporter.log("Login is unsuccessful with incorrect username and password : "+driver.findElement(By.xpath("//p[text()='User not found']")).getText(),true);
		String url2=driver.getCurrentUrl();
		String expurl2= "https://ricky-morty-fan-page.vercel.app/login";
		Assert.assertEquals(url2,expurl2);
		
		}
	}
