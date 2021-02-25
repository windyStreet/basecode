package com.base;

import java.util.HashMap;

public class HashMapCode {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        int n = 1000;
        n |= n >>> 4;
        System.out.println(n);
    }
}
