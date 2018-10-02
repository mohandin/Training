package mpcTesting.Old;

import java.io.IOException;

import mpcTesting.Configurator;
import mpcTesting.ContactPageValidation;
import mpcTesting.Parameters;

public class LaunchSite {

	public static void main(String[] args) throws IOException  {
		if(Parameters.loggerOn == 1)
		Configurator.intialize();
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
		
		//Configurator.siteAndUI[0] = "https://modernpreciouscoin.com";
		//Configurator.siteAndUI[1] = "//*[@id='main-nav']";
		//ValidatePage.validatePage(Configurator.siteAndUI);
		//MenuTest.topMenuDropdownValidate();
	//	ContactUs.insertForm();
	
		ContactPageValidation.checkValidationMsg();
		Configurator.logmsg.close();
	}

}
