package com.learn.jdk11;

import java.util.Optional;

/**
 * @author windyStreet
 * @codetime 2021-04-21 16:59
 */
public class JdkTest11_optional {
    public static void main(String[] args) {
        /**
         * Optional 新增的方法
         */

        Optional<Object> op = Optional.empty();

        // 互为相反 内部的value存在
        System.out.println(op.isPresent());
        System.out.println(op.isEmpty());

        // 内部value不存在的情况下，返回一个异常
//        var o = op.orElseThrow();
//        System.out.println(o);

        System.out.println("*******************");
        Optional<String> op1 = Optional.of("abc");
        var o1 = op1.orElseThrow();
        System.out.println(o1);


        System.out.println("*******************");

        // or 返回的是容器的选择 orElse 返回的容器值的选择
        //Optional<String> optional_1 = Optional.of("hello"); //Optional[hello]
        //Optional<String> optional_1 = Optional.ofNullable(null); //Optional[world]
        Optional<String> optional_1 = Optional.empty(); //Optional[world]
        Optional<String> optional_2 = Optional.of("world");
        Optional<String> optional_3 = optional_1.or(() -> optional_2);
        System.out.println(optional_3);


    }
}
