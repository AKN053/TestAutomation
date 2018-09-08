package pages;

import org.openqa.selenium.By;

import framework.helpers.Elements;

public class ReviewCICsSubscriberItemsPage extends BasePage{
	
	public static class PageElements{
		public static final By SUBSCRIBERS_BUTTON = By.cssSelector("button[id='reviewSubscribers']");	
		public static final By SUBSCRIBERS_DROPDOWN = By.cssSelector("ul[role='select']"); 
		public static final By SEARCH_TEXTBOX = By.cssSelector("input[id='reviewKeyword']");
		
		public static final By RETURN_TO_PUBLISHING_CENTER_LINK = By.linkText("Return to Publishing Center");
		
	}
	
	
	public static String getSelectedSubscriber(){
		Elements.isEnabled(PageElements.SUBSCRIBERS_BUTTON);
		return Elements.getText(PageElements.SUBSCRIBERS_BUTTON);
	}
	
	public static void clickReturnToPublishingCenterLink(){
		Elements.isEnabled(PageElements.RETURN_TO_PUBLISHING_CENTER_LINK);
		Elements.clickElement(PageElements.RETURN_TO_PUBLISHING_CENTER_LINK);
	}
	
	
}
