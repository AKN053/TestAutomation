package framework.providers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Data {
	 private static final String PASS_List = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	 private static final String NAME_List = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 private static final String NUM_LIST = "123456789";
	 private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";
	 
	public static String getString(int length){
        
        StringBuffer randStr = new StringBuffer();
        Random randomGenerator = new Random();
	      
        for(int i=0; i<length; i++){
        	int number = randomGenerator.nextInt(NAME_List.length());
            char ch = NAME_List.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
     
    /**
     * This method generates random numbers
     * @return int
     */
    private static String getPassword(int length) {
    	 StringBuffer randStr = new StringBuffer();
         Random randomGenerator = new Random();
 	      
         for(int i=0; i<length; i++){
         	int number = randomGenerator.nextInt(PASS_List.length());
             char ch = PASS_List.charAt(number);
             randStr.append(ch);
         }
         return randStr.toString();
    }
    
   public static String getNumber(int length){
        
        StringBuffer randStr = new StringBuffer();
        Random randomGenerator = new Random();
        for(int i=0; i<length; i++){
        	int number = randomGenerator.nextInt(NUM_LIST.length());
            char ch = NUM_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
   
   //  This method Incre/Decre days from today date and return date 
   //  depending on  positive/negative value of noOfDaysFromToday with specified date format
   public static String getDate(int noOfDaysFromToday,String dateFormat){
		if(dateFormat.equals(""))
			dateFormat = "MM/dd/yyyy";
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, noOfDaysFromToday);
		// DateFormat format method  create a string 
		// representation of a date with the defined format.
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String date = sdf.format(cal.getTime());
		return date;
			
	}
   
   // This method returns random mail Id with default name length 6
   public static String getMailId(String domain){
		
		String mailId= "";
		if(domain.equals(""))
			domain ="sample.com";
		Random genrator = new Random();
		for(int i=0;i<6;i++){
			int num = genrator.nextInt(CHAR_LIST.length());
			mailId = mailId+CHAR_LIST.charAt(num);
		}
		mailId= mailId+"@"+domain;
		return mailId;
			
	}
   
   public static String getWebSiteURL(int length){
	   return "www."+getString(length)+".com";
   }
   
   
   public static int getNumberBetween(int min, int max) {
	    
	    Random rand = new Random();	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
   

}
