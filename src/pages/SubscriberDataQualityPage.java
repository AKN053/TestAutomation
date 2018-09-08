package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import common.Enumerations.ColumnName;

import pages.BasePage.MDS_Table;
import pages.GDSNSubscriptions.PageElements;
import framework.helpers.Elements;

public class SubscriberDataQualityPage extends BasePage{
	
	public static class PageElements{
		
		public static final By SEARCH_TEXTBOX =By.cssSelector("input[id='searchItem']");
		public static final By TYPEAHEAD_RESULTLIST = By.cssSelector("ul[class*='typeahead'][role='select']");
	}
	
	public static void performSearch(String searchText){
		Elements.isEnabled(PageElements.SEARCH_TEXTBOX);
		Elements.clearAndType(PageElements.SEARCH_TEXTBOX, searchText.substring(0, searchText.length()));		
		Elements.typeIn(PageElements.SEARCH_TEXTBOX, Keys.BACK_SPACE);
		WebElement typeAheadResultList = Elements.find(PageElements.TYPEAHEAD_RESULTLIST);
		Elements.selectFromTypeAheadDropdownMid(typeAheadResultList,searchText);
	}
	
	public static String getFirstPublisherName(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.PUBLISHER_NAME_DATA_QUALITY);		
		return gtin.get(0);
	}
	
	public static String getFirstGLN(){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.PUBLISHER_GLN);		
		return gtin.get(0);
	}
	
	public static int getTotalMatchedCountNthRow(int rowNumber){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.TOTAL_MATCHED);
		return Integer.parseInt(gtin.get(rowNumber-1).trim());
	}
	
	public static int getTotalUnMatchedCountNthRow(int rowNumber){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.TOTAL_UNMATCHED);
		return Integer.parseInt(gtin.get(rowNumber-1).trim());
	}
	
	public static int getPublishedCountNthRow(int rowNumber){
		List<String> gtin = MDS_Table.getColumnData(ColumnName.PUBLISHED_COUNT);
		return Integer.parseInt(gtin.get(rowNumber-1).trim());
	}

}
