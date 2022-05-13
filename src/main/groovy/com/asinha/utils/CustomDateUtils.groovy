package com.asinha.utils

import java.text.SimpleDateFormat

class CustomDateUtils {

    public static Date toDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern)
        return format.parse(date)
    }
}
