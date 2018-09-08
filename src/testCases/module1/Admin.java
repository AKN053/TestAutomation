package testCases.module1;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddNewCompanyAccountPage;
import pages.AddNewCompanyAccountPage.UserAccountsWizard;
import pages.BasePage;
import pages.BasePage.Breadcrumb;
import pages.BasePage.Header;
import pages.BasePage.MDS_Table;
import pages.BasePage.MenuBar;
import pages.CompanyAccountsPage;
import pages.EditCompanyInformationPage;
import pages.LoginPage;
import pages.UsersAccountsPage;
import pages.ViewCompanyAccountPage;
import testCases.TestBase;
import common.Config;
import common.Config.DataKeys;
import common.Enumerations.BreadCrumbPage;
import common.Enumerations.ColumnName;
import common.Enumerations.CompanyStatus;
import common.Enumerations.Country;
import common.Enumerations.IndustrySegment;
import common.Enumerations.State;
import common.Enumerations.UserRole;
import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;
import framework.providers.Data;
import framework.providers.DriverManager;

@Listeners({framework.providers.WebDriverListener.class})
public class Admin extends TestBase{
	
	@Test
	public void cancelCompanyInformation(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		AddNewCompanyAccountPage.CompanyInformationWizard.setCompanyName();
		AddNewCompanyAccountPage.CompanyInformationWizard.clickCancel();
		AddNewCompanyAccountPage.acceptModalDialog();
		Elements.waitForElementToBeVisible(Header.PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
		VerifyAsserts.verifyTrue(Breadcrumb.verifyCurrentPage(BreadCrumbPage.COMPANY_ACCOUNTS_PAGE));	
		
	}
	
	@Test
	public void cancelCompanyRole(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ARIZONA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		AddNewCompanyAccountPage.CompanyRolesWizard.clickCancel();
		AddNewCompanyAccountPage.acceptModalDialog();
		Elements.waitForElementToBeVisible(Header.PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
		VerifyAsserts.verifyTrue(Breadcrumb.verifyCurrentPage(BreadCrumbPage.COMPANY_ACCOUNTS_PAGE));
	}
	
	@Test
	public void cancelIntegration(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ARIZONA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(false, 1, 1, 1, 3);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickCancel();
		
		AddNewCompanyAccountPage.acceptModalDialog();
		Elements.waitForElementToBeVisible(Header.PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
		VerifyAsserts.verifyTrue(Breadcrumb.verifyCurrentPage(BreadCrumbPage.COMPANY_ACCOUNTS_PAGE));
	}
	
	@Test
	public void cancelEntrusments(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ARIZONA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(false, 1, 1, 1, 3);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		fillIntegrationApplicationDetailsADD(12345, 1,1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickCancel();
		AddNewCompanyAccountPage.acceptModalDialog();
		Elements.waitForElementToBeVisible(Header.PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
		VerifyAsserts.verifyTrue(Breadcrumb.verifyCurrentPage(BreadCrumbPage.COMPANY_ACCOUNTS_PAGE));
	}
	
	
	@Test
	public void cancelUserAccounts(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ARIZONA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(false, 1, 1, 1, 3);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		fillIntegrationApplicationDetailsADD(145, 1,1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();
		AddNewCompanyAccountPage.UserAccountsWizard.clickCancelButtonOnAddNewUserOverlay();
		AddNewCompanyAccountPage.UserAccountsWizard.clickCancel();
		AddNewCompanyAccountPage.acceptModalDialog();
		Elements.waitForElementToBeVisible(Header.PageElements.ADD_ACCOUNT_LINK_COMPANY_ACCOUNTS_PAGE);
		VerifyAsserts.verifyTrue(Breadcrumb.verifyCurrentPage(BreadCrumbPage.COMPANY_ACCOUNTS_PAGE));
	}
	
	
	@Test
	public void SaveEditViewCompanyInformationWizard(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		AddNewCompanyAccountPage.CompanyInformationWizard.setCompanyName();
		AddNewCompanyAccountPage.CompanyInformationWizard.clickSaveAndCloseButton();
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyInformationWizard.verifyStatus(CompanyStatus.INPROCESS));
		
		ViewCompanyAccountPage.CompanyInformationWizard.clickEditButton();		
		EditCompanyInformationPage.CompanyInformationWizard.clickCancel();
		
		ViewCompanyAccountPage.CompanyInformationWizard.clickEditButton();		
		VerifyAsserts.verifyEquals(EditCompanyInformationPage.clickSaveButtonAndGetAlert(), "Please fix the errors indicated below.");
		
		fillCompanyInformationEDIT(IndustrySegment.DISTRIBUTOR, State.ALABAMA, Country.US, true, 1);
		EditCompanyInformationPage.clickSaveChangesButton();
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyInformationWizard.verifyDetails());
		
	}
	
	@Test
	public void SaveEditViewCompanyRoleWizard(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.AMERICAN_SAMOA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		AddNewCompanyAccountPage.CompanyRolesWizard.clickSaveAndCloseButton();
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		ViewCompanyAccountPage.goToCompanyRolesWizard();
		ViewCompanyAccountPage.CompanyRolesWizard.clickEditButton();
		EditCompanyInformationPage.CompanyRolesWizard.clickCancelButton();
		
		ViewCompanyAccountPage.CompanyRolesWizard.clickEditButton();
		String alert = EditCompanyInformationPage.CompanyRolesWizard.clickSaveChangesButtonAndGetError();
		VerifyAsserts.verifyEquals(alert, "At least one company role must be selected to activate a new Company Account.");
		
		EditCompanyInformationPage.CompanyRolesWizard.getAllCheckBoxes();
		fillCompanyRolesEDIT(true, 1, 3, 1, 2);
		EditCompanyInformationPage.clickSaveChangesButton();
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyRolesWizard.verifyCompanyRoles());		
	}
	
	
	@Test
	public void SaveEditViewCompanyIntegrationAndApplicationWizard(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.AMERICAN_SAMOA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(true, 1, 1, 1, 1);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickSaveAndCloseButton();
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		ViewCompanyAccountPage.goToIntegrationsApplicationsWizard();
		ViewCompanyAccountPage.IntegrationsApplicationsWizard.clickEditButton();
		EditCompanyInformationPage.IntegrationsApplicationsWizard.clickCancel();
		
		ViewCompanyAccountPage.IntegrationsApplicationsWizard.clickEditButton();
		String alert = EditCompanyInformationPage.IntegrationsApplicationsWizard.clickSaveChangesButtonAndGetAlert();
		VerifyAsserts.verifyEquals(alert, "At least one integration type must be selected to activate a new Company Account.");
		
		
		fillIntegrationsApplicationsDetailsEDIT(12, 23, 1);
		EditCompanyInformationPage.IntegrationsApplicationsWizard.clickSaveChangesButton();
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.IntegrationsApplicationsWizard.verifyIntegrationApplications());		
		
		
	}
	
	@Test
	public void SaveEditViewCompanyEntrustmentsWizard(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.AMERICAN_SAMOA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(true, 1, 1, 1, 1);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		fillIntegrationApplicationDetailsADD(1, 1, 1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		AddNewCompanyAccountPage.EntrustmentsWizard.clickSaveAndCloseButton();		
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		ViewCompanyAccountPage.goToEntrustmentsWizard();
		ViewCompanyAccountPage.EntrustmentsWizard.clickEditButton();		
		EditCompanyInformationPage.EntrustmentsWizard.clickCancelButton();
		
		ViewCompanyAccountPage.EntrustmentsWizard.clickEditButton();
		EditCompanyInformationPage.EntrustmentsWizard.addFirstAvailablePartner();
		EditCompanyInformationPage.EntrustmentsWizard.clickSaveChangesButton();
		
		List<String> name = ViewCompanyAccountPage.EntrustmentsWizard.getActiveEntrustmentNames();
		VerifyAsserts.verifyTrue(Config.DATA_MAP.get(DataKeys.SELECTED_PARTNER_ENTRUSTMENT).contains(name.get(0)));
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.EntrustmentsWizard.getActiveEntrustmentsCount()==1);
		
	}
	
	
	@Test
	public void SaveEditViewCompanyUserAccountsWizard(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.AMERICAN_SAMOA, Country.US, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		fillCompanyRolesADD(true, 1, 1, 1, 1);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		fillIntegrationApplicationDetailsADD(1, 1, 1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		AddNewCompanyAccountPage.EntrustmentsWizard.addFirstAvailablePartner();		
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();
		
		addNewUserADD(UserRole.SUBSCRIBER_ADMIN);		
		AddNewCompanyAccountPage.UserAccountsWizard.clickSaveAndCloseButton();
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		ViewCompanyAccountPage.goToUserAccountsWizard();
		ViewCompanyAccountPage.UserAccountsWizard.verifyUserListed(Config.DATA_MAP.get(DataKeys.LAST_NAME_USER));
	}
	
	@Test
	public void AddCompanyWithMultipleGLNs(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.MANUFACTURER, State.AMERICAN_SAMOA, Country.US, false, Data.getNumberBetween(2, 10));
		AddNewCompanyAccountPage.CompanyInformationWizard.clickSaveAndCloseButton();
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyInformationWizard.verifyGLN());
	}
	
	@Test
	public void nextButtonAddNewCompany(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		String error = AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButtonAndGetErrorMessage();
		
		VerifyAsserts.verifyTrue(error.equals("Please fix the errors indicated below."));
				
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ALABAMA, Country.CANADA, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		
		Elements.pauseExecution(4000);
		error = AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButtonAndGetErrorMessage();
		
		VerifyAsserts.verifyTrue(error.equals("At least one company role must be selected to activate a new Company Account."));
		
		fillCompanyRolesADD(true, 1, 1, 1, 2);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		
		Elements.pauseExecution(4000);
		error = AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButtonAndGetErrorMessage();
		
		VerifyAsserts.verifyTrue(error.equals("At least one integration type must be selected to activate a new Company Account."));
		fillIntegrationApplicationDetailsADD(1, 1, 1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.EntrustmentsWizard.addFirstAvailablePartner();
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickCancelButtonOnAddNewUserOverlay();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickSaveAndCloseButton();
		
	}
	
	
	
	
	@Test
	public void previousButtonAddNewCompany(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ALABAMA, Country.CANADA, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		
		fillCompanyRolesADD(true, 1, 1, 1, 2);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		
		fillIntegrationApplicationDetailsADD(1, 1, 1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.EntrustmentsWizard.addFirstAvailablePartner();		
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickCancelButtonOnAddNewUserOverlay();
		AddNewCompanyAccountPage.UserAccountsWizard.clickPreviousButton();
		
		
		AddNewCompanyAccountPage.EntrustmentsWizard.clickPreviousButton();
		
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickPreviousButton();
		
		AddNewCompanyAccountPage.CompanyRolesWizard.clickPreviousButton();
		
		VerifyAsserts.verifyTrue(AddNewCompanyAccountPage.CompanyInformationWizard.verifyCompanyInfoPageLoaded());		
		
	}
	
	@Test
	public void activeCompany(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ALABAMA, Country.CANADA, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		
		fillCompanyRolesADD(true, 1, 1, 1, 2);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.getAllCheckBoxes();
		
		
		fillIntegrationApplicationDetailsADD(12345, 123, 123);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.EntrustmentsWizard.addFirstAvailablePartner();		
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickCancelButtonOnAddNewUserOverlay();
		AddNewCompanyAccountPage.UserAccountsWizard.clickAddNewUserButton();
		String error = AddNewCompanyAccountPage.UserAccountsWizard.clickAddUserButtonAndGetErrorMessage();
		
		VerifyAsserts.verifyEquals(error, "Please fill in all required inputs.");
		
		addNewUserADD(UserRole.SITE_ADMIN);
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.EDIT_USER_LINK);
		updateUserDetails(UserRole.PUBLISHER_USER);
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickCreateNewAccountButton();
		
		
		MenuBar.goToCompanyAccounts();
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyInformationWizard.verifyPageLoad());
	}
	
	
	@Test
	public void changeCompanyStatus(){
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		Header.clickAddAccountLinkCompanyAccountPage();
		fillCompanyInformationADD(IndustrySegment.DISTRIBUTOR, State.ALABAMA, Country.CANADA, false, 1);
		AddNewCompanyAccountPage.CompanyInformationWizard.clickNextButton();
		
		fillCompanyRolesADD(true, 1, 1, 1, 2);
		AddNewCompanyAccountPage.CompanyRolesWizard.clickNextButton();
		
		fillIntegrationApplicationDetailsADD(1, 1, 1);
		AddNewCompanyAccountPage.IntegrationsApplicationsWizard.clickNextButton();
		
		AddNewCompanyAccountPage.EntrustmentsWizard.addFirstAvailablePartner();		
		AddNewCompanyAccountPage.EntrustmentsWizard.clickNextButton();		
		
		addNewUserADD(UserRole.SITE_ADMIN);
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickCreateNewAccountButton();
		MenuBar.goToCompanyAccounts();
		
		CompanyAccountsPage.performSearch(DriverManager.getDataSet().getCompanyName());
		BasePage.MDS_Table.clickFirstElementInMDSTable(ColumnName.COMPANY_NAME);
		
		//VerifyAsserts.verifyEquals(ViewCompanyAccountPage.CompanyInformationWizard.getStatus(), CompanyStatus.ACTIVE.toString());
		
		ViewCompanyAccountPage.CompanyInformationWizard.clickEditButton();
		EditCompanyInformationPage.CompanyInformationWizard.selectStatus(CompanyStatus.INACTIVE);
		EditCompanyInformationPage.clickSaveChangesButton();
		
		VerifyAsserts.verifyTrue(ViewCompanyAccountPage.CompanyInformationWizard.getStatus().equalsIgnoreCase(CompanyStatus.INACTIVE.toString()));
		
		ViewCompanyAccountPage.CompanyInformationWizard.clickEditButton();
		EditCompanyInformationPage.CompanyInformationWizard.selectStatus(CompanyStatus.ACTIVE);
		EditCompanyInformationPage.clickSaveChangesButton();
		
		VerifyAsserts.verifyEquals(ViewCompanyAccountPage.CompanyInformationWizard.getStatus(), CompanyStatus.ACTIVE.toString());
	}
	
	//Industry Segmment Test cases
	
	
	@Test
	public void industrySegmentFilterDistributor(){
		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.DISTRIBUTOR);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.DISTRIBUTOR.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.DISTRIBUTOR.toString()));
	}
	
	@Test
	public void industrySegmentFilterManufacturer(){		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.MANUFACTURER);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.MANUFACTURER.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.MANUFACTURER.toString()));
	}
	
	@Test
	public void industrySegmentFilterOperator(){		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.OPERATOR);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.OPERATOR.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.OPERATOR.toString()));
	}
	
	@Test
	public void industrySegmentFilterSupplier(){		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.SUPPLIER);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.SUPPLIER.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.SUPPLIER.toString()));
	}
	
	@Test
	public void industrySegmentFilterReDistributor(){		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.RE_DISTRIBUTOR);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.RE_DISTRIBUTOR.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.RE_DISTRIBUTOR.toString()));
	}
	
	@Test
	public void industrySegmentFilterProduceSupplier(){		
		LoginPage.loginAdmin();
		MenuBar.goToCompanyAccounts();
		CompanyAccountsPage.selectFromIndustrySegmentsDropdown(IndustrySegment.PRODUCE_SUPPLIER);
		VerifyAsserts.verifyTrue(MDS_Table.verifyColumnData(ColumnName.INDUSTRY_SEGMENT, IndustrySegment.PRODUCE_SUPPLIER.toString()));
		VerifyAsserts.verifyTrue(CompanyAccountsPage.verifyAppliedFilter(IndustrySegment.PRODUCE_SUPPLIER.toString()));
	}
	
	
	/*@Test
	public void addUserFromUserAccounts(){
		
		LoginPage.loginAdmin();
		MenuBar.goToUserAccounts();		
		Header.clickAddUserLinkUserAccountPage();
		UsersAccountsPage.AddNewUserOverlay.fillAddUserOverlay(UserRole.SITE_ADMIN);
		UsersAccountsPage.AddNewUserOverlay.clickAddUserButton();
		
	}*/

}
