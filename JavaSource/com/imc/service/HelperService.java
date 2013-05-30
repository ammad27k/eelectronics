package com.imc.service;

import com.imc.framework.bean.MobileBrands;

public class HelperService {

	public static void setStringWithFirstLetterUpperCase(MobileBrands brands){
		char title = brands.getTitle().charAt(0);
		String firstLetter = ""+title;
		firstLetter = firstLetter.toUpperCase();
		title = firstLetter.charAt(0);
		char[] array = brands.getTitle().toCharArray();
		array[0] = title;
		brands.setTitle(String.copyValueOf(array));
	}
}
