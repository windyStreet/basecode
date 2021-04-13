package com.learn.reflect.t1;

import java.io.Serializable;

/**
 * @author windyStreet
 * @codetime 2021-04-12 15:28
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("呼吸中...");
    }

    public void eat() {
        System.out.println("进食中....");
    }
}
