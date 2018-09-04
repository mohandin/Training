package automationframework;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchSite {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		/*Configurator.siteAndUI[0] = "https://modernpreciouscoin.com";
		Configurator.siteAndUI[1] = "main-nav";
		PerformanceTest.measurePerformance(Configurator.siteAndUI);
		Configurator.siteAndUI[0] = "https://modernpreciouscoin.com/contact-us/";
		Configurator.siteAndUI[1] = "main-nav";
		PerformanceTest.measurePerformance(Configurator.siteAndUI);
		Configurator.siteAndUI[0] = "https://modernpreciouscoin.com/about-us/";
		Configurator.siteAndUI[1] = "main-nav";
		PerformanceTest.measurePerformance(Configurator.siteAndUI);*/
		ValidatePage.validatePage("https://modernpreciouscoin.com");
		
	}

}
