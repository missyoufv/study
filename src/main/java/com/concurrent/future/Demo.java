package com.concurrent.future;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    private static String param = "123";

    static{
        System.out.println(Demo.param);
    }

    public static void main(String[] args) throws Exception{
        Demo demo = new Demo();

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");//19 0222 1830 20 348  yyyy MMdd hhmmss SSS
        String data = sdf.format(new Date());
        System.out.println(data);

        String str = "1211";
        Date parse = sdf.parse(str);
        System.out.println(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(parse));
        System.out.println(getRandomNum());
    }


    public static int getRandomNum(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String date = sdf.format(new Date());
        System.out.println(date);
        System.out.println(date.substring(4,8));
        System.out.println(date.substring(12));
        sb.append("1").append(date.substring(4,8)).append(date.substring(12));
        //生成5位随机数
        return Integer.valueOf(sb.toString());
    }
}
