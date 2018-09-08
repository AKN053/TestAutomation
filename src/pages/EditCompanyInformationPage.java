package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Config;
import common.Config.DataKeys;
import common.Enumerations.CompanyStatus;
import common.Enumerations.Country;
import common.Enumerations.IndustrySegment;
import common.Enumerations.State;
import common.Enumerations.UserRole;
import framework.helpers.Elements;
import framework.providers.Data;

public class EditCompanyInformationPage extends BasePage{
	
	
	public static class PageElements{
		//Page Title
		public static final By PAGE_HEADER_STATIC = By.cssSelector("div[ng-init='setForm(companyform)'] > h4 > b");
		
		//Footer Buttons
		public static final By CANCEL_BUTTON = By.cssSelector("button[id='cancel']");
		public static final By SAVE_CHANGES_BUTTON = By.cssSelector("button[id='saveChanges']");
		
		//Alert - appear if mandatory fileds are not filled
		public static final By ALERT_MESSAGE = By.cssSelector("div[id='errorAlert'][role='alert']");
		
			
	}
	
	public static String getPageTitle(){
		String title = "Page Not Found!!!"; 
		
		if(Elements.isEnabled(PageElements.PAGE_HEADER_STATIC)){
			title = Elements.getText(PageElements.PAGE_HEADER_STATIC);
		}
		System.out.println("*******\nTitle : "+title);
		return title;
	}
	
	public static void clickCancelButton(){
		Elements.isEnabled(PageElements.CANCEL_BUTTON);
		Elements.clickElement(PageElements.CANCEL_BUTTON);
	}
	
	
	public static void clickSaveChangesButton(){
		Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
		Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
		waitForEditCompanyInfoToDisappear();
	}
	
	public static void waitForEditCompanyInfoToDisappear(){
		Elements.isDisappeared(PageElements.SAVE_CHANGES_BUTTON, Config.pageLoadRetry);
		Elements.pauseExecution(3000);
	}
	
	public static String clickSaveButtonAndGetAlert(){
		Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
		Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
		return Elements.getText(PageElements.ALERT_MESSAGE);
	}
	
	public static void waitForPageLoad(){
		int count = 0 ;
		
		while(true){
			if(ViewCompanyAccountPage.verifyViewCompanyPageLoaded() && count< Config.pageLoadRetry){
				Elements.pauseExecution(1500);
				System.out.println("Page Loaded");
				break;
			}
			else
			{
				System.out.println("Loading this page");
				Elements.pauseExecution(1500);
				
			}
			count++;
				
		}
	}
	
	
	public static class CompanyInformationWizard{
		
			public static class PageElements{
				
				public static final By COMPANY_REGISTRATION_STAUS_DROPDOWN =By.cssSelector("select[name='status']");
				//public static final By COMPANY_REGISTRATION_STAUS_DROPDOWN =By.cssSelector("select[name='status']");
				public static final By COMPANY_NAME_TEXTBOX =By.cssSelector("input[name='companyName']");
				public static final By SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX = By.cssSelector("input[id='buName']");
				public static final By COMPANY_URL_TEXTBOX = By.cssSelector("input[name='companyURL']");
				public static final By GLN_TEXTBOX = By.cssSelector("input[name='gln0']");
				public static final By DUNS_TEXTBOX = By.cssSelector("input[id='dunsNumber']");
				public static final By INDUSTRY_SEGMENT_DROPDOWN = By.cssSelector("select[name='industrysegment']");
				public static final By STREET_ADDRESS1_TEXTBOX = By.cssSelector("input[id='address1']");
				public static final By STREET_ADDRESS2_TEXTBOX = By.cssSelector("input[id='address2']");
				public static final By CITY_TEXTBOX = By.cssSelector("input[name='city']");
				public static final By COUNTY_TEXTBOX = By.cssSelector("input[name='country']");
				public static final By STATE_DROPDOWN = By.cssSelector("select[name='state']");
				public static final By ZIP_TEXTBOX = By.cssSelector("input[name='zip']");
				public static final By COUNTRY_DROPDOWN = By.cssSelector("select[name='country']");
				public static final By FIRST_NAME_TEXTBOX =By.cssSelector("input[name='firstName']");
				public static final By ADD_MIDDLE_NAME_BUTTON = By.cssSelector("button[id='addMiddleName']");
				
				public static final By LAST_NAME_TEXTBOX = By.cssSelector("input[name='lastName']");
				public static final By TITLE_TEXTBOX = By.cssSelector("input[ng-model='companyAdminAdd.uiModel.Company.companyContact.title']");
				public static final By EMAIL_TEXTBOX = By.cssSelector("input[name='email']");
				public static final By PHONE_TEXTBOX = By.cssSelector("input[name='phone']");
				public static final By ADD_FAX_LINK = By.cssSelector("button[type='button']");
				public static final By FAX_TEXTBOX = By.cssSelector("input[name='fax']");
				public static final By USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX = By.cssSelector("input[id='billingInfoCkeck']");
				
				
				//Billing Information 
				
				public static final By BILLING_FIRST_NAME_TEXTBOX = By.cssSelector("input[name='billingFirstName']");
				public static final By BILLING_MIDDLE_NAME_TEXTBOX = By.cssSelector("input[name='billingMiddleName']");
				public static final By BILLING_LAST_NAME_TEXTBOX = By.cssSelector("input[name='billingLastName']");
				public static final By BILLING_TITLE_TEXTBOX = By.cssSelector("input[ng-model='companyAdminAdd.uiModel.Company.companyContact.billingTiltle']");
				public static final By BILLING_EMAIL_TEXTBOX = By.cssSelector("input[name='billingEmail']");
				public static final By BILLING_PHONE_TEXTBOX = By.cssSelector("input[name='billingPhone']");
				public static final By BILLING_ADD_FAX_LINK =By.cssSelector("button[id='addBillingFax']");
				public static final By BILLING_FAX_TEXTBOX = By.cssSelector("input[name='billingFax']");
				public static final By BILLING_STREET_ADDRESS1_TEXTBOX = By.cssSelector("input[name='billingAddress1']");
				public static final By BILLING_STREET_ADDRESS2_TEXTBOX = By.cssSelector("input[name='billingAddress2']");
				public static final By BILLING_CITY_TEXTBOX = By.cssSelector("input[name='billingCity']");
				public static final By BILLING_COUNTY_TEXTBOX = By.cssSelector("input[id='billingCounty']");
				public static final By BILLING_STATE_DROPDOWN = By.cssSelector("select[name='state']");
				public static final By BILLING_ZIP_TEXTBOX = By.cssSelector("input[name='billingZip']");
				public static final By BILLING_COUNTRY_DROPDOWN = By.cssSelector("select[name='country']");	
				
				public static final By CANCEL_BUTTON = By.cssSelector("ng-form[name='companyform'] > div:nth-child(4) > div[ng-show='infoEditable'] > div:nth-child(1) > button[id='cancel']");
				
			}
			
			public static void selectStatus(CompanyStatus companyStatus){
				Elements.isEnabled(PageElements.COMPANY_REGISTRATION_STAUS_DROPDOWN);
				Elements.selectOption(PageElements.COMPANY_REGISTRATION_STAUS_DROPDOWN, companyStatus.toString());
			}
			
			public static void clickCancel(){
				Elements.clickElement(PageElements.CANCEL_BUTTON);
			}
			
			
			
			public static void setCompanyName(){
				
				String name="Automation" + Data.getString(6);
				Elements.isEnabled(PageElements.COMPANY_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.COMPANY_NAME_TEXTBOX, name);
			}
			
			public static void setSubsidaryOrBusinessUnit(){
				String name="Automation"+ Data.getString(6);
				Config.DATA_MAP.put(DataKeys.SUBSIDIARY_OR_BUSINESS_UNIT, name);
				Elements.isEnabled(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX);
				Elements.clearAndType(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX, name);
			}
			
			public static void setCompanyURL(){
				String data = Data.getWebSiteURL(6);
				Config.DATA_MAP.put(DataKeys.COMPANY_URL, data);
				Elements.isEnabled(PageElements.COMPANY_URL_TEXTBOX);
				Elements.clearAndType(PageElements.COMPANY_URL_TEXTBOX, data);
			}
			
			public static void setGLNNumber(){
				String data = Data.getNumber(13);
				Config.GLNS.add(data);
				Elements.isEnabled(PageElements.GLN_TEXTBOX);
				Elements.clearAndType(PageElements.GLN_TEXTBOX, data);
			}
			
			public static void setDUNSNumber(){
				String data = Data.getNumber(13);
				//Config.DATA_MAP.put(DataKeys.DUN, data);
				Config.DUNS.add(data);
				Elements.isEnabled(PageElements.DUNS_TEXTBOX);
				Elements.clearAndType(PageElements.DUNS_TEXTBOX, data);
			}
			
			public static void selectIndustrySegment(IndustrySegment industrySegment){
				
				Config.DATA_MAP.put(DataKeys.INDUSTRY_SEGMENT, industrySegment.toString());
				Elements.isEnabled(PageElements.INDUSTRY_SEGMENT_DROPDOWN);
				//Elements.clickElement(PageElements.INDUSTRY_SEGMENT_DROPDOWN);
				Elements.selectOption(PageElements.INDUSTRY_SEGMENT_DROPDOWN, industrySegment.toString());
			}
			
			public static void setStreetAddress(){
				String data1 = Data.getString(10);
				String data2 = Data.getString(10);
				Config.DATA_MAP.put(DataKeys.STREET_ADDRESS, data1+" , "+data2);
				Elements.isEnabled(PageElements.STREET_ADDRESS1_TEXTBOX);
				Elements.clearAndType(PageElements.STREET_ADDRESS1_TEXTBOX, data1);
				Elements.clearAndType(PageElements.STREET_ADDRESS2_TEXTBOX, data2);
			}
			
			
			public static void setCity(){
				String data = Data.getString(8);
				Config.DATA_MAP.put(DataKeys.CITY, data);
				Elements.isEnabled(PageElements.CITY_TEXTBOX);
				Elements.clearAndType(PageElements.CITY_TEXTBOX, data);
			}
			
			public static void setCounty(){
				String data = Data.getString(8);
				Config.DATA_MAP.put(DataKeys.COUNTY, data);
				Elements.isEnabled(PageElements.COUNTY_TEXTBOX);
				Elements.clearAndType(PageElements.COUNTY_TEXTBOX, data);
			}
			public static void selectState(State state){
				Config.DATA_MAP.put(DataKeys.STATE, state.toString());
				Elements.pauseExecution(3500);
				Elements.isEnabled(PageElements.STATE_DROPDOWN);
				Elements.selectOption(PageElements.STATE_DROPDOWN, state.toString());
			}
			
			
			public static void setZip(){
				String data = Data.getNumber(5);
				Config.DATA_MAP.put(DataKeys.ZIP, data);
				Elements.isEnabled(PageElements.ZIP_TEXTBOX);
				Elements.clearAndType(PageElements.ZIP_TEXTBOX, data);
			}
			
			public static void selectCountry(Country country){				
				Config.DATA_MAP.put(DataKeys.COUNTRY, country.toString());
				Elements.isEnabled(PageElements.COUNTRY_DROPDOWN);
				Elements.selectOption(PageElements.COUNTRY_DROPDOWN, country.toString());		
			}
				
			
			public static void setFirstName(){
				String data = Data.getString(10);
				Config.DATA_MAP.put(DataKeys.FIRST_NAME, data);
				Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.FIRST_NAME_TEXTBOX, data);
				
			}
			
			public static void setLastName(){
				String data = Data.getString(10);
				Config.DATA_MAP.put(DataKeys.LAST_NAME, data);
				Elements.isEnabled(PageElements.LAST_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.LAST_NAME_TEXTBOX, data);
			}
			
			public static void setTitle(){
				
				Elements.isEnabled(PageElements.TITLE_TEXTBOX);
				Elements.clearAndType(PageElements.TITLE_TEXTBOX, Data.getString(4));
			}
			
			public static void setEmail(){
				String data = Data.getMailId("");
				Config.DATA_MAP.put(DataKeys.EMAIL, data);
				Elements.isEnabled(PageElements.EMAIL_TEXTBOX);
				Elements.clearAndType(PageElements.EMAIL_TEXTBOX, data);
			}
			
			public static void setPhone(){
				String data = Data.getNumber(10);
				Config.DATA_MAP.put(DataKeys.PHONE, data);
				Elements.isEnabled(PageElements.PHONE_TEXTBOX);
				Elements.clearAndType(PageElements.PHONE_TEXTBOX, data);
			}
			
			public static void clickAddFaxLink(){
				
				Elements.isEnabled(PageElements.ADD_FAX_LINK);
				Elements.clickElement(PageElements.ADD_FAX_LINK);
			}
			
			public static void setFaxNumber(){
				String data = Data.getNumber(10);
				Config.DATA_MAP.put(DataKeys.FAX, data);
				Elements.isEnabled(PageElements.FAX_TEXTBOX);
				Elements.clearAndType(PageElements.FAX_TEXTBOX, data);
			}
			
			
			
			// Billing Information
			
			public static void setBillingFirstName(){
				Elements.isEnabled(PageElements.BILLING_FIRST_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_FIRST_NAME_TEXTBOX, Data.getString(10));	
			}
			
			public static void setBillingMiddleName(){
				Elements.isEnabled(PageElements.BILLING_MIDDLE_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_MIDDLE_NAME_TEXTBOX, Data.getString(10));
			}
			
			public static void setBillingLastName(){
				Elements.isEnabled(PageElements.BILLING_LAST_NAME_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_LAST_NAME_TEXTBOX, Data.getString(10));
			}
			
			public static void setBillingTitle(){
				Elements.isEnabled(PageElements.BILLING_TITLE_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_TITLE_TEXTBOX, Data.getString(4));
			}
			
			public static void setBillingEmail(){
				Elements.isEnabled(PageElements.BILLING_EMAIL_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_EMAIL_TEXTBOX, Data.getMailId(""));
			}
			
			public static void setBillingPhone(){
				Elements.isEnabled(PageElements.BILLING_PHONE_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_PHONE_TEXTBOX, Data.getString(10));
			}
			
			
			public static void clickAddBillingFaxLink(){
				Elements.isEnabled(PageElements.BILLING_ADD_FAX_LINK);
				Elements.clickElement(PageElements.BILLING_FAX_TEXTBOX);
			}
			
			public static void setBillingFax(){
				Elements.isEnabled(PageElements.BILLING_FAX_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_FAX_TEXTBOX, Data.getNumber(10));
			}
				
			public static void setBillingStreetAddress(){
				Elements.isEnabled(PageElements.BILLING_STREET_ADDRESS1_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_STREET_ADDRESS1_TEXTBOX, Data.getString(10));
				Elements.clearAndType(PageElements.BILLING_STREET_ADDRESS2_TEXTBOX, Data.getString(10));
			}
			
			public static void setBillingCity(){
				Elements.isEnabled(PageElements.BILLING_CITY_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_CITY_TEXTBOX, Data.getString(8));
			}
			
			public static void setBillingCounty(){
				Elements.isEnabled(PageElements.BILLING_COUNTY_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_COUNTY_TEXTBOX, Data.getString(8));
			}
			
			public static void selectBillingState(State state){
				Elements.isEnabled(PageElements.BILLING_STATE_DROPDOWN);
				Elements.selectOption(PageElements.BILLING_STATE_DROPDOWN, state.toString());
			}
			
			public static void setBillingZip(String zipCode){
				Elements.isEnabled(PageElements.BILLING_ZIP_TEXTBOX);
				Elements.clearAndType(PageElements.BILLING_ZIP_TEXTBOX, zipCode);
			}
			
			public static void selectBillingCountry(Country country){				
				Elements.isEnabled(PageElements.BILLING_COUNTRY_DROPDOWN);
				Elements.selectOption(PageElements.BILLING_COUNTRY_DROPDOWN, country.toString());
				
			}			
			
			
			public void checkUncheck_UseSameInfoAsProfileContact(boolean flag){
				if(flag){
					if(!Elements.find(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX).isSelected())
						Elements.clickElement(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX);
						}
				else{
					if(Elements.find(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX).isSelected())
						Elements.clickElement(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX);
					}
					
				
			}
		
	}
	
	public static class CompanyRolesWizard{
		
			public static class PageElements{
				
				public static final By NO_RADIO_BUTTON = By.cssSelector("div[ng-init='setForm(companyRoleform)'] > div > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > span > input");
				public static final By YES_RADIO_BUTTON = By.cssSelector("div[ng-init='setForm(companyRoleform)'] > div > div:nth-child(6) > div:nth-child(2) > div:nth-child(3) > span > input");
				
				public static final By PUBLISHER_CHECKBOX=By.cssSelector("input[id='rolePub']");
				public static final By SUBSCRIBER_CHECKBOX = By.cssSelector("input[id='roleSub']");
				public static final By DIGITAL_ASSETES_MANAGEMENT_CHECKBOX = By.cssSelector("input[id='digitalAm']");
				public static final By SELL_SHEET_CHECKBOX = By.cssSelector("input[id='itnSellSheet']");
				public static final By PRODUCT_INFORMATION_MANAGEMENT_CHECKBOX = By.cssSelector("input[id='itnPim']");
				public static final By DATA_QUALITY_CHECKBOX = By.cssSelector("input[id='itnDataQuality']");
				public static final By DATA_POOL_ITN_CHECKBOX = By.cssSelector("input[id='datapoolITN']");
				public static final By DATA_POOL_3RD_PARTY_CHECKBOX = By.cssSelector("input[id='datapoolThirdParty']");
				
				public static final By SAVE_CHANGES_BUTTON = By.cssSelector("ng-form[name='companyRoleform'] > div > div[ng-show='infoEditable'] > div:nth-child(2) > button[id='saveChanges']");
				public static final By CANCEL_LINK = By.cssSelector("ng-form[name='companyRoleform'] > div > div[ng-show='infoEditable'] > div:nth-child(1) > button[id='cancel']");
				public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyRoleInfo'][role='alert']");					
			}
			
			public static void clickSaveChangesButton(){
				Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
				Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
				Elements.isDisappeared(PageElements.SAVE_CHANGES_BUTTON, Config.pageLoadRetry);
				waitForElementToBeVisible(ViewCompanyAccountPage.CompanyRolesWizard.PageElements.EDIT_BUTTON);
			}
			
			public static String clickSaveChangesButtonAndGetError(){
				Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
				Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
				return Elements.getText(PageElements.ERROR_MESSAGE);
			}
			
			
			public static void checkYesRadio(){
				
				Elements.isEnabled(PageElements.YES_RADIO_BUTTON);
				Elements.clickElement(PageElements.YES_RADIO_BUTTON);
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_IS_GDSN, true);
			}
			
			public static void checkNoRadio(){
				Elements.isEnabled(PageElements.NO_RADIO_BUTTON);
				Elements.clickElement(PageElements.NO_RADIO_BUTTON);
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_IS_GDSN, false);
			}
			
			public static List<WebElement> getAllCheckBoxes(){
				/*List<WebElement> all = Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
				System.out.println("Size : "+all.size());
				for(int i=0; i<all.size();i++){
					//System.out.println(all.get(i).getAttribute("id"));
					
					WebElement input = Elements.find(all.get(i),By.cssSelector("input"));
					System.out.println(i+" : "+input.getAttribute("id"));
					//input.click();
				}*/
				//return  Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
				return  Elements.findAll(By.cssSelector("span[class='checkboxNative']"));
				
			}
			
			public static void checkPublisherCheckBox(){
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(0),By.cssSelector("input"));			
				checkbox.click();
				/*Elements.isEnabled(PageElements.PUBLISHER_CHECKBOX);
				Elements.clickElement(PageElements.PUBLISHER_CHECKBOX);*/
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_PUBLISHER, true);
			}
			
			public static void checkSubscriberCheckBox(){
				/*Elements.isEnabled(PageElements.SUBSCRIBER_CHECKBOX);
				Elements.clickElement(PageElements.SUBSCRIBER_CHECKBOX);*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(1),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_SUBSCRIBER, true);
			}
			
			//Advanced Features
			public static void checkDigitalAssetsManagementCheckBox(){
				/*Elements.isEnabled(PageElements.DIGITAL_ASSETES_MANAGEMENT_CHECKBOX);
				Elements.clickElement(PageElements.DIGITAL_ASSETES_MANAGEMENT_CHECKBOX);*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(4),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_DIGITAL_ASSET_MANAGEMENT, true);
			}
			
			public static void checkSellSheetCheckBox(){
				/*Elements.isEnabled(PageElements.SELL_SHEET_CHECKBOX);
				Elements.clickElement(PageElements.SELL_SHEET_CHECKBOX);	*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(5),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_SELL_SHEET, true);
			}
			
			
			//ITN Solutions
			public static void checkProductInfoManagementCheckBox(){
				/*Elements.isEnabled(PageElements.PRODUCT_INFORMATION_MANAGEMENT_CHECKBOX);
				Elements.clickElement(PageElements.PRODUCT_INFORMATION_MANAGEMENT_CHECKBOX);*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(2),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_PRODUCT_INFORMATION_MANAGEMENT_PIM, true);
			}
			
			public static void checkDataQualityCheckBox(){
				/*Elements.isEnabled(PageElements.DATA_QUALITY_CHECKBOX);
				Elements.clickElement(PageElements.DATA_QUALITY_CHECKBOX);	*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(3),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_DATA_QUALITY, true);
			}
			
			//Data Pool Membership
			public static void checkDataPool_ITN_CheckBox(){
				/*Elements.isEnabled(PageElements.DATA_POOL_ITN_CHECKBOX);
				Elements.clickElement(PageElements.DATA_POOL_ITN_CHECKBOX);	*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(6),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_DATA_POOL_ITN, true);
			}
			
			public static void checkDataPool_3P_CheckBox(){
				/*Elements.isEnabled(PageElements.DATA_POOL_3RD_PARTY_CHECKBOX);
				Elements.clickElement(PageElements.DATA_POOL_3RD_PARTY_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(7),By.cssSelector("input"));			
				checkbox.click();
				Config.DATA_FLAG.put(DataKeys.COMPANY_ROLES_DATA_POOL_3RD_PARTY, true);
			}
			
			public static void clickCancelButton(){
				Elements.isEnabled(PageElements.CANCEL_LINK);
				Elements.clickElement(PageElements.CANCEL_LINK);
				waitForElementToBeVisible(ViewCompanyAccountPage.CompanyRolesWizard.PageElements.EDIT_BUTTON);
			}
			
			
			
		
	}
	
	public static class IntegrationsApplicationsWizard{
		
			public static class PageElements{
				
				//Inbound Integration
				public static final By XML_INBOUND_CHECKBOX = By.cssSelector("input[id='integInboundXML'][type='checkbox']");
				public static final By FLAT_FILE_INBOUND_CHECKBOX = By.cssSelector("input[id='integInboundFlatFile'][type='checkbox']");
				public static final By SPREADSHEET_INBOUND_CHECKBOX = By.cssSelector("input[id='integInboundSpreadSheet'][type='checkbox']");
				public static final By PUBLISHER_PORTAL_INBOUND_CHECKBOX = By.cssSelector("input[id='integInboundPub'][type='checkbox']");
				public static final By PUBLISHER_PORTAL_LIMITED_INBOUND_CHECKBOX = By.cssSelector("input[id='integInboundPubLimited'][type='checkbox']");
				
				//Outbound Integration
				public static final By XML_OUTBOUND_CHECKBOX = By.cssSelector("input[id='integOutboundXML'][type='checkbox']");
				public static final By FLAT_FILE_OUTBOUND_CHECKBOX = By.cssSelector("input[id='integOutboundFlatFile'][type='checkbox']");
				public static final By SPREADSHEET_OUTBOUND_CHECKBOX = By.cssSelector("input[id='integOutboundSpreadSheet'][type='checkbox']");
				
				//Partner Integration
				public static final By BRANDED_PROCUREMENT_CHECKBOX = By.cssSelector("input[id='integPartnerBP']");
				public static final By CBORD_CHECKBOX = By.cssSelector("input[id='integPartnerCbord']");
				public static final By OMS_CHECKBOX = By.cssSelector("input[id='integPartnerOms']");
				
				//Save Button
				
				public static final By SAVE_CHANGES_BUTTON = By.cssSelector("button[id='saveChanges'][ng-click*='saveChangesEditPage()']");
				public static final By CANCEL_LINK = By.cssSelector("div[ng-show='infoEditable'] > div:nth-child(1) > button[id='cancel']");
				
				public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyIntegrationInfo'][role='alert']");
				
			}
			
			
			public static List<WebElement> getAllCheckBoxes(){
				/*List<WebElement> all = Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
				System.out.println("Size : "+all.size());
				for(int i=0; i<all.size();i++){
					//System.out.println(all.get(i).getAttribute("id"));
					
					WebElement input = Elements.find(all.get(i),By.cssSelector("input"));
					System.out.println(i+" : "+input.getAttribute("id"));
					//input.click();
				}*/
				//return  Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
				return  Elements.findAll(By.cssSelector("span[class='checkboxNative']"));
				
			}
			
			//INBOUND
			public static void checkXMLInboundCheckbox(){
				/*Elements.isEnabled(PageElements.XML_INBOUND_CHECKBOX);
				Elements.clickElement(PageElements.XML_INBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(0),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkFlatFileInboundCheckbox(){
				/*Elements.isEnabled(PageElements.FLAT_FILE_INBOUND_CHECKBOX);
				Elements.clickElement(PageElements.FLAT_FILE_INBOUND_CHECKBOX);*/
				
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(1),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkSpreadSheetInboundCheckbox(){
				/*Elements.isEnabled(PageElements.SPREADSHEET_INBOUND_CHECKBOX);
				Elements.clickElement(PageElements.SPREADSHEET_INBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(2),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkPublisherPortalInboundCheckbox(){
				/*Elements.isEnabled(PageElements.PUBLISHER_PORTAL_INBOUND_CHECKBOX);
				Elements.clickElement(PageElements.PUBLISHER_PORTAL_INBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(3),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkPublisherPortalLimitedInboundCheckbox(){
				/*Elements.isEnabled(PageElements.PUBLISHER_PORTAL_LIMITED_INBOUND_CHECKBOX);
				Elements.clickElement(PageElements.PUBLISHER_PORTAL_LIMITED_INBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(4),By.cssSelector("input"));			
				checkbox.click();
			}
			
			
			//OUTBOUND
			
			public static void checkXMLOutboundCheckbox(){
				/*Elements.isEnabled(PageElements.XML_OUTBOUND_CHECKBOX);
				Elements.clickElement(PageElements.XML_OUTBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(5),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkFlatFileOutboundCheckbox(){
				/*Elements.isEnabled(PageElements.FLAT_FILE_OUTBOUND_CHECKBOX);
				Elements.clickElement(PageElements.FLAT_FILE_OUTBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(6),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkSpreadSheetOutboundCheckbox(){
				/*Elements.isEnabled(PageElements.SPREADSHEET_OUTBOUND_CHECKBOX);
				Elements.clickElement(PageElements.SPREADSHEET_OUTBOUND_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(7),By.cssSelector("input"));			
				checkbox.click();
			}
			
			//PARTNER INTEGRATION
			
			public static void checkBrandedProcurementCheckbox(){
				/*Elements.isEnabled(PageElements.BRANDED_PROCUREMENT_CHECKBOX);
				Elements.clickElement(PageElements.BRANDED_PROCUREMENT_CHECKBOX);*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(8),By.cssSelector("input"));			
				checkbox.click();
				
			}
			
			public static void checkCBORDCheckbox(){
				/*Elements.isEnabled(PageElements.CBORD_CHECKBOX);
				Elements.clickElement(PageElements.CBORD_CHECKBOX);	*/
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(9),By.cssSelector("input"));			
				checkbox.click();
			}
			
			public static void checkOMSCheckbox(){
				/*Elements.isEnabled(PageElements.OMS_CHECKBOX);
				Elements.clickElement(PageElements.OMS_CHECKBOX);*/			
				List<WebElement> allCheckboxes = getAllCheckBoxes();
				WebElement checkbox = Elements.find(allCheckboxes.get(10),By.cssSelector("input"));			
				checkbox.click();
			}
			
			//Actions
			public static void clickSaveChangesButton(){
				Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
				Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
				Elements.isDisappeared(PageElements.SAVE_CHANGES_BUTTON, Config.pageLoadRetry);
			}
			
			
			public static String clickSaveChangesButtonAndGetAlert(){
				Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
				Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
				return Elements.getText(PageElements.ERROR_MESSAGE);
			}
			
			public static void clickCancel(){
				Elements.isEnabled(PageElements.CANCEL_LINK);
				Elements.clickElement(PageElements.CANCEL_LINK);
				Elements.isDisappeared(PageElements.SAVE_CHANGES_BUTTON, Config.pageLoadRetry);
			}
			
			
		
		
	}
	
	public static class EntrustmentsWizard{
			
			public static class PageElements{				
				public static final By SEARCH_TEXTBOX_AVAILABLE_PARTNERS = By.cssSelector("input[id='searchExistingPartner']");
				public static final By SEARCH_TEXTBOX_SELECTED_PARTNERS = By.cssSelector("input[id='searchSelectedPartners']");
				
				public static final By AVAILABLE_PARTNERS_LIST = By.cssSelector("div[id='partnerList'] > div");
				public static final By SELECTED_PARTNERS_LIST = By.cssSelector("div[id='selectedPartnerList'] > div");		
				
				//Action buttons
				public static final By SAVE_CHANGES_BUTTON = By.cssSelector("div[ng-show='infoEditable'] > div:nth-child(2) > button[id='saveChanges']");
				public static final By CANCEL_LINK = By.cssSelector("div[ng-show='infoEditable'] > div:nth-child(1) > button[id='cancel']");
			}
			
			public static void addFromAvailablePartners(String partnerName){
				//Elements.isEnabled(PageElements.AVAILABLE_PARTNERS_TABLE);
				Config.DATA_MAP.put(DataKeys.SELECTED_PARTNER_ENTRUSTMENT, partnerName);
				AddRemoveTable.searchInLeftTableAndAddtoRightTable(PageElements.SEARCH_TEXTBOX_AVAILABLE_PARTNERS, PageElements.AVAILABLE_PARTNERS_LIST,partnerName);
			}
			
			public static boolean verifyInAvailablePartnersTable(String partnerName){
				Elements.isEnabled(PageElements.SEARCH_TEXTBOX_AVAILABLE_PARTNERS);
				return AddRemoveTable.verifyInTable(PageElements.SEARCH_TEXTBOX_AVAILABLE_PARTNERS, PageElements.AVAILABLE_PARTNERS_LIST, partnerName);
			}
			
			public static void removeFromSelectedPartnerList(String partnerName){
				Elements.isEnabled(PageElements.SEARCH_TEXTBOX_SELECTED_PARTNERS);
				AddRemoveTable.searchInLeftTableAndAddtoRightTable(PageElements.SEARCH_TEXTBOX_SELECTED_PARTNERS, PageElements.SELECTED_PARTNERS_LIST , partnerName);
			}
			
			public static boolean verifyInSelectedPartnersTable(String partnerName){
				Elements.isEnabled(PageElements.SEARCH_TEXTBOX_SELECTED_PARTNERS);
				return AddRemoveTable.verifyInTable(PageElements.SEARCH_TEXTBOX_SELECTED_PARTNERS, PageElements.SELECTED_PARTNERS_LIST ,partnerName);	
				
			}
			
			public static void addFirstAvailablePartner(){
				List<WebElement> existingPartners = Elements.findAll(PageElements.AVAILABLE_PARTNERS_LIST);
				while(existingPartners.size()<3){
					System.out.println("Loading existing partners...");
					Elements.pauseExecution(2500);
					existingPartners = Elements.findAll(PageElements.AVAILABLE_PARTNERS_LIST);
				}
				//addFromAvailablePartners(Elements.getText(existingPartners.get(0)));
				Config.DATA_MAP.put(Config.DataKeys.SELECTED_PARTNER_ENTRUSTMENT, Elements.getText(existingPartners.get(0)));
				Elements.clickElement(existingPartners.get(0), Config.sleep);
				Elements.pauseExecution(3000);
			}
			
			public static void waitForAvailablePartnersDataLoad(){
				List<WebElement> existingPartners = Elements.findAll(PageElements.AVAILABLE_PARTNERS_LIST);
				int count=0;
				while(true){
					
					if(existingPartners.size() < 2 || count > Config.pageLoadRetry  ){
						Elements.pauseExecution(1500);
						System.out.println("Available partners to load in Entrustment tab");
						existingPartners = Elements.findAll(PageElements.AVAILABLE_PARTNERS_LIST);					
					}
					else{
						System.out.println("All available partners are loaded");
						break;
					}
						
				}
			}
			
			
			//Actions
			
			public static void clickSaveChangesButton(){
				
				Elements.isEnabled(PageElements.SAVE_CHANGES_BUTTON);
				Elements.clickElement(PageElements.SAVE_CHANGES_BUTTON);
				waitForElementToBeVisible(ViewCompanyAccountPage.EntrustmentsWizard.PageElements.EDIT_BUTTON);
				
			}
			
			public static void clickCancelButton(){
				Elements.isEnabled(PageElements.CANCEL_LINK);
				Elements.clickElement(PageElements.CANCEL_LINK);
				waitForElementToBeVisible(ViewCompanyAccountPage.EntrustmentsWizard.PageElements.EDIT_BUTTON);
			}
		
	}
	
	public static class UserAccountsWizard{
		
			public static class PageElements{
				
				public static final By FIRST_NAME_TEXTBOX = By.cssSelector("input[name='firstName']");
				public static final By LAST_NAME_TEXTBOX = By.cssSelector("input[name='lastName']");
				public static final By USER_ROLE_BUTTON = By.cssSelector("button[id='userRole']");
				public static final By USER_ROLE_DROPLIST = By.cssSelector("ul[role='select']");
				public static final By TITLE_TEXTBOX = By.cssSelector("input[name='title']");
				public static final By EMAIL_TEXTBOX = By.cssSelector("input[type='email'][name='email']");
				public static final By PHONE_TEXTBOX = By.cssSelector("input[name='phone'][type='tel']");
				public static final By USER_NAME_TEXTBOX = By.cssSelector("input[name='login']");
				
				public static final By ADD_USER_BUTTON = By.cssSelector("div[class*='modal-footer'] > button[type='submit'][ng-click='addUser()']");
				public static final By UPDATE_USER_BUTTON = By.cssSelector("button[type='submit][ng-click='updateUser()']");
				public static final By CANCEL_LINK = By.cssSelector("div[class*='modal-footer'] > a[id='cancel']");
				
				public static final By ALERT_MESSAGE = By.cssSelector("div[id='UserAccountModalActionPanel'] > div > span");			
				
				
			}
			
			public static void setFirstName(){
				String firstName = Data.getString(8);
				Config.DATA_MAP.put(DataKeys.FIRST_NAME_USER, firstName);
				Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
				Elements.typeIN(PageElements.FIRST_NAME_TEXTBOX, firstName);
			}
			
			public static void setLastName(){
				String lastName = Data.getString(8);
				Config.DATA_MAP.put(DataKeys.LAST_NAME_USER, lastName);
				Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
				Elements.typeIN(PageElements.FIRST_NAME_TEXTBOX, lastName);
			}
			
			public static void selectUserRole(UserRole userRole){
				
				Config.DATA_MAP.put(DataKeys.USER_ROLE, userRole.toString());
				Elements.isEnabled(PageElements.USER_ROLE_BUTTON);
				Elements.clickElement(PageElements.USER_ROLE_BUTTON);
				Elements.clickElementInDropList(PageElements.USER_ROLE_DROPLIST, "", userRole.toString());
			}
			
			public static void setTitle(){
				String data = Data.getString(4);
				Config.DATA_MAP.put(DataKeys.TITLE_USER, data);
				Elements.isEnabled(PageElements.TITLE_TEXTBOX);
				Elements.typeIN(PageElements.TITLE_TEXTBOX, data);
			}
			
			public static void setEmail(){
				String data = Data.getMailId("");
				Config.DATA_MAP.put(DataKeys.EMAIL_USER, data);
				Elements.isEnabled(PageElements.EMAIL_TEXTBOX);
				Elements.typeIN(PageElements.EMAIL_TEXTBOX, data);
			}
			
			public static void setPhone(){
				String data = Data.getNumber(10);
				Config.DATA_MAP.put(DataKeys.PHONE_USER, data);
				Elements.isEnabled(PageElements.PHONE_TEXTBOX);
				Elements.typeIN(PageElements.PHONE_TEXTBOX, data);
			}
			
			public static void setUserName(){
				String data = Data.getString(10);
				Config.DATA_MAP.put(DataKeys.USER_NAME_USER, data);
				Elements.isEnabled(PageElements.USER_NAME_TEXTBOX);
				Elements.typeIN(PageElements.USER_NAME_TEXTBOX, data);
			}
			
			public static String getAlertMessage(){
				
				if(Elements.isExist(PageElements.ALERT_MESSAGE))
					return Elements.getText(PageElements.ALERT_MESSAGE);
				
				else
					return "ALERT NOT PRESENT";
				
			}
			
			public static void clickAddUserButton(){
				Elements.isEnabled(PageElements.ADD_USER_BUTTON);
				Elements.clickElement(PageElements.ADD_USER_BUTTON);
				waitForElementToBeVisible(ViewCompanyAccountPage.UserAccountsWizard.PageElements.ADD_USER_BUTTON);
			}
			
			public static void clickUpdateUserButton(){
				Elements.isEnabled(PageElements.UPDATE_USER_BUTTON);
				Elements.clickElement(PageElements.UPDATE_USER_BUTTON);
				waitForElementToBeVisible(ViewCompanyAccountPage.UserAccountsWizard.PageElements.ADD_USER_BUTTON);
			}
			
			public static void clickCancelLink(){
				Elements.isEnabled(PageElements.CANCEL_LINK);
				Elements.clickElement(PageElements.CANCEL_LINK);
				waitForElementToBeVisible(ViewCompanyAccountPage.UserAccountsWizard.PageElements.ADD_USER_BUTTON);
			}
			
			
		
	}

}
