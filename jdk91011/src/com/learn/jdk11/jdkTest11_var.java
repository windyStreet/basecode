package com.learn.jdk11;

import java.util.function.Consumer;

/**
 * @author windyStreet
 * @codetime 2021-04-21 17:14
 */
public class jdkTest11_var {
    /**
     * var 上添加注解
     */

    public static void main(String[] args) {
        // 错误的 jdk 语法错误
        //Consumer<String> con1  = (@Deprecated  t) -> System.out.println(t.toUpperCase());
        // jdk 11 实现
        Consumer<String> con1 = (@Deprecated var t) -> System.out.println(t.toUpperCase());

    }
}
