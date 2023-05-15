package homePageBehavior;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.Rickandmortymainpage;
import pomPage.RickyandmortyLoginPage;

public class TC5 extends BaseClass {
	@Test
	public void noResultcase() throws FileNotFoundException, IOException {
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();

		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		utilies.searchbox(driver, rmm.getSearchtextbox(), "asdf");

		WebElement ele = driver.findElement(By.xpath("//p[text()='Characters Not Found']"));
		String text = ele.getText();
		String exptext = "Characters Not Found";
		Reporter.log("Popup message:"+text,true);
		Assert.assertEquals(exptext, text);
		
	}

}
