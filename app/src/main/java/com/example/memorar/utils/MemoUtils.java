package com.example.memorar.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoUtils {
    public static String dateFromLong(long time){
        DateFormat format=new SimpleDateFormat("EEE, aaa-MM-dd 'at' hh:mm aaa", Locale.ITALIAN);
        return format.format(new Date(time));

    }
}
