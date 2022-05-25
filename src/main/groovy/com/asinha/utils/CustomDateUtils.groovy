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

    public static Date getMinutesBefore(minutes) {
        Calendar now = Calendar.getInstance()
        now.add(Calendar.MINUTE, -minutes)
        return now.getTime()
    }

    public static Calendar clearTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar
    }

    public static Date getYesterday() {
        Calendar yesterday = Calendar.getInstance()
        yesterday.add(Calendar.DAY_OF_MONTH, -1)
        yesterday = clearTime(yesterday)
        return yesterday.getTime()
    }
    
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern)
        return format.format(date).toString()
    }
}
