package com.zaqacu.test;

import com.zaqacu.util.TimeUtls;
import org.junit.Test;

import java.util.Date;

public class TimeTest {
    @Test
    public void getFirstDayTest(){
        String s= TimeUtls.getTimeFommat(new Date());
        Date firstDay = GetFirstAndLastDay.getFirstDay(s);
        System.out.println(firstDay);
    }

}
