package testCases.module1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.Config;
import common.Enumerations.ColumnName;
import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;
import pages.BasePage.Breadcrumb;
import pages.BasePage.Header;
import pages.BasePage.Header.PageElements;
import pages.BasePage.MDS_Table;
import pages.LoginPage;
import pages.BasePage.MenuBar;
import pages.PublishItemsPage;
import pages.PublishingCenterPage;
import pages.ReviewCICsPage;
import pages.SubscribersItemPage;
import testCases.TestBase;


@Listeners({framework.providers.WebDriverListener.class})
public class PublishingCenter extends TestBase{
	
	@Test
	public void verifyAvailableColumns(){
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishingCenter();	
		VerifyAsserts.verifyTrue(PublishingCenterPage.verifyAvailableColumns());
	}
	
	@Test
	public void subscribersItemSplitHeader(){
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.SUBSCRIBER_NAME);
		String data = SubscribersItemPage.getFirstGTIN();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);
				
		VerifyAsserts.verifyTrue(SubscribersItemPage.SplitScreen.getHeader().contains(data));		
	}
	
	
	@Test
	public void reviewCICs(){
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		
		String count= Elements.getText(Header.PageElements.REVIEW_CIC_ICON_NUMBER);
	    int counter=Integer.parseInt(count);
		System.out.println(counter);
		
		if (counter > 0) {
		Header.clickReviewCICsLinkPublicationCenterPage();
		
		VerifyAsserts.verifyTrue(ReviewCICsPage.getSelectedSubscriber().equalsIgnoreCase("All Subscribers"));
		
		VerifyAsserts.verifyTrue(ReviewCICsPage.verifyAvailableColumns());	
		}
	   else{
		   System.out.println("Review CIC Link is disabled");
	   }
	}
	
	
	/*@Test
	public void reviewCICsSelectedSubscriber(){		
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		String data = PublishingCenterPage.getFirstSubscriberName();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.SUBSCRIBER_NAME);
		Header.clickReviewCICsLinkSubscribersItemPage();		
		VerifyAsserts.verifyTrue(ReviewCICsPage.getSelectedSubscriber().equalsIgnoreCase(data));
		
		VerifyAsserts.verifyTrue(ReviewCICsPage.verifyAvailableColumns());
	}*/
	
	@Test
	public void returnToPublishingCenter(){
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		String count= Elements.getText(Header.PageElements.REVIEW_CIC_ICON_NUMBER);
	    int counter=Integer.parseInt(count);
		System.out.println(counter);
		
		if (counter > 0) {
		Header.clickReviewCICsLinkPublicationCenterPage();
		ReviewCICsPage.clickReturnToPublishingCenterLink();
		
		VerifyAsserts.verifyTrue(Breadcrumb.getCurrentPage().equalsIgnoreCase("Publishing Center"));
		}
		else{
			System.out.println("Review CIC Link is disabled");
		}
	}
	
	
	@Test
	public void mandatorySelectionOnPublishItems(){
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		Header.clickPublishToGroupLink_PublicationPage();
		PublishItemsPage.clickNextButton();
		VerifyAsserts.verifyTrue(PublishItemsPage.verifyNextButtonAvailable());
	}
	
	@Test
	public void publishItemsThroughSubscriber(){
		//LoginPage.loginGDSNUser();
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishingCenter();		
		MDS_Table.clickFirstElementInMDSTable(ColumnName.SUBSCRIBER_NAME);
		Header.clickPublishItemsLink_SubscriberItemsPage();
		MDS_Table.isColumnPresent(ColumnName.GTIN);
		MDS_Table.isColumnPresent(ColumnName.PRODUCT_CODE);
		MDS_Table.isColumnPresent(ColumnName.DESCRIPTION);
		MDS_Table.isColumnPresent(ColumnName.LASTUPDATED);
	}
	
	@Test
	public void publishingItemSuccessfully(){
		LoginPage.loginSuplierUser();
		//LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		Header.clickPublishToGroupLink_PublicationPage();
		PublishItemsPage.SelectSubscribers.selectFirstAvailableSubscriber();
		PublishItemsPage.clickNextButtonAndWaitForNextPageToLoad();
				
		if(PublishItemsPage.ChooseItems.getTotalRowsAvailable()!=0){
			PublishItemsPage.ChooseItems.selectFirstNGTIN(1);
			String msg = PublishItemsPage.ChooseItems.clickPublishItemsButton();
			VerifyAsserts.verifyEquals(msg, "All items are published successfully.");
					
		}
		
	}
}
