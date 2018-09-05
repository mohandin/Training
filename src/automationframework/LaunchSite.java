package automationframework;


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
		
		//Configurator.siteAndUI[0] = "https://modernpreciouscoin.com";
		//Configurator.siteAndUI[1] = "//*[@id='main-nav']";
		//ValidatePage.validatePage(Configurator.siteAndUI);
		MenuTest.topMenuValidate();
	}

}
