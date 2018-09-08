package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Config;
import common.Config.DataKeys;
import common.Enumerations.ColumnName;
import common.Enumerations.CompanyStatus;

import framework.helpers.Elements;

public class ViewCompanyAccountPage extends BasePage{
	
	public static class PageElements{
		
		public static final By WIZARD_HEADER_DIV = By.cssSelector("div[id='wizardHeader'] > div[ng-show='header'] > div > div > h3 > a > span:nth-child(1) > strong");
		public static final By COMPANY_INFORMATION_WIZARD = By.cssSelector("a[id='companyWizardCompanyInformation']");
		public static final By COMPANY_ROLES_WIZARD = By.cssSelector("a[id='companyWizardCompanyRoles']");
		public static final By INTEGRATIONS_APPLICATIONS_WIZARD = By.cssSelector("a[id='companyWizardIntegerationsApplications']");
		public static final By ENTRUSTMENTS_WIZARD = By.cssSelector("a[id='companyWizardEntrustments']");
		public static final By USER_ACCOUNTS_WIZARD = By.cssSelector("a[id='companyWizardUserAccounts']");
	}
	
	public static boolean verifyViewCompanyPageLoaded(){
		if(Elements.isClickable(PageElements.WIZARD_HEADER_DIV, Config.pageLoadRetry))
			return true;
		else
			return false;
	}
	
	public static void goToCompanyInformationWizard(){
		Elements.isEnabled(PageElements.COMPANY_INFORMATION_WIZARD);
		Elements.clickElement(PageElements.COMPANY_INFORMATION_WIZARD);
		waitForPageToLoad("companyinformationedit");
		
	}
	
	public static void goToCompanyRolesWizard(){
		Elements.isEnabled(PageElements.COMPANY_ROLES_WIZARD);
		Elements.clickElement(PageElements.COMPANY_ROLES_WIZARD);
		waitForPageToLoad("companyrolesedit");
	}
	
	
	public static void goToIntegrationsApplicationsWizard(){
		Elements.isEnabled(PageElements.INTEGRATIONS_APPLICATIONS_WIZARD);
		Elements.clickElement(PageElements.INTEGRATIONS_APPLICATIONS_WIZARD);
		waitForPageToLoad("integrationsapplicationsedit");
	}
	
	public static void goToEntrustmentsWizard(){
		Elements.isEnabled(PageElements.ENTRUSTMENTS_WIZARD);
		Elements.clickElement(PageElements.ENTRUSTMENTS_WIZARD);
		waitForPageToLoad("entrustmentsedit");
	}
	
	public static void goToUserAccountsWizard(){
		Elements.isEnabled(PageElements.USER_ACCOUNTS_WIZARD);
		Elements.clickElement(PageElements.USER_ACCOUNTS_WIZARD);	
		waitForPageToLoad("useraccountsedit");
	}	
	
	
	public static class CompanyInformationWizard{
		
		
		
		public static class PageElements{
			
			public static final By STATUS_STATIC =By.cssSelector("div[name='status']");
			public static final By COMPANY_NAME_STATIC = By.cssSelector("div[id='companyName']");
			public static final By SUBSIDIARY_OR_BUSINESS_UNIT_STATIC =By.cssSelector("div[id='buName']");
			public static final By COMPANY_URL_STATIC = By.cssSelector("div[id='companyURL']");
			public static final By GLN_STATIC = By.cssSelector("div[id='gln']");
			public static final By DUNS_STATIC = By.cssSelector("div[id='dunsNumber']");
			public static final By INDUSTRY_SEGMENT_STATIC = By.cssSelector("div[name='industrySegment']");
			public static final By STREET_ADDRESS1_STATIC = By.cssSelector("div[id='address']");
			public static final By CITY_STATIC = By.cssSelector("div[id='city']");
			public static final By COUNTY_STATIC = By.cssSelector("div[id='county']");
			public static final By STATE_STATIC = By.cssSelector("div[id='state']");
			public static final By ZIP_STATIC = By.cssSelector("div[id='zip']");
			public static final By COUNTRY_STATIC = By.cssSelector("div[id='country']");
			
			
			public static final By FIRST_NAME_STATIC =By.cssSelector("div[id='firstName']");
			public static final By LAST_NAME_STATIC = By.cssSelector("div[id='lastName']");
			public static final By TITLE_STATIC = By.cssSelector("div[id='title']");
			public static final By EMAIL_STATIC = By.cssSelector("div[id='email']");
			public static final By PHONE_STATIC = By.cssSelector("div[id='phone']");
			
			
			
			/*public static final By ADD_FAX_LINK = By.cssSelector("button[type='button']");
			public static final By FAX_TEXTBOX = By.cssSelector("input[name='fax']");*/
			
			// Billing Information
			
			public static final By BILLING_FIRST_NAME_STATIC =By.cssSelector("div[id='billingFirstName']");
			public static final By BILLING_MIDDLE_NAME_STATIC = By.cssSelector("div[id='billingMiddleName']");
			public static final By BILLING_LAST_NAME_STATIC = By.cssSelector("div[id='billingLastName']]");
			public static final By BILLING_TITLE_STATIC = By.cssSelector("div[id='billingTitle']");
			public static final By BILLING_EMAIL_STATIC = By.cssSelector("div[id='billingEmail']");
			public static final By BILLING_PHONE_STATIC = By.cssSelector("div[id='billingPhone']");
			
			public static final By EDIT_BUTTON =By.cssSelector("button[ng-click*='companyinformationedit']");
			
			
		}
		
		public static boolean verifyPageLoad(){
			if(Elements.isClickable(PageElements.EDIT_BUTTON, Config.pageLoadRetry))
				return true;
			else
				return false;
		}
		
		public static void clickEditButton(){
			Elements.isEnabled(PageElements.EDIT_BUTTON);
			Elements.clickElement(PageElements.EDIT_BUTTON);
			waitForPageToLoad("companyinformationedit");
		}
		
		//STATUS
		
		public static String getStatus(){
			Elements.isEnabled(PageElements.STATUS_STATIC);
			return Elements.getText(PageElements.STATUS_STATIC);
		}
		
		public static boolean verifyStatus(CompanyStatus companyStatus){
			String currentStatus = getStatus();
			if(currentStatus.equalsIgnoreCase(companyStatus.toString()))
				return true;
			else
				return false;
		}
		
		// COMPANY NAME
		
		public static String getCompanyName(){
			Elements.isEnabled(PageElements.COMPANY_NAME_STATIC);
			return Elements.getText(PageElements.COMPANY_NAME_STATIC);
		}
		
		public static boolean verifyCompanyName(String companyName){
			String name = getCompanyName();
			if(name.equalsIgnoreCase(companyName))
				return true;
			else
				return false;
		}
		
		//SUBSIDIARY OR BUSINESS UNIT
		
		public static String getSubsidiaryOrBusinessUnit(){
			Elements.isEnabled(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_STATIC);
			return Elements.getText(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_STATIC);
		}
		
		public static boolean verifySubsidiaryOrBusinessUnit(String name){
			String data = getSubsidiaryOrBusinessUnit();
			if(data.equalsIgnoreCase(name))
				return true;
			else
				return false;
		}
		
		
		//COMPANY URL
		
		public static String getCompanyURL(){
			Elements.isEnabled(PageElements.COMPANY_URL_STATIC);
			return Elements.getText(PageElements.COMPANY_URL_STATIC);
		}
		
		public static boolean verifyCompanyURL(String url){
			String data = getCompanyURL();
			if(data.equalsIgnoreCase(url))
				return true;
			else
				return false;
		}
		
		//GLN
		
		public static List<String> getGLN(){
			Elements.isEnabled(PageElements.GLN_STATIC);
			
			List<WebElement> glns = Elements.findAll(PageElements.GLN_STATIC);
			List<String> data = new ArrayList<String>();
			for(int i=0; i<glns.size(); i++){
				data.add(Elements.getText(glns.get(i)));
			}
			return data;
			//return Elements.getText(PageElements.GLN_STATIC);
		}
		
		public static boolean verifyGLN(){
			List<String> data = getGLN();
			if(Config.GLNS.containsAll(data))
					return true;
			else
				return false;		
			
		}
		
		//DUNS
		
		public static List<String> getDUNS(){
			Elements.isEnabled(PageElements.DUNS_STATIC);
			List<WebElement> duns = Elements.findAll(PageElements.DUNS_STATIC);
			List<String> data = new ArrayList<String>();
			for(int i=0; i<duns.size(); i++){
				data.add(Elements.getText(duns.get(i)));
			}
			return data;
		}
		
		public static boolean verifyDUNS(){
			List<String> data = getDUNS();
			if(Config.DUNS.containsAll(data))
					return true;
			else
				return false;		
			
		}
		
				
		//INDUSTRY SEGMENT
		
		public static String getIndustrySegment(){
			Elements.isEnabled(PageElements.INDUSTRY_SEGMENT_STATIC);
			return Elements.getText(PageElements.INDUSTRY_SEGMENT_STATIC);
		}
		
		public static boolean verifyIndustrySegment(String industrySegment){
			String data = getIndustrySegment();
			if(data.equalsIgnoreCase(industrySegment))
				return true;
			else
				return false;
		}
		
		
		//STREET ADDRESS
		
		public static String getStreetAddress(){
			Elements.isEnabled(PageElements.STREET_ADDRESS1_STATIC);
			return Elements.getText(PageElements.STREET_ADDRESS1_STATIC);
		}
		
		public static boolean verifyStreetAddress(String streetAddress){
			String data = getStreetAddress();
			if(data.equalsIgnoreCase(streetAddress))
				return true;
			else
				return false;
		}
		
		
		//CITY
		
		public static String getCity(){
			Elements.isEnabled(PageElements.CITY_STATIC);
			return Elements.getText(PageElements.CITY_STATIC);
		}
		
		public static boolean verifyCity(String city){
			String data = getStreetAddress();
			if(data.equalsIgnoreCase(city))
				return true;
			else
				return false;
		}
		
		//COUNTY
		
		public static String getCounty(){
			Elements.isEnabled(PageElements.COUNTY_STATIC);
			return Elements.getText(PageElements.COUNTY_STATIC);
		}
		
		public static boolean verifyCounty(String county){
			String data = getCounty();
			if(data.equalsIgnoreCase(county))
				return true;
			else
				return false;
		}
		
		public static String getState(){
			Elements.isEnabled(PageElements.STATE_STATIC);
			return Elements.getText(PageElements.STATE_STATIC);
		}
		
		public static String getZip(){
			Elements.isEnabled(PageElements.ZIP_STATIC);
			return Elements.getText(PageElements.ZIP_STATIC);
		}
		
		public static String getCountry(){
			Elements.isEnabled(PageElements.COUNTRY_STATIC);
			return Elements.getText(PageElements.COUNTRY_STATIC);
		}
		
		public static String getFirstName(){
			Elements.isEnabled(PageElements.FIRST_NAME_STATIC);
			return Elements.getText(PageElements.FIRST_NAME_STATIC);
		}
		
		public static String getLastName(){
			Elements.isEnabled(PageElements.LAST_NAME_STATIC);
			return Elements.getText(PageElements.LAST_NAME_STATIC);
		}
		
		public static String getPhone(){
			Elements.isEnabled(PageElements.PHONE_STATIC);
			return Elements.getText(PageElements.PHONE_STATIC);
		}
		
		public static String getEmail(){
			Elements.isEnabled(PageElements.EMAIL_STATIC);
			return Elements.getText(PageElements.EMAIL_STATIC);
		}
		
		public static boolean verifyCountry(String countryName){
			String data;
			if(countryName.equalsIgnoreCase("United States"))
				data = "USA";
			else
				data = "CAN";
			
			if(getCountry().equalsIgnoreCase(data))
				return true;
			else
				return false;
		}
		
		public static boolean verifyDetails(){			
			
			if(!getSubsidiaryOrBusinessUnit().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.SUBSIDIARY_OR_BUSINESS_UNIT)))
				return false;
			
			if(!getCompanyURL().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.COMPANY_URL)))
				return false;
			
			if(!verifyGLN())
				return false;
			
			if(!verifyDUNS())
				return false;
			
			if(!getIndustrySegment().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.INDUSTRY_SEGMENT)))
				return false;
			
			if(!getStreetAddress().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.STREET_ADDRESS)))
				return false;
			
			if(!getCity().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.CITY)))
				return false;
			
			if(!getCounty().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.COUNTY)))
				return false;
			
			if(!getZip().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.ZIP)))
				return false;
			
			if(!verifyCountry(Config.DATA_MAP.get(DataKeys.COUNTRY)))
				return false;
			
			if(!getFirstName().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.FIRST_NAME)))
				return false;
			
			if(!getLastName().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.LAST_NAME)))
				return false;
			
			if(!getPhone().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.PHONE)))
				return false;
			
			if(!getEmail().equalsIgnoreCase(Config.DATA_MAP.get(DataKeys.EMAIL)))
				return false;			
			
			return true;
			
			
		}
		
		
		
	}
	
	
	public static class CompanyRolesWizard{
		
		public static class PageElements{
			
			public static final By EDIT_BUTTON = By.cssSelector("div[id*='staticRoleDiv'] > div:nth-child(1) > div > div:nth-child(2) > div > button[id='edit']");

			public static final By GDSN_STATIC = By.cssSelector("span[id='isGDSN']");			
			
			public static final By PUBLISHER_STATIC =By.cssSelector("span[id='isPubBus']");
			public static final By SUBSCRIBER_STATIC = By.cssSelector("span[id='isPubSub']");
			public static final By DIGITAL_ASSETES_MANAGEMENT_STATIC = By.cssSelector("span[id='digitalAssetsMgmt']");
			public static final By SELL_SHEET_STATIC = By.cssSelector("span[id='sellSheet']");
			public static final By PRODUCT_INFORMATION_MANAGEMENT_STATIC = By.cssSelector("span[id='pim']");
			public static final By DATA_QUALITY_STATIC = By.cssSelector("span[id='dataQuality']");
			public static final By DATA_POOL_ITN_STATIC = By.cssSelector("span[id='datapoolITN']");
			public static final By DATA_POOL_3RD_PARTY_STATIC = By.cssSelector("span[id='datapoolThirdParty']");
		
		}
		
		public static void clickEditButton(){
			Elements.isEnabled(PageElements.EDIT_BUTTON);
			Elements.clickElement(PageElements.EDIT_BUTTON);
			waitForElementToBeVisible(EditCompanyInformationPage.CompanyRolesWizard.PageElements.SAVE_CHANGES_BUTTON);
			
		}
		
		public static String getGDSN(){
			Elements.isEnabled(PageElements.GDSN_STATIC);
			return Elements.getText(PageElements.GDSN_STATIC);
		}
		
		public static boolean verifyGDSN(){
			try{
				if(!getGDSN().contains("GDSN"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getPublisher(){
			Elements.isEnabled(PageElements.PUBLISHER_STATIC);
			return Elements.getText(PageElements.PUBLISHER_STATIC);
		}
		
		public static boolean verifyPublisher(){
			try{
				if(!getPublisher().contains("Publisher"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getSubscriber(){
			Elements.isEnabled(PageElements.SUBSCRIBER_STATIC);
			return Elements.getText(PageElements.SUBSCRIBER_STATIC);
		}
		
		public static boolean verifySubscriber(){
			try{
				if(!getSubscriber().contains("Subscriber"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getDigitalAssetManagement(){
			Elements.isEnabled(PageElements.DIGITAL_ASSETES_MANAGEMENT_STATIC);
			return Elements.getText(PageElements.DIGITAL_ASSETES_MANAGEMENT_STATIC);
		}
		
		public static boolean verifyDigitalAssetsManagement(){
			try{
				if(!getDigitalAssetManagement().contains("Digital Assets Management"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getSellSheet(){
			Elements.isEnabled(PageElements.SELL_SHEET_STATIC);
			return Elements.getText(PageElements.SELL_SHEET_STATIC);
		}
		
		public static boolean verifySellSheet(){
			try{
				if(!getSellSheet().contains("Sell Sheet"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		
		public static String getProductInformationManagement(){
			Elements.isEnabled(PageElements.PRODUCT_INFORMATION_MANAGEMENT_STATIC);
			return Elements.getText(PageElements.PRODUCT_INFORMATION_MANAGEMENT_STATIC);
		}
		
		public static boolean verifyProductInformationManagement(){
			try{
				if(!getProductInformationManagement().contains("Product Information Management (PIM)"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getDataQuality(){
			Elements.isEnabled(PageElements.DATA_QUALITY_STATIC);
			return Elements.getText(PageElements.DATA_QUALITY_STATIC);
		}
		
		public static boolean verifyDataQuality(){
			try{
				if(!getDataQuality().contains("Data Quality"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getDataPoolITN(){
			Elements.isEnabled(PageElements.DATA_POOL_ITN_STATIC);
			return Elements.getText(PageElements.DATA_POOL_ITN_STATIC);
		}
		
		public static boolean verifyDataPoolITN(){
			try{
				if(!getDataPoolITN().contains("Data Pool - ITN"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		public static String getDataPool3P(){
			Elements.isEnabled(PageElements.DATA_POOL_3RD_PARTY_STATIC);
			return Elements.getText(PageElements.DATA_POOL_3RD_PARTY_STATIC);
		}
		
		public static boolean verifyDataPool3P(){
			try{
				if(!getDataPoolITN().contains("Data Pool - 3rd Party"))
					return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}	
		
		
		public static boolean verifyCompanyRoles(){
			
			// verifying is gdsn?
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_IS_GDSN)!=null && Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_IS_GDSN)){
				if(!getGDSN().contains("GDSN"))
					return false;
			}
			
			
			//verifying publisher subscriber
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_PUBLISHER)!=null){
				if(!getPublisher().contains("Publisher"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_SUBSCRIBER)!=null){
				if(!getSubscriber().contains("Subscriber"))
					return false;
			}
			
			// verifying Advanced Features
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_DIGITAL_ASSET_MANAGEMENT)!=null){
				if(!getDigitalAssetManagement().contains("Digital Assets Management"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_SELL_SHEET)!=null){
				if(!getSellSheet().contains("Sell Sheet"))
					return false;
			}
			
			// Verifying ITN Solutions
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_PRODUCT_INFORMATION_MANAGEMENT_PIM)!=null){
				if(!getProductInformationManagement().contains("Product Information Management (PIM)"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_DATA_QUALITY)!=null){
				if(!getDataQuality().contains("Data Quality"))
					return false;
			}
			
			// Verifying Data Pool Membership
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_DATA_POOL_ITN)!=null){
				if(!getDataPoolITN().contains("Data Pool - ITN"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.COMPANY_ROLES_DATA_POOL_3RD_PARTY)!=null){
				if(!getDataPool3P().contains("Data Pool - 3rd Party"))
					return false;
			}
			
			return true;
			
		}
		
	}
	
	
	
	
	public static class IntegrationsApplicationsWizard{
		
		public static class PageElements{
			public static final By EDIT_BUTTON = By.cssSelector("div[id='itnWizardContainer'] > div[class*='itnWizardContent'] > div > div > div:nth-child(1) > div > div:nth-child(2) > div > button[id='edit']");
			//INBOUND INTEGRATION
			public static final By XML_INBOUND_STATIC = By.cssSelector("span[id='xml']");
			public static final By FLAT_FILE_INBOUND_STATIC = By.cssSelector("span[id='flatFile']");
			public static final By SPREADSHEET_INBOUND_STATIC = By.cssSelector("span[id='spreadsheet']");
			public static final By PUBLISHER_PORTAL_INBOUND_STATIC = By.cssSelector("span[id='publisherPortal']");
			public static final By PUBLISHER_PORTAL_LIMITED_INBOUND_STATIC = By.cssSelector("span[id='publisherPortalLimited']");
			
			//OUTBOUND INTEGRATION
			public static final By XML_OUTBOUND_STATIC = By.cssSelector("span[id='xmlOutBound']");
			public static final By FLAT_FILE_OUTBOUND_STATIC = By.cssSelector("span[id='flatFileOutBound']");
			public static final By SPREADSHEET_OUTBOUND_STATIC = By.cssSelector("span[id='spreadSheetOutBound']");
			
			//PARTNER INTEGRATION
			public static final By BRANDED_PROCUREMENT_STATIC = By.cssSelector("span[id='integPartnerBP']");
			public static final By CBORD_STATIC = By.cssSelector("span[id='integPartnerCbord']");
			public static final By ORDER_MANAGEMENT_SYSTEM_STATIC = By.cssSelector("span[id='integPartnerCbord']");
		}
		
		
		public static void clickEditButton(){
			Elements.isEnabled(PageElements.EDIT_BUTTON);
			Elements.clickElement(PageElements.EDIT_BUTTON);
			waitForElementToBeVisible(EditCompanyInformationPage.IntegrationsApplicationsWizard.PageElements.SAVE_CHANGES_BUTTON);
		}
		
		public static String getXMLInbound(){
			Elements.isEnabled(PageElements.XML_INBOUND_STATIC);
			return Elements.getText(PageElements.XML_INBOUND_STATIC);
		}
		
		public static String getFlatFileInbound(){
			Elements.isEnabled(PageElements.FLAT_FILE_INBOUND_STATIC);
			return Elements.getText(PageElements.FLAT_FILE_INBOUND_STATIC);
		}
		
		public static String getSpreadsheetInbound(){
			Elements.isEnabled(PageElements.SPREADSHEET_INBOUND_STATIC);
			return Elements.getText(PageElements.SPREADSHEET_INBOUND_STATIC);
		}
		
		public static String getPublisherPortalInbound(){
			Elements.isEnabled(PageElements.PUBLISHER_PORTAL_INBOUND_STATIC);
			return Elements.getText(PageElements.PUBLISHER_PORTAL_INBOUND_STATIC);
		}
		
		public static String getPublisherPortalLimitedInbound(){
			Elements.isEnabled(PageElements.PUBLISHER_PORTAL_LIMITED_INBOUND_STATIC);
			return Elements.getText(PageElements.PUBLISHER_PORTAL_LIMITED_INBOUND_STATIC);
		}
		
		public static String getXMLOutbound(){
			Elements.isEnabled(PageElements.XML_OUTBOUND_STATIC);
			return Elements.getText(PageElements.XML_OUTBOUND_STATIC);
		}
		
		public static String getFlatFileOutbound(){
			Elements.isEnabled(PageElements.FLAT_FILE_OUTBOUND_STATIC);
			return Elements.getText(PageElements.FLAT_FILE_OUTBOUND_STATIC);
		}
		
		public static String getSpreadsheetOutbound(){
			Elements.isEnabled(PageElements.SPREADSHEET_OUTBOUND_STATIC);
			return Elements.getText(PageElements.SPREADSHEET_OUTBOUND_STATIC);
		}
		
		public static String getBrandedProcurement(){
			Elements.isEnabled(PageElements.BRANDED_PROCUREMENT_STATIC);
			return Elements.getText(PageElements.BRANDED_PROCUREMENT_STATIC);
		}
		
		public static String getCBORD(){
			Elements.isEnabled(PageElements.CBORD_STATIC);
			return Elements.getText(PageElements.CBORD_STATIC);
		}
		
		public static String getOrderManagementSystem(){
			Elements.isEnabled(PageElements.ORDER_MANAGEMENT_SYSTEM_STATIC);
			return Elements.getText(PageElements.ORDER_MANAGEMENT_SYSTEM_STATIC);
		}
		
		public static boolean verifyIntegrationApplications(){
			
			//inbound
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_XML_INBOUND)!=null){
				if(!getXMLInbound().contains("XML"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_FLAT_FILE_INBOUND)!=null){
				if(!getFlatFileInbound().contains("Flat File"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_SPREADSHEET_INBOUND)!=null){
				if(!getSpreadsheetInbound().contains("Spreadsheet"))
					return false;
			}
			
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_PUBLISHER_PORTAL_INBOUND)!=null){
				if(!getPublisherPortalInbound().contains("Publisher Portal"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_PUBLISHER_PORTAL_LIMITED_INBOUND)!=null){
				if(!getPublisherPortalLimitedInbound().contains("Publisher Portal (Limited)"))
					return false;
			}
			
			//outbound
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_XML_OUTBOUND)!=null){
				if(!getXMLOutbound().contains("XML"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_FLAT_FILE_OUTBOUND)!=null){
				if(!getFlatFileOutbound().contains("Flat File"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_SPREADSHEET_OUTBOUND)!=null){
				if(!getSpreadsheetOutbound().contains("Spreadsheet"))
					return false;
			}
			
			//Partner Integration
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_BRANDED_PROCUREMENT_BP)!=null){
				if(!getBrandedProcurement().contains("Branded Procurement (BP)"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_CBORD)!=null){
				if(!getCBORD().contains("CBORD"))
					return false;
			}
			
			if(Config.DATA_FLAG.get(DataKeys.INTEGRATIONS_APPLICATIONS_ORDER_MANAGEMENT_SYSTEM)!=null){
				if(!getOrderManagementSystem().contains("Order Management System (OMS)"))
					return false;
			}
			
			return true;
		}
		
		
	}
	
	public static class EntrustmentsWizard{
		
		public static class PageElements{
			
			public static final By EDIT_BUTTON = By.cssSelector("div[id='staticRoleDiv'] > div:nth-child(1) > div > div:nth-child(2) > div > button[id='edit']");
			public static final By ACTIVE_ENTRUSTMENTS_COUNT_STATIC = By.cssSelector("label[id='activeEentrustments']");
			public static final By ACTIVE_ENTRUSTMENT_NAME_STATIC  =By.cssSelector("div[id='searchExistingPartner'] > div[id*='partner']");
			
			
		}
		
		public static void clickEditButton(){
			Elements.isEnabled(PageElements.EDIT_BUTTON);
			Elements.clickElement(PageElements.EDIT_BUTTON);
			EditCompanyInformationPage.EntrustmentsWizard.waitForAvailablePartnersDataLoad();
		}
		
		public static int getActiveEntrustmentsCount(){
			Elements.isEnabled(PageElements.ACTIVE_ENTRUSTMENTS_COUNT_STATIC);
			String count = Elements.getText(PageElements.ACTIVE_ENTRUSTMENTS_COUNT_STATIC);
			return Integer.parseInt(count);
		}
		
		public static List<String> getActiveEntrustmentNames(){
			List<String> names = new ArrayList<String>();
			Elements.pauseExecution(3000);
			Elements.findAll(PageElements.ACTIVE_ENTRUSTMENT_NAME_STATIC);
			List<WebElement> activeEntrustments = Elements.findAll(PageElements.ACTIVE_ENTRUSTMENT_NAME_STATIC);			
			for(int i=0; i<activeEntrustments.size();i++){
				names.add(Elements.getText(activeEntrustments.get(i)));			
			}
			
			return names;
		}
	}
	
	public static class UserAccountsWizard{
		
		public static class PageElements{
			
			public static final By ADD_USER_BUTTON = By.cssSelector("button[ng-click='showAddUser()']");
			public static final By EDIT_USER_LINK = By.cssSelector("td[ng-if$='canManageUser()'] > a > i");
			
		}
		
		public static void clickAddButton(){
			Elements.isEnabled(PageElements.ADD_USER_BUTTON);
			Elements.clickElement(PageElements.ADD_USER_BUTTON);
			Elements.waitForElementToBeVisible(EditCompanyInformationPage.UserAccountsWizard.PageElements.ADD_USER_BUTTON);
		}
		
		public static void clickEditUser(String userName){
			int index = MDS_Table.getIndexOfDataFromColumn(ColumnName.LAST_NAME,userName);
			List<WebElement> data = Elements.findAll(PageElements.EDIT_USER_LINK);
			Elements.clickElement(data.get(index), Config.wait);
		}
		
		public static boolean verifyUserListed(String userName){
			if(MDS_Table.verifyColumnData(ColumnName.FIRST_NAME, userName))
				return true;
			else
				return false;
		}
		
		
	}
}
