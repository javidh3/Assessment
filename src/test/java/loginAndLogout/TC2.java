package loginAndLogout;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.RickyandmortyLoginPage;

public class TC2 extends BaseClass {
	
	@Test
	public void wrongpassAndCorrectemail() throws FileNotFoundException, IOException {
		RickyandmortyLoginPage ram = new RickyandmortyLoginPage(driver);
		ram.EnterUserName(pfd.getData("username"));
		ram.EnterPassword(pfd.getData("incorrectpassword"));
		ram.loginclick();
		WebElement ele =driver.findElement(By.xpath("//p[text()='Wrong password']"));
		Reporter.log(ele.getText()+" : successfully got message for correct email and incorrect password",true);
		
		String expectedText = "Wrong password";
		String Actualtext = ele.getText();
		Assert.assertEquals(Actualtext, expectedText);
		
		
		
	}

}
