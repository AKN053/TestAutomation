package framework.providers;



import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import common.Config;

public class WebDriverListener implements IInvokedMethodListener {
	
	@Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        if (method.isTestMethod()) {
        	
            String browserName = Config.BrowserType.CHROME_LOCAL.toString();            
            WebDriver driver = DriverFactory.createInstance(browserName);
            DataSet dataSet = new DataSet();
            DriverManager.setWebDriver(driver);
            DriverManager.setDataSet(dataSet);
            driver.get(Config.BaseUrl.BASE_URL);
            DataSet.setTestCaseName(method.getTestMethod().getMethodName());
            /*System.out.println("******************");
            System.out.println(DataSet.getTestCaseName());
            System.out.println("******************");*/
        }
    }
 
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    	
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();           
            if (driver != null) {
            	driver.close();
                driver.quit();                
            }
        }
    }

}
