package com.zaqacu.test;

import java.util.UUID;

public class GetUUID {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            String string= UUID.randomUUID().toString().replaceAll("-","");
            System.out.println(string.length());
            System.out.println(string);
        }
    }
}
