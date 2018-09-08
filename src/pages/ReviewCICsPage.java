package pages;

import org.openqa.selenium.By;

import pages.BasePage.MDS_Table;

import common.Enumerations.ColumnName;

import framework.helpers.Elements;

public class ReviewCICsPage extends BasePage{
	
	public static class PageElements{
		public static final By SUBSCRIBERS_BUTTON = By.cssSelector("button[id='reviewSubscribers']");	
		public static final By SUBSCRIBERS_DROPDOWN = By.cssSelector("ul[role='select']"); 
		public static final By SEARCH_TEXTBOX = By.cssSelector("input[id='reviewKeyword']");
		
		public static final By RETURN_TO_PUBLISHING_CENTER_LINK = By.linkText("Return to Publishing Center");
		public static final By RETURN_TO_SUBSCRIBER_ITEMS_LINK = By.partialLinkText("Return to Subscriber Items");
		
	}
	
	
	public static String getSelectedSubscriber(){
		Elements.isEnabled(PageElements.SUBSCRIBERS_BUTTON);
		return Elements.getText(PageElements.SUBSCRIBERS_BUTTON);
	}
	
	public static void clickReturnToPublishingCenterLink(){
		Elements.isEnabled(PageElements.RETURN_TO_PUBLISHING_CENTER_LINK);
		Elements.clickElement(PageElements.RETURN_TO_PUBLISHING_CENTER_LINK);
	}
	
	public static void clickReturnToSubscriberItemLink(){
		Elements.isEnabled(PageElements.RETURN_TO_SUBSCRIBER_ITEMS_LINK);
		Elements.clickElement(PageElements.RETURN_TO_SUBSCRIBER_ITEMS_LINK);
	}
	
	public static boolean verifyAvailableColumns(){
		if(!MDS_Table.isColumnPresent(ColumnName.GTIN))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.PRODUCT_CODE))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.UNIT_DESCRIPTOR))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.DESCRIPTION))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.SUBSCRIBER_NAME))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.CIC_STATUS))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.CIC_STATUS_DATE))
			return false;
		
		return true;
	}
	
	
}
