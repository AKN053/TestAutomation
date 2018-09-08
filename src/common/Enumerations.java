package common;

public class Enumerations {
	
	/*public static enum DataKeys{
			FIRST_ROW_TEXT	
	}*/
	
	public static enum State{
		ALABAMA("Alabama"),
		ALASKA("Alaska"),
		AMERICAN_SAMOA("American Samoa"),
		ARIZONA("Arizona"),
		ARKANSAS("Arkansas"),
		CALIFORNIA("California"),
		COLORADO("Colorado"),
		CONNECTICUT("Connecticut"),
		DELAWARE("Delaware"),
		DISTRICT_OF_COLUMBIA("District of Columbia"),
		FEDERATED_STATES_OF_MICRONESIA("Federated States of Micronesia"),
		FLORIDA("Florida"),
		GEORGIA("Georgia"),
		GUAM("Guam"),
		HAWAII("Hawaii"),
		IDAHO("Idaho"),
		ILLINOIS("Illinois"),
		INDIANA("Indiana"),
		IOWA("Iowa"),
		KANSAS("Kansas"),
		KENTUCKY("Kentucky"),
		LOUISIANA("Louisiana"),
		MAINE("Maine"),
		MARSHALL_ISLAND("Marshall Islands"),
		MARYLAND("Maryland"),
		MASSACHUSETTS("Massachusetts"),
		MICHIGAN("Michigan"),
		MINNESOTA("Minnesota"),
		MISSISSIPPI("Mississippi"),
		MISSOURI("Missouri"),
		MONTANA("Montana"),
		NEBRASKA("Nebraska"),
		NEVADA("Nevada"),
		NEW_HAMPSHIRE("New Hampshire"),
		NEW_JERSEY("New Jersey"),
		NEW_MEXICO("New Mexico"),
		NEW_YORK("New York"),
		NORTH_CAROLINA("North Carolina"),
		NORTH_DACOTA("North Dakota"),
		NORTHERN_MARIANA_ISLANDS ("Northern Mariana Islands"),
		OHIO("Ohio"),
		OKLAHOMA("Oklahoma"),
		OREGON("Oregon"),
		PALAU("Palau"),
		PENNSYLVANIA("Pennsylvania"),
		PUERTO_RICO("Puerto Rico"),
		RHODE_ISLAND("Rhode Island"),
		SOUTH_CAROLINA("South Carolina"),
		SOUTH_DAKOTA("South Dakota"),
		TENNESSEE("Tennessee"),
		TEXAS("Texas"),
		UTAH("Utah"),
		VERMOUNT("Vermont"),
		VIRGIN_ISLAND_US("Virgin Islands, U.S."),
		VIRGINIA("Virginia"),
		WASHINGTON("Washington"),
		WEST_VIRGINIA("West Virginia"),
		WISCONSIN("Wisconsin"),
		WYOMING("Wyoming"),
				
		ALBERTA("Alberta"),
		BRITISH_COLUMBIA("British Columbia"),
		MANITOBA("Manitoba"),
		NEW_BRUNSWICK("New Brunswick"),
		NEWFOUNDLAND_AND_LABRADOR("Newfoundland and Labrador"),
		NORTHWEST_TERRITORIES("Northwest Territories"),
		NOVA_SCOTIA("Nova Scotia"),
		NUNAVUT("Nunavut"),
		ONTARIO("Ontario"),
		PRINCE_EDWARD_ISLAND("Prince Edward Island"),
		QUEBEC("Quebec"),
		SASKATCHEWAN("Saskatchewan"),
		YUKON("Yukon");
	
		
		private String displayName;

		State(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }
	}
	
	
	public static enum Country{
		US ("United States"),
		CANADA("Canada");
		
		private String displayName;

		Country(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }
	}
	
	public static enum IndustrySegment{		
		DISTRIBUTOR("Distributor"),
		MANUFACTURER("Manufacturer"),
		OPERATOR("Operator"),
		PRODUCE_SUPPLIER("Produce Supplier"),
		RE_DISTRIBUTOR("Re-Distributor"),
		SUPPLIER("Supplier"),
		NA("NA");
		
		private String displayName;
	
		IndustrySegment (String displayName){
				this.displayName=displayName;
				}
					public String displayName() {return displayName; }
		
					@Override public String toString(){return displayName; }
	
	}
	
	public static enum CompanyStatus{
		ACTIVE("Active"),
		INACTIVE("Inactive"),
		INPROCESS("Inprocess");
		
		private String displayName;
		
		CompanyStatus (String displayName){
				this.displayName=displayName;
				}
					public String displayName() {return displayName; }
		
					@Override public String toString(){return displayName; }
		
	}
	
	
	public static enum More{
		DOWNLOAD_ITEMS("Download Items"),
		DELETE_RECORDS("Delete Records"),
		GET_GTIN_TEMPLATES("Get GTIN Template");
		
		private String displayName;

		More(String displayName) {
		        this.displayName = displayName;
		    }
		    public String displayName() { return displayName; }
	         // Optionally and/or additionally, toString.
		    @Override public String toString() { return displayName; }
	}
	
	
	public static enum ColumnName{
		//Catalog Page
		GTIN("GTIN"),
		GTIN_STATIC("GTIN"),
		GTIN_STATIC_SUBSCRIBER("GTIN"),
		PRODUCT_CODE("Product Code"),
		ITEM_DESCRIPTION("Item Description"),
		REGISTRATION_STATUS("Registration Status"),
		NO_OF_SUBSCRIBERS("# Subscribers"),
		NO_OF_SUBSCRIBERS_ARROW(""),
		CIC_REVIEW("CIC Review"),
		LAST_UPDATE("Last Update"),
		
		//Subscriber catalog page 
		LAST_UPLOAD_DATE("Last Upload Date"),
		DMS_STATUS("DMS Status"),
		
		//Publisher Center Page 
		SUBSCRIBER_NAME("Subscriber Name"),
		GLN("GLN"),
		PUBLISHED("# Published"),
		SUBSCRIBER_CIC_STATUS("Subscriber CIC Status"), // This column contains sub-Columns
		ACCEPTED("# Accepted"),
		REVIEW("# Review"),
		REJECTED("# Rejected"),
		SYNCHRONIZED("# Synchronized"),
		//Admin - Company Accounts Page
		COMPANY_NAME("Company Name"),
		SUBSIDIARY_OR_BUSINESS_UNIT("Subsidiary or Business Unit"),
		//GLN("GLN"),
		INDUSTRY_SEGMENT("Industry Segment"),
		COMPANY_ROLES("# Company Roles"),
		ENTRUSTMENTS("# Entrustments"),
		USERS("# Users"),
		STATUS_COMPANY_ACCOUNTS_PAGE("Status"),
		//Admin – Users Accounts Page
		EDIT_USER_LINK("Edit User Link"),
		LAST_NAME("Last Name"),
		FIRST_NAME("First Name"),
		USER_ROLE("User Role"),
		TITLE("Title"),
		EMAIL("Email"),
		PHONE("Phone"),
		USER_NAME("User Name"),
		PASSWORD("Password"),
		STATUS_USER_ACCOUNTS_PAGE("Status"),
		
		//Subscribers Items
		DESCRIPTION("Description"),
		CIC_STATUS("CIC Status"),
		CIC_STATUS_DATE("CIC Status Date"),
		//Review CICs
		UNIT_DESCRIPTOR("Unit Descriptor"),
		
		//publish items from subscriber
		LASTUPDATED("LastUpdated"),
		PUBLISHER_NAME("publisherName"),
		PUBLISHER_GLN("publisherGln"),
		PRODUCT_GPC("Product GPC"),
		SUBSCRIBER_GLN("Subscriber GLN"),
		STATUS_GDSN_SUBSCRIPTION("Status"),
		PUBLISHER_NAME_DATA_QUALITY("Publisher Name"),
		TOTAL_MATCHED("Total"),
		TOTAL_UNMATCHED("Total"),
		PUBLISHED_COUNT("# Published");
		
		private String displayName;

		ColumnName(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }
		
		
	}
	
	public static enum UserRole{
		SITE_ADMIN("Site Admin Role"),		
		PUBLISHER_ADMIN("Publisher Admin Role"),
		PUBLISHER_USER("Publisher User Role"),
		SUBSCRIBER_ADMIN("Subscriber Admin Role"),
		SUBSCRIBER_USER("Subscriber User Role");
		
		private String displayName;

		UserRole(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }
		
	}
	
	public static enum BreadCrumbPage{
		HOME_PAGE("Home"),
		COMPANY_ACCOUNTS_PAGE("Administration - Company Accounts"),
		ADD_NEW_COMPANY_PAGE("Add New Company Account");
		
		private String displayName;

		BreadCrumbPage(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }		
		
	}
	
	public static enum CompanyRoles{
		PUBLISHER("Publisher"),
		SUBSCRIBER("Subscriber"),
		DIGITAL_ASSETS_MANAGEMENT("Digital Assets Management"),
		SELL_SHEET("Sell Sheet"),
		PRODUCT_INFORMATION_MANAGEMENT_PIM("Product Information Management (PIM)"),
		DATA_QUALITY("Data Quality"),
		DATA_POOL_ITN("Data Pool - ITN"),
		DATA_POOL_3RD_PARTY("Data Pool - 3rd Party");
		
		private String displayName;

		CompanyRoles(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }	
		
	}
	
	public static enum CatalogActivities{
		FIX_FAILED_ITEMS("Fix Failed Items"),
		UPLOAD_AND_REGISTER("Upload & Register"),
		DOWNLOAD_ITEMS("Download Items"),
		GET_CATALOG_UPLOAD_FILE("Get Catalog Upload File"),
		DELETE_RECORDS("Delete Records"),
		GO_TO_CATALOG("Go to Catalog");
		 
		private String displayName;

		CatalogActivities(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }	
	}
	
	public static enum PublishingActivities{
		REVIEW_CICS("Review CICs"),
		UNPUBLISH_ITEMS("Unpublish Items"),
		PUBLISH_ITEMS("Publish Items"),
		GO_TO_PUBLISHING_CENTER("Go to Publishing Center");
		 
		private String displayName;

		PublishingActivities(String displayName) {
			        this.displayName = displayName;
			    }
			    public String displayName() { return displayName; }
		         // Optionally and/or additionally, toString.
			    @Override public String toString() { return displayName; }	
	}

}
