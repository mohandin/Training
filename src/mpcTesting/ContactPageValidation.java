package mpcTesting;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ContactPageValidation {

	public static WebDriver driver;
	
	
  @Test
  public static void checkValidationMsg() {
	  
	  	SoftAssert softAssert = new SoftAssert();
	  	WebElement validationMsg = null;
	  	WebElement name = driver.findElement(By.name("nf-field-1"));
	  	WebElement form = driver.findElement(By.xpath("//*[@id=\"nf-form-1-cont\"]/div/div[4]/form/div/div[2]"));
	  	WebElement email = driver.findElement(By.name("nf-field-2-email"));
	  	WebElement address = driver.findElement(By.name("nf-field-6-address"));
	  	Actions builder = new Actions(driver);
	  	
	  	
	  	builder.click(name).perform();
	  	builder.click(form).perform();
	  	
	  	try
	  	{
	  	validationMsg = driver.findElement(By.xpath("//*[@id=\"nf-error-1\"]/div"));
	  	}
	  	catch(NoSuchElementException e)
	  	{
	  		validationMsg = null;
	  	}
	  	
	  	softAssert.assertTrue(validationMsg.isDisplayed(),"Validation msg for name does not appear");
	  	validationMsg = null;
	  	builder.click(email).perform();
	    builder.click(form).perform();  	
	  	try
	  	{
	  	validationMsg = driver.findElement(By.xpath("//*[@id=\"nf-error-2\"]/div"));
	  	}
	  	catch(NoSuchElementException e)
	  	{
	  		validationMsg = null;
	  	}
	  	
	  	softAssert.assertFalse(validationMsg.isDisplayed(),"Validation msg for email does not appears");
	  	validationMsg = null;
	  	
	  	

  }
  
  @Test
  public static void inputValues() 
  { 
	  	SoftAssert softAssert = new SoftAssert();
	  	WebElement validationMsg = null;
	  	WebElement name = driver.findElement(By.name("nf-field-1"));
	  	WebElement form = driver.findElement(By.xpath("//*[@id=\"nf-form-1-cont\"]/div/div[4]/form/div/div[2]"));
	  	WebElement email = driver.findElement(By.name("nf-field-2-email"));
	  	WebElement address = driver.findElement(By.name("nf-field-6-address"));
	  	Actions builder = new Actions(driver);
	  	
	/*
	 * Type in value in field and make sure validation message does not appear
	 */
	name.sendKeys("MyName");
	email.sendKeys("a@acme.org");
	address.sendKeys("Acmeland");
	
	validationMsg = null;
	try
	{
	validationMsg = driver.findElement(By.xpath("//*[@id=\"nf-error-1\"]/div"));
	}
	catch(NoSuchElementException e)
	{
		validationMsg = null;
	}
	softAssert.assertEquals(validationMsg != null,"Validation Msg is appearing");
	softAssert.assertAll();
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  	
		Configurator.intialize();
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(Parameters.urlContactPage);
		
	  
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	//  driver.quit();
	  Configurator.cleanup();
  }

}
