package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import common.Config;
import common.LogHandler;
import common.Enumerations.ColumnName;
import framework.helpers.Elements;
import framework.providers.DriverManager;
import pages.BasePage;
import pages.BasePage.IsLoading;
import pages.BasePage.MDS_Table;
import pages.CatalogPage.PageElements;

public class SubscriberCatalogPage extends BasePage {
	
	public static class PageElements{
			
		public static final By SEARCH_TEXTBOX =By.cssSelector("input[id='searchItem']");
		public static final By TYPEAHEAD_RESULTLIST = By.cssSelector("ul[class*='typeahead'][role='select']");
		
		public static final By TOOLTIP = By.cssSelector("");		
		
	}
	
	
	
	public static void performSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		//Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()-1));
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, 4));
		
		while(IsLoading.isLoading())
			LogHandler.logInfo("Waiting for page load...");
		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		
		List<WebElement> options = Elements.findAll(typeAheadResultList, By.cssSelector("a[role='menuitem']"));
		
		for(int i=0; i<options.size(); i++){
			System.out.println(Elements.getText(options.get(i)));
			System.out.println(Elements.getText(options.get(i)) +" Contains "+searchText +" : "+Elements.getText(options.get(i)).contains(searchText));
			if(Elements.getText(options.get(i)).contains(searchText)){
				
				options.get(i).click();
			}
		}
		//typeAheadResultList.
		//System.out.println(DriverManager.getDriver().getPageSource());
		/*System.out.println(typeAheadResultList.getAttribute("innerHTML"));
		Elements.selectFromTypeAheadDropdownStart(typeAheadResultList,searchText);*/
	}
	
	public static void performProductCodeSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownMid(typeAheadResultList,searchText);
	}
	
	public static void performProductDescriptionSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownLast(typeAheadResultList,searchText);
	}
	
	public static void searchFirstGTIN(){		
		performSearch(getFirstGTIN());
	}
	
	public static String getFirstGTIN(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.GTIN);
		if(gtin.get(0).equalsIgnoreCase("--"))
			return gtin.get(1);
		return gtin.get(0);
	}
	
	public static String getFirstProductCode(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.PRODUCT_CODE);
		return gtin.get(0);
	}
	
	public static void searchFirstProductCode(){		
		performProductCodeSearch(getFirstProductCode());
	}
	
	public static String getFirstProductDescription(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.ITEM_DESCRIPTION);
		return gtin.get(0);
	}
	
	public static void searchFirstProductDescription(){		
		performProductDescriptionSearch(getFirstProductDescription());
	}
	
	public static void waitForDataLoad(){
		/*if(Elements.isVisible(PageElements.TABLE_BODY_GRID))
			return true;
		else
			return false;*/
		while(MDS_Table.getTotalNumberOfRowsFromMDSTable(ColumnName.GTIN)<1){
			//System.out.println("waiting for data load");
			Elements.pauseExecution(2000);
			break;
		}
		
		//System.out.println("data loaded");
	}
	
	public static boolean verifyAvailableColumns(){
		
		if(!MDS_Table.isColumnPresent(ColumnName.GTIN))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.PRODUCT_CODE))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.DESCRIPTION))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.UNIT_DESCRIPTOR))
			return false;
		
		if(!MDS_Table.isColumnPresent(ColumnName.LAST_UPLOAD_DATE))
			return false;
		if(!MDS_Table.isColumnPresent(ColumnName.DMS_STATUS))
			return false;
		
		return true;
		
	}	
	
	
	public static String getLastUploadDateToolTip(int rowNumber){
		By LAST_UPLOAD_DATE_ROW = BasePage.MDS_Table.getColumnCSS(ColumnName.LAST_UPLOAD_DATE);
		List<WebElement> data = Elements.findAll(LAST_UPLOAD_DATE_ROW);
		Elements.hoverOnElement(data.get(rowNumber-1));
		String info = Elements.getText(By.cssSelector("div[class^='popover']"));
		System.out.println(info);
		return info;
	}
	
	
	public static class SplitScreen{
			
			public static class PageElements{
				public static final By HEADER_STATIC = By.cssSelector("div[ng-show='splitScreen'] > div > div[ng-show='header'] > div > div > h3 > a");
				public static final By CLOSE_BUTTON = By.cssSelector("div[ng-show='splitScreen'] > div > div[ng-show='header'] > div > div > h3 > span > span[ng-show='showcloseinheader'] > button");
				public static final By GET_PRODUCT_SHEET_BUTTON = By.cssSelector("div[id='itn_Review_Details'] > div > a[id='gtinProductSellSheet']");
			}
			
			public static String getHeader(){
				return Elements.getText(PageElements.HEADER_STATIC);
			}
			
			public static void clickCloseSplitScreen(){
				Elements.isEnabled(PageElements.CLOSE_BUTTON);
				Elements.clickElement(PageElements.CLOSE_BUTTON);
			}
			
			public static boolean verifySplitScreenVisible(){
				if(Elements.isVisible(PageElements.HEADER_STATIC))
					return true;
				else
					return false;
			}
			
			public static boolean verifyGetProductSheetButtonClickable(){
				if(Elements.isClickable(PageElements.GET_PRODUCT_SHEET_BUTTON, Config.wait))
					return true;
				else
					return false;
			}
		}

}
