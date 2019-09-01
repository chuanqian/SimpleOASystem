package com.zaqacu.util;

import java.util.Calendar;
import java.util.Date;

public class GetFristAndLastDaUtils {

    //获取当月第一天
    public static Date getFirstDay(String date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(TimeUtls.getTimeParse(date));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }
    //获取当月第二天
    public static Date getLiatDay(Date date){
        return null;
    }
}
