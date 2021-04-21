package com.learn.jdk9;

import java.util.*;

/**
 * @author windyStreet
 * @codetime 2021-04-21 11:14
 */
public class Jdk9Test1_ReadSet {
    /**
     * 集合工厂方法：创建只读集合
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jerry");
        list.add("bob");
        // 创建一个只读集合
        List<String> readOnlyList = Collections.unmodifiableList(list);
        // readOnlyList.add("TT"); //java.lang.UnsupportedOperationException
        System.out.println("----------------");


        List<String> list1 = Collections.unmodifiableList(Arrays.asList("a", "d", "fg", "g", "s", "a"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("tt", "ee", "www", "qqq", "qq", "w", "dd")));
        Map<Object, Object> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("----------------");


        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        //list2.add(7); //java.lang.UnsupportedOperationException

        System.out.println("-------------------jdk9------------------");
        /**
         * of 方法
         * 以下生成的对象均为只读
         */

        List<Integer> list3 = List.of(1, 2, 3, 6, 4, 58);
        //list3.add(12);//java.lang.UnsupportedOperationException
        Map.of("A", 1, "B", 1, "C", 1, "D", 1, "E", 1, "F", 1, "G", 1);
        Map.of("aa", Map.of("tt", "11"), "bb", Map.of("yy", "22"));
        Map<String, Object> stringObjectMap = Map.ofEntries(Map.entry("aa", Map.entry("tt", "11")), Map.entry("cc", "cc"));
    }
}
