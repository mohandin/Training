package mpcTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatePage {
	public static void validatePage(String siteAndUI[])
	{
		boolean status = false;
		System.setProperty("webdriver.chrome.driver","C:/tool/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(siteAndUI[0]);
		try
		{
		status = driver.findElement(By.xpath(siteAndUI[1])).isDisplayed();
		}
		catch(NoSuchElementException e)
		{
				System.out.println("Is Element appear " + false);
		}
		System.out.println("Is Element appear " + status );
        driver.close();
}
}
