package rough;

import net.sf.saxon.functions.Parse;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddNewCompanyAccountPage;
import pages.BasePage.MDS_Table;
import pages.PublishingCenterPage;
import pages.PublishingCenterPage.PageElements;
import pages.ReviewCICsPage;
import pages.BasePage.Admin;
import pages.BasePage.Breadcrumb;
import pages.BasePage.Header;
import pages.BasePage.MenuBar;
import pages.BasePage;
import pages.LoginPage;
import testCases.TestBase;
import common.Enumerations.ColumnName;
import common.Enumerations.Country;
import common.Enumerations.IndustrySegment;
import common.Enumerations.State;
import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;


@Listeners({framework.providers.WebDriverListener.class})
public class MyTest extends TestBase{

	@Test
	public void myTest(){		
		
		/*LoginPage.loginAdmin();
		//MenuBar.goToUserAccounts();
		MenuBar.goToViewCatalogPage();	
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CatalogPage.performSearch("BRG1");
		Elements.getAllRowColumnText(By.cssSelector("table[id='itnCatalogTable']"), 2, "");
		//CatalogPage.Header.selectFromMore(More.DELETE_RECORDS);
		
		MenuBar.goToCompanyAccounts();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> companyNames = Elements.findAll(By.cssSelector("td[data-title*='companyname'] > a"));
		System.out.println("SIZE : "+companyNames.size());
		for(int i=0; i<companyNames.size();i++){
			System.out.println(companyNames.get(i).getText());
			
		}*/
		
		/*String columnName = "COLnAME";
		String a = "td[data-title='"+columnName+"'] > a";
		System.out.println(a);*/
	
		/*LoginPage.loginDefaultUser();
		Breadcrumb.getCurrentPage();*/
		
		/*LoginPage.loginSuplierUser();
		String currentPage = Breadcrumb.getCurrentPage();
		VerifyAsserts.verifyEquals(currentPage, "Home");*/
		
		/*LoginPage.setUserName(Config.Logins.Credential.SUPLIER.userName);
		String message = LoginPage.clickLoginButton();
		System.out.println(message);*/
		
		/*LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		CatalogPage.performSearch(Config.GTIN);
		int x = Elements.getTotalNumberOfRowsFromMDSTable(ColumnNames.GTIN.toString());
		System.out.println("Total Rows = "+x);*/
		
		
		/*LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		CatalogPage.performSearch(Config.PRODUCTCODE);
		int numberOfRows = Elements.getTotalNumberOfRowsFromMDSTable(ColumnNames.PRODUCT_CODE.toString());
		System.out.println("Total Rows = "+numberOfRows);
		VerifyAsserts.verifyTrue(numberOfRows>0);*/
		
	/*	LoginPage.loginSuplierUser();
		MenuBar.goToViewCatalogPage();
		CatalogPage.performSearch(Config.PRODUCT_DESCRIPTION);
		int numberOfRows = Elements.getTotalNumberOfRowsFromMDSTable(ColumnNames.PRODUCT_CODE.toString());
		System.out.println("Total Rows = "+numberOfRows);
		VerifyAsserts.verifyTrue(numberOfRows>0);*/
		
		
		/*LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(INDUSTRY_SEGMENT.Distributor);
		Pagination.clickCount(50);
		int x = MDS_Table.getTotalNumberOfRowsFromMDSTable(ColumnNames.INDUSTRY_SEGMENT);
		System.out.println("Total Number of Cols : "+x);
		
		Pagination.clickCount(100);
		x = MDS_Table.getTotalNumberOfRowsFromMDSTable(ColumnNames.INDUSTRY_SEGMENT);
		System.out.println("Total Number of Cols : "+x);
		
		Pagination.clickCount(200);
		x = MDS_Table.getTotalNumberOfRowsFromMDSTable(ColumnNames.INDUSTRY_SEGMENT);
		System.out.println("Total Number of Cols : "+x);
		List<String> data = MDS_Table.getColumnData(ColumnNames.INDUSTRY_SEGMENT);	
		
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnNames.INDUSTRY_SEGMENT, "Distributor"));*/
		
		/*LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();		
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(INDUSTRY_SEGMENT.DISTRIBUTOR);		
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnNames.INDUSTRY_SEGMENT, "Distributor"));*/
		/*
		LoginPage.loginAdmin();
		MenuBar.goToPublishItems();
		
		List<String> cols = MDS_Table.getColumnNames();
		for(int i=0; i<cols.size(); i++){
			System.out.println(cols.get(i));
		}*/
		
		/*
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishItems();		
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnNames.SUBSCRIBER_NAME);
		System.out.println("***********\n"+Header.getPageTitle());
		System.out.println(DriverManager.getDataSet().getDataMap().get(DataKeys.FIRST_ROW_TEXT).toString());
		VerifyAsserts.verifyTrue(Header.getPageTitle().contains(DriverManager.getDataSet().getDataMap().get(DataKeys.FIRST_ROW_TEXT).toString()));
		VerifyAsserts.verifyTrue(MDS_Table.isColumnPresent(ColumnNames.GTIN));
		VerifyAsserts.verifyTrue(MDS_Table.isColumnPresent(ColumnNames.PRODUCT_CODE));
		VerifyAsserts.verifyTrue(MDS_Table.isColumnPresent(ColumnNames.DESCRIPTION));
		VerifyAsserts.verifyTrue(MDS_Table.isColumnPresent(ColumnNames.CIC_STATUS));
		VerifyAsserts.verifyTrue(MDS_Table.isColumnPresent(ColumnNames.CIC_STATUS_DATE));
		*/
		
		/*
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishItems();		
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnNames.SUBSCRIBER_NAME);
		
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnNames.GTIN);
		VerifyAsserts.verifyTrue(SubscribersItemPage.getHistoryAlert().contains("No CIC History Available"));
		*/
		/*
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishItems();	
		Header.clickReviewCICsLinkPublicationCenterPage();	
		
		VerifyAsserts.verifyTrue(ReviewCICsSubscriberItemsPage.getSelectedSubscriber().contains("All Subscribers"));
		*/
		
		/*
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishItems();	
		Header.clickReviewCICsLinkPublicationCenterPage();	
		
		ReviewCICsSubscriberItemsPage.clickReturnToPublishingCenterLink();
		String a = Breadcrumb.getCurrentPage();
		System.out.println("*******************\nCurrent Page : "+a);
		
		*/
		
		/*LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(INDUSTRY_SEGMENT.PRODUCE_SUPLIER);		
		CompanyAccountsPage.verifyAppliedFilter(INDUSTRY_SEGMENT.PRODUCE_SUPLIER.toString());
		
		
		*/
		/*
		LoginPage.loginSuplierUser();
		MenuBar.goToPublishItems();	
		Header.clickPublishItemsLink_PublicationPage();
		//AddRemoveTable.searchInLeftTableAndAddtoRightTable(leftTableLocator, searchString);
		PublishItemsPage.SelectSubscribers.selectSubscriberFromAvailableSubscribersTable("SubscriberName");
		PublishItemsPage.SelectSubscribers.verifyInSelectedSubscriberTable("SubscriberName");*/
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.ALBERTA, Country.US, false, 1);
	}
	
	@Test
	public void testCase2(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.ALBERTA, Country.US, false, 1);
		Admin.clickNextButton();
		
		AddNewCompanyAccountPage.CompanyRolesWizard.checkPublisherCheckBox();
		AddNewCompanyAccountPage.CompanyRolesWizard.checkDigitalAssetsManagementCheckBox();
		Admin.clickNextButton();
		
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkFlatFileInboundCheckbox();
		Admin.clickNextButton();
		
		
		
		AddNewCompanyAccountPage.EntrustmentsWizard.addFromAvailablePartners("Automation FcegIKwk");
		
		Elements.pauseExecution(10000);
		
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
	public void reviewCICsSelectedSubscriber(){		
		LoginPage.loginGDSNUser();
		MenuBar.goToPublishingCenter();
		String data = PublishingCenterPage.getFirstSubscriberName();
		MDS_Table.clickFirstElementInMDSTable(ColumnName.SUBSCRIBER_NAME);
		
		String count= Elements.getText(Header.PageElements.REVIEW_CIC_ICON_NUMBER);
	    int counter=Integer.parseInt(count);
		System.out.println(counter);
		
		if (counter > 0) {
		Header.clickReviewCICsLinkSubscribersItemPage();		
		VerifyAsserts.verifyTrue(ReviewCICsPage.getSelectedSubscriber().equalsIgnoreCase(data));
		
		VerifyAsserts.verifyTrue(ReviewCICsPage.verifyAvailableColumns());
		}
		else{
			System.out.println("Review CIC Link is disabled");
		}
	}
}
