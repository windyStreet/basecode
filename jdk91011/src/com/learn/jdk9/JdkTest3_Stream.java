package com.learn.jdk9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author windyStreet
 * @codetime 2021-04-21 14:23
 */
public class JdkTest3_Stream {
    /**
     * 增强的Stream
     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(36, 15, 36, 98, 45, 1, 25, 3, 78, 69, 31, 56);
        // takeWhile 返回从开头开始的按指定规则尽量多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        System.out.println("------------------------");
        //dropWhile  与takeWhile 相反 [找到一个元素接口停止，返回当前元素和后续元素]
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
        System.out.println("------------------------");

        Stream<Integer> integerStream = Stream.of(1, 2, 6, 7, null, 9);
        integerStream.forEach(System.out::println);
        System.out.println("*************");
        Stream<Integer> integerStream1 = Stream.of(1, 2, 6, 7, null, 9);
        System.out.println(integerStream1.count());
        System.out.println("------------------------");
        // 仅存一个null 对象是不允许的
        // Stream<Object> objectStream = Stream.of(null);
        // objectStream.forEach(System.out::println); //java.lang.IllegalStateException

        Stream<String> stream_str = Stream.ofNullable("A");
        System.out.println(stream_str.count());
        System.out.println("------------------------");
        Stream<Object> objectStream = Stream.ofNullable(null);
        System.out.println(objectStream.count());


        System.out.println("迭代方式");
        /**
         * jdk8
         */

        // 无限流 不会终止
//        Stream.iterate(0, x -> x + 1).forEach(System.out::println);
        // 添加limit 终止操作
        Stream.iterate(0, x -> x + 1).limit(20).forEach(System.out::println);

        /**
         * jdk9
         */

        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);

    }
}
