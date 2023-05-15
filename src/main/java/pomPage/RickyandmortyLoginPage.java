package pomPage;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RickyandmortyLoginPage{
	
	@FindBy(xpath="//input[@class='login-input user-name']")
	private WebElement username;
	
	@FindBy(xpath="//input[@class='login-input password']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginbtn;

	
	
	
	public RickyandmortyLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	


	public void EnterUserName(String uname) {
		
		username.sendKeys(uname);
	}
	
	public void EnterPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void loginclick() {
		
		loginbtn.click();
	}
	
	
	
	}

	

	


