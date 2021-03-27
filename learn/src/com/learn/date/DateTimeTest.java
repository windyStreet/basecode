package com.learn.date;

import org.junit.Test;

import java.util.Date;

/**
 * @author windyStreet
 * @codetime 2021-03-27 14:17
 * jdk 8 之前
 */
public class DateTimeTest {

    @Test
    public void test() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970-1-1 00:00:00 之间的时间差，单位毫秒
        //时间戳
        System.out.println(time);
    }

    @Test
    public void test1(){
        /** java.util.Date
         *  --java.sql.Date
         *  1、两个构造器
         *  2、两个使用方法
         *  3、java.sql.Date 数据库中日期类型
         *  4、java.util.Date 转 java.sql.Date
         */

        Date date1 = new Date(); // 创建一个当前时间的Date对象
        System.out.println(date1.toString());
        System.out.println(date1.getTime()); // 时间戳

        Date date = new Date(1616826487870L);
        System.out.println(date.toString());

        java.sql.Date d  = new java.sql.Date(1616826487870L);
        System.out.println(d.toString());
        System.out.println(d.toLocalDate().toString());

        Date da = new Date();
        java.sql.Date jsd = new java.sql.Date(da.getTime());
        System.out.println(jsd.toString());

    }
}
