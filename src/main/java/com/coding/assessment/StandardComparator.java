package com.coding.assessment;

public class StandardComparator extends TitleLengthComparator{
	@Override
	public boolean isLonger(String title1, String title2) {
		return title1.length() > title2.length();
	}
}
