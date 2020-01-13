package com.amaris.automation.model.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	public static final String DATE_FORMAT = "dd/MM/yyy";
	public static final String HOUR_FORMAT = "HH:mm:ss";

	public static Date getTodayDate() {
		return new Date();
	}

	public static String getDayOfWeek() {
		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US);
	}

	public static String getTodayDate(String dateFormat) {
		return dateToString(new Date(), dateFormat);
	}

	public static Date getModifiedDate(int tipeOfAddition, int quantity) {
		return modifyTime(new Date(), tipeOfAddition, quantity);
	}

	public static String getModifiedDate(int tipeOfAddition, int quantity, String dateFormat) {
		return dateToString(getModifiedDate(tipeOfAddition, quantity), dateFormat);
	}

	public static Date modifyTime(Date date, int tipeOfAddition, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(tipeOfAddition, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifyDays(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifyMonths(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.MONTH, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifyYears(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.YEAR, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifyHours(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.HOUR, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifyMinutes(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.MINUTE, quantity);
		date = c.getTime();

		return date;
	}

	public static Date modifySeconds(Date date, int quantity) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.SECOND, quantity);
		date = c.getTime();

		return date;
	}
	
	public static String dateToString(Date date) {
		return dateToString(date, DateUtils.DATE_FORMAT);
	}

	public static String dateToString(Date date, String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(date);
	}

	private DateUtils() {}
}