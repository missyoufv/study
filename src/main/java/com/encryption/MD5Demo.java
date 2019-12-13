package com.encryption;

import java.security.MessageDigest;

/**
 * @author: duw
 * @Date: 2019/9/24 17:42
 * @Description: md5 算法
 */
public class MD5Demo {

    public static String getMd5(byte [] data){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("MD5");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        md.update(data);
        byte s[] = md.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
        }
        return result;

    }
    public static void main(String[] args) throws Exception {

        String message = "hello";
        System.out.println(getMd5(message.getBytes()));
    }
}
