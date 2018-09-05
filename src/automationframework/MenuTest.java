package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 
 * Validation tests to make sure top and side menu display correctly
 * 
 */
public class MenuTest {

	/*
	 * This class tests the top menu and verifies the regions are displayed when the user clicks on menu header.
	 */
	public static void topMenuValidate()
	{
		boolean status = false;
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://modernpreciouscoin.com");
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
				System.out.println("Is Element appear " + false);
				
		}

		System.out.println("Is Element appear " + status);
		WebElement link_Search = driver.findElement(By.xpath("//*[@id=\"woocommerce_product_search-5\"]/div/form/button"));
		builder.moveToElement(link_Search).click().perform();
		driver.close();
		
	}
}
