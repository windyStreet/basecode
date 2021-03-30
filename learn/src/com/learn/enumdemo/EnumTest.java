package com.learn.enumdemo;


/**
 * @author windyStreet
 * @codetime 2021-03-30 14:37
 */

import org.junit.Test;


public class EnumTest {

    @Test
    public void test() {
        System.out.println(Season.AUTUMN.toString());
    }

    @Test
    public void test1() {
        System.out.println(Season1.SPRING.toString());
        Season1[] values = Season1.values();
        for (Season1 s : values) {
            System.out.println(s.toString());
        }

        System.out.println(Season1.valueOf(Season1.SUMMER.name()).toString());
        System.out.println(Season1.WINTER.name());
        Season1.WINTER.show();

    }
}
