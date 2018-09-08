package pages;

import java.util.List;

import org.openqa.selenium.By;

import common.Enumerations.ColumnName;

import framework.helpers.Elements;

public class PublishingCenterPage extends BasePage{
	
	public static class PageElements{	
		
		public static final By SHOW_UPDATES_LINK = By.cssSelector("a[ng-hide='showUpdates'][ng-click='showUpdates=true']");
		public static final By HIDE_UPDATES_LINK = By.cssSelector("a[ng-show='showUpdates'][ng-click='showUpdates=false']");
		
		public static final By INFO_MESSAGE_STATIC = By.cssSelector("div[ng-show='showUpdates']");
		
	}
	
	public static void clickHideUpdatesLink(){
		Elements.isEnabled(PageElements.HIDE_UPDATES_LINK);
		Elements.clickElement(PageElements.HIDE_UPDATES_LINK);
	}
	
	public static String clickShowUpdateslinkAndGetMessage(){
		Elements.isEnabled(PageElements.SHOW_UPDATES_LINK);
		Elements.clickElement(PageElements.SHOW_UPDATES_LINK);
		
		Elements.isEnabled(PageElements.INFO_MESSAGE_STATIC);
		return Elements.getText(PageElements.INFO_MESSAGE_STATIC);
	}
	
	public static boolean verifyAvailableColumns(){
		
		if(!MDS_Table.isColumnPresent(ColumnName.SUBSCRIBER_NAME))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.GLN))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.PUBLISHED))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.ACCEPTED))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.REVIEW))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.REJECTED))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.SYNCHRONIZED))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.SUBSCRIBER_CIC_STATUS))
			return false;
		
		return true;
		
	}
	
	public static String getFirstSubscriberName(){
		List<String> data = MDS_Table.getColumnData(ColumnName.SUBSCRIBER_NAME);
		return data.get(0);
	}
	
	

}
