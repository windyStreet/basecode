package com.learn.jdk9;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author windyStreet
 * @codetime 2021-04-21 14:52
 */
public class JdkTest4_OptionalStream {
    /**
     * Optional 添加Stream() 方法
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jerry");
        list.add("mary ");

        Optional<ArrayList<String>> optional = Optional.ofNullable(list);
        Stream<ArrayList<String>> stream = optional.stream();
        stream.flatMap(x->x.stream()).forEach(System.out::println);
        //stream.flatMap(Collection::stream).forEach(System.out::println);
    }
}
