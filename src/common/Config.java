package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Config {
	
	public static String currentUser = "";
	public static int sleep = 3000; //In Milliseconds - Can be increased as per environment.
	public static int wait = 25; //In Seconds -  Can be increased as per environment.
	public static int retryLoop = 20; //Can be increased as per environment.
	
	public static int pageLoadRetry = 100;
	
	public static int dataIndex = 0;
	
	//Test Data
	
	public static String GTIN = "44444444444444";
	public static String PRODUCTCODE = "BRG13";
	public static String PRODUCT_DESCRIPTION = "Brocolli Green13";
	
	public static Map<DataKeys, String> DATA_MAP = new HashMap<DataKeys,String>();
	public static Map<DataKeys, Boolean> DATA_FLAG = new HashMap<DataKeys,Boolean>();
	public static List<String> DUNS = new ArrayList<String>();
	public static List<String> GLNS = new ArrayList<String>();
	
	public enum BrowserType{
		CHROME_REMOTE, 
		CHROME_LOCAL,
		FIREFOX,
		IE;
	}
	
	
	public static class BaseUrl {
         // this should be set to one of constants below
		public static final String BOI_DEV_URL = "http://boi-dev06.itradenetwork.com:8181/mds/mdsui/index.html#";        
        private static final String PRE_QA_URL = "https://sqe-mds.itradenetwork.com/mds/mdsui/index.html#";        
        public static final String BASE_URL = PRE_QA_URL;
     }
	 
	 public static class Logins{
			/* Purpose : For declaring user credentials 
			 * * */
			public  String  userName;
			public  String password;
			
			public Logins(String userName,String password){
				this.userName = userName;
				this.password = password;
			}
			
			public static class Credential{
				public static final Logins DEFAULTS = new Logins("default","password");
				public static final Logins ADMIN = new Logins("admin@itn.com","password");
				public static final Logins GDSN = new Logins("gdsn_publisher", "password");
				public static final Logins OMS = new Logins("oms_publisher", "password");
				public static final Logins SUPLIER = new Logins("gdsn_oms_publisher","password");
				public static final Logins INVALID_USERNAME_PASSWORD = new Logins("InvalidUserName", "InvalidPassword");
				public static final Logins NONGDSN = new Logins("Automation_oms_subscriber", "password");
				
				//Subscriber
				public static final Logins GDSN_SUBSCRIBER = new Logins("gdsn_subscriber", "password");
				//Combo user
				public static final Logins COMBO = new Logins("pub_sub_user", "password");
				
			}
			
		}
	 
	 
	 public static enum DataKeys{
		 
		 FIRST_ROW_TEXT,
		 //Company Information
		 SUBSIDIARY_OR_BUSINESS_UNIT,
		 COMPANY_URL,
		 GLN,
		 DUN,
		 INDUSTRY_SEGMENT,
		 STREET_ADDRESS,
		 CITY,
		 COUNTY,
		 STATE,
		 ZIP,
		 COUNTRY,
		 FIRST_NAME,
		 MIDDLE_NAME,
		 LAST_NAME,
		 PHONE,
		 FAX,
		 EMAIL,
		 //Company Roles Detials
		 COMPANY_ROLES_IS_GDSN,
		 COMPANY_ROLES_PUBLISHER,
		 COMPANY_ROLES_SUBSCRIBER,
		 COMPANY_ROLES_DIGITAL_ASSET_MANAGEMENT,
		 COMPANY_ROLES_SELL_SHEET,
		 COMPANY_ROLES_PRODUCT_INFORMATION_MANAGEMENT_PIM,
		 COMPANY_ROLES_DATA_QUALITY,
		 COMPANY_ROLES_DATA_POOL_ITN,
		 COMPANY_ROLES_DATA_POOL_3RD_PARTY,
		 //Integration-Applications
		 INTEGRATIONS_APPLICATIONS_XML_INBOUND,
		 INTEGRATIONS_APPLICATIONS_FLAT_FILE_INBOUND,
		 INTEGRATIONS_APPLICATIONS_SPREADSHEET_INBOUND,
		 INTEGRATIONS_APPLICATIONS_PUBLISHER_PORTAL_INBOUND,
		 INTEGRATIONS_APPLICATIONS_PUBLISHER_PORTAL_LIMITED_INBOUND,
		 INTEGRATIONS_APPLICATIONS_XML_OUTBOUND,
		 INTEGRATIONS_APPLICATIONS_FLAT_FILE_OUTBOUND,
		 INTEGRATIONS_APPLICATIONS_SPREADSHEET_OUTBOUND,
		 INTEGRATIONS_APPLICATIONS_BRANDED_PROCUREMENT_BP,		 
		 INTEGRATIONS_APPLICATIONS_CBORD,
		 INTEGRATIONS_APPLICATIONS_ORDER_MANAGEMENT_SYSTEM,
		 //User Accounts
		 FIRST_NAME_USER,
		 LAST_NAME_USER,
		 USER_ROLE,
		 TITLE_USER,
		 EMAIL_USER,
		 PHONE_USER,
		 USER_NAME_USER,
		 //Entrustments
		 SELECTED_PARTNER_ENTRUSTMENT,
		 
		 
	 }
	 
}