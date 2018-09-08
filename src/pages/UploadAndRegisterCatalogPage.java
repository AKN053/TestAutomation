package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Config;
import framework.helpers.Elements;

public class UploadAndRegisterCatalogPage extends BasePage{
	
	public static class PageElements{
		
		public static final By BROWSE_BUTTON = By.cssSelector("div[id='browse'] > span > input");
		public static final By REMOVE_BUTTON = By.cssSelector("div[ng-show*='length>0'] > table > tbody > tr > td:nth-child(4) > button[id='removeBtn']");
		
		public static final By UPLOAD_BUTTON = By.cssSelector("button[ng-click*='uploadAll()'][id='uploadBtn']");
		public static final By CANCEL_LINK = By.cssSelector("a[ng-click*='onCancelAll()'][id='cancel']");
	}
	
	public static void uploadAfile(){
		String dir = System.getProperty("user.dir")+"\\uploadFiles\\";
		String file = "Sample.xlsx";
		WebElement div = Elements.find(By.cssSelector("div[id='browse']"));
		WebElement input = Elements.find(div, By.tagName("input"));
		//Elements.isEnabled(PageElements.BROWSE_BUTTON);
		input.sendKeys(dir+file);
		//Elements.typeIN(PageElements.BROWSE_BUTTON, dir+file);
		Elements.waitForElementToBeVisible(PageElements.REMOVE_BUTTON);
	}
	
	public static boolean verifyRemoveButtonClickable(){
		Elements.pauseExecution(4000);		
		if(Elements.isVisible(PageElements.REMOVE_BUTTON) && Elements.isClickable(PageElements.REMOVE_BUTTON, Config.wait))
			return true;
		else
			return false;
	}
	
	public static boolean verifyUploadButtonClickable(){
		if(Elements.isVisible(PageElements.UPLOAD_BUTTON) && Elements.isClickable(PageElements.UPLOAD_BUTTON, Config.wait))
			return true;
		else
			return false;
	}
	
	public static boolean verifyCancelClickable(){
		if(Elements.isVisible(PageElements.CANCEL_LINK) && Elements.isClickable(PageElements.CANCEL_LINK, Config.wait))
			return true;
		else
			return false;
	}

}
