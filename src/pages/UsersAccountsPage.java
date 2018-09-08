/**
 * 
 */
package pages;

import org.openqa.selenium.By;

import common.Config;
import common.Config.DataKeys;
import common.Enumerations.UserRole;
import framework.helpers.Elements;
import framework.providers.Data;

/**
 * @author prashantc
 *
 */
public class UsersAccountsPage extends BasePage{
	
	
	public static class AddNewUserOverlay{
		public static class PageElements{
			public static final By FIRST_NAME_TEXTBOX = By.cssSelector("div > input[name='firstName']");
			public static final By LAST_NAME_TEXTBOX = By.cssSelector("div > input[name='lastName']");
			public static final By USER_ROLE_BUTTON = By.cssSelector("div > button[id='userRole']");
			public static final By USER_ROLE_DROPDOWN = By.cssSelector("div > ul[role='select']");
			public static final By TITLE_TEXTBOX = By.cssSelector("div > input[name='title']");
			public static final By EMAIL_TEXTBOX = By.cssSelector("div > input[name='email']");
			public static final By PHONE_TEXTBOX = By.cssSelector("div > input[name='phone']");
			public static final By USER_NAME_TEXTBOX = By.cssSelector("div > input[name='login']");
			
			//Buttons
			public static final By ADD_USER_BUTTON = By.cssSelector("div[class*='modal-footer'] > button[ng-click='addUser()']");
			public static final By CACENL_LINK = By.cssSelector("div[class*='modal-footer'] > a[id='cancel']");
		}
		
		public static void setFirstName(){
			Elements.isEnabled(PageElements.FIRST_NAME_TEXTBOX);
			String data = Data.getString(10);
			Config.DATA_MAP.put(DataKeys.FIRST_NAME_USER, data);
			Elements.typeIN(PageElements.FIRST_NAME_TEXTBOX, data);
		}
		
		public static void setLastName(){
			Elements.isEnabled(PageElements.LAST_NAME_TEXTBOX);
			String data = Data.getString(10);
			Config.DATA_MAP.put(DataKeys.LAST_NAME_USER, data);
			Elements.typeIN(PageElements.LAST_NAME_TEXTBOX, data);
		}
		
		public static void selectUserRole(UserRole userRole){
			Elements.isEnabled(PageElements.USER_ROLE_BUTTON);
			Elements.clickElement(PageElements.USER_ROLE_BUTTON);
			Elements.clickElementInDropList(PageElements.USER_ROLE_DROPDOWN, "", userRole.toString());
		}
		
		public static void setTitle(){
			Elements.isEnabled(PageElements.TITLE_TEXTBOX);
			String data = Data.getString(4);
			Elements.typeIN(PageElements.TITLE_TEXTBOX, data);
		}
		
		public static void setEmail(){
			Elements.isEnabled(PageElements.EMAIL_TEXTBOX);
			String data = Data.getMailId("");
			Config.DATA_MAP.put(DataKeys.EMAIL_USER, data);
			Elements.typeIN(PageElements.EMAIL_TEXTBOX, data);
		}
		
		public static void setPhone(){
			Elements.isEnabled(PageElements.PHONE_TEXTBOX);
			String data = Data.getNumber(10);
			Config.DATA_MAP.put(DataKeys.PHONE_USER, data);
			Elements.typeIN(PageElements.PHONE_TEXTBOX, data);
		}
		
		public static void setUserName(){
			Elements.isEnabled(PageElements.USER_NAME_TEXTBOX);
			String data = Data.getString(10);
			Config.DATA_MAP.put(DataKeys.USER_NAME_USER, data);
			Elements.typeIN(PageElements.USER_NAME_TEXTBOX, data);
		}
		
		public static void clickAddUserButton(){
			Elements.isEnabled(PageElements.ADD_USER_BUTTON);
			Elements.clickElement(PageElements.ADD_USER_BUTTON);
			Elements.isDisappeared(PageElements.ADD_USER_BUTTON, Config.pageLoadRetry);
		}
		
		public static void clickCancel(){
			Elements.isEnabled(PageElements.CACENL_LINK);
			Elements.clickElement(PageElements.CACENL_LINK);
		}
		
		
		public static void fillAddUserOverlay(UserRole userRole){
			setFirstName();
			setLastName();
			selectUserRole(userRole);
			setTitle();
			setEmail();
			setPhone();
			setUserName();
		}
	}
	
	

}
