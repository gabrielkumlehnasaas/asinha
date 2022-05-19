package com.asinha.utils

import java.sql.Timestamp;
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

    public static Date getToday() {
       Calendar today = getInstanceOfCalendar(new Date())
       return today.getTime().clearTime()
    }

    public static Date getYesterday() {
       Calendar yesterday = getInstanceOfCalendar(new Date())
       yesterday.add(Calendar.DAY_OF_MONTH, -1)
       return yesterday.getTime().clearTime()
    }
}
