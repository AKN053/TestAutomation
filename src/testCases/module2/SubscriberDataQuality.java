package testCases.module2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.Enumerations.ColumnName;

import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;
import pages.BasePage.MDS_Table;
import pages.LoginPage;
import pages.SubscriberDataQualityPage;
import pages.BasePage.MenuBar;


@Listeners({framework.providers.WebDriverListener.class})
public class SubscriberDataQuality {
	
	@Test
	public void searchPublisherName(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToDataQuality();
		String data = SubscriberDataQualityPage.getFirstPublisherName();
		SubscriberDataQualityPage.performSearch(data);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PUBLISHER_NAME_DATA_QUALITY, data));
	}
	
	
	@Test
	public void searchGLN(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToDataQuality();
		String data = SubscriberDataQualityPage.getFirstGLN();
		SubscriberDataQualityPage.performSearch(data);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PUBLISHER_GLN, data));
	}
	
	@Test
	public void verifyTotal(){
		
		LoginPage.loginGDSNSubscriber();
		MenuBar.goToDataQuality();
		
		int published = SubscriberDataQualityPage.getPublishedCountNthRow(1);
		int totalMatched = SubscriberDataQualityPage.getTotalMatchedCountNthRow(1);
		int totalUnMatched = SubscriberDataQualityPage.getTotalUnMatchedCountNthRow(1);
		
		boolean result;
		
		if(published==(totalMatched+totalUnMatched))
			result = true;
		else
			result = false;
		
		VerifyAsserts.verifyTrue(result);
	}
	
	

}
