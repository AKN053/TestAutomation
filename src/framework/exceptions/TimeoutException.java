package framework.exceptions;


import framework.helpers.VerifyAsserts;
import framework.providers.DataSet;

public class TimeoutException extends Exception{
	
	public  TimeoutException(String message){
		
		super(message);
		try {
			VerifyAsserts.screenCap(DataSet.getTestCaseName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
