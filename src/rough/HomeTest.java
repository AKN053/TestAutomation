package rough;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.Enumerations.CatalogActivities;
import common.Enumerations.PublishingActivities;
import framework.helpers.Elements;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

@Listeners({framework.providers.WebDriverListener.class})
public class HomeTest extends BasePage {

	@Test
	public static void CatalogUploadFileLinkHomePage(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickGetCatalogUploadFileLink();
	}
	
	@Test
	public static void UploadAndRegisterLinkHomePage(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickUploadAndRegisterLink();
	}
	
	@Test 
	public static void FixFailedItemsHomePage(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickFixFailedItemsLink();
	}
	
	@Test
	public static void CatalogActivitiesDropdownHome(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		
		HomePage.clickCatalogActivitiesDropdown();
		Elements.pauseExecution(1000);
		System.out.println("Done");
		HomePage.selectFromCatalogActivities(CatalogActivities.FIX_FAILED_ITEMS);
		System.out.println("*************Fix Failed**************");
		
		MenuBar.clickHome();
		HomePage.selectFromCatalogActivities(CatalogActivities.UPLOAD_AND_REGISTER);
		System.out.println("*************Catalog Upload File**************");
		
				
		MenuBar.clickHome();
		HomePage.selectFromCatalogActivities(CatalogActivities.GET_CATALOG_UPLOAD_FILE);
		System.out.println("*************Catalog Upload File**************");
		
				
		MenuBar.clickHome();
		HomePage.selectFromCatalogActivities(CatalogActivities.DOWNLOAD_ITEMS);
		System.out.println("*************Download Items**************");
		
		
		MenuBar.clickHome();
		HomePage.selectFromCatalogActivities(CatalogActivities.DELETE_RECORDS);
		System.out.println("*************Delete Records**************");
		
		
		
		MenuBar.clickHome();
		HomePage.selectFromCatalogActivities(CatalogActivities.GO_TO_CATALOG);
		System.out.println("*************Go To Catalog**************");
	}
	
	
	@Test
	public static void clickReviewCICLinkHome(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickReviewCICLink();
	}
	
	@Test
	public static void clickUnpublishItemsLink(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickUnpublishItems();
		System.out.println("Clicked");
	}
	
	@Test
	public static void PublishingActivitiesDropdownHome(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		
		HomePage.clickPublishingActivitiesDropdown();
		Elements.pauseExecution(1000);
		System.out.println("Done");
		HomePage.selectFromPublishingActivities(PublishingActivities.GO_TO_PUBLISHING_CENTER);
		System.out.println("*************Go To Publishing Center**************");
		
		MenuBar.clickHome();
		HomePage.selectFromPublishingActivities(PublishingActivities.PUBLISH_ITEMS);
		System.out.println("*************Publish Items**************");
		
		MenuBar.clickHome();
		HomePage.selectFromPublishingActivities(PublishingActivities.REVIEW_CICS);
		System.out.println("*************Review CICs**************");
		
		MenuBar.clickHome();
		HomePage.selectFromPublishingActivities(PublishingActivities.UNPUBLISH_ITEMS);
		System.out.println("*************Unpublished Items**************");
		
	}
	
	
	@Test
	public static void subscriberNameLink(){
		LoginPage.loginSuplierUser();
		MenuBar.clickHome();
		HomePage.clickSubscriberNameLink();
		System.out.println("#################");
		
	}
}
