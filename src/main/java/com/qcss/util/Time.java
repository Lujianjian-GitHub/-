package com.qcss.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        System.out.println(timeToLong("2021-06-08 00:00:00"));
    }
    public static String toString(Date date){

        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy年MM月dd日kk:mm:ss");
        String now = sdFormatter.format(date);
        return now;
    }
    public static String toString(Long l){
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy年MM月dd日kk:mm:ss");
        String now = sdFormatter.format(l);
        return now;
    }
    public static String toString(Object l){
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy年MM月dd日kk:mm:ss");
        String now = sdFormatter.format(l);
        return now;
    }

    //将2021-06-08 00:00:00转化为long时间戳
    public static Long timeToLong(String str){
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(str);
//            System.out.println(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
