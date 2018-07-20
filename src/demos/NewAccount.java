package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Mary Smith";
		String email = "mail@mail.com";
		String password = "mspass";
		String country = "United States";
		String phoneNumber = "12233454";
		String browserType = "chrome";
		WebDriver driver;
		
		
		String gender = "Female" ;
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = true;
		
	
		//1. Open Browser Navigate to Account Managment Page >> Click on Create
		driver = utilities.DriverFactory.open(browserType);
		
		
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
		//Define web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passowordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry")); 
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		
		
		//3. Fill out the form
		
		//How to locate elements
	
		nameElement.sendKeys(name); //By.name
		emailElement.sendKeys(email); //By.id
		phoneElement.sendKeys(phoneNumber); //xPath nie jest zbyt przydatne, bo pokazuje dokladna sciezke projektu, jezeli ono ewoluuje, wtedy xPath jest bezuzyteczne w tescie
		passowordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select (countryElement).selectByVisibleText(country);
		
		//Gender Radio Button
		if (gender.equalsIgnoreCase("Male"))
		{
			maleRadio.click();
		}
		else
		{
			
			femaleRadio.click();

		}
		//check Box Algorithm
		if (weeklyEmail)
		{
			if (!weeklyCheckbox.isSelected())
			{
				weeklyCheckbox.click();
			}
		}
		else 
		{
			if (weeklyCheckbox.isSelected())
			{
				weeklyCheckbox.click();
			}
		}
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();

		//4. Get confirmation and close
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected))
		{
			System.out.println("CONF: "+conf);
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		driver.close();


	}

}
