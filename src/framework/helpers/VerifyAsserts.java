package framework.helpers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import common.LogHandler;
import framework.providers.DataSet;
import framework.providers.DriverManager;


public class VerifyAsserts {
	
	
	public static void verifyTrue(Boolean condition) {
		
		try{
			Assert.assertTrue(condition);			
		}catch(Throwable t){
			try {
				screenCap(DataSet.testCaseName);
			} catch (Exception e) {				
				e.printStackTrace();
			}		
			//ErrorUtil.addVerificationFailure(t);
			org.testng.Assert.fail("Failing Test Case", t);
		}
		
	}
	
	public static void verifyEquals(String actual, String expected) {
		try{
			Assert.assertEquals(actual, expected);			
		}catch(Throwable t){			
			try {
				screenCap(DataSet.testCaseName);
			} catch (Exception e) {				
				e.printStackTrace();
			}
			//ErrorUtil.addVerificationFailure(t);
			org.testng.Assert.fail("Failing Test Case");			
		}
		
	}
	
	
	public static void screenCap(String fileName) {		
		   
		   LogHandler.logInfo("Capturing Screen-Shot "+fileName+".jpg");
		   String updateFileName = System.getProperty("user.dir")+"\\src\\screenshots\\"+fileName+".jpg";
		   /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize);
		   Robot robot = new Robot();
		   BufferedImage image = robot.createScreenCapture(screenRectangle);
		   ImageIO.write(image, "png", new File(updateFileName));*/
		   
		   File src = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		   try {
			FileUtils.copyFile(src, new File(updateFileName));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		 

		}
		

}