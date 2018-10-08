package mpcTesting.Old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import mpcTesting.Parameters;


public class ContactUs {
	
	public static void insertForm()
	{
		
		
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(Parameters.urlContactPage);
		//Actions builder = new Actions(driver);
		WebElement Name = driver.findElement(By.name("nf-field-1"));
		Name.sendKeys("MyName");
		
		WebElement Email = driver.findElement(By.name("nf-field-2-email"));
		Email.sendKeys("a@acme.org");
		
		WebElement Address = driver.findElement(By.name("nf-field-6-address"));
		Address.sendKeys("Acmeland");
		Assert.assertTrue(true);
		
		//WebElement Address = driver.findElement(By.name("nf-field-3"));
	//	Address.sendKeys("This is my message i have entered for test. *** End of message****.");
	}
	


}
