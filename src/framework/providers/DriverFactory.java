package framework.providers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.Config;

class DriverFactory {
	
	static WebDriver createInstance(String browserName) {
		
		WebDriver driver = null;
		ChromeOptions options;
        if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("IE")) {
            driver = new InternetExplorerDriver();
            return driver;
        }
        if (browserName.equalsIgnoreCase(Config.BrowserType.CHROME_LOCAL.toString())) {
        	System.out.println("Starting Local Chrome Driver..");
        	
        	DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        	System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        	//String chromeProfile = "C:\\Users\\prashantc1\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        	/*ArrayList<String> switches = new ArrayList<String>();
        	//switches.add("--user-data-dir=" + chromeProfile);
        	switches.add("test-type");
        	chromeCapabilities.setCapability("chrome.switches", switches);*/
        	
        	options = new ChromeOptions();
        	//options.addArguments("user-data-dir=/ChromeAutomationMDSprofile");
        	options.addArguments("test-type");
        	chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	driver = new ChromeDriver(chromeCapabilities);
        	driver.manage().window().maximize();
        	return driver;
        }
        
        if(browserName.toLowerCase().equalsIgnoreCase("remote_chrome")){
        	System.out.println("Starting RemoteWebDriver..");
        	
            DesiredCapabilities caps = DesiredCapabilities.chrome();
       	    System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
       	    caps.setBrowserName("chrome");
       	    options = new ChromeOptions();
       	    options.addArguments("test-type");
       	    caps.setCapability(ChromeOptions.CAPABILITY, options);
       	    try {
			  driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
			  } catch (MalformedURLException e) {			
				e.printStackTrace();
			}        	
        }
        driver.manage().window().maximize();
        return driver;
    }	
	

}
