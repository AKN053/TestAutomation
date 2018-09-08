package pages;

import java.util.List;

import org.openqa.selenium.By;

import common.Enumerations.ColumnName;

import framework.helpers.Elements;

public class SubscribersItemPage extends BasePage{
	public static class PageElements{
		
		public static final By HISTORY_ALERT_STATIC = By.cssSelector("#itn_Review_Details > div > div.panel-body.itnPanelSubBody > div:nth-child(3) > div > div.alert.alert-warning.center-block.text-center.ng-scope");
				
	}
	
	public static boolean isHistoryAlertPresent(){		
		if(Elements.isExist(PageElements.HISTORY_ALERT_STATIC))
			return true;
		else
			return false;
	}
	
	public static String getHistoryAlert(){
		Elements.isExist(PageElements.HISTORY_ALERT_STATIC);
		return Elements.getText(PageElements.HISTORY_ALERT_STATIC);
	}
	
	public static String getFirstGTIN(){
		List<String> data = MDS_Table.getColumnData(ColumnName.GTIN);
		return data.get(0);
	}
	
	public static class SplitScreen{
		
		public static class PageElements{
			public static final By HEADER = By.cssSelector("div[id='itnSearchResultsGrid'] > div[id='itn_Review_Details'] > div > div[ng-show='header'] > div > div > h3 > a");
			
			public static final By GET_PRODUCT_SHEET_BUTTON = By.cssSelector("a[id='gtinProductSellSheet']");
			public static final By CIC_MESSAGE_STATIC = By.cssSelector("div[id='cicMessages'] > div");
		}
		
		public static String getHeader(){
			Elements.waitForElementToBeVisible(PageElements.HEADER);
			Elements.isEnabled(PageElements.HEADER);
			return Elements.getText(PageElements.HEADER);
		}
		
		public static void clickGetProductSheetButton(){
			Elements.isEnabled(PageElements.GET_PRODUCT_SHEET_BUTTON);
			Elements.clickElement(PageElements.GET_PRODUCT_SHEET_BUTTON);
		}
		
		public static String getCICMessage(){
			Elements.isEnabled(PageElements.CIC_MESSAGE_STATIC);
			return Elements.getText(PageElements.CIC_MESSAGE_STATIC);
		}
	}

}
