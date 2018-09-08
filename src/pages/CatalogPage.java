package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.BasePage.MDS_Table;
import common.Config;
import common.Enumerations.ColumnName;
import framework.helpers.Elements;


public class CatalogPage extends BasePage{
	
	public static class PageElements{
		public static final By SEARCH_TEXTBOX = By.cssSelector("input[id='searchItem']");
		public static final By TYPEAHEAD_RESULTLIST = By.cssSelector("ul[class*='typeahead'][role='select']");
		
		//download button
		public static final By DOWNLOAD_SELECTED_BUTTON = By.cssSelector("div[ng-if='showDownload'] > a[ng-show='showDownload && !masterCheck'][id='downloadSheets'])");//("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody > div:nth-child(3) > div > div > div > div:nth-child(3) > div.col.col-sm-8.col-md-9.col-lg-10 > div:nth-child(2) > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div:nth-child(2) > div.col-xs-6 > div > a:nth-child(1)");
		public static final By DOWNLOAD_ALL_BUTTON = By.cssSelector("div[ng-if='showDownload'] > a[ng-show='showDownload && masterCheck'][id='downloadSheets']");
		public static final By DOWNLOAD_DROPDOWN_BUTTON = By.cssSelector("button[type='button'][data-toggle='dropdown'][aria-expanded='false']");
		public static final By DOWNLOAD_ALL_LINK = By.cssSelector("ul[class='dropdown-menu'][role='menu'] > li > a[id='downloadSheetsAll']");
		
		public static final By TABLE_BODY_GRID = By.cssSelector("table[id='itnCatalogTable'] > tbody:nth-child(3)");
		
		//checkboxes
		public static final By SELECT_CHECKBOXES = By.cssSelector("td > input[type='checkbox'][id*='gtinChk']");
		
	}
	
	public static void performSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()-1));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownStart(typeAheadResultList,searchText);
	}
	
	public static void performProductCodeSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, 4));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownMid(typeAheadResultList,searchText);
		while(IsLoading.isLoading())
			Elements.pauseExecution(1500);
	}
	
	public static void performProductDescriptionSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, 4));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownLast(typeAheadResultList,searchText);
		while(IsLoading.isLoading())
			Elements.pauseExecution(1500);
		
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
	
	public static void clickDownloadButton(){
		Elements.isEnabled(PageElements.DOWNLOAD_DROPDOWN_BUTTON);
		Elements.clickElement(PageElements.DOWNLOAD_DROPDOWN_BUTTON);
	}
	
	public static boolean isDownloadAllClickable(){
		if(Elements.isClickable(PageElements.DOWNLOAD_ALL_LINK, Config.wait))
			return true;
		else
			return false;
	}
	
	public static boolean isDownloadSelectedButtonClickable(){
		if(Elements.isClickable(PageElements.DOWNLOAD_SELECTED_BUTTON, Config.wait))
			return true;
		else
			return false;
	}
	
	public static void clickDownloadSelectedButton(){
		Elements.isEnabled(PageElements.DOWNLOAD_SELECTED_BUTTON);
		Elements.clickElement(PageElements.DOWNLOAD_SELECTED_BUTTON);
	}
	
	public static void clickDownloadAllButton(){
		Elements.isEnabled(PageElements.DOWNLOAD_ALL_BUTTON);
		Elements.clickElement(PageElements.DOWNLOAD_ALL_BUTTON);
	}
	
	
	public static boolean isDownloadAllButtonClickable(){
		if(Elements.isClickable(PageElements.DOWNLOAD_ALL_BUTTON, Config.wait))
			return true;
		else
			return false;
	}
	
	public static void selectFirstNGTINs(int n){
		List<WebElement> data = Elements.findAll(PageElements.SELECT_CHECKBOXES);
		for(int i=0; i<n; i++){
			Elements.clickElement(data.get(i), Config.sleep);
			if(i>=data.size())
				break;
		}
	}
	
	
	public static class Filters{
		
		public static class RegistrationStatus{
		
			public static class PageElements{
				
				//public static final By INCOMPLETE_CHECKBOX = By.cssSelector("input[type='checkbox'][id='registrationStatus_Incomplete']");
				public static final By NOT_READY_CHECKBOX = By.cssSelector("div[header='Registration Status'] > div[ng-show='showITNPanelContent'] > div:nth-child(3) > div > div > div:nth-child(1) > div[ng-click='addRegistrationStatus(status)'] > div > input[type='checkbox'][id='registrationStatus_Not Ready']");
				public static final By IN_PROCESS_CHECKBOX = By.cssSelector("div[header='Registration Status'] > div[ng-show='showITNPanelContent'] > div:nth-child(3) > div > div > div:nth-child(2) > div[ng-click='addRegistrationStatus(status)'] > div > input[type='checkbox'][id='registrationStatus_In Process']");
				//public static final By REGISTERED_CHECKBOX = By.cssSelector("input[type='checkbox'][id='registrationStatus_Registered']");
				public static final By VALIDATED_CHECKBOX = By.cssSelector("div[header='Registration Status'] > div[ng-show='showITNPanelContent'] > div:nth-child(3) > div > div > div:nth-child(3) >div[ng-click='addRegistrationStatus(status)'] > div > input[type='checkbox'][id='registrationStatus_Validated']");
				public static final By FAILED_CHECKBOX = By.cssSelector("div[ng-show*='isNonGdsnOmsUser()'] > div > div:nth-child(2) > div:nth-child(3) > div > div > div:nth-child(4) > div > div > input");
				
			}
			
			/*public static void checkIncompleteCheckbox(){
				Elements.isEnabled(PageElements.INCOMPLETE_CHECKBOX);
				Elements.clickElement(PageElements.INCOMPLETE_CHECKBOX);
				IsLoadin.isLoading();
			}*/
			
			public static void checkNotReadyCheckbox(){
				List<WebElement> all = Elements.findAll(By.cssSelector("div[ng-click='addRegistrationStatus(status)']"));
				/*Elements.isEnabled(PageElements.NOT_READY_CHECKBOX);
				Elements.clickElement(PageElements.NOT_READY_CHECKBOX);*/
				WebElement data = Elements.find(all.get(0), By.tagName("input"));
				data.click();
				IsLoading.isLoading();
			}
			
			public static void checkProcessingCheckbox(){
				List<WebElement> all = Elements.findAll(By.cssSelector("div[ng-click='addRegistrationStatus(status)']"));
				WebElement data = Elements.find(all.get(1), By.tagName("input"));
				data.click();
				/*Elements.isEnabled(PageElements.IN_PROCESS_CHECKBOX);
				Elements.clickElement(PageElements.IN_PROCESS_CHECKBOX);*/
				IsLoading.isLoading();
			}
			
			/*public static void checkRegisteredCheckbox(){
				Elements.isEnabled(PageElements.REGISTERED_CHECKBOX);
				Elements.clickElement(PageElements.REGISTERED_CHECKBOX);
				IsLoadin.isLoading();
			}*/
			public static void checkValidatedCheckbox(){
				List<WebElement> all = Elements.findAll(By.cssSelector("div[ng-click='addRegistrationStatus(status)']"));
				WebElement data = Elements.find(all.get(2), By.tagName("input"));
				data.click();
				
				/*
				Elements.isEnabled(PageElements.VALIDATED_CHECKBOX);
				Elements.clickElement(PageElements.VALIDATED_CHECKBOX);*/
				IsLoading.isLoading();
			}
			
			public static void checkFailedCheckbox(){
				List<WebElement> all = Elements.findAll(By.cssSelector("div[ng-click='addRegistrationStatus(status)']"));
				WebElement data = Elements.find(all.get(3), By.tagName("input"));
				data.click();
				/*Elements.isEnabled(PageElements.FAILED_CHECKBOX);
				Elements.clickElement(PageElements.FAILED_CHECKBOX);*/
				IsLoading.isLoading();
			}			
			
		}
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
