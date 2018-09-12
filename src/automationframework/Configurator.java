package automationframework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Configurator {
public static String loggerfiler = "C:/temp/Logger.txt";
public static String [] siteAndUI = new String[2];
public static BufferedWriter logmsg;
/*
Configurator()
{
	try {
		Configurator.intialize();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
*/
public static void intialize() throws IOException
{
	
	
	File file = new File(loggerfiler);
	if(file.delete())
	{
		file.createNewFile();
	}
	else
	{
		
	}
	try {
		logmsg = new BufferedWriter(new FileWriter(loggerfiler));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
