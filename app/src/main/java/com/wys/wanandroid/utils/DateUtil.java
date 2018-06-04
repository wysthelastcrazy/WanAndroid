package com.wys.wanandroid.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String DateToStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	public static String getCurrentTime(long date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String str = format.format(new Date(date));
		return str;
	}
	public static String getCurrentTimeV2(long date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(new Date(date));
		return str;
	}
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 判断是否为闰年
	public static boolean isLeapYear(int year) {
		if (year % 100 == 0 && year % 400 == 0) {
			return true;
		} else if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}
	//得到某月有多少天数
	public static int getDaysOfMonth(boolean isLeapyear, int month) {
		int daysOfMonth=0;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysOfMonth = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysOfMonth = 30;
				break;
			case 2:
				if (isLeapyear) {
					daysOfMonth = 29;
				} else {
					daysOfMonth = 28;
				}

		}
		return daysOfMonth;
	}
}