package com.learn.jdk10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windyStreet
 * @codetime 2021-04-21 16:40
 */
public class JdkTest10_copyOf {
    public static void main(String[] args) {

        /**
         * 集合中新增一个copyOf()
         */

        List<Integer> list = List.of(10, 10, 23, 58, 69, 26);
        List<Integer> list1 = List.copyOf(list);
        System.out.println(list == list1);  // true

        ArrayList<String> list_str = new ArrayList<>();
        list_str.add("xxx");
        List<String> list_str_1 = List.copyOf(list_str);
        System.out.println(list_str == list_str_1); // false
        // 因为这个集合是只读的
//        list_str_1.add("ttt");  // 异常 java.lang.UnsupportedOperationException

        System.out.println(list_str_1);

        // 如果集合本身是只读的，返回的就是集合本省
        // 如果结合不是一个只读的，则返回一个新的只读集合


    }
}
