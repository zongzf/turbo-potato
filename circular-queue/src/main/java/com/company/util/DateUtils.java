package com.company.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static final String DEFULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String now(){
        LocalDateTime time = LocalDateTime.now();
        return time.format(DateTimeFormatter.ofPattern(DEFULT_PATTERN));
    }

    public static String plusSeconds(int seconds){
        LocalDateTime time = LocalDateTime.now();
        time.plusSeconds(seconds);
        return time.format(DateTimeFormatter.ofPattern(DEFULT_PATTERN));
    }
}
