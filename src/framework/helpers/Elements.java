package framework.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Config;
import common.LogHandler;
import framework.exceptions.ElementNotClickable;
import framework.providers.DataSet;
import framework.providers.DriverManager;

/**
 * 
 * @author prashantc
 * 
 * This area interacts with Web-Elements on Browser
 *
 */
public class Elements {
		
	public static Boolean isEnabled(By locator) {		
		WebElement element = find(locator);
		if(element.isEnabled()){
			//LogHandler.logInfo("Element is enabled");
			return true;			
		}
		
		LogHandler.logInfo("Element is NOT enabled");
		return false;		
	}
	
	public static boolean isExist(By locator){
		int waitTime = Config.wait;
		
		//LogHandler.logInfo("Waiting up to " +waitTime+  " seconds for element : "+locator+" to exist");
		try{
		 	int interval = 500;
		    if ( waitTime >= 30 ) interval = 2000;
		    else
		    		if ( waitTime >= 20 ) interval = 1000;
		   
		   WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
		   wait.withTimeout(waitTime, TimeUnit.SECONDS);
		   wait.pollingEvery(interval, TimeUnit.MILLISECONDS);
		   wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		   wait.ignoring(NoSuchElementException.class);
		    if(DriverManager.getDriver().findElement(locator)!=null){
		    	//LogHandler.logInfo("Element :"+locator+" exist");
		    	 return true;
		    }		
		}catch(Exception e){			
	    	LogHandler.logInfo("Element : "+ locator+" does not  exist");
	    	//new  framework.exceptions.TimeoutException("Element Does not exist");
			return false;			
		}
		LogHandler.logInfo("Element :"+locator+" does not exists!");
        return false;
	}
	
	/** This method determines whether an element exists within another element
	 *  Selenium locator for the element being searched for the parent element
	 *  Number of seconds to look for the element, default is 1000
	 * 
	 * */
	 public static boolean isExist(WebElement parent, By locator){
		 //LogHandler.logInfo("Searching element : " + locator + " for " + Config.sleep + " seconds");
		 int retry = Config.retryLoop;
		 do{			 
			 try{
				 parent.findElement(locator);
				 return true;				 
			 } catch(Exception e){
				 try {
					Thread.sleep(Config.sleep);
				 	} catch (InterruptedException e1) {					
				 	}
				retry--;			 
			 }			 
		 } while(retry > 0);		 
		
		 LogHandler.logInfo("Did not find element :"+locator+" in time allowed, returning false");
		 return false;
	 }
	 
	 public static List<WebElement> findAll(By locator){
		 //LogHandler.logInfo("Finding all elements matching: "+locator);
		 if (!isExist(locator)){             
			 LogHandler.logInfo("Unable to find elements matching: "+ locator);
            
				try {
					throw new NoSuchElementException("Unable to find elements matching: "+ locator);
				} catch (NoSuchElementException e) {
					e.printStackTrace();
				}
		
         }
		 List<WebElement> elements = DriverManager.getDriver().findElements(locator);		 
		// LogHandler.logInfo("Successfully returned "+elements.size()+" elements matching :"+ locator);		 
		 return Collections.unmodifiableList(elements);
	 }
	 
	 public static List<WebElement> findAll(WebElement parent, By locator) {		 
		// LogHandler.logInfo("Finding all elements matching :"+ locator);
		
		 List<WebElement> elements = parent.findElements(locator);
		 //LogHandler.logInfo("Successfully returned "+elements.size()+" elements matching :"+ locator);
		 
		 return Collections.unmodifiableList(elements);		 
	 }
	 
	 ///     This method returns an element on a page or throws a NoSuchElementException
     ///     It uses the Exists method to wait a period of time for the element to exist
	public static WebElement find(By locator) {	
		if (!(isExist(locator) && isVisible(locator))){
			LogHandler.logInfo("Unable to find element :"+locator);
			try {
				VerifyAsserts.screenCap(DataSet.testCaseName);
				throw new NoSuchElementException("Unable to find element :"+locator);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		//LogHandler.logInfo("Successfully returned element :"+ locator);
		
		return DriverManager.getDriver().findElement(locator);
	}
	
	/**
	 * This method searchs a parent for an element
	 * It uses the Exists method to wait a period of time for the element to eixst
	 * 
	 * @param parent	: Parent element to be searched in
	 * @param locator 	: The element to look for
	 * @return The desired element
	 */
	public static WebElement find(WebElement parent, By locator) {
		
		if (!isExist(parent, locator)){
			LogHandler.logInfo("Unable to find element :"+locator+" in parent "+ parent);
			try {
				throw new NoSuchElementException("Unable to find element :"+locator+" in parent :"+ parent);
			} catch (NoSuchElementException e) {
				
				e.printStackTrace();
			}
		}
		
		//LogHandler.logInfo("Successfully returned element :"+locator+" in parent "+ parent);
		return parent.findElement(locator);		
	}
	
	public static boolean isVisible(By locator){
		return isVisible(locator, false);
	}	
	
	public static boolean isClickable(By locator, int waitTime){
		
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
		wait.withTimeout(waitTime, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		wait.ignoring(NoSuchElementException.class);
		
		try{
			if(DriverManager.getDriver().findElement(locator).isEnabled()){
				return true;
			}
		}catch(Exception e){
			System.out.println("Encountered an exception");
				return false;
		}
		
		return false;
		
	}
	
	public static void isDisappeared(By locator, int waitTime){
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
		wait.withTimeout(waitTime, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
		System.out.println("Element is now invisible");
	}
	
	public static boolean isVisible(By locator, boolean asrt){
		 if (isVisible(locator, Config.wait)){
			 return true;
		 }
		 
		 if (asrt){
			 LogHandler.logInfo(locator+" was not visible after "+Config.wait+" seconds");
			 
			 throw new ElementNotVisibleException(locator+" was not visible after "+Config.wait+" seconds");
		 }
		 return false;		
	}
	
    /**
     * This method checks that an element is present on a page and visible and wait for specified time period. 
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * @param locator 	: Element to be searched
     * @param waitTime 	: wait time for selenium search
     * @return
     */
	public static boolean isVisible(By locator, int waitTime) {
		//LogHandler.logInfo("Waiting up to " + waitTime + " seconds for element :"+locator+" to be visible");
		
		try{
			int interval = 500;
		    if ( waitTime >= 30 ) interval = 2000;
		    else
		    	if ( waitTime >= 20 ) interval = 1000;
		   
		   WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
		   wait.withTimeout(waitTime, TimeUnit.SECONDS);
		   wait.pollingEvery(interval, TimeUnit.MILLISECONDS);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   wait.ignoring(NoSuchElementException.class);
		    if(DriverManager.getDriver().findElement(locator)!=null){
		    	LogHandler.logInfo("Element :"+locator+" exist");
		    	 return true;
		    }
		}
		catch(TimeoutException e){
			LogHandler.logInfo("Element :"+locator+" is not visible after "+waitTime+" seconds!");
			//new  framework.exceptions.TimeoutException("Element is not visible");
			return false;			
		}
		
		LogHandler.logInfo("Element :"+locator+" is not visible!");		
		return false;
	}
	
	
	public static void clickElement(By locator){
		WebElement element = find(locator);		
		try {
			clickElement(element, Config.sleep);
		} catch (Throwable t) {			
			t.printStackTrace();
		}
	}
	
	/**
	 * This  method  will attempt to click an element until timeout occurs
	 * @param element : Element to be clicked
	 * @param timeout : wait time for selenium search
	 */
	public static void clickElement(WebElement element, int timeout){
		
		int retry = Config.retryLoop;
		WebElement locator = element;
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Config.wait);
		 while (retry > 0){
			 
			 try {		
				 wait.until(ExpectedConditions.elementToBeClickable(locator));
                 locator.click();                 
                // LogHandler.logInfo("Successfully Clicked Element :"+ locator.toString());
                 retry = 0;
                 return;
				 
			 } catch(Exception e){
				 if (retry > 0)
                 {
					 retry--;
					 try {
						Thread.sleep(timeout);
					} catch (InterruptedException e1) {						
						e1.printStackTrace();
					}
					 LogHandler.logInfo("Element not clickable yet");
                     continue;
                 }
				 
				 LogHandler.logInfo("The element was not clickable in "+timeout+" seconds");
				 try {
					throw new ElementNotClickable("The element was not clickable in "+timeout+" seconds");
				} catch (ElementNotClickable e1) {					
					e1.printStackTrace();
				}
			 }
		 }
		
	}
	
	public static void clearAndType(WebElement field, String text){		
		field.clear();
		LogHandler.logInfo("Typing text :"+ text);
        field.sendKeys(text);
        //field.sendKeys(Keys.TAB);		
	}
	
	/**
	 *  This method will find the textfield, clear its containts and typein the text into it
	 * @param locator : Element where text to be typed in 
	 * @param text : Text to be typed in 
	 */
	public static void clearAndType(By locator, String text){
		WebElement field = find(locator);
		field.clear();
		LogHandler.logInfo("Typing text :"+ text);
        field.sendKeys(text);
        //field.sendKeys(Keys.TAB);		
	}
	
	
	public static void typeIN(By locator, String text){
		
		WebElement field = find(locator);
		LogHandler.logInfo("Typing text :"+ text);
        field.sendKeys(text);
		
	}
	
	public static void typeIN(WebElement field, String text){		
		//WebElement field = find(locator);
		LogHandler.logInfo("Typing text :"+ text);
        field.sendKeys(text);
		
	}
	
	public static void typeIn(By locator, Keys key){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement field = find(locator);
		LogHandler.logInfo("Typing text :"+ key.toString());
        field.sendKeys(key);
	}
	
	
	/**
	 * This method selects an option from the desired droplist-box
	 * @param droplist : Dropdown to be used 
	 * @param optionToBeClicked : Option to be selected
	 */
	public static void clickElementInDropList(By droplist, String optionToBeClicked) {	
		
		clickElement(droplist);
		
		String a = droplist.toString().substring(13, droplist.toString().length()-6);
		By lst = By.cssSelector(a+"ul");
		
		String start = a+"ul > li:nth-child(";
		String end = ") > a > span";				

		WebElement mylist = find(lst);
		List<WebElement> options = findAll(mylist, By.tagName("li"));		
		LogHandler.logInfo("Total # of Options in drop-list are "+options.size());
		
		for(int i = 1 ; i <= options.size(); i++){
			if(find(By.cssSelector(start+i+end)).getText().equalsIgnoreCase(optionToBeClicked)){
				clickElement(By.cssSelector(start+i+end));
				break;
			}
		}
		
	}
	
	/**
	 * This method selects an option from the desired droplist-box
	 * 
	 * @param droplistlocator	: 	main locator(container) of drop down list
	 * @param optionTagName		:	tag name of option in drop down list
	 * @param optionToBeClicked	:	Option to be clicked
	 */
   public static void clickElementInDropList(By droplistlocator,String optionTagName,String optionToBeClicked){
		if(optionTagName.equals(""))
			optionTagName="li";
		
		WebElement element = find(droplistlocator);
		List<WebElement> optionsList = findAll(element,By.tagName(optionTagName));
		LogHandler.logInfo("Total Options in drop-list are "+optionsList.size());
		
		java.util.Iterator<WebElement> options = optionsList.iterator();
		while(options.hasNext()) {
			 WebElement option = options.next();				   
			 if(optionToBeClicked.equalsIgnoreCase(option.getText().trim())){
		    	clickElement(option,10);
		    	break;
		     }
		}		
	}
   
   /**
    * Method returns string value of element
    * @param locator
    * @return String
    */
   public static String getText(By locator){
	   String text="";
	   WebElement element =find(locator);
	   text = element.getText().trim();
	   return text;
   }
   
   public static String getText(WebElement element){
	   String text="";	  
	   text = element.getText().trim();
	   return text;
   }
   
   /**
    *  This method provides a search for a text string within a table designated by
    *  the tableLocator parameter.  Returns a true or false
    * @param tableLocator
    * @param textToSearchInCell
    * @return 
    */
 
   
   public static List<String> getTableData(By tableLocator){
	   List<String> dataList =  new ArrayList<String>();
	   
	    Elements.isExist(tableLocator);
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		
		// loop to search elements till visible/Enabled on page 
		
			List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
			if(tbodyList.size()>0){      
				temprowList = tbodyList;
				for(int tbody=0;tbody<temprowList.size();tbody++)
				{  // get all row if "tr" child of "tbody" element in table
					List<String> List = getAllRowColumnText(temprowList.get(tbody));
					dataList.addAll(tbody, List);
				   
				}
			}else{
				// check in all row of specified column
				dataList = getAllRowColumnText(htmltable);
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	    				
		
		return dataList;
  }
   private static List<String> getAllRowColumnText(WebElement htmltable){
	   List<String> dataList =  new ArrayList<String>();  
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("td"));
			for(int cnum=0;cnum<tblcolList.size();cnum++)
			{
				if(!tblcolList.get(cnum).getText().isEmpty()){
					LogHandler.logInfo("Adding Table cell Text into List - " +tblcolList.get(cnum).getText());
					dataList.add(tblcolList.get(cnum).getText());
				}
			}
		}
	  
	   return dataList;
   }
   
   
   /**
    * This method returns true when designated column text available in all rows 
    * @param tableLocator
    * @param columnNum
    * @param textToSearchInCell
    * @return
    */
   public static boolean getAllRowColumnText(By tableLocator,int columnNumber,String textToSearchInCell){
	
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	    				

		
		List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
		if(tbodyList.size()>0){      
			temprowList = tbodyList;
			for(int tbody=0;tbody<temprowList.size();tbody++)
			{  // get all row if "tr" child of "tbody" element in table
				if(!checkAllRowInAColumn(temprowList.get(tbody),columnNumber,textToSearchInCell)){
					return false;
				}
			}
		}else{
			// check in all row of specified column
			if(!checkAllRowInAColumn(htmltable,columnNumber,textToSearchInCell)){
				return false;
			}
		}
			
		return  true;
   }
   
   
   /**
    *   This method provides a search for a text string within a table designated by
    *   the tableLocator parameter.    
    * @param tableLocator
    * @param textToSearchInCell
    * @return  true or false
    */
   public static boolean getTableCellText(By tableLocator,String textToSearchInCell){
	    int retry = Config.retryLoop;
	    boolean foundCellText = false;
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		List<WebElement> rowList = new ArrayList<WebElement>();
		// loop to search elements till visible/Enabled on page 
		while(retry > 0) {			
			List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
			if(tbodyList.size()>0){      
				temprowList = tbodyList;
				for(int tbody=0;tbody<temprowList.size();tbody++)
				{  // get all row if "tr" child of "tbody" element in table
					if(checkAllRowColumn(temprowList.get(tbody),textToSearchInCell)){
						foundCellText = true;
						break;
					}					
				}
			} else{
				// get all rows in a table
				//rowList =findAll(htmltable,By.tagName("tr"));
				LogHandler.logInfo("Total Table Rows are "+rowList.size());
				if(checkAllRowColumn(htmltable,textToSearchInCell)){
					foundCellText = true;
					break;
				}
			}
			
			retry --;
			try {
				Thread.sleep(Config.sleep);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}		
		}
		return foundCellText;
  }
   
   
   /**
    * This method Search text in all rows & all column of table
    * @param htmltable
    * @param textToSearchInCell
    * @return true or false
    */
   public static boolean checkAllRowColumn(WebElement htmltable,String textToSearchInCell){
	  
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("td"));
			for(int cnum=0;cnum<tblcolList.size();cnum++)
			{
				if (tblcolList.get(cnum).getText().trim().equalsIgnoreCase(textToSearchInCell)) {
					LogHandler.logInfo("Cell Text  ==  "+tblcolList.get(cnum).getText());
					return true;
				}
			}
		}
	   LogHandler.logInfo("Text "+textToSearchInCell+" does not exist");
	   return false;
   }
   
   /**
    * This method search text in All row of specific column
    * @param htmltable
    * @param colNum
    * @param textToSearchInCell
    * @return  true or false
    */
   private static boolean checkAllRowInAColumn(WebElement htmltable,int colNum,String textToSearchInCell){
	  
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("td"));
				if (!tblcolList.get(colNum).getText().trim().toUpperCase().contains(textToSearchInCell.toUpperCase())) {
					return false;
				}
				LogHandler.logInfo("Text  ="+ tblcolList.get(colNum).getText() + " Found");
		}
	  
	   return true;
   }
   
   
   /**
    * This method search text in all row in a specific columns child tag Title
    * @param tableLocator
    * @param columnNumber
    * @param textToSearchInCell
    * @return
    */
   public static boolean getAllRowColumnChildText(By tableLocator,int columnNumber,String textToSearchInCell){
		
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	    				

		
		List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
		if(tbodyList.size()>0){      
			temprowList = tbodyList;
			for(int tbody=0;tbody<temprowList.size();tbody++)
			{  // get all row if "tr" child of "tbody" element in table
				if(!checkAllRowInAColumnChildTag(temprowList.get(tbody),columnNumber,textToSearchInCell)){
					return false;
				}
			}
		}else{
			// check in all row of specified column
			if(!checkAllRowInAColumnChildTag(htmltable,columnNumber,textToSearchInCell)){
				return false;
			}
		}
			
		return  true;
  }
   
   
   /**
    * This method search text in All row of specific columns child tag title
    * @param htmltable
    * @param colNum
    * @param textToSearchInCell
    * @return 
    */
   private static boolean checkAllRowInAColumnChildTag(WebElement htmltable,int colNum,String textToSearchInCell){
	  
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("td"));
			 
			 WebElement span=find(tblcolList.get(colNum),By.tagName("span"));
			 WebElement childElement=find(span,By.tagName("i"));
			 if (!childElement.getAttribute("title").contains(textToSearchInCell)) {
					return false;
				}
	
			LogHandler.logInfo("Text  ="+ childElement.getAttribute("title") + " found");
		}
	  
	   return true;
   }
   
   /**
    * This method search text in all cell of table, if cell contains text then it returns WebElement 
    * @param tableLocator
    * @param textToSearchInCell
    * @return WebElement
    */
   public static WebElement getTableCellContainsText(By tableLocator,String textToSearchInCell){
	    int retry =  Config.retryLoop;
	    WebElement element=null;
	  
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		List<WebElement> rowList = new ArrayList<WebElement>();
		// loop to search elements till visible/Enabled on page 
		while(retry>0){
			retry --;
			
			List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
			if(tbodyList.size()>0){      
				temprowList = tbodyList;
				for(int tbody=0;tbody<temprowList.size();tbody++)
				{  // get all row if "tr" child of "tbody" element in table
					element = checkCellContainsText(temprowList.get(tbody),textToSearchInCell);
					if(element!=null){
						return element;
					}					
				}
			}else{
				// get all rows in a table
				//rowList =findAll(htmltable,By.tagName("tr"));
				LogHandler.logInfo("Total Table Rows are "+rowList.size());
				 element = checkCellContainsText(htmltable,textToSearchInCell);
				 if(element!=null){
						return element;
				 }
			}
			try {
				Thread.sleep(Config.sleep);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}    
					
		}
		return element;
 }
   
   /**
    * This method search text in all cell of table . If cell contains text then returns element
    * @param htmltable
    * @param textToSearchInCell
    * @return WebElement
    */
   private static WebElement checkCellContainsText(WebElement htmltable,String textToSearchInCell){
	   WebElement element=null;
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("td"));
			for(int cnum=0;cnum<tblcolList.size();cnum++)
			{
				if (tblcolList.get(cnum).getText().trim().contains(textToSearchInCell) || tblcolList.get(cnum).getText().trim().replace(" ", "").contains(textToSearchInCell.replace(" ", ""))) {
					LogHandler.logInfo("Cell Text  ==  "+tblcolList.get(cnum).getText());
					return tblcolList.get(cnum);
				}
			}
		}
	   LogHandler.logInfo("Text ="+textToSearchInCell+" does not exist");
	   return element;
   }
   
   /**
    * This method return Column number of Table 
    * @param tableLocator
    * @param textToSearchInCell
    * @return
    */
   public static int getTableHeaderColumn(By tableLocator,String textToSearchInCell){
	    int retry =  Config.retryLoop;
	    int  columnNum = 0;
	  
	    WebElement htmltable=find(tableLocator);
		List<WebElement> temprowList =null;
		List<WebElement> rowList = new ArrayList<WebElement>();
		// loop to search elements till visible/Enabled on page 
		while(retry>0){
			retry --;
			
			List<WebElement> tbodyList =findAll(htmltable,By.tagName("tbody"));
			if(tbodyList.size()>0){      
				temprowList = tbodyList;
				for(int tbody=0;tbody<temprowList.size();tbody++)
				{  // get all row if "tr" child of "tbody" element in table
					columnNum = getHerderColumn(temprowList.get(tbody),textToSearchInCell);
					if(columnNum!=0){
						return columnNum;
					}					
				}
			}else{
				// get all rows in a table
				//rowList =findAll(htmltable,By.tagName("tr"));
				LogHandler.logInfo("Total Table Rows are "+rowList.size());
				columnNum = getHerderColumn(htmltable,textToSearchInCell);
				 if(columnNum!=0){
						return columnNum;
				 }
			}
			try {
				Thread.sleep(Config.sleep);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}    
					
		}
		return columnNum;
}
  
  
   
   /**
   * This method search text in all cell of table . If cell contains text then returns element
   * @param htmltable
   * @param textToSearchInCell
   * @return WebElement
   */
  private static int getHerderColumn(WebElement htmltable,String textToSearchInCell){
	   int colNum = 0;
	   List<WebElement> rowList = new ArrayList<WebElement>();
	   rowList =findAll(htmltable,By.tagName("tr"));
	   for(int rnum=0;rnum<rowList.size();rnum++)
		{
			// get all column in a row
			List<WebElement> tblcolList=findAll(rowList.get(rnum),By.tagName("th"));
			for(int cnum=0;cnum<tblcolList.size();cnum++)
			{	
				String headerText ="";
				if(isExist(tblcolList.get(cnum), By.tagName("div"))){
					headerText = find(tblcolList.get(cnum), By.tagName("div")).getText();
				}else{
					headerText = tblcolList.get(cnum).getText();
				}
				
				if (tblcolList.get(cnum).getText().trim().equalsIgnoreCase(textToSearchInCell) || headerText.contains(textToSearchInCell)) {
					LogHandler.logInfo("Header Column Number  ==  "+ cnum);
					return cnum;
				}
			}
		}
	   LogHandler.logInfo("Text ="+textToSearchInCell+" does not exist");
	   return colNum;
  }
  
  /**
   * This method set focus to  popup window
   */
  public static void switchTo(){
		String parentWindowHandler = DriverManager.getDriver().getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = DriverManager.getDriver().getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		DriverManager.getDriver().switchTo().window(subWindowHandler); // switch to popup window
		                                            // perform operations on popup

		DriverManager.getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window
	}
  
	public static void selectOption(By locator, String option) {
		WebElement element = find(locator);
		/*Elements.clickElement(locator);
		List<WebElement> allOptions = element.findElements(By.tagName("option"));
		for (int opt = 0; opt < allOptions.size(); opt++) {
			if (allOptions.get(opt).getText().trim().equals(option)) {
				allOptions.get(opt).click();
			}
		}*/
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(option);
	}
	
	public static String getAttribute(By locator,String attribute){
		
		WebElement element = find(locator);
		String attributeValue = element.getAttribute(attribute);
		return attributeValue.trim();
	}
	
	
	public static boolean verifySelectedOptionInDropBox(By locator, String option){
		
		Select select = new Select(find(locator));
		WebElement selectedOption = select.getFirstSelectedOption();
		if(selectedOption.getText().equalsIgnoreCase(option))
			return true;
		else
			return false;
	}
	
	
	public static void selectFromTypeAheadDropdownStart(WebElement dropdown, String optionToBeClicked){
		List<WebElement> options =  findAll(dropdown, By.cssSelector("li"));
		
		for(int i=0 ; i< options.size(); i++){			
			if(options.get(i).getText().contains(optionToBeClicked)){
				//System.out.println("Clicking...");
				options.get(i).click();
				break;
			}
		}
		
	}
	
	public static void selectFromTypeAheadDropdownMid(WebElement dropdown, String optionToBeClicked){		
		
		pauseExecution(2500);
		List<WebElement> options =  findAll(dropdown, By.cssSelector("li"));
		
		for(int i=0 ; i< options.size(); i++){			
			if(options.get(i).getText().contains("- "+optionToBeClicked+" -")){
				//System.out.println("Clicking...");
				options.get(i).click();
				break;
			}
		}		
	}
	
	public static void selectFromTypeAheadDropdownLast(WebElement dropdown, String optionToBeClicked){
		Elements.pauseExecution(2500);
		List<WebElement> options =  findAll(dropdown, By.cssSelector("li"));
		
		for(int i=0 ; i< options.size(); i++){			
			if(options.get(i).getText().contains("- "+optionToBeClicked)){
				//System.out.println("Clicking...");
				options.get(i).click();
				break;
			}
		}
		
	}
	
	
	/**
	 * MDS-TABLE METHODS
	 * This method clicks the first LINK of the columnName
	 * @param columnName : Name Of the Column
	 */
	
	
	public static void pauseExecution(int miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitForElementToBeVisible(By locator){
		int count = 0;
		LogHandler.logInfo("Waiting for Page Load ");
		while(!isVisible(locator)){
			LogHandler.logInfo("page load in progress..");
			pauseExecution(1500);
			if(count>60){
				break;
			}
			count++;
		}
		LogHandler.logInfo("page loaded");
	}
	
	
	public static String getCurrentURL(){
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	public static void goToURL(String url){
		DriverManager.getDriver().get(url);
	}
	
	public static void hoverOnElement(WebElement element){
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
		actions.moveToElement(element).build().perform();
	}
}
