package genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtilies {
	
	public void searchbox(WebDriver driver,WebElement ele,String text) {
		Actions a = new Actions(driver);
		a.sendKeys(ele,text).build().perform();
		
		
	}

}
