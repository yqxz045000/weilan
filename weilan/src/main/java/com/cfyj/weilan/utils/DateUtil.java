package com.cfyj.weilan.utils;

import java.util.Calendar;

public class DateUtil {
	
	
	public static long yesterdayTime() {
		Calendar calendar = Calendar.getInstance();	
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY , 0);
		calendar.set(Calendar.DATE , -1);
		return calendar.getTimeInMillis();
	}

}
