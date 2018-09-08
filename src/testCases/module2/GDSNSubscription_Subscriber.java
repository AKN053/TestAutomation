package testCases.module2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.Config;
import common.Enumerations.ColumnName;
import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;
import pages.BasePage.MDS_Table;
import pages.BasePage.MenuBar;
import pages.GDSNSubscriptions;
import pages.LoginPage;


@Listeners({framework.providers.WebDriverListener.class})
public class GDSNSubscription_Subscriber {
	
	@Test
	public void GTINSearch(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		String data = GDSNSubscriptions.getFirstGTIN();
		GDSNSubscriptions.searchFirstGTIN();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.GTIN_STATIC_SUBSCRIBER, data));
	}
	
	@Test
	public void publisherNameSearch(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		String data = GDSNSubscriptions.getFirstPublisherName();
		GDSNSubscriptions.performSearch(data);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PUBLISHER_NAME, data));
	}
	
	@Test
	public void publisherGLNSearch(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		String data = GDSNSubscriptions.getFirstPublisherGLN();
		GDSNSubscriptions.performSearch(data);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PUBLISHER_GLN, data));
	}
	
	@Test
	public void productGPCSearch(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		String data = GDSNSubscriptions.getFirstProductGPC();
		String subGLN = GDSNSubscriptions.getNthPublisherGLN(Config.dataIndex);		
		GDSNSubscriptions.performSearch(subGLN);
		VerifyAsserts.verifyTrue(!MDS_Table.verifyColumnData(ColumnName.PRODUCT_GPC, data));
	}
	
	@Test
	public void subscriberGLNSearch(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		String data = GDSNSubscriptions.getfirstSubscriberGLN();
		GDSNSubscriptions.performSearch(data);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.SUBSCRIBER_GLN, data));
		
	}
	
	@Test
	public void validFilter(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.checkValidCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.STATUS_GDSN_SUBSCRIPTION, "Valid"));
	}
	
	@Test
	public void inProcessFilter(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.checkInProcessCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.STATUS_GDSN_SUBSCRIPTION, "InProcess"));
	}
	
	
	@Test
	public void inValidFilter(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.checkInValidCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.STATUS_GDSN_SUBSCRIPTION, "InValid"));
	}
	
	@Test
	public void cancelledFilter(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.checkCancelledCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.STATUS_GDSN_SUBSCRIPTION, "Cancelled"));
	}
	
	@Test
	public void resetFilter(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.checkCancelledCheckbox();
		GDSNSubscriptions.clickResetFilterLink();
		VerifyAsserts.verifyTrue(GDSNSubscriptions.verifyFilterReset());
		
	}
	
	@Test
	public void createSubscriptionValidation(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.clickCreateSubscriptionLink();
		GDSNSubscriptions.CreateASubscription.clickCreateSubscriptionButton();		
		VerifyAsserts.verifyTrue(GDSNSubscriptions.CreateASubscription.verifyPublisherGLNRequiredFieldPresent());
	}
	
	@Test
	public void createSubscriptionCancel(){		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		GDSNSubscriptions.clickCreateSubscriptionLink();
		GDSNSubscriptions.CreateASubscription.clickCancelLink();
		VerifyAsserts.verifyTrue(GDSNSubscriptions.CreateASubscription.verifyOverlayPresent());
	}
	
	@Test
	public void createSubscriptionGTIN(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		
		int index = GDSNSubscriptions.getIndexWherePublisherGLN_And_GTIN_exists();		
		
		String gln = GDSNSubscriptions.getNthPublisherGLN(index);
		String gtin = GDSNSubscriptions.getNthGTIN(index);
		int subscriptionCount = GDSNSubscriptions.getSubscriptionCount();
		
		GDSNSubscriptions.clickCreateSubscriptionLink();	
		
		
		GDSNSubscriptions.CreateASubscription.fillPublisherGLN(gln);
		GDSNSubscriptions.CreateASubscription.fillGTIN(gtin);
		GDSNSubscriptions.CreateASubscription.clickCreateSubscriptionButton();
		Elements.pauseExecution(10000);
		VerifyAsserts.verifyTrue(subscriptionCount<GDSNSubscriptions.getSubscriptionCount());
	}
	
	@Test
	public void test(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		
		int subscriptionCount = GDSNSubscriptions.getSubscriptionCount();
		
		
		GDSNSubscriptions.clickCreateSubscriptionLink();	
		GDSNSubscriptions.CreateASubscription.fillPublisherGLN("4049111221238");
		GDSNSubscriptions.CreateASubscription.fillGTIN("12345678912345");
		GDSNSubscriptions.CreateASubscription.clickCreateSubscriptionButton();
		Elements.pauseExecution(10000);
		
		subscriptionCount = GDSNSubscriptions.getSubscriptionCount();		
		
	}
	
	@Test
	public void createSubscriptionGlobalGPC(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		
		int index = GDSNSubscriptions.getIndexWherePublisherGLN_And_ProductGPC_exists();		
		
		String gln = GDSNSubscriptions.getNthPublisherGLN(index);
		String gpc = GDSNSubscriptions.getNthProductGPC(index);
		int subscriptionCount = GDSNSubscriptions.getSubscriptionCount();
		
		GDSNSubscriptions.clickCreateSubscriptionLink();	
		
		
		GDSNSubscriptions.CreateASubscription.fillPublisherGLN(gln);
		GDSNSubscriptions.CreateASubscription.fillGlobalGPC(gpc);
		GDSNSubscriptions.CreateASubscription.clickCreateSubscriptionButton();
		Elements.pauseExecution(10000);
		VerifyAsserts.verifyTrue(subscriptionCount<GDSNSubscriptions.getSubscriptionCount());
	}
	
	@Test
	public void cancelSubscription(){
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		Elements.pauseExecution(3000);		
		GDSNSubscriptions.clickCancelSubscriptionLink();		
		int subscriptionCount = GDSNSubscriptions.getSubscriptionCountOnCancel();
		GDSNSubscriptions.checkNthRowCheckbox(1);
		GDSNSubscriptions.clickCancelSubscriptionsButton();
		Elements.pauseExecution(10000);
		VerifyAsserts.verifyTrue(subscriptionCount>GDSNSubscriptions.getSubscriptionCountOnCancel());
		
	}
	
	@Test
	public void downloadSubscriptions(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToGDSNSubscriptions();
		Elements.pauseExecution(3000);
		
		GDSNSubscriptions.clickDownloadSubscriptionLink();
		VerifyAsserts.verifyTrue(GDSNSubscriptions.verifyDownloadButtonEnabled());
		
	}
	

}
