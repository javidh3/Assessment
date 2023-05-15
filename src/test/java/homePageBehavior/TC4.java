package homePageBehavior;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPage.Rickandmortymainpage;
import pomPage.RickyandmortyLoginPage;

public class TC4 extends BaseClass {
	@Test
	public void ResetFilter() throws FileNotFoundException, IOException, InterruptedException {
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();

		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		List<WebElement> ele=driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));
		Reporter.log("***************Default first four character************",true);
		for (int i = 0; i < ele.size();) {
			String defaultText=ele.get(0).getText();
			Reporter.log(defaultText,true);
           Assert.assertTrue(defaultText.contains("Rick Sanchez"));
			
			String defaultText1=ele.get(1).getText();
			Reporter.log(defaultText1,true);
			Assert.assertTrue(defaultText1.contains("Morty Smith"));
			
			String defaultText2=ele.get(2).getText();
			Reporter.log(defaultText2,true);
			Assert.assertTrue(defaultText2.contains("Summer Smith"));
			
			String defaultText3=ele.get(3).getText();
			Reporter.log(defaultText3,true);
			Assert.assertTrue(defaultText3.contains("Beth Smith"));
			break;
		}
			
		utilies.searchbox(driver, rmm.getSearchtextbox(), "Beth");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Unknown']")).click();
		Thread.sleep(2000);
		List<WebElement> ele1=driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));
		Reporter.log("***************After selecting Beth and unknown**********************",true);
		for (int j = 0; j < ele1.size();) {
			
			
			String Bethtext=ele1.get(0).getText();
			Reporter.log(Bethtext,true);
			Assert.assertTrue(Bethtext.contains("Goddess Beth"));
			
			String Bethtext1=ele1.get(1).getText();
			Reporter.log(Bethtext1,true);
			Assert.assertTrue(Bethtext1.contains("Young Beth"));
			
			String Bethtext2=ele1.get(2).getText();
			Reporter.log(Bethtext2,true);
			Assert.assertTrue(Bethtext2.contains("Young Beth"));
			break;
			
		}
			
		driver.findElement(By.xpath("//span[text()='Reset Filter']")).click();
		Thread.sleep(2000);
		List<WebElement> ele2=driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));
		Reporter.log("***************Default first four character after Reset************",true);
		for (int k = 0; k < ele2.size();) {
			
			String defaultTextReset=ele2.get(0).getText();
			Reporter.log(defaultTextReset,true);
           Assert.assertTrue(defaultTextReset.contains("Rick Sanchez"));
			
			String defaultTextReset1=ele2.get(1).getText();
			Reporter.log(defaultTextReset1,true);
			Assert.assertTrue(defaultTextReset1.contains("Morty Smith"));
			
			String defaultTextReset2=ele2.get(2).getText();
			Reporter.log(defaultTextReset2,true);
			Assert.assertTrue(defaultTextReset2.contains("Summer Smith"));
			
			String defaultTextReset3=ele2.get(3).getText();
			Reporter.log(defaultTextReset3,true);
			Assert.assertTrue(defaultTextReset3.contains("Beth Smith"));
			break;
		}
			
		
	}
		

}

		
