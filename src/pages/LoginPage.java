package pages;

import org.openqa.selenium.By;
import common.Config;
import framework.helpers.Elements;

public class LoginPage extends BasePage{
	
	public static class PageElements{
		public static final By USERNAME_TEXTBOX = By.cssSelector("input[id='username']");
		public static final By PASSWORD_TEXTBOX = By.cssSelector("input[id='password']");
		public static final By LOGIN_BUTTON = By.cssSelector("a[id='btn-login']");
		public static final By ERROR_MESSAGE_STATIC = By.cssSelector("div[ng-show='loginFailed'][role='alert']");
		public static final By HEADER_TEXT = By.cssSelector("a[class='itnSiteTitleText']");
	}
	
	public static void doLogin(String userName, String password){
		Elements.isEnabled(PageElements.USERNAME_TEXTBOX);
		
		/*if(userName.equals(Config.Logins.Credential.SUPLIER.userName.toString())){
			Elements.clearAndType(PageElements.USERNAME_TEXTBOX, userName);
			Elements.clearAndType(PageElements.PASSWORD_TEXTBOX, password);
		}*/
		
		
		Elements.clearAndType(PageElements.USERNAME_TEXTBOX, userName);
		Elements.clearAndType(PageElements.PASSWORD_TEXTBOX, password);
		
		Elements.clickElement(PageElements.LOGIN_BUTTON);
		int count=0;
		while(count<6){
			String url = Elements.getCurrentURL();
			if(url.contains("/home")){
				Elements.pauseExecution(2000);
				break;
			}
			else
				Elements.pauseExecution(2000);
			
			count++;
		}
	}
	
	public static String getHeaderText(){
		Elements.isEnabled(PageElements.HEADER_TEXT);		
		return Elements.getText(PageElements.HEADER_TEXT);		
	}
	
	public static void loginAdmin(){
		doLogin(Config.Logins.Credential.ADMIN.userName, Config.Logins.Credential.ADMIN.password);
	}
	
	public static void loginDefaultUser(){
		doLogin(Config.Logins.Credential.DEFAULTS.userName, Config.Logins.Credential.DEFAULTS.password);
	}
	
	public static void loginSuplierUser(){
		doLogin(Config.Logins.Credential.SUPLIER.userName, Config.Logins.Credential.SUPLIER.password);
	}
	
	public static void loginOMSUser(){
		doLogin(Config.Logins.Credential.OMS.userName, Config.Logins.Credential.OMS.password);
	}
	
	public static void loginGDSNUser(){
		doLogin(Config.Logins.Credential.GDSN.userName, Config.Logins.Credential.GDSN.password);
	}
	
	public static void loginComboUser(){
		doLogin(Config.Logins.Credential.COMBO.userName, Config.Logins.Credential.COMBO.password);
	}
	
	public static void loginNonGDSNUser(){
		
		doLogin(Config.Logins.Credential.NONGDSN.userName, Config.Logins.Credential.NONGDSN.password);
	}
	
	public static void loginGDSNSubscriber(){
		doLogin(Config.Logins.Credential.GDSN_SUBSCRIBER.userName, Config.Logins.Credential.GDSN_SUBSCRIBER.password);
		
	}
	
	public static void setUserName(String userName){
		Elements.isEnabled(PageElements.USERNAME_TEXTBOX);
		Elements.clearAndType(PageElements.USERNAME_TEXTBOX, userName);
	}
	
	public static void setPassword(String password){
		Elements.isEnabled(PageElements.PASSWORD_TEXTBOX);
		Elements.clearAndType(PageElements.PASSWORD_TEXTBOX, password);		
	}
	
	public static String clickLoginButton(){
		Elements.isEnabled(PageElements.LOGIN_BUTTON);
		Elements.clickElement(PageElements.LOGIN_BUTTON);
		if(Elements.isEnabled(PageElements.ERROR_MESSAGE_STATIC))
			return Elements.getText(PageElements.ERROR_MESSAGE_STATIC);
		else 
			return "";
	}
	
	public static String loginWithInvalidUserNamePassword(){
		
		Elements.isEnabled(PageElements.USERNAME_TEXTBOX);
		Elements.clearAndType(PageElements.USERNAME_TEXTBOX, Config.Logins.Credential.INVALID_USERNAME_PASSWORD.userName);
		Elements.clearAndType(PageElements.PASSWORD_TEXTBOX, Config.Logins.Credential.INVALID_USERNAME_PASSWORD.password);
		
		clickLoginButton();
		if(Elements.isEnabled(PageElements.ERROR_MESSAGE_STATIC))
			return Elements.getText(PageElements.ERROR_MESSAGE_STATIC);
		else 
			return "";
	}

}
