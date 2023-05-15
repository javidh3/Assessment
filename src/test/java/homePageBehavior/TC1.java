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

public class TC1 extends BaseClass {

	@Test
	public void YieldingCorrectResults() throws FileNotFoundException, IOException, InterruptedException {
		RickyandmortyLoginPage rm = new RickyandmortyLoginPage(driver);
		rm.EnterUserName(pfd.getData("username"));
		rm.EnterPassword(pfd.getData("password"));
		rm.loginclick();

		Rickandmortymainpage rmm = new Rickandmortymainpage(driver);
		utilies.searchbox(driver, rmm.getSearchtextbox(), "Jerry Smith");
		List<WebElement> ele = driver.findElements(By.xpath("//li[@data-character-name='Jerry Smith']"));

		for (int i = 0; i < ele.size(); i++) {
			Reporter.log(ele.get(i).getText(),true);
			String text = ele.get(0).getText();
			String text1 = ele.get(1).getText();
			String text2 = ele.get(2).getText();
			Assert.assertTrue(text.contains("Jerry Smith"));
			Assert.assertTrue(text1.contains("Jerry Smith"));
			Assert.assertTrue(text2.contains("Jerry Smith"));

			}
		int pagination = driver.findElements(By.xpath("//ul[@class='Pagination_pagination-container__hAc3K']"))
				.size();
		if (pagination > 0) {
			Reporter.log("Pagination is present",true);
		} else
			Reporter.log("Pagination is not present",true);

	}
}

