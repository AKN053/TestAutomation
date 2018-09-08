package testCases.module2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BasePage.MDS_Table;
import pages.CatalogPage;
import pages.LoginPage;
import pages.SubscriberCatalogPage;
import testCases.TestBase;

import common.Enumerations.ColumnName;

import framework.helpers.VerifyAsserts;

@Listeners({framework.providers.WebDriverListener.class})
public class Catalog extends TestBase{
	
	@Test
	public static void searchGTIN(){
		
		LoginPage.loginNonGDSNUser();
		//MenuBar.goToViewCatalogPage();
		String data= SubscriberCatalogPage.getFirstGTIN();
		//SubscriberCatalogPage.searchFirstGTIN();
		
		SubscriberCatalogPage.performSearch("12345111222334");
		
		//VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.GTIN, data));
	}
	
	@Test
	public void searchProductCode(){
		LoginPage.loginNonGDSNUser();
		//MenuBar.goToViewCatalogPage();
		String data = SubscriberCatalogPage.getFirstProductCode();
		CatalogPage.searchFirstProductCode();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PRODUCT_CODE, data));		
	}
	
	@Test
	public void searchProductDescription(){
		LoginPage.loginNonGDSNUser();
		//MenuBar.goToViewCatalogPage();
		String data = SubscriberCatalogPage.getFirstProductDescription();
		CatalogPage.searchFirstProductDescription();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.ITEM_DESCRIPTION, data));		
	}
	
	@Test
	public void verifyAvailableColumns(){
		
		LoginPage.loginNonGDSNUser();
		//MenuBar.goToViewCatalogPage();
		VerifyAsserts.verifyTrue(SubscriberCatalogPage.verifyAvailableColumns());
		
	}
	
	@Test
	public void checkTooltipDataDisplay(){
		LoginPage.loginNonGDSNUser();
		//MenuBar.goToViewCatalogPage();		
		String data = SubscriberCatalogPage.getLastUploadDateToolTip(1);		
		VerifyAsserts.verifyTrue(data.equals("oms, _subscriber\nIntegration"));
	}
	
	@Test
	public void verifySplitScreen(){
		
		LoginPage.loginNonGDSNUser();
		String firstGTIN = SubscriberCatalogPage.getFirstGTIN();
		String firstItemDescription = SubscriberCatalogPage.getFirstProductDescription();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);
		String data  = SubscriberCatalogPage.SplitScreen.getHeader();
		VerifyAsserts.verifyTrue(data.contains(firstGTIN) && data.contains(firstItemDescription));
	}
}
