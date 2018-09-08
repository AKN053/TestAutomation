package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testCases.module2.GDSNSubscription_Subscriber;
import common.Config;
import common.Enumerations.BreadCrumbPage;
import common.Enumerations.ColumnName;
import common.Enumerations.More;
import common.LogHandler;
import framework.helpers.Elements;
import framework.providers.DriverManager;

public abstract class BasePage {
	
	
	public static class MenuBar{
		
		public static class PageElements{
			
			//MAIN MENU
			public static final By CATALOG_MAIN_MENU = By.id("catalogMenu"); 	
			public static final By GDSN_MAIN_MENU = By.id("gdsnMenu");
			public static final By ADMIN_MAIN_MENU = By.cssSelector("li[class='dropdown'] > a[id='adminMenu']");
			public static final By LOGOUT_MAIN_MENU = By.cssSelector("a[id='logout']");
			
			public static final By GDSN_SUBSCIPTIONS_SUPPLIER = By.cssSelector("a[ng-click='goToSubscription()'][id='Subscription']");
			
			//SUBMENU
			//CATALOG_MAIN_MENU
			public static final By VIEWCATALOG_SUB_MENU = By.cssSelector("a[id='viewCatalog']");
			// GDSN 
			public static final By GDSNOVERVIEW_SUB_MENU = By.linkText("GDSN Overview");
			public static final By FIXFAILEDITEMS_SUB_MENU = By.linkText("Fix Failed Items");
			public static final By PUBLISHITEMS_SUB_MENU = By.linkText("Publishing Center");
			// ADMIN_MAIN_MENU
			public static final By COMPANYACCOUNTS_SUB_MENU = By.cssSelector("ul[class='dropdown-menu'] > li[ng-show*='canViewCompany()'] > a[id='companyAccounts']");
			public static final By USERACCOUNTS_SUB_MENU = By.cssSelector("ul[class='dropdown-menu'] > li[ng-show*='canViewUser()'] > a[id='userAccounts']");
			
			
			
			//ITN_WELCOME_MENU
			
			public static final By HOME_MENU = By.cssSelector("a[class='itnwelcomemenulink'][ng-click='goToHome()']");
			public static final By CONTACT_US_MENU = By.cssSelector("a[class='itnwelcomemenulink'][ng-click='showContactUs()']");
			public static final By HELP_MENU = By.cssSelector("a[class='itnwelcomemenulink'][ng-click='showHelp()']");
			
			public static final By USERNAME_STATIC =  By.cssSelector("div[class='welcome'] > div[class='itnwelcomealign'] > div[class='itnweltextb']");
		}
		
		public static void goToGDSNSubscriptions(){
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/subscription");
			//GDSNSubscriptions.waitForDataLoad();
			
		}
		
		public static void goToDataQuality(){
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/dms");
			//GDSNSubscriptions.waitForDataLoad();
			Elements.pauseExecution(5000);
			
		}
		
		
		public static void goToViewCatalogPage(){
			
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/catalog///");
			CatalogPage.waitForDataLoad();
			//Elements.find(PageElements.CATALOG_MAIN_MENU);
			/*Elements.clickElement(PageElements.CATALOG_MAIN_MENU);
			Elements.isEnabled(PageElements.VIEWCATALOG_SUB_MENU);
			Elements.clickElement(PageElements.VIEWCATALOG_SUB_MENU);
			
			
			while(IsLoadin.isLoading())
				LogHandler.logInfo("Loading the page...");*/
		}
		
		/*public static void goToGDSNOverview(){
			Elements.goToURL(Config.BaseUrl.BASE_URL+");
			Elements.clickElement(PageElements.GDSN_MAIN_MENU);
			Elements.isEnabled(PageElements.GDSNOVERVIEW_SUB_MENU);
			Elements.clickElement(PageElements.GDSNOVERVIEW_SUB_MENU);
			
		}*/
		
		/*public static void goToFixFailedItems(){
			
			//Elements.clickElement(PageElements.GDSN_MAIN_MENU);
			Elements.clickElement(PageElements.CATALOG_MAIN_MENU);
			Elements.isEnabled(PageElements.FIXFAILEDITEMS_SUB_MENU);
			Elements.clickElement(PageElements.FIXFAILEDITEMS_SUB_MENU);
			
		}*/
		
		public static void goToPublishingCenter(){
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/publication");	
			
			while(IsLoading.isLoading())
				LogHandler.logInfo("Loading the page...");
			/*
			//Elements.clickElement(PageElements.GDSN_MAIN_MENU);
			Elements.clickElement(PageElements.CATALOG_MAIN_MENU);
			Elements.isEnabled(PageElements.PUBLISHITEMS_SUB_MENU);
			Elements.clickElement(PageElements.PUBLISHITEMS_SUB_MENU);*/
			
		}
		
		public static void goToCompanyAccounts(){
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/admin/company");
			/*Elements.clickElement(PageElements.ADMIN_MAIN_MENU);
			Elements.isEnabled(PageElements.COMPANYACCOUNTS_SUB_MENU);
			Elements.clickElement(PageElements.COMPANYACCOUNTS_SUB_MENU);*/
			while(IsLoading.isLoading())
				LogHandler.logInfo("Waiting for page load...");
			
		}
		
		public static void goToUserAccounts(){
			
			Elements.goToURL(Config.BaseUrl.BASE_URL+"/home/admin/user");
			
			/*Elements.clickElement(PageElements.ADMIN_MAIN_MENU);
			Elements.isEnabled(PageElements.USERACCOUNTS_SUB_MENU);
			Elements.clickElement(PageElements.USERACCOUNTS_SUB_MENU);*/
			
		}
		
		
		public static void clickLogOut(){
			
			Elements.isEnabled(PageElements.LOGOUT_MAIN_MENU);
			Elements.clickElement(PageElements.LOGOUT_MAIN_MENU);
			
		}
		
		
		public static void clickHome(){
			
			Elements.isEnabled(PageElements.HOME_MENU);
			Elements.clickElement(PageElements.HOME_MENU);
			
		}
		
		public static void clickContactUs(){
			
			Elements.isEnabled(PageElements.CONTACT_US_MENU);
			Elements.clickElement(PageElements.CONTACT_US_MENU);
			
		}
		
		public static void clickHelp(){
			
			Elements.isEnabled(PageElements.HELP_MENU);
			Elements.clickElement(PageElements.HELP_MENU);
			
		}
		
		
		public static String getUserName(){
			Elements.isEnabled(PageElements.USERNAME_STATIC);
			return Elements.getText(PageElements.USERNAME_STATIC);
		}
		
		
	}
	
	public static class Header{
		public static class PageElements{
			//Page name
			
			public static final By PAGE_TITLE_STATIC = By.cssSelector("body > div > div:nth-child(2) > div > div > div.panel-body.itnPanelBody > div:nth-child(3) > div > div:nth-child(2) > div > div > div.col.col-sm-4.col-md-4.col-lg-3.itnColPadTop > div > strong > span");
			
			//Catalog Page
			public static final By CREATE_NEW_ITEM_LINK_CATALOG_PAGE = By.cssSelector("div[id='linkCreateNewItem'] > span");
			public static final By UPLOAD_ITEMS_LINK_CATALOG_PAGE = By.cssSelector("div[nav-id='linkUploadAndRegister'] > a[id='linkUploadAndRegister']");
			public static final By FIX_FAILED_ITEMS_LINK_CATALOG_PAGE = By.cssSelector("div[nav-id='linkFixFailedItems'] > a[id='linkFixFailedItems']");
			public static final By PUBLISH_ITEMS_LINK_CATALOG_PAGE = By.cssSelector("div[id='linkPublishItems'] > span");
			public static final By PUBLISH_TO_GROUP_LINK_PUBLICATION_PAGE = By.cssSelector("div[nav-id='publication_publishLink'] > a[id='publication_publishLink']");
			public static final By PUBLISH_ITEMS_LINK_SUBSCRIBER_ITEMS_PAGE = By.cssSelector("div[nav-id='subscriberItem_publishLink'] > a[id='subscriberItem_publishLink']");
			public static final By REVIEW_CICS_LINK_CATALOG_PAGE = By.cssSelector("div[nav-id='linkReviewCICs'] > a[id='linkReviewCICs']");
			public static final By MORE_DROPLIST_BUTTON_CATALOG_PAGE = By.cssSelector("div[id='linkMore'] > span");
			public static final By MORE_DROPLIST_CATALOG_PAGE = By.cssSelector("div[id='linkMore'] > ul");
			public static final By DOWNLOAD_ITEMS_CATALOG_PAGE = By.cssSelector("div[nav-id='linkDownloadItems'] > a[id='linkDownloadItems']");
			
			//Publishing Center
			//public static final By REVIEW_CIC_LINK_PUBLICATION_CENTER_PAGE = By.cssSelector("div[id='publication_reviewCICLink'] > span");
			public static final By REVIEW_CIC_LINK_PUBLICATION_CENTER_PAGE = By.cssSelector("div[nav-id='publication_reviewCICLink'] > a > span");
			
			// for the displaying counter 
			//public static final By REVIEW_CIC_ICON_NUMBER =By.cssSelector("a[id='publication_reviewCICLink'][ng-click='navLinkClicked()'] > span[class='itnIconImage'] > i > span[ng-show='navDisplayTotal']");
			public static final By REVIEW_CIC_ICON_NUMBER =By.cssSelector("#publication_reviewCICLink > span > span");
			
			//public static final By REVIEW_CIC_LINK_PUBLICATION_CENTER_PAGE = By.cssSelector("div[nav-id='publication_reviewCICLink'] > a[href id='publication_reviewCICLink'] > span[class='itnIconImage'] > i > span[ng-show='navDisplayTotal']");
			public static final By REVIEW_CIC_LINK_SUBSCRIBER_ITEM_PAGE = By.cssSelector("div[nav-id='subscriberItem_reviewCICLink'] > a");
			public static final By RPUBLISH_ITEMS_LINK_PUBLICATION_CENTER_PAGE = By.cssSelector("div[id='publication_publishLink'] > span");
			
			//Company Accounts Page
			public static final By ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE = By.cssSelector("div[id='company_addAccountLink'] > span");
			
			//User Accounts Page			
			public static final By ADD_USER_LINK_USER_ACCOUNT_PAGE = By.cssSelector("div[id='user_addUserLink'] > span");
			
			
			
			
		}
		
		public static String getPageTitle(){
			Elements.isEnabled(PageElements.PAGE_TITLE_STATIC);
			String pageName = Elements.getText(PageElements.PAGE_TITLE_STATIC);
			return pageName;					
		}
		
		
		
		public static void clickCreateNewItemLink(){
			Elements.isEnabled(PageElements.CREATE_NEW_ITEM_LINK_CATALOG_PAGE);
			Elements.clickElement(PageElements.CREATE_NEW_ITEM_LINK_CATALOG_PAGE);
		}
		
		public static void clickUploadAndRegisterLink(){			
			Elements.isEnabled(PageElements.UPLOAD_ITEMS_LINK_CATALOG_PAGE);
			Elements.clickElement(PageElements.UPLOAD_ITEMS_LINK_CATALOG_PAGE);
			
		}
		
		public static void clickFixFailedItemsLink(){
			Elements.isEnabled(PageElements.FIX_FAILED_ITEMS_LINK_CATALOG_PAGE);
			Elements.clickElement(PageElements.FIX_FAILED_ITEMS_LINK_CATALOG_PAGE);
			
		}
		
		public static void clickPublishItemsLink_CatalogPage(){
			Elements.isEnabled(PageElements.PUBLISH_ITEMS_LINK_CATALOG_PAGE);
			Elements.clickElement(PageElements.PUBLISH_ITEMS_LINK_CATALOG_PAGE);
		}
		
		public static void clickDownloadItemsLinkCatalogPage(){
			Elements.isEnabled(PageElements.DOWNLOAD_ITEMS_CATALOG_PAGE);
			Elements.clickElement(PageElements.DOWNLOAD_ITEMS_CATALOG_PAGE);
		}
		
		public static void clickPublishToGroupLink_PublicationPage(){
			Elements.isEnabled(PageElements.PUBLISH_TO_GROUP_LINK_PUBLICATION_PAGE);
			Elements.clickElement(PageElements.PUBLISH_TO_GROUP_LINK_PUBLICATION_PAGE);
		}
		
		public static void clickPublishItemsLink_SubscriberItemsPage(){
			Elements.isEnabled(PageElements.PUBLISH_ITEMS_LINK_SUBSCRIBER_ITEMS_PAGE);
			Elements.clickElement(PageElements.PUBLISH_ITEMS_LINK_SUBSCRIBER_ITEMS_PAGE);
			Elements.isDisappeared(PageElements.PUBLISH_ITEMS_LINK_SUBSCRIBER_ITEMS_PAGE, Config.pageLoadRetry);
		}
		
		public static void clickReviewCICsLinkPublicationCenterPage(){
			
			Elements.isEnabled(PageElements.REVIEW_CIC_LINK_PUBLICATION_CENTER_PAGE);
			Elements.clickElement(PageElements.REVIEW_CIC_LINK_PUBLICATION_CENTER_PAGE);
			
		}
		
		
		public static void clickReviewCICsLinkSubscribersItemPage(){
			
			Elements.isEnabled(PageElements.REVIEW_CIC_LINK_SUBSCRIBER_ITEM_PAGE);
			Elements.clickElement(PageElements.REVIEW_CIC_LINK_SUBSCRIBER_ITEM_PAGE);
			
		}
		
		public static void clickReviewCICsLinkCatalogPage(){
			
			Elements.isEnabled(PageElements.REVIEW_CICS_LINK_CATALOG_PAGE);
			Elements.clickElement(PageElements.REVIEW_CICS_LINK_CATALOG_PAGE);
			
		}
		
		public static void selectFromMore(More more){
			Elements.isEnabled(PageElements.MORE_DROPLIST_BUTTON_CATALOG_PAGE);
			Elements.clickElement(PageElements.MORE_DROPLIST_CATALOG_PAGE);
			Elements.clickElementInDropList(PageElements.MORE_DROPLIST_CATALOG_PAGE, "", more.toString());
			
		}
		
		public static void clickAddAccountLinkCompanyAccountPage(){
			Elements.isEnabled(PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
			Elements.clickElement(PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
			//Elements.waitForElementToBeVisible(Admin.PageElements.NEXT_BUTTON);
						
		}
		public static void clickAddUserLinkUserAccountPage(){
			Elements.clickElement(PageElements.ADD_USER_LINK_USER_ACCOUNT_PAGE);
			Elements.clickElement(PageElements.ADD_USER_LINK_USER_ACCOUNT_PAGE);
		}		
		
	}	
	
	
	public static class Breadcrumb{
		public static class PageElements{
			
			public static final By BREADCRUMB = By.cssSelector("ol[class*='breadcrumb']");
		}
		
		public static String getCurrentPage(){
			Elements.isEnabled(PageElements.BREADCRUMB);
			WebElement parent = Elements.find(PageElements.BREADCRUMB);
			List<WebElement> tree = Elements.findAll(parent, By.tagName("li"));
			//LogHandler.logInfo(tree.get(tree.size()-1).getText());			
			return tree.get(tree.size()-1).getText();
		}
		
		public static boolean verifyCurrentPage(BreadCrumbPage breadCrumbPage){
			String currentPage = getCurrentPage();	
			if(currentPage.equalsIgnoreCase(breadCrumbPage.toString())){
				return true;
			}
			else return false;
		}
		
		public static boolean isBreadCrumbVisible(){
			Elements.pauseExecution(1500);
			if(Elements.isClickable(PageElements.BREADCRUMB,Config.pageLoadRetry))
				return true;
			else
				return false;
			
		}
	}
	
	public static class IsLoading{
		public static class PageElements{			
			public static final By LOADER_IMAGE = By.cssSelector("div[is-loading='catalog.uiData.searchInProgress'] > div > center > img");
		}
		
		public static boolean isLoading(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			return MDS_Table.isLoading(PageElements.LOADER_IMAGE);			
			
		}
	}
	
	
	public static class Pagination{
		
		
		public static class PageElements{
			public static final By COUNT_25_BUTTON = By.cssSelector("div[template-url='templates.pagination'] > div > div > div > button:nth-child(1)" );
			public static final By COUNT_50_BUTTON = By.cssSelector("div[template-url='templates.pagination'] > div > div > div > button:nth-child(2)" );
			public static final By COUNT_100_BUTTON = By.cssSelector("div[template-url='templates.pagination'] > div > div > div > button:nth-child(3)" );
			public static final By COUNT_200_BUTTON = By.cssSelector("div[template-url='templates.pagination'] > div > div > div > button:nth-child(4)" );
			
			public static final By PAGE_NUMBER_BUTTONS = By.cssSelector("div[template-url='templates.pagination'] > div > div > ul");
		}
		
		public static void clickCount(int count){
			
				switch (count) {
				
				case 25: 	Elements.isEnabled(PageElements.COUNT_25_BUTTON);
							Elements.clickElement(PageElements.COUNT_25_BUTTON);
							while(IsLoading.isLoading())
								LogHandler.logInfo("Loading the Page");
							break;
							
				case 50: 	Elements.isEnabled(PageElements.COUNT_50_BUTTON);
							Elements.clickElement(PageElements.COUNT_50_BUTTON);
							while(IsLoading.isLoading())
								LogHandler.logInfo("Loading the Page");
							break;			
							
				case 100: 	Elements.isEnabled(PageElements.COUNT_100_BUTTON);
							Elements.clickElement(PageElements.COUNT_100_BUTTON);
							while(IsLoading.isLoading())
								LogHandler.logInfo("Loading the Page");
							break;
				case 200: 	Elements.isEnabled(PageElements.COUNT_200_BUTTON);
							Elements.clickElement(PageElements.COUNT_200_BUTTON);
							while(IsLoading.isLoading())
								LogHandler.logInfo("Loading the Page");
							break;
	
				default:	LogHandler.logInfo("Invalid Count : count should be 25, 50, 100 or 200");
							break;
				}
			
			}
		
		public static void clickPageNumber(int pageNumber){
			List<WebElement> pages = Elements.findAll(Elements.find(PageElements.PAGE_NUMBER_BUTTONS), By.tagName("li"));
			
			switch (pageNumber) {
			case -1: 	Elements.clickElement(pages.get(0),Config.sleep);
						while(IsLoading.isLoading())
							LogHandler.logInfo("Loading the Page");
						break;
						
			case 0: 	Elements.clickElement(pages.get(pages.size()),Config.sleep);
						while(IsLoading.isLoading())
							LogHandler.logInfo("Loading the Page");	
						break;			

			default:	for(int i=1; i<pages.size();i++){
							if(i==pageNumber){
								Elements.clickElement(pages.get(i),Config.sleep);
								while(IsLoading.isLoading())
									LogHandler.logInfo("Loading the Page");
							}				
						}						
						break;				
			}
			
		}
			
	}
	
	
	public static class MDS_Table{
		public static class PageElements {
			public static final By TABLE = By.cssSelector("div[id='itnSearchResultsGrid']");
		}
		
		
		public static By getColumnCSS(ColumnName columnName){
			
			switch (columnName) {
			
					case GTIN 						: 	return By.cssSelector("td[data-title*='gtin'] > a");	
					
					case GTIN_STATIC				: 	return By.cssSelector("td[data-title*='gtin']");
					
					case GTIN_STATIC_SUBSCRIBER		: 	return By.cssSelector("td[data-title*='subscribeToGtin']");
											
					case PRODUCT_CODE 				: 	return By.cssSelector("td[data-title*='productCode']");
					
					case ITEM_DESCRIPTION			:	return By.cssSelector("td[data-title*='description']");
					
					case REGISTRATION_STATUS		:	return By.cssSelector("td[data-title*='regStatus']");
					
					case NO_OF_SUBSCRIBERS			:	return By.cssSelector("td[data-title*='noOfSubscribers']");
					
					case NO_OF_SUBSCRIBERS_ARROW	:	return By.cssSelector("td[data-title*='noOfSubscribersArrow']");
					
					case CIC_REVIEW					:	return By.cssSelector("td[data-title*='cicReviewYesNo']");
					
					case LAST_UPDATE				:	return By.cssSelector("td[data-title*='modifiedTime']");
					
					case SUBSCRIBER_NAME			:	return By.cssSelector("td[data-title*='name'] > a");
					
					case GLN						:	return By.cssSelector("td[data-title*='gln']");
					
					case PUBLISHED					:	return By.cssSelector("td[data-title*='publishedCount']");
					
					case ACCEPTED					:	return By.cssSelector("td[data-title*='acceptedCount']");
					
					case REVIEW						:	return By.cssSelector("td[data-title*='reviewCount']");
					
					case REJECTED					:	return By.cssSelector("td[data-title*='rejectedCount']");
					
					case SYNCHRONIZED				:	return By.cssSelector("td[data-title*='syncronizedCount']");
					
					case COMPANY_NAME				:	return By.cssSelector("td[data-title*='companyname']");
					
					case INDUSTRY_SEGMENT			:	return By.cssSelector("td[data-title*='industrySegment']");
					
					case COMPANY_ROLES				:	return By.cssSelector("td[data-title*='companyRoles']");
					
					case ENTRUSTMENTS				:	return By.cssSelector("td[data-title*='enstrustments']");
					
					case USERS						:	return By.cssSelector("td[data-title*='users']");
					
					case STATUS_COMPANY_ACCOUNTS_PAGE		:	return By.cssSelector("td[data-title*='status']");
					
					case EDIT_USER_LINK				:	return By.cssSelector("td > a[ng-click='showEditUser(results)']");
					
					case LAST_NAME					:	return By.cssSelector("td[data-title*='lastName']");
					
					case FIRST_NAME					:	return By.cssSelector("td[data-title*='firstName']");
					
					case USER_ROLE					:	return By.cssSelector("td[data-title*='roleDescription']");
					
					case TITLE						:	return By.cssSelector("td[data-title*='title']");
					
					case EMAIL						:	return By.cssSelector("td[data-title*='email']");
					
					case PHONE						:	return By.cssSelector("td[data-title*='phone']");
					
					case USER_NAME					:	return By.cssSelector("td[data-title*='login']");			
					
					case PASSWORD					:	return By.cssSelector("td[data-title*='password'] > a");
					
					case STATUS_USER_ACCOUNTS_PAGE	:	return By.cssSelector("td[data-title*='status']");
					
					case LAST_UPLOAD_DATE			:	return By.cssSelector("td[data-title*='lastUploadDate'] > span");
					
					case PUBLISHER_NAME				:	return By.cssSelector("td[data-title*='publisherName']");
					
					case PUBLISHER_GLN				:	return By.cssSelector("td[data-title*='publisherGln']");
					
					case PRODUCT_GPC				:	return By.cssSelector("td[data-title*='productGpc']");
					
					case SUBSCRIBER_GLN				:	return By.cssSelector("td[data-title*='subscriberGln']");
					
					case STATUS_GDSN_SUBSCRIPTION	:	return By.cssSelector("td[data-title*='status'] > div > div");
					
					case PUBLISHER_NAME_DATA_QUALITY :	return By.cssSelector("td[data-title*='name'] > a");
					
					case TOTAL_MATCHED 				:	return By.cssSelector("td[data-title*='matchTotalCount'] > a");
					
					case TOTAL_UNMATCHED 				:	return By.cssSelector("td[data-title*='totalUnMatched'] > a");
					
					case PUBLISHED_COUNT			:	return By.cssSelector("td[data-title*='publishedItemsCount']");
		
					default: return null;
				
			}
			
		}
		
		public static void clickFirstElementInMDSTable(ColumnName columnName){
			
			Elements.pauseExecution(5000);
			
			By columnCss = getColumnCSS(columnName);
			List<WebElement> columnData = Elements.findAll(columnCss);
			DriverManager.getDataSet().putIntoDataMap(common.Config.DataKeys.FIRST_ROW_TEXT, Elements.getText(columnData.get(0)));
			Elements.clickElement(columnData.get(0),Config.sleep);
			checkPageLoad();
			
		}
		
		public static int getTotalNumberOfRowsFromMDSTable(ColumnName columnName){
			Elements.pauseExecution(Config.sleep);
			By columnCss = getColumnCSS(columnName);
			List<WebElement> columnData = Elements.findAll(columnCss);
			return columnData.size();
			
		}
		
		
		public static List<String> getColumnData(ColumnName columnName){
			LogHandler.logInfo("Fetching column Data");
			List<String> data = new ArrayList<String>();
			Elements.pauseExecution(5000);
			final By columnCss = getColumnCSS(columnName);
			//System.out.println("******   "+columnCss.toString());
			List<WebElement> columnData = Elements.findAll(columnCss);
			
			for(int i=0; i<columnData.size();i++){			
				data.add(columnData.get(i).getText());
				}		
			return data;
		}
		
		public static boolean verifyColumnData(ColumnName columnName, String text){
			IsLoading.isLoading();
			List<String> data = getColumnData(columnName);
			boolean flag = true;
			for(int i=0; i<data.size();i++){
				if(!data.get(i).contains(text)){
					if(!data.get(i).isEmpty()){
					flag= false;
					break;
					}
				}			
			}
			
			return flag;
		}
		
		public static boolean isLoading(By locator){
			try{
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 3);
				wait.withTimeout(3, TimeUnit.SECONDS);
				wait.pollingEvery(500, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				wait.ignoring(NoSuchElementException.class);
				if(DriverManager.getDriver().findElement(locator)!=null){
				    	LogHandler.logInfo("Element :"+locator+" exist");
				    	 return true;
				    }
				else
					return true;
			}catch(Exception e){
				LogHandler.logInfo("Page Successfully loaded..");
				return false;
			}
		}
		
		public static List<String> getColumnNames(){
			List<String> columnNames = new ArrayList<String>();
			Elements.isEnabled(PageElements.TABLE);
			WebElement table = Elements.find(PageElements.TABLE);
			
			List<WebElement> headers = Elements.findAll(table, By.cssSelector("th"));
			
			for(int i = 0; i<headers.size(); i++){
				if(headers.get(i).isEnabled()){
					String label = headers.get(i).getText();
					columnNames.add(label);					
				}				
			}
			
			return columnNames;
			
		}
		
		public static boolean isColumnPresent(ColumnName columnName){
			List<String> allColumns = getColumnNames();
			for(int i=0; i<allColumns.size(); i++){
				if(allColumns.get(i).contains(columnName.toString()))
					return true;		
			}
			
			return false;
		}
		
		public static int getIndexOfDataFromColumn(ColumnName columnName , String value){
			List<String> data = MDS_Table.getColumnData(columnName);			
			int i;
			for(i=0; i<data.size();i++){
				if(data.get(i).equals(value)){
					return i;
				}
			}
			
			return i;
		}
		
		public static void clickNthIndexOfColumn(ColumnName columnName, int index){
			final By columnCss = getColumnCSS(columnName);
			List<WebElement> columnData = Elements.findAll(columnCss);
			Elements.clickElement(columnData.get(index), Config.wait);
			
		}
	}
	
	public static void checkPageLoad(){
		while(IsLoading.isLoading())
			LogHandler.logInfo("Loading the page...");
	}
	
	
	public static class AddRemoveTable{
		
		public static void searchInLeftTable(By searchTextbox ,String searchString){
			Elements.isEnabled(searchTextbox);
			WebElement searchBox = Elements.find(searchTextbox);
			Elements.typeIN(searchBox, searchString);
			
		}
		
		public static void searchInLeftTableAndAddtoRightTable(By searchTextbox , By list,String searchString){
			
			searchInLeftTable(searchTextbox ,searchString);
			
			List<WebElement> searchList = Elements.findAll(list);
			for(int i=0; i<searchList.size(); i++){
				//System.out.println("***************"+searchList.get(i).getAttribute("textContent"));
				if(searchList.get(i).getAttribute("textContent").trim().contains(searchString))
					searchList.get(i).findElement(By.tagName("a")).click();
			}			
		}
		
		public static boolean verifyInTable(By searchTextbox , By list,String searchString){
			searchInLeftTable(searchTextbox ,searchString);
			List<WebElement> searchList = Elements.findAll(list);
			for(int i=0; i<searchList.size(); i++){
				//System.out.println("*****\n\n"+searchList.get(i).getAttribute("textContent"));
				if(searchList.get(i).getAttribute("textContent").equalsIgnoreCase(searchString))
					return true;
			}	
			
			return false;
		}	
		
	}	
	
	public static class Admin{
		
		
		public static class PageElements{			
			//Wizards
			public static final By COMPANY_INFORMATION_WIZARD = By.cssSelector("a[id='companyWizardCompanyInformation']");
			public static final By COMPANY_ROLES_WIZARD = By.cssSelector("a[id='companyWizardCompanyRoles']");
			public static final By INTEGRATIONS_APPLICATIONS_WIZARD = By.cssSelector("a[id='companyWizardIntegerationsApplications']");
			public static final By ENTRUSTMENTS_WIZARD = By.cssSelector("a[id='companyWizardEntrustments']");
			public static final By USER_ACCOUNTS_WIZARD = By.cssSelector("a[id='companyWizardUserAccounts']");
			
			//Footer Buttons
			public static final By CANCEL_LINK = By.cssSelector("a[id='cancel']");
			public static final By CANCEL_BUTTON = By.cssSelector("button[id='close']");
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			public static final By NEXT_BUTTON =By.cssSelector("button[id='wizardNext']");
			public static final By PREVIOUS_BUTTON =By.cssSelector("button[id='wizardPrevious']");
			public static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector("button[id='SaveAndCloseUseraccounts']");
			
			
			//Edit Button - Available on View Company Page for all tabs
			public static final By EDIT_BUTTON = By.cssSelector("button[ng-click*='companyinformationedit']");
			
			//
			public static final By SAVE_CHANGES_BUTTON = By.cssSelector("button[id='saveChanges']");
		
		}
		
		public static void goToCompanyInformationWizard(){
			Elements.isEnabled(PageElements.COMPANY_INFORMATION_WIZARD);
			Elements.clickElement(PageElements.COMPANY_INFORMATION_WIZARD);
			
		}
		
		public static void goToCompanyRolesWizard(){
			Elements.isEnabled(PageElements.COMPANY_ROLES_WIZARD);
			Elements.clickElement(PageElements.COMPANY_ROLES_WIZARD);
		}
		
		
		public static void goToIntegrationsApplicationsWizard(){
			Elements.isEnabled(PageElements.INTEGRATIONS_APPLICATIONS_WIZARD);
			Elements.clickElement(PageElements.INTEGRATIONS_APPLICATIONS_WIZARD);
		}
		
		public static void goToEntrustmentsWizard(){
			Elements.isEnabled(PageElements.ENTRUSTMENTS_WIZARD);
			Elements.clickElement(PageElements.ENTRUSTMENTS_WIZARD);
		}
		
		public static void goToUserAccountsWizard(){
			Elements.isEnabled(PageElements.USER_ACCOUNTS_WIZARD);
			Elements.clickElement(PageElements.USER_ACCOUNTS_WIZARD);		
		}	
		
		
		public static void clickCancelLink(){
			Elements.isEnabled(PageElements.CANCEL_LINK);
			Elements.clickElement(PageElements.CANCEL_LINK);
		}
		
		public static void clickCancelButton(){
			Elements.isEnabled(PageElements.CANCEL_BUTTON);
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			while(Elements.isVisible(PageElements.SAVE_AND_CLOSE_BUTTON)){
				Elements.pauseExecution(1000);
			}
			while(IsLoading.isLoading())
				LogHandler.logInfo("Loading the page...");
		}
		
		public static void clickNextButton(){
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
		}
		
		public static void clickPreviousButton(){
			Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
			Elements.clickElement(PageElements.PREVIOUS_BUTTON);
		}
		
		public static void clickCreateNewAccountButton(){
			Elements.isEnabled(PageElements.CREATE_NEW_ACCOUNT_BUTTON);
			Elements.clickElement(PageElements.CREATE_NEW_ACCOUNT_BUTTON);
		}
		
		public static void clickEditPageButton(){
			Elements.isEnabled(PageElements.EDIT_BUTTON);
			Elements.clickElement(PageElements.EDIT_BUTTON);
		}
		
		public static void clickSaveChangesButton(){
			Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
			Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
		}
	}
	
	public static void waitForPageToLoad(String pageURLEndsWith){
		int count = 0;
		while(true){
			//System.out.println("waiting for page load");
			Elements.pauseExecution(1500);
			String url = Elements.getCurrentURL();
			if(url.endsWith(pageURLEndsWith) || count>30){
				//Elements.pauseExecution(1500);
				System.out.println("page loaded succesfully");
				break;
			}
			
			count++;
		}
	}
	
	public static void waitForElementToBeVisible(By locator){
		int count = 0;
		while(true){
			//System.out.println("waiting for Element to be visible");
			Elements.pauseExecution(1500);			
			if(Elements.isVisible(locator) || count>Config.pageLoadRetry){
				Elements.pauseExecution(1500);
				//System.out.println("Element is visible now");
				break;
			}
			
			count++;
		}
	}
	
}
