package common;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogHandler {
	
	//******** LOG HANDLER METHOD ************
	// This method logs errors
	public static void logError(Class className,String message, Exception e)
	{
		Logger logger = LoggerFactory.getLogger(className);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//log4j.properties");
		//Write to log 
		logger.error(message,e);
	}
	// This method logs information to file
	public static void logInfo(String message)
	{
		Logger logger = LoggerFactory.getLogger(LogHandler.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//log4j.properties");
		//Write to log 
		logger.error(message);
	}
}
