package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rickandmortymainpage {
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutbtn;
	
	@FindBy(id="search-characters")
	private WebElement searchtextbox;
	
	public Rickandmortymainpage(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
public void logoutclick() {
		
		logoutbtn.click();
	}

public WebElement getSearchtextbox() {
	return searchtextbox;
}
	


}
