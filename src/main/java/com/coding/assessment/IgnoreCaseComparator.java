package com.coding.assessment;

public class IgnoreCaseComparator extends TitleLengthComparator{
	
	@Override
	public boolean isLonger(String title1, String title2) {
		return title1.toLowerCase().length() > title2.toLowerCase().length();
	}
}
