package testCases.module1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage.Breadcrumb;
import pages.BasePage.Header;
import pages.BasePage.MDS_Table;
import pages.BasePage.MenuBar;
import pages.CatalogPage;
import pages.FixFailedItemsPage;
import pages.LoginPage;
import pages.UploadAndRegisterCatalogPage;
import testCases.TestBase;
import common.Enumerations.ColumnName;
import framework.helpers.VerifyAsserts;

@Listeners({framework.providers.WebDriverListener.class})

public class Catalog extends TestBase{
	
	
	@Test
	public void searchGTIN(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstGTIN();
		CatalogPage.searchFirstGTIN();
		
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.GTIN, data));		
	}
	
	@Test
	public void searchProductCode(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstProductCode();
		CatalogPage.searchFirstProductCode();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.PRODUCT_CODE, data));		
	}
	
	@Test
	public void searchProductDescription(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstProductDescription();
		CatalogPage.searchFirstProductDescription();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.ITEM_DESCRIPTION, data));		
	}
	
	@Test
	public void RegistrationStatusfilterNotReady(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		//CatalogPage.Filters.RegistrationStatus.checkIncompleteCheckbox();
		CatalogPage.Filters.RegistrationStatus.checkNotReadyCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.REGISTRATION_STATUS,"Not Ready"));
	}
	
	@Test
	public void RegistrationStatusfilterProcessing(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		CatalogPage.Filters.RegistrationStatus.checkProcessingCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.REGISTRATION_STATUS,"In Process"));
	}
	
	@Test
	public void RegistrationStatusfilterValidated(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		//CatalogPage.Filters.RegistrationStatus.checkRegisteredCheckbox();
		CatalogPage.Filters.RegistrationStatus.checkValidatedCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.REGISTRATION_STATUS,"Validated"));
	}
	
	@Test
	public void RegistrationStatusfilterFailed(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();		
		CatalogPage.Filters.RegistrationStatus.checkFailedCheckbox();
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.REGISTRATION_STATUS,"Failed"));
	
	}
	
	//this test case has been skipped feature#222
	/*@Test
	public void downloadAllButtonClickable(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		CatalogPage.clickDownloadButton();
		VerifyAsserts.verifyTrue(CatalogPage.isDownloadAllClickable());
		
	}*/
	
	
	@Test
	public void downloadSelectedButtonClickable(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		Header.clickDownloadItemsLinkCatalogPage(); // this test case has been modified for feature#222
		//CatalogPage.selectFirstNGTINs(Data.getNumberBetween(1, 3));		
		VerifyAsserts.verifyTrue(CatalogPage.isDownloadAllButtonClickable());
		
		
	}
	
	@Test
	public void GTINDetailsOMS(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstGTIN();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);		
		VerifyAsserts.verifyTrue(CatalogPage.SplitScreen.getHeader().contains(data));
		CatalogPage.SplitScreen.clickCloseSplitScreen();
		VerifyAsserts.verifyTrue(!CatalogPage.SplitScreen.verifySplitScreenVisible());
	}
	
	@Test
	public void GTINDetailsGDSN(){
		LoginPage.loginGDSNUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstGTIN();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);		
		VerifyAsserts.verifyTrue(CatalogPage.SplitScreen.getHeader().contains(data));
		CatalogPage.SplitScreen.clickCloseSplitScreen();
		VerifyAsserts.verifyTrue(!CatalogPage.SplitScreen.verifySplitScreenVisible());
	}
	
	@Test
	public void GTINDetailsGDSNOMS(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		String data = CatalogPage.getFirstGTIN();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);		
		VerifyAsserts.verifyTrue(CatalogPage.SplitScreen.getHeader().contains(data));
		CatalogPage.SplitScreen.clickCloseSplitScreen();
		VerifyAsserts.verifyTrue(!CatalogPage.SplitScreen.verifySplitScreenVisible());
	}
	
	
	@Test
	public void getProductSheetButton(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();		
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);		
		VerifyAsserts.verifyTrue(CatalogPage.SplitScreen.verifyGetProductSheetButtonClickable());
	}
	
	@Test
	public void FixFailedGTINDetailsGDSNOMS(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		Header.clickFixFailedItemsLink();
		String data = FixFailedItemsPage.getFirstGTIN();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.GTIN);
		VerifyAsserts.verifyTrue(FixFailedItemsPage.SplitScreen.getHeaderText().contains(data));
	}
	
	
	@Test
	public void FixFailedCancelLink(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		Header.clickFixFailedItemsLink();
		FixFailedItemsPage.clickCancel();		
		VerifyAsserts.verifyTrue(Breadcrumb.getCurrentPage().equalsIgnoreCase("Catalog"));
	}
	
	
	@Test
	public void uploadAndRegisterCatalog(){
		LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		Header.clickUploadAndRegisterLink();
		UploadAndRegisterCatalogPage.uploadAfile();
		VerifyAsserts.verifyTrue(UploadAndRegisterCatalogPage.verifyRemoveButtonClickable());
		VerifyAsserts.verifyTrue(UploadAndRegisterCatalogPage.verifyUploadButtonClickable());
		VerifyAsserts.verifyTrue(UploadAndRegisterCatalogPage.verifyCancelClickable());		
	}	
	
}
