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

public class TC2 extends BaseClass {
	@Test
	public void GenderSelectionPreservedonSearching() throws FileNotFoundException, IOException, InterruptedException {
		
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();
		
		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		utilies.searchbox(driver,rmm.getSearchtextbox(),"Morty");
		Thread.sleep(2000);
	
	
		List<WebElement> ele =driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));
		
		for(int i=0; i<ele.size();) {
			String text=ele.get(0).getText();
			Reporter.log(text,true);
			Assert.assertTrue(text.contains("Morty Smith"));
			
			String text1=ele.get(1).getText();
			Reporter.log(text1,true);
			Assert.assertTrue(text1.contains("Alien Morty"));
			
			String text2=ele.get(2).getText();
			Reporter.log(text2,true);
			Assert.assertTrue(text2.contains("Antenna Morty"));
			
			String text3=ele.get(3).getText();
			Reporter.log(text3,true);
			Assert.assertTrue(text3.contains("Aqua Morty"));
			break;
		}
			
		
		List<WebElement> Pages = driver.findElements(By.xpath("//ul[@class='Pagination_pagination-container__hAc3K']/li[@id]"));
        int pagesCount = Pages.size();
        System.out.println("Total Number of pages present : " + pagesCount);
        Assert.assertEquals(5, pagesCount);
				
		
		Reporter.log("***************AFTER SELECTING FEMALE CHARACTER*****************",true);
		driver.findElement(By.xpath("//button[@class='bp4-button']")).click();
		driver.findElement(By.xpath("//div[text()='Female Characters']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> ele1 =driver.findElements(By.xpath("//li[@class='CharacterItem_character-item__p-nts']"));
		
		for(int j=0; j<ele1.size();) {
			String femaletext=ele1.get(0).getText();
			Reporter.log(femaletext,true);
			Assert.assertTrue(femaletext.contains("Morty’s Disguise"));
			
			String femaletext1=ele1.get(1).getText();
			Reporter.log(femaletext1,true);
			Assert.assertTrue(femaletext1.contains("Morty’s Mother-in-law"));
			
			String femaletext2=ele1.get(2).getText();
			Reporter.log(femaletext2,true);
			Assert.assertTrue(femaletext2.contains("Morty’s Girlfriend"));
			break;
			

		}
		int pagination = driver.findElements(By.xpath("//ul[@class='Pagination_pagination-container__hAc3K']"))
				.size();
		if (pagination > 0) {
			Reporter.log("Pagination is not hidden",true);
		} else
			Reporter.log("Pagination is hidden",true);
		}
}
		
		

	

