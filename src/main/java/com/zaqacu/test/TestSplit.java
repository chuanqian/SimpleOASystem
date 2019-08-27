package com.zaqacu.test;

public class TestSplit {
    public static void main(String[] args) {
        String string="1,2,3,";
        String[] strings=string.split(",");
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println(strings.length);
    }

}
