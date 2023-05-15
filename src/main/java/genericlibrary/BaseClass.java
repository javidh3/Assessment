package genericlibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public Propertyfiledata pfd = new Propertyfiledata();
	public WebDriverUtilies utilies = new WebDriverUtilies();
	public WebDriver driver;
	
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pfd.getData("URL"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeApp() {
		
		driver.close();
		
		
	}
	
	

	

}
