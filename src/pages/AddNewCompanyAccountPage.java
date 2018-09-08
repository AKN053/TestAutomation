package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.Config;
import common.Config.DataKeys;
import common.Enumerations.Country;
import common.Enumerations.IndustrySegment;
import common.Enumerations.State;
import common.Enumerations.UserRole;
import framework.helpers.Elements;
import framework.providers.Data;
import framework.providers.DriverManager;

public class AddNewCompanyAccountPage extends BasePage{	
	
	/**
	 * Company Information Wizard Page
	 * @author prashantc
	 *
	 */
	
	public static class PageElements{
		
		public static final By NEXT_BUTTON = By.cssSelector("button[id='wizardNext']");
		public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
		public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='wizardPrevious']");
		
		
		public static final By MODAL_DIALOG_HEADER = By.cssSelector("div[id='itnConfirmModal'] > div[class='modal-dialog'] > div > div[class='modal-header'] > h4");
		public static final By MODAL_DIALOG_CONTENT = By.cssSelector("div[id='itnConfirmModal'] > div[class='modal-dialog'] > div > div[ng-bind-html='content']");
		public static final By MODAL_DIALOG_OK_BUTTON = By.cssSelector("div[id='itnConfirmModal'] > div[class='modal-dialog'] > div > div[class='modal-footer'] > button[ng-click='answer(true)']");
		public static final By MODAL_DIALOG_CANCEL_BUTTON = By.cssSelector("div[id='itnConfirmModal'] > div[class='modal-dialog'] > div > div[class='modal-footer'] > button[ng-click='answer(false)']");
		
		public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyInfo'][id='errorAlert']");
		
	}
	
	/*public static String clickNextButtonAndGetErrorMessage(){
		Elements.isEnabled(PageElements.NEXT_BUTTON);
		Elements.clickElement(PageElements.NEXT_BUTTON);
		return getErrorMessage();
	}*/
	
	/**
	 * This method is used to fetch the error message displayed for mandatory fields
	 * @return : the error message
	 */
	/*public static String getErrorMessage(){
		int count=0;
		while(count<10){
			if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
				Elements.pauseExecution(1500);
			}
			else
				return Elements.getText(PageElements.ERROR_MESSAGE);
			
			count++;
		}
		
		return "Error_Message_Not_Displayed";
	}*/
	/*public static void clickNextButton(){
		String nextPage = getNextPage();
		Elements.isEnabled(PageElements.NEXT_BUTTON);
		Elements.clickElement(PageElements.NEXT_BUTTON);
		waitForNextPageToLoad(nextPage);
	}*/
	
	public static String getNextPage(){
		
		String url = Elements.getCurrentURL();
		String[] pageString = url.split("add/");
		String currentPage = pageString[1];
		
		String nextPage="";
		
		switch (currentPage) {
		
		case "companyinformation"			:	nextPage =  "companyroles";
												break;	
			
		case "companyroles"					: 	nextPage =  "integrationsapplications";
												break;
		
		case "integrationsapplications"		: 	nextPage =  "entrustments";
												break;
												
		case "entrustments"					: 	nextPage =  "useraccounts";
												break;
												
		case "useraccounts"					: 	nextPage =  "companyinformation";
												break;
								
		default								:   nextPage =	"WrongPage";
												break;										
		
		}
		
		
		return nextPage;
	}
	
	public static String getPreviousPage(){
		
		String url = Elements.getCurrentURL();
		String[] pageString = url.split("add/");
		String currentPage = pageString[1];
		
		String prevPage="";
		
		switch (currentPage) {
		
		case "useraccounts		"			:	prevPage =  "entrustments";
												break;	
			
		case "entrustments"					: 	prevPage =  "integrationsapplications";
												break;
		
		case "integrationsapplications"		: 	prevPage =  "companyroles";
												break;
												
		case "companyroles"					: 	prevPage =  "companyinformation";
												break;
								
		default								:   prevPage =	"WrongPage";
												break;										
		
		}
		
		
		return prevPage;
	}
	
	
	public static void waitForPageToLoad(String pageToBeLoaded){
		int count = 0;
		while(true){
			//System.out.println("waiting for page load");
			Elements.pauseExecution(1500);
			String url = Elements.getCurrentURL();
			if(url.endsWith(pageToBeLoaded) || count>Config.pageLoadRetry){
				Elements.pauseExecution(1500);
				//System.out.println("page loaded succesfully");
				break;
			}
			
			count++;
		}		
		
	}
	
		
	//Removing these buttons from common, adding them to page level
	/*public static void clickPreviousButton(){
		Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
		Elements.clickElement(PageElements.PREVIOUS_BUTTON);
	}
	
	
	public static void clickSaveAndCloseButton(){
		Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
		Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
		waitForNextPageToLoad("company");
	}*/
	
	
	public static String getModalContent(){
		Elements.isEnabled(PageElements.MODAL_DIALOG_CONTENT);
		return Elements.getText(PageElements.MODAL_DIALOG_CONTENT);			
	}
	
	public static void acceptModalDialog(){
		Elements.isEnabled(PageElements.MODAL_DIALOG_OK_BUTTON);
		Elements.clickElement(PageElements.MODAL_DIALOG_OK_BUTTON);
	}
	
	public static String acceptModalDialogAndGetContent(){
		String content = getModalContent();
		acceptModalDialog();
		return content;
	}
	
	public static void cancelModalDialog(){
		Elements.isEnabled(PageElements.MODAL_DIALOG_CANCEL_BUTTON);
		Elements.clickElement(PageElements.MODAL_DIALOG_CANCEL_BUTTON);
	}
	
	public static class CompanyInformationWizard{
		
		public static class PageElements{

			
			public static final By COMPANY_NAME_TEXTBOX = By.cssSelector("input[name='companyName']");
			public static final By SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX = By.cssSelector("input[id='buName']");
			public static final By COMPANY_URL_TEXTBOX = By.cssSelector("input[name='companyURL']");
			public static final By GLN_TEXTBOX = By.cssSelector("input[name='gln0']");
			public static final By ADD_ANOTHER_GLN_BUTTON =By.cssSelector("button[id='addAnotherGLN']");
			public static final By ADD_ANOTHER_GLN_TEXTBOX =By.cssSelector("input[name='gln1']");
			public static final By DUNS_TEXTBOX = By.cssSelector("input[id='dunsNumber']");
			public static final By INDUSTRY_SEGMENT_DROPDOWN= By.cssSelector("select[name='industrysegment']");
			public static final By STREET_ADDRESS1_TEXTBOX= By.cssSelector("input[name='address1']");
			public static final By STREET_ADDRESS2_TEXTBOX= By.cssSelector("input[ng-model*='address2']");
			public static final By CITY_TEXTBOX = By.cssSelector("input[name='city']");
			public static final By COUNTY_TEXTBOX = By.cssSelector("input[name='country']");
			public static final By STATE_DROPDOWN = By.cssSelector("select[name='state']");
			public static final By ZIP_TEXTBOX = By.cssSelector("input[name='zip']");
			public static final By COUNTRY_DROPDOWN = By.cssSelector("select[name='country']");
			public static final By FIRST_NAME_TEXTBOX = By.cssSelector("input[name='firstName']");
			public static final By ADD_MIDDLE_NAME_BUTTON = By.cssSelector("button[id='addMiddleName']");
			public static final By ADD_MIDDLE_NAME_TEXTBOX = By.cssSelector("input[name='middleName']");
			public static final By LAST_NAME_TEXTBOX = By.cssSelector("input[name='lastName']");
			public static final By TITLE_TEXTBOX = By.cssSelector("input[ng-model='companyAdminAdd.uiModel.Company.companyContact.title']");
			public static final By EMAIL_TEXTBOX = By.cssSelector("input[name='email']");
			public static final By PHONE_TEXTBOX = By.cssSelector("input[name='phone']");
			public static final By ADD_FAX_LINK = By.cssSelector("button[type='button'][id='addFax']");
			public static final By FAX_TEXTBOX = By.cssSelector("input[name='fax']");
			public static final By USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX = By.cssSelector("input[id='billingInfoCkeck']");			
			
			
			// Billing Information
			
			public static final By BILLING_FIRST_NAME_TEXTBOX =By.cssSelector("input[name='billingFirstName']");
			public static final By BILLING_ADD_MIDDLE_NAME_BUTTON = By.cssSelector("button[name='addBillingMiddleName']");
			public static final By BILLING_MIDDLE_NAME_TEXTBOX = By.cssSelector("input[name='billingMiddleName']");
			public static final By BILLING_LAST_NAME_TEXTBOX = By.cssSelector("input[name='billingLastName']");
			public static final By BILLING_TITLE_TEXTBOX = By.cssSelector("input[id='billingTiltle']");
			public static final By BILLING_EMAIL_TEXTBOX = By.cssSelector("input[id='billingEmail']");
			public static final By BILLING_PHONE_TEXTBOX = By.cssSelector("input[id='billingPhone']");
			public static final By BILLING_ADD_FAX_LINK = By.cssSelector("button[id='addBillingFax']");
			public static final By BILLING_FAX_TEXTBOX = By.cssSelector("input[name='billingFax']");
			public static final By BILLING_STREET_ADDRESS1_TEXTBOX = By.cssSelector("input[name='billingAddress1']");
			public static final By BILLING_STREET_ADDRESS2_TEXTBOX = By.cssSelector("input[name='billingAddress2']");
			public static final By BILLING_CITY_TEXTBOX = By.cssSelector("input[name='billingCity']");
			public static final By BILLING_COUNTY_TEXTBOX = By.cssSelector("input[id='billingCounty']");
			public static final By BILLING_STATE_DROPDOWN = By.cssSelector("select[id='billingState']");
			public static final By BILLING_ZIP_TEXTBOX = By.cssSelector("input[id='billingZip']");
			public static final By BILLING_COUNTRY_DROPDOWN = By.cssSelector("select[ng-model='companyAdminAdd.uiModel.Company.companyContact.billingCountry']");
			
			//cancel footer button
			
			public static final By CANCEL_BUTTON = By.cssSelector("#wizardHeader > div.panel-body.itnPanelBody > div:nth-child(4) > div > div.row.ng-scope > div > div > div.panel-body.itnPanelSubBody.itnPanelNoBorder.itnPanelSubBodyNoPadding > div:nth-child(3) > div > div > div > div.pull-left > div:nth-child(1) > button");
			public static final By NEXT_BUTTON = By.cssSelector("button[id='wizardNext']");
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			
			//Modal dialogue
			
			//Alert for mandatory fields
			public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyInfo'][role='alert']");
			
		
		}		
		
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			waitForPageToLoad("company");
		}
		
		
		public static void clickNextButton(){
			String nextPage = getNextPage();
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			waitForPageToLoad(nextPage);
		}
		
		
		public static String clickNextButtonAndGetErrorMessage(){
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			return getErrorMessage();
		}
		
		public static String getErrorMessage(){
			int count=0;
			while(count<10){
				if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
					Elements.pauseExecution(1500);
				}
				else
					return Elements.getText(PageElements.ERROR_MESSAGE);
				
				count++;
			}
			
			return "Error_Message_Not_Displayed";
		}
		
		public static void clickCancel(){
			//Elements.isEnabled(PageElements.CANCEL_BUTTON);
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		
		
		public static void setCompanyName(){
			String name = "Automation "+Data.getString(8);
			DriverManager.getDataSet().setCompanyName(name);
			Elements.waitForElementToBeVisible(PageElements.COMPANY_NAME_TEXTBOX);
			//Elements.isEnabled(PageElements.COMPANY_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.COMPANY_NAME_TEXTBOX, name);
		}
		
		
		public static void setSubsidiaryOrBusinessUnit(){
			String name = "Automation "+Data.getString(5);
			Elements.isEnabled(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX);
			Elements.clearAndType(PageElements.SUBSIDIARY_OR_BUSINESS_UNIT_TEXTBOX, name);
		}
		
		public static void setCompanyURL(){
			Elements.isEnabled(PageElements.COMPANY_URL_TEXTBOX);
			Elements.clearAndType(PageElements.COMPANY_URL_TEXTBOX, "www."+Data.getString(6)+".com");
			
		}
		
		public static void setGLNNumber(){
			Elements.isEnabled(PageElements.GLN_TEXTBOX);
			Elements.clearAndType(PageElements.GLN_TEXTBOX, Data.getNumber(13));
		}
		
		public static void clickAddAnotherGLNButton(){
			Elements.isEnabled(PageElements.ADD_ANOTHER_GLN_BUTTON);
			Elements.clickElement(PageElements.ADD_ANOTHER_GLN_BUTTON);
		}
		
		public static void setAnotherGLNTextbox(){
			Elements.isEnabled(PageElements.ADD_ANOTHER_GLN_TEXTBOX);
			Elements.clearAndType(PageElements.ADD_ANOTHER_GLN_TEXTBOX, Data.getNumber(13));
		}
		
		
		public static void setDUNSNumber(){
			Elements.isEnabled(PageElements.DUNS_TEXTBOX);
			Elements.clearAndType(PageElements.DUNS_TEXTBOX, Data.getNumber(13));
		}
		
		public static void selectIndustrySegment(IndustrySegment industrySegment){		
			Elements.isEnabled(PageElements.INDUSTRY_SEGMENT_DROPDOWN);
			//Elements.clickElement(PageElements.INDUSTRY_SEGMENT_DROPDOWN);
			Elements.selectOption(PageElements.INDUSTRY_SEGMENT_DROPDOWN, industrySegment.toString());
			
		}
		
		public static void setStreetAddress(){
			Elements.isEnabled(PageElements.STREET_ADDRESS1_TEXTBOX);
			Elements.clearAndType(PageElements.STREET_ADDRESS1_TEXTBOX, Data.getString(10));
			Elements.clearAndType(PageElements.STREET_ADDRESS2_TEXTBOX, Data.getString(10));
		}
		
		public static void setCity(){
			Elements.isEnabled(PageElements.CITY_TEXTBOX);
			Elements.clearAndType(PageElements.CITY_TEXTBOX, Data.getString(8));
		}
		
		public static void setCounty(){
			Elements.isEnabled(PageElements.COUNTY_TEXTBOX);
			Elements.clearAndType(PageElements.COUNTY_TEXTBOX, Data.getString(8));
		}
		
		public static void selectState(State state){
			Elements.isEnabled(PageElements.STATE_DROPDOWN);
			Elements.selectOption(PageElements.STATE_DROPDOWN, state.toString());
			
		
			
		}
		
		public static void setZip(){
			Elements.isEnabled(PageElements.ZIP_TEXTBOX);
			Elements.clearAndType(PageElements.ZIP_TEXTBOX, Data.getNumber(5));
		}
		
		public static void selectCountry(Country country){

			Elements.isEnabled(PageElements.COUNTRY_DROPDOWN);
			Elements.selectOption(PageElements.COUNTRY_DROPDOWN, country.toString());		
		}
		
		public static void setFirstName(){
			Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.FIRST_NAME_TEXTBOX, Data.getString(10));
		}
		
		public static void clickAddMiddleNameButton(){
			Elements.isEnabled(PageElements.ADD_MIDDLE_NAME_BUTTON);
			Elements.clickElement(PageElements.ADD_MIDDLE_NAME_BUTTON);
		}
		
		public static void setMiddleNameTextbox(){
			Elements.isEnabled(PageElements.ADD_MIDDLE_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.ADD_MIDDLE_NAME_TEXTBOX, Data.getString(10));
		}
		
		public static void setLastName(){
			Elements.isEnabled(PageElements.LAST_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.LAST_NAME_TEXTBOX, Data.getString(8));
		}
		
		public static void setTitle(){
			Elements.isEnabled(PageElements.TITLE_TEXTBOX);
			Elements.clearAndType(PageElements.TITLE_TEXTBOX, Data.getString(4));
			
		}
		
		public static void setEmail(){
			Elements.isEnabled(PageElements.EMAIL_TEXTBOX);
			Elements.clearAndType(PageElements.EMAIL_TEXTBOX, Data.getMailId(""));
		}
		
		public static void setPhone(){
			Elements.isEnabled(PageElements.PHONE_TEXTBOX);
			Elements.clearAndType(PageElements.PHONE_TEXTBOX, Data.getNumber(10));		
		}
		
		public static void clickAddFaxLink(){
			Elements.isEnabled(PageElements.ADD_FAX_LINK);
			Elements.clickElement(PageElements.ADD_FAX_LINK);
		}
		
		public static void setFaxNumber(){
			Elements.isEnabled(PageElements.FAX_TEXTBOX);
			Elements.clearAndType(PageElements.FAX_TEXTBOX, Data.getNumber(10));
		}
		
		
		public static void clickUseSameInformationAsProfileContact(){
			Elements.isEnabled(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX);
			Elements.clickElement(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX);
		}
		
		
		//Billing Information Methods
		
		public static void setBillingFirstName(){
			Elements.isEnabled(PageElements.BILLING_FIRST_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.BILLING_FIRST_NAME_TEXTBOX, Data.getString(10));
			
		}
		
		public static void clickAddBillingMiddleNameButton(){
			Elements.isEnabled(PageElements.BILLING_ADD_MIDDLE_NAME_BUTTON);
			Elements.clickElement(PageElements.BILLING_ADD_MIDDLE_NAME_BUTTON);
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
			Elements.clearAndType(PageElements.BILLING_TITLE_TEXTBOX, Data.getString(10));
			
		}
		
		public static void setBillingEmail(){
			Elements.isEnabled(PageElements.BILLING_EMAIL_TEXTBOX);
			Elements.clearAndType(PageElements.BILLING_EMAIL_TEXTBOX, Data.getMailId(""));
		}
		
		public static void setBillingPhone(){
			Elements.isEnabled(PageElements.BILLING_PHONE_TEXTBOX);
			Elements.clearAndType(PageElements.BILLING_PHONE_TEXTBOX, Data.getNumber(10));		
		}
		
		public static void clickBillingAddFaxLink(){
			Elements.isEnabled(PageElements.BILLING_ADD_FAX_LINK);
			Elements.clickElement(PageElements.BILLING_ADD_FAX_LINK);
		}
		
		public static void setBillingFaxNumber(){
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
		
		public static void setBillingZip(){
			Elements.isEnabled(PageElements.BILLING_ZIP_TEXTBOX);
			Elements.clearAndType(PageElements.BILLING_ZIP_TEXTBOX, Data.getNumber(5));
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
				else
					if(Elements.find(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX).isSelected())
						Elements.clickElement(PageElements.USE_SAME_INFORMATION_AS_PROFILE_CONTACT_CHECKBOX);
				
		}	
		
		
		public static boolean verifyCompanyInfoPageLoaded(){
			String url = Elements.getCurrentURL();
			if(url.endsWith("companyinformation")){
				return true;
			}
			else
				return false;
		}
		
	}
	
	/**
	 * Company Roles Wizard Page
	 * @author prashantc
	 *
	 */
	public static class CompanyRolesWizard{
		
		public static class PageElements{
			
			public static final By PARENT_OF_CHECKBOXES = By.cssSelector("span[class='checkbox checkbox-primary']");
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
			//Footer-Buttons
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='wizardPrevious']");
			public static final By NEXT_BUTTON = By.cssSelector("button[id='wizardNext']");
			public static final By CANCEL_BUTTON = By.cssSelector("div[ng-hide='companyAdminAdd.uiData.urlParam.showWizardButton'] > div > div > div:nth-child(2) > div:nth-child(3) > div > div > div > div:nth-child(1) >  div:nth-child(1) > button");
			//Alert for mandatory fields
			public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyRoleInfo'][role='alert']");
		}
		
		public static List<WebElement> getAllCheckBoxes(){
			//return  Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
			return  Elements.findAll(By.cssSelector("span[class='checkboxNative']"));
			/*System.out.println("Size : "+all.size());
			for(int i=0; i<all.size();i++){
				//System.out.println(all.get(i).getAttribute("id"));
				
				WebElement input = Elements.find(all.get(i),By.cssSelector("input"));
				System.out.println(i+" : "+input.getAttribute("id"));
				input.click();
			}*/
		}
		
		public static void clickPreviousButton(){
			String prevPage = getPreviousPage();
			Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
			Elements.clickElement(PageElements.PREVIOUS_BUTTON);
			waitForPageToLoad(prevPage);
		}
		
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			waitForPageToLoad("company");
		}
		
		public static void clickNextButton(){
			String nextPage = getNextPage();
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			waitForPageToLoad(nextPage);
		}
		
		
		public static String clickNextButtonAndGetErrorMessage(){
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			return getErrorMessage();
		}
		
		public static String getErrorMessage(){
			int count=0;
			while(count<10){
				if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
					Elements.pauseExecution(1500);
				}
				else
					return Elements.getText(PageElements.ERROR_MESSAGE);
				
				count++;
			}
			
			return "Error_Message_Not_Displayed";
		}
		
		public static void clickCancel(){			
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		
		//Will be using GDSN?
		public static void checkYesRadio(){
			Elements.isEnabled(PageElements.YES_RADIO_BUTTON);
			Elements.clickElement(PageElements.YES_RADIO_BUTTON);
		}
		
		public static void checkNoRadio(){
			Elements.isEnabled(PageElements.NO_RADIO_BUTTON);
			Elements.clickElement(PageElements.NO_RADIO_BUTTON);			
		}
		
		//Select role type:
		public static void checkPublisherCheckBox(){
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			System.out.println(allCheckboxes.size());
			WebElement data = Elements.find(allCheckboxes.get(0), By.tagName("input"));
			data.click();
			//WebElement checkbox = Elements.find(allCheckboxes.get(0),By.tagName("input"));		
			//Elements.clickElement(checkbox, Config.sleep);				
		}
		
		public static void checkSubscriberCheckBox(){
			/*Elements.isEnabled(PageElements.SUBSCRIBER_CHECKBOX);
			Elements.clickElement(PageElements.SUBSCRIBER_CHECKBOX);*/
			
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(1),By.cssSelector("input"));	
			checkbox.click();
			//Elements.clickElement(checkbox, Config.sleep);	
		}
		
		//Advanced Features
		public static void checkDigitalAssetsManagementCheckBox(){
			/*Elements.isEnabled(PageElements.DIGITAL_ASSETES_MANAGEMENT_CHECKBOX);
			Elements.clickElement(PageElements.DIGITAL_ASSETES_MANAGEMENT_CHECKBOX);	*/
			
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(4),By.cssSelector("input"));				
			//Elements.clickElement(checkbox, Config.sleep);
			checkbox.click();
		}
		
		public static void checkSellSheetCheckBox(){
			/*Elements.isEnabled(PageElements.SELL_SHEET_CHECKBOX);
			Elements.clickElement(PageElements.SELL_SHEET_CHECKBOX);	*/
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(5),By.cssSelector("input"));				
			//Elements.clickElement(checkbox, Config.sleep);
			checkbox.click();
		}
		
		
		//ITN Solutions
		public static void checkProductInfoManagementCheckBox(){
			/*Elements.isEnabled(PageElements.PRODUCT_INFORMATION_MANAGEMENT_CHECKBOX);
			Elements.clickElement(PageElements.PRODUCT_INFORMATION_MANAGEMENT_CHECKBOX);	*/
			
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(2),By.cssSelector("input"));		
			checkbox.click();
			//Elements.clickElement(checkbox, Config.sleep);	
		}
		
		public static void checkDataQualityCheckBox(){
			/*Elements.isEnabled(PageElements.DATA_QUALITY_CHECKBOX);
			Elements.clickElement(PageElements.DATA_QUALITY_CHECKBOX);*/
			
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(3),By.cssSelector("input"));		
			checkbox.click();
			//Elements.clickElement(checkbox, Config.sleep);	
		}
		
		//Data Pool Membership
		public static void checkDataPool_ITN_CheckBox(){
			/*Elements.isEnabled(PageElements.DATA_POOL_ITN_CHECKBOX);
			Elements.clickElement(PageElements.DATA_POOL_ITN_CHECKBOX);*/
			
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(6),By.cssSelector("input"));			
			checkbox.click();
			//Elements.clickElement(checkbox, Config.sleep);	
		}
		
		public static void checkDataPool_3P_CheckBox(){
			/*Elements.isEnabled(PageElements.DATA_POOL_3RD_PARTY_CHECKBOX);
			Elements.clickElement(PageElements.DATA_POOL_3RD_PARTY_CHECKBOX);*/
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(7),By.cssSelector("input"));		
			checkbox.click();
			//Elements.clickElement(checkbox, Config.sleep);	
		}
		
	}
	
	/**
	 * Integrations / Applications Wizard Page
	 * @author prashantc
	 *
	 */
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
			
			
			//Footer-Buttons
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='wizardPrevious']");
			public static final By NEXT_BUTTON = By.cssSelector("button[id='wizardNext']");
			public static final By CANCEL_BUTTON = By.cssSelector("div[ng-hide='companyAdminAdd.uiData.urlParam.showWizardButton'] > div > div > div:nth-child(2) > div:nth-child(3) > div > div > div > div:nth-child(1) >  div:nth-child(1) > button");
			//Alert for mandatory fields
			public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyIntegrationInfo'][role='alert']");
			
			
		}
		
		public static void clickPreviousButton(){
			String prevPage = getPreviousPage();
			Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
			Elements.clickElement(PageElements.PREVIOUS_BUTTON);
			waitForPageToLoad(prevPage);
		}
		
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			waitForPageToLoad("company");
		}		
		
		
		public static void clickNextButton(){
			String nextPage = getNextPage();
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			waitForPageToLoad(nextPage);
		}
		
		
		public static String clickNextButtonAndGetErrorMessage(){
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			return getErrorMessage();
		}
		
		public static String getErrorMessage(){
			int count=0;
			while(count<10){
				if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
					Elements.pauseExecution(1500);
				}
				else
					return Elements.getText(PageElements.ERROR_MESSAGE);
				
				count++;
			}
			
			return "Error_Message_Not_Displayed";
		}
		public static void clickCancel(){			
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		
		public static List<WebElement> getAllCheckBoxes(){			
			//return  Elements.findAll(By.cssSelector("span[class='checkbox checkbox-primary']"));
			return  Elements.findAll(By.cssSelector("span[class='checkboxNative']"));
			
		}
		
		//INBOUND
		public static void checkXMLInboundCheckbox(){
			List<WebElement> allCheckboxes = getAllCheckBoxes();
			WebElement checkbox = Elements.find(allCheckboxes.get(0),By.cssSelector("input"));			
			checkbox.click();
			/*Elements.isEnabled(PageElements.XML_INBOUND_CHECKBOX);
			Elements.clickElement(PageElements.XML_INBOUND_CHECKBOX);*/
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
		
	}
	
	/**
	 * Entrustments Wizard Page
	 * @author prashantc
	 *
	 */
	public static class EntrustmentsWizard{
		
		public static class PageElements{
			/*
			public static final By AVAILABLE_PARTNERS_TABLE = By.cssSelector("div[id='existingPartner']");
			public static final By SELECTED_PARTNERS_TABLE = By.cssSelector("div[id='selectedPartnerList']");		
			*/
			public static final By SEARCH_TEXTBOX_AVAILABLE_PARTNERS = By.cssSelector("input[id='searchExistingPartner']");
			public static final By SEARCH_TEXTBOX_SELECTED_PARTNERS = By.cssSelector("input[id='searchSelectedPartners']");
			
			public static final By AVAILABLE_PARTNERS_LIST = By.cssSelector("div[id='partnerList'] > div");
			public static final By SELECTED_PARTNERS_LIST = By.cssSelector("div[id='selectedPartnerList'] > div");
			
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='wizardPrevious']");
			public static final By NEXT_BUTTON = By.cssSelector("button[id='wizardNext']");
			public static final By CANCEL_BUTTON = By.cssSelector("div[ng-hide='companyAdminAdd.uiData.urlParam.showWizardButton'] > div > div > div:nth-child(2) > div:nth-child(3) > div > div > div > div:nth-child(1) >  div:nth-child(1) > button");

			//Alert for mandatory fields
			//public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='companyInfo'][role='alert']");
			
		}
		
		public static void clickPreviousButton(){
			String prevPage = getPreviousPage();
			Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
			Elements.clickElement(PageElements.PREVIOUS_BUTTON);
			waitForPageToLoad(prevPage);
		}
		
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			waitForPageToLoad("company");
		}
		
		public static void clickNextButton(){
			String nextPage = getNextPage();
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			waitForPageToLoad(nextPage);
		}
		
		//NO ERROR MESSAGE FOR MANDATORY FIELDS ON ENTRUSTMENTS TAB
		/*public static String clickNextButtonAndGetErrorMessage(){
			Elements.isEnabled(PageElements.NEXT_BUTTON);
			Elements.clickElement(PageElements.NEXT_BUTTON);
			return getErrorMessage();
		}
		
		public static String getErrorMessage(){
			int count=0;
			while(count<10){
				if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
					Elements.pauseExecution(1500);
				}
				else
					return Elements.getText(PageElements.ERROR_MESSAGE);
				
				count++;
			}
			
			return "Error_Message_Not_Displayed";
		}*/
		
		public static void clickCancel(){			
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		
		public static void addFromAvailablePartners(String partnerName){
			//Elements.isEnabled(PageElements.AVAILABLE_PARTNERS_TABLE);
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
				//addFromAvailablePartners(Elements.getText(existingPartners.get(0)).replace("-", "").trim());
				//WebElement addLink = Elements.findAll(existingPartners.get(0), By.tagName("a"));
				//existingPartners.get(0).click();
				Elements.clickElement(existingPartners.get(0), Config.sleep);
		}
		
		
	}
	
	/**
	 * User Account Wizard Page
	 * @author prashantc
	 *
	 */
	public static class UserAccountsWizard{
		
		public static class PageElements{
			
			public static final By ADD_NEW_USER_BUTTON = By.cssSelector("button[ng-click='showAddUser()']");
			
			//Add New User Overlay
			public static final By FIRST_NAME_TEXTBOX = By.cssSelector("input[name='firstName']");
			public static final By LAST_NAME_TEXTBOX = By.cssSelector("input[name='lastName']");
			public static final By USER_ROLE_BUTTON = By.cssSelector("button[id='userRole']");
			public static final By USER_ROLE_BUTTON_EDIT = By.cssSelector("button[id='role']"); 
			public static final By USER_ROLE_DROPDOWN = By.cssSelector("ul[role='select']");
			public static final By TITLE_TEXTBOX = By.cssSelector("input[name='title']");
			public static final By EMAIL_TEXTBOX = By.cssSelector("input[name='email']");
			public static final By PHONE_TEXTBOX = By.cssSelector("input[name='phone']");
			public static final By USER_NAME_TEXTBOX = By.cssSelector("input[name='login']");
			public static final By ADD_USER_BUTTON  = By.cssSelector("button[type='submit'][ng-click='addUser()']");
			public static final By UPDATE_USER_BUTTON = By.cssSelector("button[ng-click='updateUser()']");
			public static final By CANCEL_BUTTON_ADD_NEW_USER_OVERLAY  = By.cssSelector("div[class='modal-dialog'] > div[class='modal-content'] > div[class*='modal-footer'] > a[id='cancel']");
			
			
			public static final By SAVE_AND_CLOSE_BUTTON = By.cssSelector("button[id='SaveAndCloseCompanyInfo']");
			public static final By PREVIOUS_BUTTON = By.cssSelector("button[id='wizardPrevious']");
			public static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector("button[id='SaveAndCloseUseraccounts']");
			public static final By CANCEL_BUTTON = By.cssSelector("div[ng-hide='companyAdminAdd.uiData.urlParam.showWizardButton'] > div > div > div:nth-child(2) > div:nth-child(3) > div > div > div > div:nth-child(1) >  div:nth-child(1) > button");
			//Alert for mandatory fields
			public static final By ERROR_MESSAGE = By.cssSelector("div[ng-show='userError'][role='alert']");
			
			//Alert for mandatory fields -- Add User Ovelay
			public static final By ERROR_MESSAGE_ADD_NEW_USER_OVERLAY = By.cssSelector("div[id='UserAccountModalActionPanel'] > div > span");
			
			
		}
		
		public static void clickCreateNewAccountButton(){
			String nextPage = getNextPage();
			Elements.isEnabled(PageElements.CREATE_NEW_ACCOUNT_BUTTON);
			Elements.clickElement(PageElements.CREATE_NEW_ACCOUNT_BUTTON);
			waitForPageToLoad(nextPage);
		}
		
		public static void clickPreviousButton(){
			String prevPage = getPreviousPage();
			Elements.isEnabled(PageElements.PREVIOUS_BUTTON);
			Elements.clickElement(PageElements.PREVIOUS_BUTTON);
			waitForPageToLoad(prevPage);
		}
		
		
		public static void clickSaveAndCloseButton(){
			Elements.isEnabled(PageElements.SAVE_AND_CLOSE_BUTTON);
			Elements.clickElement(PageElements.SAVE_AND_CLOSE_BUTTON);
			waitForPageToLoad("company");
		}
		
		public static String getErrorMessage(){
			int count=0;
			while(count<10){
				if(!Elements.isVisible(PageElements.ERROR_MESSAGE)){
					Elements.pauseExecution(1500);
				}
				else
					return Elements.getText(PageElements.ERROR_MESSAGE);
				
				count++;
			}
			
			return "Error_Message_Not_Displayed";
		}
		
		public static void clickCancel(){			
			Elements.clickElement(PageElements.CANCEL_BUTTON);
		}
		
		public static void clickCancelButtonOnAddNewUserOverlay(){
			Elements.isEnabled(PageElements.CANCEL_BUTTON_ADD_NEW_USER_OVERLAY);
			Elements.clickElement(PageElements.CANCEL_BUTTON_ADD_NEW_USER_OVERLAY);
			Elements.pauseExecution(2500);
		}
		
		public static void clickAddNewUserButton(){
			Elements.isEnabled(PageElements.ADD_NEW_USER_BUTTON);
			Elements.clickElement(PageElements.ADD_NEW_USER_BUTTON);
		}
		
		public static void clickUpdateUserButton(){
			Elements.isEnabled(PageElements.UPDATE_USER_BUTTON);
			Elements.clickElement(PageElements.UPDATE_USER_BUTTON);
		}
		
		
		//Add New User Overlay
		public static void setFirstName(){
			Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.FIRST_NAME_TEXTBOX, Data.getString(10));
			
		}
		
		public static void setLastName(){
			String data = Data.getString(10);
			Config.DATA_MAP.put(DataKeys.LAST_NAME_USER, data);
			Elements.isEnabled(PageElements.LAST_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.LAST_NAME_TEXTBOX, data);
		}
		
		public static void selectUserRole(UserRole userRole){
			Elements.isEnabled(PageElements.USER_ROLE_BUTTON);
			Elements.clickElement(PageElements.USER_ROLE_BUTTON);
			
			Elements.clickElementInDropList(PageElements.USER_ROLE_DROPDOWN, "", userRole.toString());
		}
		
		public static void selectUserRoleEDIT(UserRole userRole){
			Elements.isEnabled(PageElements.USER_ROLE_BUTTON_EDIT);
			Elements.clickElement(PageElements.USER_ROLE_BUTTON_EDIT);
			
			Elements.clickElementInDropList(PageElements.USER_ROLE_DROPDOWN, "", userRole.toString());
		}
		
		public static void setTitle(){
			Elements.isEnabled(PageElements.TITLE_TEXTBOX);
			Elements.clearAndType(PageElements.TITLE_TEXTBOX, Data.getString(8));
		}
		
		public static void setEmail(){
			Elements.isEnabled(PageElements.EMAIL_TEXTBOX);
			Elements.clearAndType(PageElements.EMAIL_TEXTBOX, Data.getMailId(""));
		}
		
		public static void setPhone(){
			Elements.isEnabled(PageElements.PHONE_TEXTBOX);
			Elements.clearAndType(PageElements.PHONE_TEXTBOX, Data.getNumber(10));
		}
		
		public static void setUserName(){
			Elements.isEnabled(PageElements.USER_NAME_TEXTBOX);
			Elements.clearAndType(PageElements.USER_NAME_TEXTBOX, Data.getNumber(8));
		}
		
		public static void clickAddUserButton(){
			Elements.isEnabled(PageElements.ADD_USER_BUTTON);
			Elements.clickElement(PageElements.ADD_USER_BUTTON);
		}
		
		public static String clickAddUserButtonAndGetErrorMessage(){
			Elements.isEnabled(PageElements.ADD_USER_BUTTON);
			Elements.clickElement(PageElements.ADD_USER_BUTTON);
			return Elements.getText(PageElements.ERROR_MESSAGE_ADD_NEW_USER_OVERLAY);
		}
		
		
	}

}
