package com.asinha.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat

class CustomDateUtils {

    public static Date toDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern)
        return format.parse(date)
    }

    public static String formatTimestamp(Timestamp date) {
        String[] reverseDate = date.toString().split(" ")[0].split("-") 
        return reverseDate[2] + "/" + reverseDate[1] + "/" + reverseDate[0] 
    }

    public static Date sumMinutes(minutes) {
        Calendar calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, minutes)
        return calendar.getTime()
    }

    public static Date sumDays(Date date, Integer numberDays) {
        Calendar calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, numberDays)
        return calendar.getTime().clearTime()
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(date)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.getTime()
    }
    
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern)
        return format.format(date).toString()
    }
}
