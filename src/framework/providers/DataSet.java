package framework.providers;

import java.util.HashMap;
import java.util.Map;

import common.Config.DataKeys;



public class DataSet {
	
	public static String testCaseName = null;
	public static String currentUser = null;
	public static String companyName = null;
	
	public static Map<DataKeys, String> DATA_MAP = new HashMap<DataKeys, String>();
	
	
	public static String getTestCaseName(){
		return testCaseName;
	}
	
	public static void setTestCaseName(String tname){
		testCaseName = tname;
	}
	
	public static String getCurrentUser(){
		return currentUser;
	}
	
	public static void setCurrentUser(String userName){
		currentUser = userName;
	}
	
	public static Map<DataKeys, String> getDataMap(){
		return DATA_MAP;
	}
	
	public static void putIntoDataMap(DataKeys key, String value){		
		DATA_MAP.put(key, value);
	}
	
	public static void setCompanyName(String cName){
		companyName = cName;
	}
	
	public static String getCompanyName(){
		return companyName;
	}

}
