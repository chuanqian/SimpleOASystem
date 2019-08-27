package com.zaqacu.util;

import java.util.UUID;

public class UUIDUtils {
    public static String getOneUUId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
