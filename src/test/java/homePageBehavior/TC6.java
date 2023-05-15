package homePageBehavior;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;

import pomPage.RickyandmortyLoginPage;

public class TC6 extends BaseClass {
	@Test
	public void characterDisplayScreen() throws FileNotFoundException, IOException, InterruptedException {
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();
		
		
		WebElement ele =driver.findElement(By.xpath("(//div[@class='CharacterItem_character-item__avatar__k5ewX'])[1]"));
		WebElement ele1 =driver.findElement(By.xpath("(//div[@class='CharacterItem_character-item__avatar__k5ewX'])[1]//img"));
		Reporter.log("Img:"+ele1.getAttribute("src"),true);
		String img1 = ele1.getAttribute("src");
		WebElement ele2 =driver.findElement(By.xpath("(//li[@class='CharacterItem_character-item__p-nts'])[1]"));
		Reporter.log(ele2.getText(),true);
		ele.click();
		
		Reporter.log("**************************************************",true);
		Thread.sleep(2000);
		WebElement ele4 =driver.findElement(By.xpath("(//div[@class='Character_character-addon-detail__X8fab'])//img"));
		Reporter.log("Img:"+ele4.getAttribute("src"),true);
		String img2 = ele4.getAttribute("src");
		WebElement ele5 =driver.findElement(By.xpath("(//div[@class='Character_character-basic-detail__8Up6a'])"));
		Reporter.log(ele5.getText(),true);
		
		Reporter.log("Img are equal:"+img1.equals(img2),true);
		Assert.assertEquals(img1,img2);
		
		
		}

}
