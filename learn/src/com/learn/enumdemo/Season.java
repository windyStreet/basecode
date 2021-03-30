package com.learn.enumdemo;

/**
 * @author windyStreet
 * @codetime 2021-03-30 15:03
 *
 * 枚举类的理解
 * 1、 类的对象只有有限个，确定的
 * 2、当需要定义一组常量时，强烈建议使用枚举类
 * 3、若枚举类对象只有一个，则可以作为单例模式的实现方式
 * jdk5.0 之前，自定义枚举类
 * 5.0之后，则可以使用enum关键字定义枚举类
 */

class Season {
    // 申明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("spring", "春暖花开");
    public static final Season SUMMER = new Season("summer", "夏日炎炎");
    public static final Season AUTUMN = new Season("autumn", "秋高气爽");
    public static final Season WINTER = new Season("winter", "冰天雪地");

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}