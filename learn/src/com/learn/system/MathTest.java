package com.learn.system;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author windyStreet
 * @codetime 2021-03-30 10:06
 */
public class MathTest {
    @Test
    public void test(){

        System.out.println(Math.abs(-20));
        System.out.println(Math.asin(0.369)); //asin acos atan cos sin tan
        System.out.println(Math.sqrt(16.00));
        System.out.println(Math.pow(2.0, 3.5));
        System.out.println(Math.log(36.00));
        System.out.println(Math.exp(16));
        System.out.println(Math.max(16, 20.3));
        System.out.println(Math.min(16, 20.3));
        System.out.println(Math.random());//返回0.0-1.0 的随机数
        System.out.println(Math.round(2.3614)); // long 型数据转换为long型(四舍五入)
//        Math.toDegrees() 弧度 --》 角度
//        Math.toRadians() 角度 --》弧度
    }

}
