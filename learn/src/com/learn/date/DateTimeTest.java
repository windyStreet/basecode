package com.learn.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author windyStreet
 * @codetime 2021-03-27 14:17
 * SimpleDateFormat
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
    public void test1() {
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

        java.sql.Date d = new java.sql.Date(1616826487870L);
        System.out.println(d.toString());
        System.out.println(d.toLocalDate().toString());

        Date da = new Date();
        java.sql.Date jsd = new java.sql.Date(da.getTime());
        System.out.println(jsd.toString());

    }

    @Test
    public void test2() {
        /**
         * SimpleDateFormat 对琪琪Date类的格式化和解析
         * 格式化 日期 --》 字符串
         * 解析 字符串 --》 日期
         */

        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);


        // 解析
        // String str = "2021-03-29";
        String str = "21-3-29 下午2:51";
        Date data1 = null;
        try {
            data1 = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(data1);

        String str2 = "2021-03-29 00:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date2 = simpleDateFormat.parse(str2);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calendar 日历类（抽象类）的使用
     * 1、GregorianCalendar 对象
     * 2、getInstance() 获取对象
     */
    @Test
    public void test3() {

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());//class java.util.GregorianCalendar
        // get
        // set
        // geTime
        // setTime

        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.MONTH));
        instance.set(Calendar.DAY_OF_MONTH, 36);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.MONTH));
        instance.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.MONTH));

        Date  date = instance.getTime();
        System.out.println(date);

        Date date1 = new Date();
        instance.setTime(date1);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.MONTH));


    }
}
