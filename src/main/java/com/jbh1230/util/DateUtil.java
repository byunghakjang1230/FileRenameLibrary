package com.jbh1230.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//기존의 포멧터로 출력된 시간 문자열을 다른 포멧으로 포멧팅하여 출력하려고 할 때.
	public static String changeTimeFormatToString(String timeStr, String bfFormat, String afFormat) {
		String resultTime = "";
		try {
			resultTime = new SimpleDateFormat(afFormat).format(new SimpleDateFormat(bfFormat).parse(timeStr)).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultTime = "Parse Error!!!";
		}
		return resultTime;
	}
	
	public static Date transStringToDate(String date, String format) throws ParseException {
		return new SimpleDateFormat(format).parse(date);
	}
	
	public static String transDateToString(Date date, String format) {
		return new SimpleDateFormat(format).format(date).toString();
	}
	
	public static String getYearToYYYY(Date date) {
		return new SimpleDateFormat("yyyy").format(date).toString();
	}
	
	public static String getMonthToMM(Date date) {
		return new SimpleDateFormat("MM").format(date).toString();
	}
	
	public static String getDayToDD(Date date) {
		return new SimpleDateFormat("dd").format(date).toString();
	}
	
	public static String getHourToHHBy24(Date date) {
		return new SimpleDateFormat("HH").format(date).toString();
	}
	
	public static String getHourToHHBy12(Date date) {
		return new SimpleDateFormat("hh").format(date).toString();
	}
	
	public static String getMinuteToMM(Date date) {
		return new SimpleDateFormat("mm").format(date).toString();
	}
	
	public static String getSecondsToSS(Date date) {
		return new SimpleDateFormat("ss").format(date).toString();
	}
	
	public static String getMilliSecondToSSS(Date date) {
		return new SimpleDateFormat("SSS").format(date).toString();
	}
	
	public static String getDateToYYYYMMDD(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date).toString();
	}
	
	public static String getDateToYYYYMM(Date date) {
		return new SimpleDateFormat("yyyyMM").format(date).toString();
	}
	
	public static String getTimeTo24HHmmss(Date date) {
		return new SimpleDateFormat("HHmmss").format(date).toString();
	}
	
	/* 특정한 포멧으로 현재 시간을 출력하고자 할 때.
	 * 상세 참고 : https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
	 * KK : 12시간 AM/PM(00-11)
	 * HH : 24시간(00-23)
	 * hh : 12시간 AM/PM(01-12)
	 * kk : 24시간(01-24)
	 * mm : 분
	 * ss : 초
	 * SSS : 밀리초
	 * aa : AM/PM
	 */
	public static String getNowTime(String format) {
		return new SimpleDateFormat(format).format(new Date()).toString();
	}
	
	//24시간으로 HHMMSS형태의 날짜형식 반환.
	public static String getNowTime24HHMMSS() {
		return new SimpleDateFormat("HHmmss").format(new Date()).toString();
	}
	
	//12시간으로 HHMMSSAM/PM 형식의 날짜 반환.
	public static String getNowTime12HHMMSSAmPm() {
		return new SimpleDateFormat("hhmmssaa").format(new Date()).toString();
	}
	
	public static Date getNowTime() {
		return new Date();
	}
	
}
