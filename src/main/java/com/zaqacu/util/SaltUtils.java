package com.zaqacu.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class SaltUtils {
    public static String getSaltPassword(String userPassword,String saltValue){
        Object salt = new Md5Hash(saltValue);
        String result = new SimpleHash("MD5", userPassword, salt, 1024).toString();
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getSaltPassword("fengguiping","chuanchuan"));
    }
}
