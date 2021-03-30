package com.learn.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author windyStreet
 * @codetime 2021-03-29 15:20
 */
public class Jdk8DateTimeTest {
    /**
     * joda-Time 包
     * LocalTime
     * LocalDate
     * LocalDateTime
     */
    @Test
    public void main() {
        LocalDate nowD = LocalDate.now();
        LocalTime nowT = LocalTime.now();
        LocalDateTime nowDT = LocalDateTime.now();

        System.out.println(nowD);
        System.out.println(nowT);
        System.out.println(nowDT);

        // of(): 设置指定的年、月、日、时、分、秒 。没有偏移量
        LocalDateTime localDateTime = LocalDateTime.of(2021, 03, 12, 15, 12, 3);
        System.out.println(localDateTime);

        System.out.println("---------------");
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());

        System.out.println("&&&&&&&&&&&&&&&");
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        System.out.println("^^^^^^^^^^^^^^^");
        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDateTime localDateTime3 = localDateTime2.withDayOfMonth(10);
        LocalDateTime localDateTime4 = localDateTime2.plusDays(10);
        LocalDateTime localDateTime5 = localDateTime2.minusDays(10);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);


    }

    /**
     * Instant 使用
     */
    @Test
    public void test() {

        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        long l = now.toEpochMilli();// 获取瞬时对象的毫秒数
        System.out.println(l);
        Instant instant = Instant.ofEpochMilli(1617006744721L);// 根据毫秒数获取Instant 对象
        System.out.println(instant);

    }

    /**
     * DateTimeFormatter : 格式化或解析日期、时间 类似于SimpleDateFormat
     */
    @Test
    public void test1() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(now);
        System.out.println(format);

        //解析
        TemporalAccessor parseTime = formatter.parse("2021-03-29T16:36:54.976");
        System.out.println(parseTime);
        // 方式二
        System.out.println("*****************");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str1 = formatter1.format(localDateTime);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format2 = formatter2.format(localDateTime);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format3 = formatter3.format(localDateTime);
        System.out.println(str1);
        System.out.println(format2);
        System.out.println(format3);
        // 解析
        
//        方式三 自定义
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format1 = formatter4.format(localDateTime);
        System.out.println(format1);
        TemporalAccessor parse = formatter4.parse("2021-03-29 05:16:11");
        System.out.println(parse);

    }
}
