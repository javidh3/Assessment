package loginAndLogout;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import genericlibrary.BaseClass;
import pomPage.RickyandmortyLoginPage;

public class TC3 extends BaseClass{
	
	@Test
	public void wrongusername() throws FileNotFoundException, IOException {
		 
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("incorrectusername"));
		rm.loginclick();
		Reporter.log("Entering a wrong email : "+driver.findElement(By.xpath("//p[text()='User not found']")).getText(),true);
		String expectedtext="User not found";
		String ele=driver.findElement(By.xpath("//p[text()='User not found']")).getText();
		Assert.assertEquals(ele,expectedtext);
		}
	

}
