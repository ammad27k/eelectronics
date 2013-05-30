package com.imc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String dateFormat = "yyyy-MM-dd";
	
	public static Date parseDateFromSTring(String strDate){
		try{
			SimpleDateFormat parseDate = new SimpleDateFormat(dateFormat);
			Date date = parseDate.parse(strDate);
			return date;
		}catch(Exception e){
			return null;	
		}
		
	}
}
