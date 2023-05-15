package homePageBehavior;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.Rickandmortymainpage;
import pomPage.RickyandmortyLoginPage;

public class TC3 extends BaseClass {
	
	@Test
	public void livingStatus() throws FileNotFoundException, IOException, InterruptedException {

		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();

		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		utilies.searchbox(driver, rmm.getSearchtextbox(), "A Rick");
		Thread.sleep(3000);

		List<WebElement> ele = driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));

		for (int i = 0; i < ele.size(); i++) {

			Reporter.log(ele.get(i).getText(),true);
		}
		System.out.println("****************************************************");
		driver.findElement(By.xpath("//label[text()='Dead']")).click();
		Thread.sleep(2000);
		List<WebElement> ele1 = driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));

		for (int i = 0; i < ele1.size(); i++) {
			Reporter.log("Dead:" + ele1.get(i).getText(),true);
			String text = ele1.get(i).getText();
			
			Assert.assertTrue(text.contains("Zeta Alpha Rick"));
			Assert.assertTrue(text.contains("Dead"));

		}

	}

}
