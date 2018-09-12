package automationframework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNG {

	public WebDriver driver;
	
	
  @Test
  public void main() {
	  	WebElement Name = driver.findElement(By.name("nf-field-1"));
		Name.sendKeys("MyName");
		
		WebElement Email = driver.findElement(By.name("nf-field-2-email"));
		Email.sendKeys("a@acme.org");
		
		WebElement Address = driver.findElement(By.name("nf-field-6-address"));
		Address.sendKeys("Acmeland");
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"nf-error-1\"]/div")).isDisplayed());
  }
  @BeforeMethod
  public void beforeMethod() {
	  	
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Parameters.urlContactPage);
	  
  }

  @AfterMethod
  public void afterMethod() {
	//  driver.quit();
  }

}
