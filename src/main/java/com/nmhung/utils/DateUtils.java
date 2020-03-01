package com.nmhung.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Timestamp getMonDayNow() {
        return getMonDay(getDateNow());
    }
    public static String[] getArrayDate(Date date) {
    	String[] rs = new String[9];
    	Date monDate = getMonDay(date);
    	rs[0] = DateUtils.format(dateAdd(monDate, -7));
    	rs[1] = DateUtils.format(dateAdd(monDate, +7));
    	for(int i = 2; i <= 8; ++i) {
    		Date tmp = dateAdd(monDate, i - 2);
    		rs[i] = DateUtils.format(tmp);
    	}
    	return rs;
    }

    public static Timestamp getSunDayNow() {
        return getSunDay(getDateNow());
    }

    public static Timestamp getDateNow() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        try {
            date = dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
        }
        calendar.setTime(date);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static String getDateNowToString() {
        return dateFormat.format(getDateNow());
    }

    public static Timestamp getMonDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.DAY_OF_MONTH) != calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, (2 - calendar.get(Calendar.DAY_OF_WEEK)));
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, -6);
        }

        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getSunDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getMonDay(date));
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static int dayOfWeek(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int rs = calendar.get(Calendar.DAY_OF_WEEK);
        return rs == 1? 8 : rs;
    }

    public static int dayOfWeek(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String format(Timestamp timestamp) {
        String s = dateFormat.format(timestamp);
        return s;
    }
    public static Date parse(String str){
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            return getDateNow();
        }
    }

    public static String format(Date date) {
        String s = dateFormat.format(date);
        return s;
    }

    public static Timestamp timestampAdd(Timestamp timestamp, int x) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_MONTH, x);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp dateAdd(Date date, int x) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, x);
        return new Timestamp(calendar.getTimeInMillis());
    }


    public static boolean isDayOfWeek(Date date, int x) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar.get(calendar.DAY_OF_WEEK) == x;
    }

    public static int weekCompareTo(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDate = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date());
        int weekNow = calendar.get(Calendar.WEEK_OF_YEAR);
        return Integer.compare(weekDate, weekNow);


    }

    public static int weekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
