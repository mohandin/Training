package mpcTesting;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PerformanceTest {
	
	public WebDriver driver;
	public Actions builder;
	
	  @Test
	  public void contactPage() {
		  	
		  performanceTest(Parameters.urlContactPage,15);
		  
	  }
	  
	  @Test
	  public void homePage() {
		  	
		  performanceTest(Parameters.urlHome,15);
		  
	  }
		    	
	  @BeforeMethod
	  public void beforeMethod() {
		  	
			System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			
			builder = new Actions(driver);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	  
	  public void performanceTest(String url, long perfTime){
		  
		  
			SoftAssert softAssert = new SoftAssert();
			StopWatch pageLoad = new StopWatch();
			pageLoad.start();
			driver.get(url);
			 WebDriverWait wait = new WebDriverWait(driver, perfTime+10);
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-nav")));

		        pageLoad.stop();
		        //Get the time
		        long pageLoadTime_ms = pageLoad.getTime();
		        long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
		        System.out.println("Total Page Load Time for " +  Parameters.urlContactPage + " " + pageLoadTime_ms + " milliseconds");
		        System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
		    	softAssert.assertTrue(pageLoadTime_Seconds < perfTime, "Page is too slow the page took " + pageLoadTime_Seconds + " the pass criteria is less than " + perfTime + " seconds");
		    	softAssert.assertAll();
		  
		  
	  }
	  
	  
	/*
public static void measurePerformance(String[] siteAndUI)
{
	
	System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();

        driver.close();
}*/
	
}
