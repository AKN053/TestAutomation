package pages;

import org.openqa.selenium.By;

import common.Enumerations.CatalogActivities;
import common.Enumerations.PublishingActivities;
import framework.helpers.Elements;

public class HomePage {
	
	public static class PageElements{
		
		public static final By GET_CATALOG_UPLOAD_FILE_LINK = By.cssSelector("a[id='getGtinTemplate'] > div");
		public static final By UPLOAD_AND_REGISTER_LINK = By.cssSelector("a[id='uploadAndRegister'] > div");
		public static final By FIX_FAILED_ITEMS_LINK = By.cssSelector("a[id='fixFailedItemsWithCount'] > div");
		
		//public static final By CATALOG_ACTIVITIES_DROPDOWN = By.cssSelector("div[id='catalogActivities'] > i[bs-dropdown='catalogActivitiesDropdown'] >ul[role='menu']");
		public static final By CATALOG_ACTIVITIES_DROPDOWN = By.cssSelector("#catalogActivities > i");
		public static final By PUBLISHING_ACTIVITIES_DROPDOWN = By.cssSelector("div[id='publishingActivities'] > i[class*='fa']");
		
		public static final By REVIEW_CIC_LINK = By.cssSelector("div[class*='itnFooterPanelText']");
		public static final By UNPUBLISH_ITEMS = By.cssSelector("a[id='unpublishItemsWithCount'] > div[class*='itnPanelText']");
		
		public static final By SUBSCRIBER_NAME_LINK = By.cssSelector("div[id='subscribers'] > p > a[ng-click*='goToPublicationSubscriberItem']");
	}
	
	public static void clickGetCatalogUploadFileLink(){
		Elements.isEnabled(PageElements.GET_CATALOG_UPLOAD_FILE_LINK);
		Elements.clickElement(PageElements.GET_CATALOG_UPLOAD_FILE_LINK);
	}
	
	public static void clickUploadAndRegisterLink(){
		Elements.isEnabled(PageElements.UPLOAD_AND_REGISTER_LINK);
		Elements.clickElement(PageElements.UPLOAD_AND_REGISTER_LINK);
	}
	
	public static void clickFixFailedItemsLink(){
		Elements.isEnabled(PageElements.FIX_FAILED_ITEMS_LINK);
		Elements.clickElement(PageElements.FIX_FAILED_ITEMS_LINK);
	}
	
	public static void clickCatalogActivitiesDropdown(){
		Elements.isEnabled(PageElements.CATALOG_ACTIVITIES_DROPDOWN);
		Elements.clickElement(PageElements.CATALOG_ACTIVITIES_DROPDOWN);
	}
	
	public static void selectFromCatalogActivities(CatalogActivities catalogAtivities){
		Elements.isEnabled(PageElements.CATALOG_ACTIVITIES_DROPDOWN);
		Elements.clickElement(PageElements.CATALOG_ACTIVITIES_DROPDOWN);
		Elements.selectOption(PageElements.CATALOG_ACTIVITIES_DROPDOWN, catalogAtivities.toString());
		
	}
	public static void clickReviewCICLink(){
		Elements.isEnabled(PageElements.REVIEW_CIC_LINK);
		Elements.clickElement(PageElements.REVIEW_CIC_LINK);
	}
	
	public static void clickUnpublishItems(){
		Elements.isEnabled(PageElements.UNPUBLISH_ITEMS);
		Elements.clickElement(PageElements.UNPUBLISH_ITEMS);
	}
	
	public static void clickPublishingActivitiesDropdown(){
		Elements.isEnabled(PageElements.PUBLISHING_ACTIVITIES_DROPDOWN);
		Elements.clickElement(PageElements.PUBLISHING_ACTIVITIES_DROPDOWN);
	}
	
	public static void selectFromPublishingActivities(PublishingActivities publishingActivities){
		Elements.isEnabled(PageElements.PUBLISHING_ACTIVITIES_DROPDOWN);
		Elements.clickElement(PageElements.PUBLISHING_ACTIVITIES_DROPDOWN);
		Elements.selectOption(PageElements.PUBLISHING_ACTIVITIES_DROPDOWN, publishingActivities.toString());
	}
	
	public static void clickSubscriberNameLink(){
		Elements.isEnabled(PageElements.SUBSCRIBER_NAME_LINK);
		Elements.clickElement(PageElements.SUBSCRIBER_NAME_LINK);
	}
	
}
