package framework.exceptions;


import framework.helpers.VerifyAsserts;
import framework.providers.DataSet;

public class NoSuchElementException extends Exception{
	
	public  NoSuchElementException(String message){
			
			super();
			try {
				VerifyAsserts.screenCap(DataSet.getTestCaseName());
				//test
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
