package automationframework;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerformanceTest {
public static void measurePerformance(String[] siteAndUI)
{
	
	System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	StopWatch pageLoad = new StopWatch();
	pageLoad.start();
	driver.get(siteAndUI[0]);
	 WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(siteAndUI[1])));

        pageLoad.stop();
        //Get the time
        long pageLoadTime_ms = pageLoad.getTime();
        long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
        System.out.println("Total Page Load Time for " +  siteAndUI[0] + " " + pageLoadTime_ms + " milliseconds");
        System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
        driver.close();
}
	
}
