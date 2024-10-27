package com.abby.qa.utils;

import java.util.Date;

public class Utilities {
	
	public static final int impl_Wait = 10;
	public static final int pageLoad_Timeout = 5;

	public static String getTimeStamp() {
		Date d = new Date();
		String timeStamp =  d.toString().replace(" ","").replace(":", "");
		return "amot"+timeStamp+"@gmail.com";
		
	}
}
