package framework.providers;

import org.openqa.selenium.WebDriver;

public class DriverManager {	
	
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();	
	private static ThreadLocal<DataSet> myDataSet = new ThreadLocal<DataSet>();
 	 
    public static WebDriver getDriver() {    	
        return webDriver.get();
    }
 
    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    
    public static DataSet getDataSet(){
    	return myDataSet.get();
    }
    
    static void setDataSet(DataSet dataSet){
    	myDataSet.set(dataSet);
    }
}
