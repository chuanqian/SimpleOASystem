package com.zaqacu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式工具类
 */
public class TimeUtls {
    /**
     * 时间转换成String
     * @param time
     * @return
     */
    public static String getTimeFommat(Date time){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(time!=null){
            return sdf.format(time);
        }
        return null;
    }

    /**
     * String转换成时间
     * @param time
     * @return
     */
    public static Date getTimeParse(String time){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (time != null) {
                return sdf.parse(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
