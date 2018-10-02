/**
 * 
 */
package mpcTesting;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author i56625
 *
 */
public class InitialClass {
	  @BeforeSuite
	  public void beforeClass() throws IOException{
		  
		  
		  if(Parameters.loggerOn == 1)
				Configurator.intialize();		  
	  }
	  
	  @AfterSuite
	  public void aferClass() throws IOException{
		  
		  
		  if(Parameters.loggerOn == 1)
			  Configurator.logmsg.close();	  
	  }

}
