package mpcTesting;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * 
 * 
 * Class name: Performance Test
 * Test the response time of a page and fail the test if it is below threshold 
 * 
 */
public class PerformanceTest {
	
	public WebDriver driver;
	public Actions builder;
	
	  @Test
	  public void contactPage() throws IOException {
		  	
		  performanceTest(Parameters.urlContactPage,15);
		  
	  }
	  
	  @Test
	  public void homePage() throws IOException {
		  	
		  performanceTest(Parameters.urlHome,15);
		  
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
	  
	  public void performanceTest(String url, long perfTime) throws IOException{
		  
		  
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
		        Configurator.logmsg.write("Total Page Load Time for " +  Parameters.urlContactPage + " " + pageLoadTime_ms + " milliseconds");
		        Configurator.logmsg.newLine();
		        //System.out.println("Total Page Load Time for " +  Parameters.urlContactPage + " " + pageLoadTime_ms + " milliseconds");
		        Configurator.logmsg.write("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
		        Configurator.logmsg.newLine();
		        //System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
		    	softAssert.assertTrue(pageLoadTime_Seconds < perfTime, "Page is too slow the page took " + pageLoadTime_Seconds + " the pass criteria is less than " + perfTime + " seconds");
		    	softAssert.assertAll();
		  
		  
	  }

	
}
