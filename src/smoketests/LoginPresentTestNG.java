package smoketests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting test");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing test");
		driver.close();
	}
	
	@Test
	public void loginElementsPresentTest()
	{
		System.out.println("Running test");
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox);
		Assert.assertTrue(passwordBox);
		
		
		
	}

}
