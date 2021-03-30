package com.learn.system;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author windyStreet
 * @codetime 2021-03-30 10:14
 */
public class BigIntegerAndBigDecimal {
    @Test
    public void test1(){
        BigInteger bi = new BigInteger("1646121654842");
        System.out.println(bi.abs());
    }
}
