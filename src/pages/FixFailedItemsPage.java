package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BasePage.MDS_Table;
import common.Config;
import common.Enumerations.ColumnName;
import common.LogHandler;
import framework.helpers.Elements;

public class FixFailedItemsPage extends BasePage{
	
	public static class PageElements{
		
		//public static final By DOWNLOAD_GTINS_BUTTON = By.cssSelector("button[type='button'][ng-click='downLoadItems()']");
		//download button
		public static final By DOWNLOAD_SELECTED_BUTTON = By.partialLinkText("Download (");//("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody > div:nth-child(3) > div > div > div > div:nth-child(3) > div.col.col-sm-8.col-md-9.col-lg-10 > div:nth-child(2) > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div:nth-child(2) > div.col-xs-6 > div > a:nth-child(1)");
		public static final By DOWNLOAD_DROPDOWN_BUTTON = By.cssSelector("button[type='button'][data-toggle='dropdown'][aria-expanded='false']");
		public static final By DOWNLOAD_ALL_LINK = By.cssSelector("ul[class='dropdown-menu'][role='menu'] > li > a[id='downloadSheetsAll']");
		
		public static final By CANCEL_LINK = By.cssSelector("div[name='itn_Registration_Download'] > div > div > div:nth-child(1) > div > div:nth-child(2) > span > a");
	}
	
	
	public static String getFirstGTIN(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.GTIN);
		return gtin.get(0);
	}
	
	public static void clickCancel(){
		Elements.isEnabled(PageElements.CANCEL_LINK);
		Elements.clickElement(PageElements.CANCEL_LINK);
	}
	
	
	public static class SplitScreen{
		
		public static class PageElements{
			
			public static final By HEADER = By.cssSelector("div[id='itn_Registration_errors'][ng-show='splitScreen'] > div > div[ng-show='header']");
		}
		
		public static String getHeaderText(){
			return Elements.getText(PageElements.HEADER);
		}
		
		
	}

}
