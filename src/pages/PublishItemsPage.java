package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Config;
import common.Enumerations.ColumnName;
import framework.helpers.Elements;

public class PublishItemsPage extends BasePage{	
	
	public static class PageElements{		
		public static final By SELECT_SUBSCRIBERS_WIZARD_LINK = By.cssSelector("a[id='publicationPublishSubscriber'][ng-click='moveWizardToSubscriber()']");
		public static final By CHOOSE_ITEMS_WIZARD_LINK = By.cssSelector("a[id='publicationPublishItem'][ng-click='moveWizardToItem()']");
		public static final By CANCEL_LINK = By.cssSelector("a[ng-click='goToPublication()'][id='publishCancel']");	
		public static final By NEXT_BUTTON = By.cssSelector("button[id='publishNext']");
		public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='publishBack']");
		//public static final By PUBLISH_ITEMS_BUTTON = By.cssSelector("button[id='publish']");
	}
	
	public static void clickSelectSubscribersWizard(){
		Elements.isEnabled(PageElements.SELECT_SUBSCRIBERS_WIZARD_LINK);
		Elements.clickElement(PageElements.SELECT_SUBSCRIBERS_WIZARD_LINK);
	}
	
	
	public static void clickChooseItemsWizard(){
		Elements.isEnabled(PageElements.CHOOSE_ITEMS_WIZARD_LINK);
		Elements.clickElement(PageElements.CHOOSE_ITEMS_WIZARD_LINK);
	}
	
	public static void clickCancelLink(){
		Elements.isEnabled(PageElements.CANCEL_LINK);
		Elements.clickElement(PageElements.CANCEL_LINK);
	}
	
	public static void clickNextButton(){
		Elements.isEnabled(PageElements.NEXT_BUTTON);
		Elements.clickElement(PageElements.NEXT_BUTTON);
	}
	
	public static void clickNextButtonAndWaitForNextPageToLoad(){
		Elements.isEnabled(PageElements.NEXT_BUTTON);
		Elements.clickElement(PageElements.NEXT_BUTTON);
		while(IsLoading.isLoading())
			System.out.println("Loading next Page");
	}
	
	public static boolean verifyNextButtonAvailable(){
		Elements.pauseExecution(4000);
		if(Elements.isClickable(PageElements.NEXT_BUTTON, Config.wait))
			return true;
		else
			return false;
	}
	
	public static void clickPreviousButton(){
		Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
		Elements.clickElement(PageElements.PREVIOUS_BUTTON);
	}
	
	/*public static void clickPublishItemsButton(){
		Elements.isEnabled(PageElements.PUBLISH_ITEMS_BUTTON);
		Elements.clickElement(PageElements.PUBLISH_ITEMS_BUTTON);
	}*/
	
	
	
	/**
	 * Select Subscriber Wizard
	 * @author prashantc
	 *
	 */
	public static class SelectSubscribers{
		
		public static class PageElements{
			
			public static final By CHOOSE_EXISTING_TAB = By.cssSelector("a[role='tab'][data-index='0']");
			public static final By ADD_NEW_TAB = By.cssSelector("a[role='tab'][data-index='1']");
			
			//Choose Existing Tab
			public static final By AVAILABLE_SUBSCRIBERS_TABLE = By.cssSelector("div[id='existingSubscriber']");
			public static final By SELECTED_SUBSCRIBERS_TABLE = By.cssSelector("div[class='col-md-5'] > div[class='form-group'] > div[class='itnBox']");
			
			//Add New Tab
			public static final By ADD_NEW_SUBSCRIBER_GLN_TEXTBOX = By.cssSelector("input[name='newSubscriberText']");
			public static final By ADD_BUTTON = By.cssSelector("button[ng-click='addNewSubscriber()']");
			public static final By ADD_NEW_TABLE = By.cssSelector("div[class='col-md-5'] > div[class='form-group'] > div[class='itnBox']");
			
			//Publishing Type
			public static final By INITIAL_LOAD_RADIO = By.cssSelector("input[type='radio'][name='650']");
			public static final By NEW_RADIO = By.cssSelector("input[type='radio'][name='651']");		
			
			public static final By SEARCH_TEXTBOX_AVAILABLE_SUBSCRIBERS = By.cssSelector("input[ng-model='searchExistingSubscriber']");
			public static final By SEARCH_TEXTBOX_SELECTED_SUBSCRIBERS = By.cssSelector("input[ng-model='searchSelectedSubscriber']");
			
			public static final By AVAILABLE_SUBSCRIBERS_LIST = By.cssSelector("div[title='Add Subscriber'][ng-click='addSubscriber(subscriber)']");
			public static final By SELECTED_SUBSCRIBERS_LIST = By.cssSelector("div[title='Remove Subscriber']");
									
		}
		
		public static void selectFirstAvailableSubscriber(){
			List<WebElement> data = Elements.findAll(PageElements.AVAILABLE_SUBSCRIBERS_LIST);		
			List<WebElement> subscriber = Elements.findAll(data.get(0), By.tagName("i"));
			Elements.clickElement(subscriber.get(0), Config.sleep);
		}
		
		public static void selectSubscriberFromAvailableSubscribersTable(String subscriber){
			AddRemoveTable.searchInLeftTableAndAddtoRightTable(PageElements.SEARCH_TEXTBOX_AVAILABLE_SUBSCRIBERS, PageElements.AVAILABLE_SUBSCRIBERS_LIST, subscriber);		
		}
		
		public static boolean verifyInAvailableSubscribersTable(String subscriber){
			if(AddRemoveTable.verifyInTable(PageElements.SEARCH_TEXTBOX_AVAILABLE_SUBSCRIBERS, PageElements.AVAILABLE_SUBSCRIBERS_LIST, subscriber))
				return true;
			else
				return false;			
		}
		
		
		public static void removeSubscriberFromSelectedSubscribersTable(String subscriber){
			AddRemoveTable.searchInLeftTableAndAddtoRightTable(PageElements.SEARCH_TEXTBOX_SELECTED_SUBSCRIBERS, PageElements.SELECTED_SUBSCRIBERS_LIST, subscriber);
			
		}
		
		public static boolean verifyInSelectedSubscriberTable(String subscriber){
			if(AddRemoveTable.verifyInTable(PageElements.SEARCH_TEXTBOX_SELECTED_SUBSCRIBERS, PageElements.SELECTED_SUBSCRIBERS_LIST, subscriber))
				return true;
			else
				return false;
		}
	}
	
	public static class ChooseItems{
		public static class PageElements{
			public static final By KEYWORD_SEARCH_TEXTBOX = By.cssSelector("input[id='registrationKeyword']");
			public static final By SELECT_GTIN_CHECKBOXES = By.cssSelector("span[class='checkboxNative'] > input[type='checkbox']");
			public static final By PUBLISH_ITEMS_BUTTON = By.cssSelector("button[ng-click='publishItems()']");
			
			//Confirmation Dialogue
			public static final By MESSAGE_TEXT = By.cssSelector("div[class='modal-dialog'] > div > div[class='modal-body'] > div > div[ng-show='showITNPanelContent'] > div:nth-child(3) > div > div:nth-child(1) > div > span > span");			
		}
		
		public static void setKeywordTextbox(String data){
			Elements.isEnabled(PageElements.KEYWORD_SEARCH_TEXTBOX);
			Elements.clearAndType(PageElements.KEYWORD_SEARCH_TEXTBOX, data);
		}
		
		public static void selectFirstNGTIN(int noOfGTINsToBeSelected){
			List<WebElement> data = Elements.findAll(PageElements.SELECT_GTIN_CHECKBOXES);
			
			for(int i=1; i<=noOfGTINsToBeSelected;i++){
				if(i==data.size())
					break;
				else
					//Elements.clickElement(data.get(i),Config.wait);
					data.get(i).click();
			}
		}
		
		
		public static String clickPublishItemsButton(){
			Elements.isEnabled(PageElements.PUBLISH_ITEMS_BUTTON);
			Elements.clickElement(PageElements.PUBLISH_ITEMS_BUTTON);			
						
			return Elements.getText(PageElements.MESSAGE_TEXT);
		}
		
		public static int getTotalRowsAvailable(){
			return MDS_Table.getTotalNumberOfRowsFromMDSTable(ColumnName.GTIN_STATIC);
		}
		
		
	}

}
