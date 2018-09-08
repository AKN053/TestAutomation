package pages;

import java.util.ArrayList;
import java.util.List;

import net.sf.saxon.instruct.ForEach;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.BasePage.IsLoading;
import common.LogHandler;
import common.Enumerations.IndustrySegment;
import framework.helpers.Elements;

public class CompanyAccountsPage extends BasePage{
	
	public static class PageElements{
		
		public static final By COMPANY_LOOKUP_TEXTBOX = By.cssSelector("form[role='form'] > input[id='searchText']");
		public static final By TYPEAHEAD_RESULTLIST = By.cssSelector("ul[class*='typeahead'][role='select']");
		//
		public static final By INDUSTRY_SEGMENTS_BUTTON = By.cssSelector("div[id='selectIndustrySegment']>div > button");
		//
		public static final By INDUSTRY_SEGMENTS_DROPDOWN = By.cssSelector("div[id='selectIndustrySegment']> div > ul[role='select']");
		
		public static final By RESET_LINK = By.cssSelector("button[ng-click*='resetSearch()']");
		
		//public static final By FILTER_APPLIED_STATIC = By.cssSelector("div[ng-show='showITNPanelContent'] > div:nth-child(3) > div > div:nth-child(4) > div");
		//
		public static final By FILTER_APPLIED_STATIC = By.cssSelector("div[id='selectIndustrySegment']> div > button[type='button']");
			
		
	}	
	
	
	public static void selectFromIndustrySegmentsDropdown(IndustrySegment industrySegment){
		Elements.isEnabled(PageElements.INDUSTRY_SEGMENTS_BUTTON);
		Elements.clickElement(PageElements.INDUSTRY_SEGMENTS_BUTTON);
		
		Elements.isEnabled(PageElements.INDUSTRY_SEGMENTS_DROPDOWN);
		Elements.clickElementInDropList(PageElements.INDUSTRY_SEGMENTS_DROPDOWN, "", industrySegment.toString());
		Elements.typeIn(PageElements.INDUSTRY_SEGMENTS_DROPDOWN, Keys.TAB);
	}
	
	public static void clickReset(){
		Elements.isEnabled(PageElements.RESET_LINK);
		Elements.clickElement(PageElements.RESET_LINK);
	}
	
	public static void performSearch(String searchData){
		Elements.isEnabled(PageElements.COMPANY_LOOKUP_TEXTBOX);
		

		Elements.clearAndType(PageElements.COMPANY_LOOKUP_TEXTBOX, searchData.substring(0, searchData.length()-1));		
		Elements.typeIn(PageElements.COMPANY_LOOKUP_TEXTBOX, Keys.BACK_SPACE);
		Elements.waitForElementToBeVisible(PageElements.TYPEAHEAD_RESULTLIST);
		WebElement searchList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownStart(searchList, searchData);
		while(IsLoading.isLoading())
			LogHandler.logInfo("Loading the page...");
			
	}
	
	public static String getAppliedFilter(){
		/*Elements.isEnabled(PageElements.FILTER_APPLIED_STATIC);
		//System.out.println("*******"+Elements.getText(PageElements.FILTER_APPLIED_STATIC));
		List<WebElement> appliedFilters = Elements.findAll(Elements.find(PageElements.FILTER_APPLIED_STATIC), By.cssSelector("span")); 
		List<String> filters = new ArrayList<String>();		
		for(int i=0; i<appliedFilters.size(); i++){
			//System.out.println(Elements.getText(appliedFilters.get(i)));
			filters.add(Elements.getText(appliedFilters.get(i)));			
		}*/
		Elements.isEnabled(PageElements.FILTER_APPLIED_STATIC);
		return Elements.getText(PageElements.FILTER_APPLIED_STATIC);
		//return filters;
	}
	
	
	public static boolean verifyAppliedFilter(String expectedFilter){
		
		//Elements.find(By.cssSelector("div[id='selectIndustrySegment'] > button[type='button']"));
		
		String filterText = getAppliedFilter();
		/*for(int i=0; i<filterText.size(); i++ ){
			if(filterText.get(i).contains(expectedFilter))
				return true;
		}		
		*/
		
		if(filterText.contains(expectedFilter)){
			return true;
		}
		return false;
		
	}

	

}
