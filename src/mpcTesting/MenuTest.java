package mpcTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 
 * Validation tests to make sure top and side menu display correctly
 * 
 */
public class MenuTest {

	public WebDriver driver;
	public Actions builder;
	/*
	 * This class tests the top menu and verifies the regions are displayed when the user clicks on menu header.
	 */
	 @Test
	public void topMenuDropdownValidate() throws IOException
	{
		boolean status = false;
		
		driver.get(Parameters.urlHome);
		Actions builder = new Actions(driver);
		
		status = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[1]/a")).isDisplayed();
		System.out.println("Is Element appear " + status);
		WebElement link_Menu = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/a"));
		builder.moveToElement(link_Menu).perform();
		
		try
		{
		if(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[1]/a")).isDisplayed() && 
				driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[2]/a")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[3]/a")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[4]/a")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[5]/a")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[6]/a")).isDisplayed() 
				)
			status = true;
		else
			status = false;
		}
		catch(NoSuchElementException e)
		{
				Configurator.logmsg.write("Is Element appear " + false);
				System.out.println("Is Element appear " + false);
				
		}

		Configurator.logmsg.write("Is Element appear " + status);
		System.out.println("Is Element appear " + status);
		driver.close();
	}
	
	@Test
	public void topMenuPagesValidate()
	{
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		driver.get(Parameters.urlHome);
		
		Actions builder = new Actions(driver);
		
		WebElement link_Search = driver.findElement(By.xpath("//*[@id=\"woocommerce_product_search-5\"]/div/form/button"));
		builder.moveToElement(link_Search).click().perform();
		driver.close();
		
	}
	
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  	
		  
		  	ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
			System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver(options);
			builder = new Actions(driver);
	  }

	  @AfterMethod
	  public void afterMethod()  {
		  driver.quit();
	
	  }
	  

}
