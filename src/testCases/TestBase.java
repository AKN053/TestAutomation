package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddNewCompanyAccountPage;
import pages.BasePage.IsLoading;
import pages.EditCompanyInformationPage;
import pages.EditCompanyInformationPage.CompanyInformationWizard;
import common.Config;
import common.Enumerations.UserRole;
import common.LogHandler;
import common.Enumerations.Country;
import common.Enumerations.IndustrySegment;
import common.Enumerations.State;
import framework.helpers.Elements;
import framework.providers.Data;

public class TestBase {
	
	public static void fillCompanyInformationADD(IndustrySegment industrySegment, State state, Country country, Boolean billingInfoFlag , int noOfGLNs){
		
		AddNewCompanyAccountPage.CompanyInformationWizard.setCompanyName();
		
		AddNewCompanyAccountPage.CompanyInformationWizard.setSubsidiaryOrBusinessUnit();
		AddNewCompanyAccountPage.CompanyInformationWizard.setCompanyURL();
		
		for(int i=0;i<noOfGLNs;i++){
			if(noOfGLNs > 2){
			String data = Data.getNumber(13);
			Config.GLNS.add(data);
			WebElement gln = Elements.find(By.cssSelector("input[name='gln"+i+"']"));
			Elements.clearAndType(gln, data);
			AddNewCompanyAccountPage.CompanyInformationWizard.clickAddAnotherGLNButton();
			Elements.pauseExecution(2000);
			}
			else
				AddNewCompanyAccountPage.CompanyInformationWizard.setGLNNumber();
		}
		//AddNewCompanyAccountPage.CompanyInformationWizard.setGLNNumber();
		
		
		AddNewCompanyAccountPage.CompanyInformationWizard.setDUNSNumber();
		if(!industrySegment.equals(IndustrySegment.NA)){
		AddNewCompanyAccountPage.CompanyInformationWizard.selectIndustrySegment(industrySegment);
		}
		AddNewCompanyAccountPage.CompanyInformationWizard.setStreetAddress();
		AddNewCompanyAccountPage.CompanyInformationWizard.setCity();
		AddNewCompanyAccountPage.CompanyInformationWizard.setCounty();
		AddNewCompanyAccountPage.CompanyInformationWizard.selectState(state);
		AddNewCompanyAccountPage.CompanyInformationWizard.setZip();
		AddNewCompanyAccountPage.CompanyInformationWizard.selectCountry(country);
		AddNewCompanyAccountPage.CompanyInformationWizard.setFirstName();
		AddNewCompanyAccountPage.CompanyInformationWizard.clickAddMiddleNameButton();
		AddNewCompanyAccountPage.CompanyInformationWizard.setMiddleNameTextbox();
		AddNewCompanyAccountPage.CompanyInformationWizard.setLastName();
		AddNewCompanyAccountPage.CompanyInformationWizard.setTitle();
		AddNewCompanyAccountPage.CompanyInformationWizard.setEmail();
		AddNewCompanyAccountPage.CompanyInformationWizard.setPhone();
		AddNewCompanyAccountPage.CompanyInformationWizard.clickAddFaxLink();
		AddNewCompanyAccountPage.CompanyInformationWizard.setFaxNumber();
		
		
		if(billingInfoFlag){
				AddNewCompanyAccountPage.CompanyInformationWizard.clickUseSameInformationAsProfileContact();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingFirstName();
				AddNewCompanyAccountPage.CompanyInformationWizard.clickAddBillingMiddleNameButton();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingMiddleName();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingLastName();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingTitle();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingEmail();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingPhone();
				AddNewCompanyAccountPage.CompanyInformationWizard.clickBillingAddFaxLink();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingFaxNumber();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingStreetAddress();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingCity();
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingCounty();
				AddNewCompanyAccountPage.CompanyInformationWizard.selectBillingState(state);
				AddNewCompanyAccountPage.CompanyInformationWizard.setBillingZip();
				AddNewCompanyAccountPage.CompanyInformationWizard.selectBillingCountry(country);
				
			}
		
		Elements.pauseExecution(1000);
		while(IsLoading.isLoading())
			LogHandler.logInfo("Loading the page...");
		
		}		
	
	/**
	 * This method fills the data on Create New Company - Company Roles wizard
	 * @param usingGDSN : true or false
	 * @param roleType : 1 = publisher 2 = subscriber 3 = both
	 * @param advancedFeatures : 1 = Digital Assets Management 2 = Sell Sheet 3 = both
	 * @param itnSolutions : 1 = Product Information Management (PIM) 2 = Data Quality 3 = both  
	 * @param dataPoolMembership : 1 = Data Pool - ITN 2  = Data Pool - 3rd Party 3 = both
	 */
	public static void fillCompanyRolesADD(boolean usingGDSN, int roleType, int advancedFeatures, int itnSolutions, int dataPoolMembership){
		//Selecting GDSN Details
		if(usingGDSN)
				AddNewCompanyAccountPage.CompanyRolesWizard.checkYesRadio();
		else
			AddNewCompanyAccountPage.CompanyRolesWizard.checkNoRadio();
		
		//Selecting Role Type
		if(roleType==1)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkPublisherCheckBox();
		if(roleType==2)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkSubscriberCheckBox();
		if(roleType==3){
			AddNewCompanyAccountPage.CompanyRolesWizard.checkPublisherCheckBox();
			AddNewCompanyAccountPage.CompanyRolesWizard.checkSubscriberCheckBox();
		}
		
		//Selecting Advanced Features
		
		if(advancedFeatures==1)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDigitalAssetsManagementCheckBox();
		if(advancedFeatures==2)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkSellSheetCheckBox();
		if(roleType==3){
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDigitalAssetsManagementCheckBox();
			AddNewCompanyAccountPage.CompanyRolesWizard.checkSellSheetCheckBox();
		}
		
		//Selecting ITN Solutions
		
		if(itnSolutions==1)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkProductInfoManagementCheckBox();
		if(itnSolutions==2)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataQualityCheckBox();
		if(itnSolutions==3){
			AddNewCompanyAccountPage.CompanyRolesWizard.checkProductInfoManagementCheckBox();
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataQualityCheckBox();
		}
		
		//Selecting Data Pool Membership
		
		if(dataPoolMembership==1)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataPool_ITN_CheckBox();
		if(dataPoolMembership==2)
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataPool_3P_CheckBox();
		if(dataPoolMembership==3){
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataPool_ITN_CheckBox();
			AddNewCompanyAccountPage.CompanyRolesWizard.checkDataPool_3P_CheckBox();
		}
		
	}
	
	/**
	 * This methods fills the details on ADD COMPANY - Integration-Applications wizard
	 * @param inboundIntegration : 1=XML 2=Flat File 3=Spreadsheet 4=Publisher Portal 5=Publisher Portal (Limited)
	 * @param outboundIntegration : 1=XML 2=Flat File 3=Spreadsheet
	 * @param partnerIntegration : 1=Branded Procurement (BP) 2=CBORD 3=Order Management System (OMS)
	 */	
	public static void fillIntegrationApplicationDetailsADD(int inbound, int outbound, int partner){
		while(inbound!=0){
			int select = inbound%10;
			inbound/=10;
			
			switch (select) {
			
					case 1	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkXMLInboundCheckbox();						
								break;
						
					case 2	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkFlatFileInboundCheckbox();						
								break;
						
					case 3	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkSpreadSheetInboundCheckbox();						
								break;
		
					case 4	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkPublisherPortalInboundCheckbox();						
								break;
						
					case 5	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkPublisherPortalLimitedInboundCheckbox();						
								break;
					default	:
						break;
			}
		}
		
		while(outbound!=0){
			int select = outbound%10;
			outbound/=10;
			
			switch (select) {
			
			case 1	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkXMLOutboundCheckbox();					
						break;
				
			case 2	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkFlatFileOutboundCheckbox();				
						break;
				
			case 3	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkSpreadSheetOutboundCheckbox();					
						break;
			}
		}
		
		while(partner!=0){
			int select = partner%10;
			partner/=10;
			
			switch (select) {
			
			case 1	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkBrandedProcurementCheckbox();			
						break;
				
			case 2	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkCBORDCheckbox();			
						break;
				
			case 3	:	AddNewCompanyAccountPage.IntegrationsApplicationsWizard.checkOMSCheckbox();				
						break;
			}
		}
		
		
	}
	
	public static void fillCompanyInformationEDIT(IndustrySegment industrySegment, State state, Country country, Boolean billingInfoFlag , int noOfGLNs){
		CompanyInformationWizard.setSubsidaryOrBusinessUnit();
		CompanyInformationWizard.setCompanyURL();
		CompanyInformationWizard.setGLNNumber();
		CompanyInformationWizard.setDUNSNumber();
		CompanyInformationWizard.selectIndustrySegment(industrySegment);
		CompanyInformationWizard.setStreetAddress();
		CompanyInformationWizard.setCity();
		CompanyInformationWizard.setCounty();
		CompanyInformationWizard.selectState(state);
		CompanyInformationWizard.setZip();
		CompanyInformationWizard.selectCountry(country);
		CompanyInformationWizard.setFirstName();
		CompanyInformationWizard.setLastName();
		CompanyInformationWizard.setEmail();
		CompanyInformationWizard.setPhone();
	}
	
	/**
	 * This methods fills the information on EDIT - company roles page
	 * @param isGDSN :  0 = NO 1 = YES
	 * @param roleType : 1=PUBLISHER 2=SUBSCRIBER 3=BOTH
	 * @param advancedFeatures : 1=DIGITAL ASSETS MANAGEMENT 2=Sell Sheet 3=BOTH
	 * @param itnSolutions : 1=PRODUCT-INFORMATION-MANAGEMENT (PIM) 2=DATA-QUALITY 3=BOTH
	 * @param dataPoolMembership : 1=DATA-POOL-ITN 2=DATA-POOL-3RD-PARTY 3=BOTH
	 */
	public static void fillCompanyRolesEDIT(boolean isGDSN, int roleType, int advancedFeatures, int itnSolutions, int dataPoolMembership){
		
		// Will be using GDSN?
		if(isGDSN){
			EditCompanyInformationPage.CompanyRolesWizard.checkYesRadio();
		}
		else
			EditCompanyInformationPage.CompanyRolesWizard.checkNoRadio();
		
		// Select role type
		
		if(roleType==1)
			EditCompanyInformationPage.CompanyRolesWizard.checkPublisherCheckBox();
		else
			if(roleType==2)
				EditCompanyInformationPage.CompanyRolesWizard.checkSubscriberCheckBox();
			else		
				if(roleType==3){
					EditCompanyInformationPage.CompanyRolesWizard.checkPublisherCheckBox();
					EditCompanyInformationPage.CompanyRolesWizard.checkSubscriberCheckBox();
				}
		
		//Advanced Features
		
		if(advancedFeatures==1)
			EditCompanyInformationPage.CompanyRolesWizard.checkDigitalAssetsManagementCheckBox();
		else
			if(advancedFeatures==2)
				EditCompanyInformationPage.CompanyRolesWizard.checkSellSheetCheckBox();
			else				
				if(advancedFeatures==3){
					EditCompanyInformationPage.CompanyRolesWizard.checkDigitalAssetsManagementCheckBox();
					EditCompanyInformationPage.CompanyRolesWizard.checkSellSheetCheckBox();
				}
		
		//ITN Solutions
		if(itnSolutions==1)
			EditCompanyInformationPage.CompanyRolesWizard.checkProductInfoManagementCheckBox();
		else			
			if(itnSolutions==2)
				EditCompanyInformationPage.CompanyRolesWizard.checkDataQualityCheckBox();
			else				
				if(itnSolutions==3){
					EditCompanyInformationPage.CompanyRolesWizard.checkProductInfoManagementCheckBox();
					EditCompanyInformationPage.CompanyRolesWizard.checkDataQualityCheckBox();
				}
		
		//Data Pool Membership
		
		if(dataPoolMembership==1)
			EditCompanyInformationPage.CompanyRolesWizard.checkDataPool_ITN_CheckBox();
		else			
			if(dataPoolMembership==2)
				EditCompanyInformationPage.CompanyRolesWizard.checkDataPool_3P_CheckBox();
			else				
				if(dataPoolMembership==3){
					EditCompanyInformationPage.CompanyRolesWizard.checkDataPool_ITN_CheckBox();
					EditCompanyInformationPage.CompanyRolesWizard.checkDataPool_3P_CheckBox();
				}
		
		
	}
	
	
	/**
	 * This methods fills the details on EDIT COMPANY - Integration-Applications wizard
	 * @param inboundIntegration : 1=XML 2=Flat File 3=Spreadsheet 4=Publisher Portal 5=Publisher Portal (Limited)
	 * @param outboundIntegration : 1=XML 2=Flat File 3=Spreadsheet
	 * @param partnerIntegration : 1=Branded Procurement (BP) 2=CBORD 3=Order Management System (OMS)
	 */
	public static void fillIntegrationsApplicationsDetailsEDIT(int inboundIntegration, int outboundIntegration, int partnerIntegration){
		
		while(inboundIntegration!=0){
			int select = inboundIntegration%10;
			inboundIntegration/=10;
			
			switch (select) {
			
					case 1	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkXMLInboundCheckbox();						
								break;
						
					case 2	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkFlatFileInboundCheckbox();						
								break;
						
					case 3	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkSpreadSheetInboundCheckbox();						
								break;
		
					case 4	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkPublisherPortalInboundCheckbox();						
								break;
						
					case 5	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkPublisherPortalLimitedInboundCheckbox();						
								break;
					default	:
						break;
				}
			
			}
			
			
			while(outboundIntegration!=0){
				int select = outboundIntegration%10;
				outboundIntegration/=10;
				
				switch (select) {
				
				case 1	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkXMLOutboundCheckbox();					
							break;
					
				case 2	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkFlatFileOutboundCheckbox();				
							break;
					
				case 3	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkSpreadSheetOutboundCheckbox();					
							break;
				}
			}
			
			while(partnerIntegration!=0){
				int select = partnerIntegration%10;
				partnerIntegration/=10;
				
				switch (select) {
				
				case 1	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkBrandedProcurementCheckbox();			
							break;
					
				case 2	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkCBORDCheckbox();			
							break;
					
				case 3	:	EditCompanyInformationPage.IntegrationsApplicationsWizard.checkOMSCheckbox();				
							break;
				}
			}
		
		
	}
	
	public static void addNewUserADD(UserRole userRole){
		
		if(!Elements.isVisible(AddNewCompanyAccountPage.UserAccountsWizard.PageElements.ADD_USER_BUTTON)){
			AddNewCompanyAccountPage.UserAccountsWizard.clickAddNewUserButton();
		}
		
		AddNewCompanyAccountPage.UserAccountsWizard.setFirstName();
		AddNewCompanyAccountPage.UserAccountsWizard.setLastName();
		AddNewCompanyAccountPage.UserAccountsWizard.selectUserRole(userRole);
		AddNewCompanyAccountPage.UserAccountsWizard.setTitle();
		AddNewCompanyAccountPage.UserAccountsWizard.setEmail();
		AddNewCompanyAccountPage.UserAccountsWizard.setPhone();
		AddNewCompanyAccountPage.UserAccountsWizard.setUserName();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickAddUserButton();
	}
	
	public static void updateUserDetails(UserRole userRole){
		AddNewCompanyAccountPage.UserAccountsWizard.setFirstName();
		AddNewCompanyAccountPage.UserAccountsWizard.setLastName();
		AddNewCompanyAccountPage.UserAccountsWizard.selectUserRoleEDIT(userRole);
		AddNewCompanyAccountPage.UserAccountsWizard.setTitle();
		AddNewCompanyAccountPage.UserAccountsWizard.setEmail();
		AddNewCompanyAccountPage.UserAccountsWizard.setPhone();
		//AddNewCompanyAccountPage.UserAccountsWizard.setUserName();
		
		AddNewCompanyAccountPage.UserAccountsWizard.clickUpdateUserButton();
	}

	
}

