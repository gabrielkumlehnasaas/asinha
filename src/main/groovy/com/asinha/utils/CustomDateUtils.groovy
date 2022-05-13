package com.asinha.utils

import java.sql.Timestamp;
import java.text.SimpleDateFormat

class CustomDateUtils {

    public static Date toDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern)
        return format.parse(date)
    }

    public static String formatTimestamp(Timestamp date) {
        if (date == null) {
            return "Aguardando"
        } else {
            String[] reverseDate = date.toString().split(" ")[0].split("-") 
            return reverseDate[2]+"/"+reverseDate[1]+"/"+reverseDate[0] 
        }
    }
}
