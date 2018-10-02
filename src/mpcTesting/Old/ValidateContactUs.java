package mpcTesting.Old;

import org.testng.annotations.Test;

import mpcTesting.Parameters;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ValidateContactUs {
	public WebDriver driver;
	public Actions builder;
	
	  @Test
	  public void main() {
		  	WebElement Name = driver.findElement(By.name("nf-field-1"));
			
			builder.click(Name).perform();
			
			WebElement Email = driver.findElement(By.name("nf-field-2-email"));
			builder.click(Email).perform();
			
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"nf-error-1\"]/div")).isDisplayed(), "Cannot find error message");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  	
			System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Parameters.urlContactPage);
			builder = new Actions(driver);
	  }

	  @AfterMethod
	  public void afterMethod() {
		driver.quit();
	  }

}
