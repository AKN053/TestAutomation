package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import common.Config;
import common.Enumerations.ColumnName;
import common.LogHandler;
import framework.helpers.Elements;
import framework.providers.Data;

public class GDSNSubscriptions extends BasePage{
	
	public static class PageElements{
		
		public static final By SEARCH_TEXTBOX =By.cssSelector("input[id='searchItem']");
		public static final By TYPEAHEAD_RESULTLIST = By.cssSelector("ul[class*='typeahead'][role='select']");
		public static final By SUBSCRIPTION_COUNT_STATIC = By.cssSelector("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div > div > div:nth-child(3) > div.col.col-sm-8.col-md-9.col-lg-10 > div:nth-child(3) > div.col > div:nth-child(1) > div.col-lg-5.pull-right > div > div > div:nth-child(1) > div > span > strong");
		public static final By SUBSCRIPTION_COUNT_CANCEL_STATIC = By.cssSelector("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div > div > div:nth-child(3) > div.col.col-sm-8.col-md-9.col-lg-10 > div:nth-child(3) > div.col > div:nth-child(1) > div.col-lg-5.pull-right > div > div > div.row.itnColBottomAlignRow > div > span > strong");
		public static final By ROW_CHECKBOXES = By.cssSelector("td[ng-show*='showCancelSubscription'] > span[class='checkboxNative'] > input");
		//Status Filters
		public static final By VALID_CHECKBOX = By.cssSelector("input[id='subscriptionStatusesValid']");
		public static final By INPROCESS_CHECKBOX = By.cssSelector("");
		public static final By INVALID_CHECKBOX = By.cssSelector("");
		public static final By CANCELLED_CHECKBOX = By.cssSelector("");
		
		public static final By CANCEL_SUBSCRIPTIONS_BUTTON = By.cssSelector("div[name='subscriptionDownload'] > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > div > div:nth-child(2) > div:nth-child(1) > a");
		public static final By DOWNLOAD_BUTTON = By.cssSelector("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div > div > div:nth-child(3) > div.col.col-sm-8.col-md-9.col-lg-10 > div:nth-child(3) > div.col > div:nth-child(1) > div.col-sm-7 > div > div > div:nth-child(2) > div.btn-group.col-lg-4.ng-scope > a");
		
		//Reset
		public static final By RESET_LINK = By.cssSelector("a[id='reset'][ng-click*='resetSearch()']");
		
		//Header links
		public static final By CREATE_SUBSCRIPTION_LINK = By.cssSelector("#publication_reviewCICLink > span");
		public static final By CANCEL_SUBSCRIPTION_LINK = By.cssSelector("#publication_publishLink > span");
		public static final By DOWNLOAD_SUBSCRIPTION_LINK = By.cssSelector("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div > div > div:nth-child(1) > div > div > div.col.col-md-7.col-sm-8.col-xs-10.pull-right > div > div:nth-child(6) > div > #linkDownloadItems");
	}
	
	public static void clickCancelSubscriptionsButton(){
		
		Elements.isEnabled(PageElements.CANCEL_SUBSCRIPTIONS_BUTTON);
		Elements.clickElement(PageElements.CANCEL_SUBSCRIPTIONS_BUTTON);
		Elements.pauseExecution(80000);
	}
	
	public static boolean verifyDownloadButtonEnabled(){
		
		if(Elements.isEnabled(PageElements.DOWNLOAD_BUTTON))
			return true;
		return false;
	}
	
	public static int getSubscriptionCount(){
		Elements.isEnabled(PageElements.SUBSCRIPTION_COUNT_STATIC);
		String data = Elements.getText(PageElements.SUBSCRIPTION_COUNT_STATIC);
		String lst[] = data.split("Subscriptions");
		System.out.println("lst[0] : " +lst[0]);
		return Integer.parseInt(lst[0].trim());
	}
	
	public static int getSubscriptionCountOnCancel(){
		Elements.isEnabled(PageElements.SUBSCRIPTION_COUNT_CANCEL_STATIC);
		String data = Elements.getText(PageElements.SUBSCRIPTION_COUNT_CANCEL_STATIC);
		String lst[] = data.split("Subscriptions");
		System.out.println("lst[0] : " +lst[0]);
		return Integer.parseInt(lst[0].trim());
	}
	
	public static void clickCreateSubscriptionLink(){
		Elements.isEnabled(PageElements.CREATE_SUBSCRIPTION_LINK);
		Elements.clickElement(PageElements.CREATE_SUBSCRIPTION_LINK);
		Elements.pauseExecution(3500);
	}
	
	public static void clickCancelSubscriptionLink(){
		Elements.isEnabled(PageElements.CANCEL_SUBSCRIPTION_LINK);
		Elements.clickElement(PageElements.CANCEL_SUBSCRIPTION_LINK);
		Elements.pauseExecution(3500);
	}
	
	public static void clickDownloadSubscriptionLink(){
		Elements.isEnabled(PageElements.DOWNLOAD_SUBSCRIPTION_LINK);
		Elements.clickElement(PageElements.DOWNLOAD_SUBSCRIPTION_LINK);
		Elements.pauseExecution(3500);
	}
	
	public static void performSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		//Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()-1));
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, 4));
		
		while(IsLoading.isLoading())
			LogHandler.logInfo("Waiting for page load...");
		
		//Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		
		List<WebElement> options = Elements.findAll(typeAheadResultList, By.cssSelector("a[role='menuitem']"));
		
		for(int i=0; i<options.size(); i++){
			System.out.println(Elements.getText(options.get(i)));
			System.out.println(Elements.getText(options.get(i)) +" Contains "+searchText +" : "+Elements.getText(options.get(i)).contains(searchText));
			if(Elements.getText(options.get(i)).contains(searchText)){
				
				options.get(i).click();
				break;
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
		List<String> gtin = MDS_Table.getColumnData(ColumnName.GTIN_STATIC_SUBSCRIBER);
		if(gtin.get(0).equalsIgnoreCase("--"))
			return gtin.get(1);
		return gtin.get(0);
	}
	
	public static String getNthGTIN(int n){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.GTIN_STATIC_SUBSCRIBER);		
		return gtin.get(n);
	}
	
	public static String getFirstPublisherName(){
		List<String> data = MDS_Table.getColumnData(ColumnName.PUBLISHER_NAME);
		if(data.get(0).equalsIgnoreCase("--"))
			return data.get(1);
		return data.get(0);
	}
	
	public static String getFirstPublisherGLN(){
		List<String> data = MDS_Table.getColumnData(ColumnName.PUBLISHER_GLN);
		if(data.get(0).equalsIgnoreCase("--"))
			return data.get(1);
		return data.get(0);
	}
	
	public static String getNthPublisherGLN(int n){
		List<String> data = MDS_Table.getColumnData(ColumnName.PUBLISHER_GLN);		
		return data.get(n);
	}
	
	public static String getNthProductGPC(int n){
		List<String> data = MDS_Table.getColumnData(ColumnName.PRODUCT_GPC);		
		return data.get(n);
	}
	
	
	public static String getfirstSubscriberGLN(){
		List<String> data = MDS_Table.getColumnData(ColumnName.SUBSCRIBER_GLN);
		if(data.get(0).equalsIgnoreCase("--"))
			return data.get(1);
		return data.get(0);
		
	}
	public static String getFirstProductGPC(){
		List<String> data = MDS_Table.getColumnData(ColumnName.PRODUCT_GPC);
		for(int i=0;i<data.size();i++){
			if(!data.get(i).equalsIgnoreCase("-- -")){
				Config.dataIndex = i;
				return data.get(i);
			}
				
		}
		return null;
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
	
	
	public static void checkValidCheckbox(){		
		
		WebElement div = Elements.find(By.cssSelector("div[header='Validation Status']"));		
		List<WebElement> filters = div.findElements(By.id("subscriptionStatusesValid"));		
		for(int i=0; i<filters.size();i++){
			filters.get(i).click();
		}
		
		Elements.pauseExecution(5000);
	}
	
	public static void checkInProcessCheckbox(){		
			
			WebElement div = Elements.find(By.cssSelector("div[header='Validation Status']"));		
			List<WebElement> filters = div.findElements(By.id("subscriptionStatusesIn Process"));		
			for(int i=0; i<filters.size();i++){
				filters.get(i).click();
			}
			
			Elements.pauseExecution(5000);
	}
	
	public static void checkInValidCheckbox(){		
		
		WebElement div = Elements.find(By.cssSelector("div[header='Validation Status']"));		
		List<WebElement> filters = div.findElements(By.id("subscriptionStatusesInvalid"));		
		for(int i=0; i<filters.size();i++){
			filters.get(i).click();
		}
		
		Elements.pauseExecution(5000);
	}
	
	public static void checkCancelledCheckbox(){		
		
		WebElement div = Elements.find(By.cssSelector("div[header='Validation Status']"));		
		List<WebElement> filters = div.findElements(By.id("subscriptionStatusesCancelled"));		
		for(int i=0; i<filters.size();i++){
			filters.get(i).click();
		}
		
		Elements.pauseExecution(5000);
	}
	
	public static void clickResetFilterLink(){
		
		Elements.isEnabled(PageElements.RESET_LINK);
		Elements.clickElement(PageElements.RESET_LINK);
		Elements.pauseExecution(5000);
	}
	
	public static boolean verifyFilterReset(){
		WebElement div = Elements.find(By.cssSelector("div[header='Validation Status']"));
		
		WebElement valid = div.findElement(By.id("subscriptionStatusesValid"));
		WebElement inprocess = div.findElement(By.id("subscriptionStatusesIn Process"));
		WebElement inValid = div.findElement(By.id("subscriptionStatusesInvalid"));
		WebElement cancelled = div.findElement(By.id("subscriptionStatusesCancelled"));
		
		if(valid.isSelected())
			return false;
		if(inprocess.isSelected())
			return false;
		if(inValid.isSelected())
			return false;
		if(cancelled.isSelected())
			return false;
		
		return true;
	}
	
	
	public static int getIndexWherePublisherGLN_And_GTIN_exists(){
		
		List<String> publisherGLN = MDS_Table.getColumnData(ColumnName.PUBLISHER_GLN);
		List<String> GTIN = MDS_Table.getColumnData(ColumnName.GTIN_STATIC_SUBSCRIBER);
		
		for(int i=0;i<20;i++){				
			if(!publisherGLN.get(i).equals("--") && !GTIN.get(i).equals("--"))
				return i;
		}
		
		return -1;
	}
	
	public static int getIndexWherePublisherGLN_And_ProductGPC_exists(){
		
		List<String> publisherGLN = MDS_Table.getColumnData(ColumnName.PUBLISHER_GLN);
		List<String> ProdGPC = MDS_Table.getColumnData(ColumnName.PRODUCT_GPC);
		
		for(int i=0;i<20;i++){				
			if((!publisherGLN.get(i).equals("--") && !ProdGPC.get(i).equals("-- -")))
				return i;
		}
		
		return -1;
	}
	
	public static void checkNthRowCheckbox(int n){
		Elements.isEnabled(PageElements.ROW_CHECKBOXES);
		List<WebElement> checkboxes = Elements.findAll(PageElements.ROW_CHECKBOXES);
		Elements.clickElement(checkboxes.get(n-1), Config.wait);
		
	}
	
	public static class CreateASubscription{
		
		public static class PageElements{
			
			public static final By PUBLISHER_GLN = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > input");
			public static final By PUBLISHER_GLN_OPTIONS = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > ul > li > a");
			public static final By GTIN_RADIO = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > div:nth-child(1) > input");
			public static final By GTIN_TEXTBOX = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > div:nth-child(2) > input"); 
			public static final By TARGET_MARKET_BUTTON = By.cssSelector("#tmDropDown > button");
			public static final By SUBSCRIBER_GLN_DROPBOX = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > select");
			public static final By GLOBAL_GPC_RADIO = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(1) > input");
			public static final By GLOBAL_GPC_TEXTBOX = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(2) > tags-input > div > div > input");
			public static final By GLOBAL_GPC_OPTIONS = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(2) > tags-input > div > auto-complete > div > ul > li > ti-autocomplete-match > ng-include > span");
			
			public static final By PUBLISHER_GLN_REQUIRED_FIELD = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > span:nth-child(2)");
			//Footer buttons
			public static final By CREATE_SUBSCRIPTION_BUTTON = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(8) > div > div > div > div:nth-child(1) > div > a");
			public static final By CANCEL_LINK = By.cssSelector("div[id*='subcription'] > ng-form > div:nth-child(8) > div > div > div > div:nth-child(2) > div > a");
		}
		
		public static boolean verifyOverlayPresent(){
			if(Elements.isExist(PageElements.CREATE_SUBSCRIPTION_BUTTON))
				return true;
			return false;
		}
		
		public static void clickCreateSubscriptionButton(){			
			Elements.isEnabled(PageElements.CREATE_SUBSCRIPTION_BUTTON);
			Elements.clickElement(PageElements.CREATE_SUBSCRIPTION_BUTTON);
		}
		
		public static void clickCancelLink(){
			Elements.isEnabled(PageElements.CANCEL_LINK);
			Elements.clickElement(PageElements.CANCEL_LINK);
		}
		
		public static boolean verifyPublisherGLNRequiredFieldPresent(){			
			if(Elements.isEnabled(PageElements.PUBLISHER_GLN_REQUIRED_FIELD))
				return true;
			
			return false;
		}
		
		public static void fillPublisherGLN(){
			Elements.isEnabled(PageElements.PUBLISHER_GLN);
			Elements.typeIN(PageElements.PUBLISHER_GLN, Data.getNumber(13));
		}
		
		public static void fillPublisherGLN(String data){
			Elements.isEnabled(PageElements.PUBLISHER_GLN);
			Elements.typeIN(PageElements.PUBLISHER_GLN, data);			
			Elements.typeIn(PageElements.PUBLISHER_GLN, Keys.BACK_SPACE);
			Elements.clickElement(PageElements.PUBLISHER_GLN_OPTIONS);
		}
		
		public static void fillGTIN(){
			Elements.isEnabled(PageElements.GTIN_RADIO);
			Elements.clickElement(PageElements.GTIN_RADIO);
			
			Elements.typeIN(PageElements.GTIN_TEXTBOX, Data.getNumber(14));
		}
		
		public static void fillGTIN(String data){
			Elements.isEnabled(PageElements.GTIN_RADIO);
			Elements.clickElement(PageElements.GTIN_RADIO);
			
			Elements.typeIN(PageElements.GTIN_TEXTBOX, data);
		}
		
		public static void fillGlobalGPC(){
			Elements.isEnabled(PageElements.GLOBAL_GPC_RADIO);
			Elements.clickElement(PageElements.GLOBAL_GPC_RADIO);
			
			Elements.typeIN(PageElements.GLOBAL_GPC_TEXTBOX, Data.getNumber(10));
			
		}
		
		
		public static void fillGlobalGPC(String data){
			Elements.isEnabled(PageElements.GLOBAL_GPC_RADIO);
			Elements.clickElement(PageElements.GLOBAL_GPC_RADIO);
			String pid[] = data.split("-");
			Elements.isEnabled(PageElements.GLOBAL_GPC_TEXTBOX);
			Elements.typeIN(PageElements.GLOBAL_GPC_TEXTBOX, pid[0].trim());
			Elements.clickElement(PageElements.GLOBAL_GPC_OPTIONS);
			
		}
		
		
	}

}
