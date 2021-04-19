package com.learn.jdk8.streamapi;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author windyStreet
 * @codetime 2021-04-19 11:16
 */
public class StreamApiTest1 {
    //1、筛选与切片
    @Test
    public void test() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // filter(Predicate p) 接收一个Lambda ,从流中排除某些元素
        // 查询薪资大于5000的
        stream.filter(e -> e.getSalary() > 5000).forEach(System.out::println);
        System.out.println();
        // limit() 截断流，使其中元素不超过给定值
        // stream.limit(3); //java.lang.IllegalStateException: stream has already been operated upon or closed
        // 流使用完成就消失了，终止当前对象，无法进行二次操作
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // skip(n) 跳过元素
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println();


        // distinct() 通过流生成元素的hashCode 和 equals() 去除重复元素
        employees.add(new Employee(10032, "小天", 36, 3690));
        employees.add(new Employee(10032, "小天", 36, 3690));
        employees.add(new Employee(10032, "小天", 36, 3690));
        employees.stream().distinct().forEach(System.out::println);

    }

    @Test
    public void test1() {
        /**
         *map(Function f) 接收一个函数作为参数，将元素转换为其他形式或提取信息，该函数会被
         * 应用到每一个元素上，并将其映射成一个新的元素
         *
         */
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        list.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);

        System.out.println();
        // 练习
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(e -> e.getName()).forEach(System.out::println);
        System.out.println();
        employees.stream().map(Employee::getName).forEach(System.out::println);
        employees.stream().map(Employee::getName).filter(name -> name.contains("小")).forEach(System.out::println);
        System.out.println();

        // flatMap(function f) 接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有的
        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiTest1::fromString2Stream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("******************");
        Stream<Character> characterStream = list.stream().flatMap(StreamApiTest1::fromString2Stream);
        characterStream.forEach(System.out::println);
    }

    // 将字符串中的多个字符构建的结合转换为对应的Stream的实例
    public static Stream<Character> fromString2Stream(String str) {
        if (str == null)
            return null;
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    // 排序
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(25, 36, 14, 23, 1, 26, 3, 7, 95);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();

        List<Employee> employees = EmployeeData.getEmployees();
        // Employee 没有默认排序，报异常
        //employees.stream().sorted().forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> {
            int n =  Double.compare(e1.getSalary(), e2.getSalary());
            if (n ==0){
                return  Integer.compare(e1.getAge(),e2.getAge());
            }
            return n;
        }).forEach(System.out::println);
        System.out.println();
        employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).forEach(System.out::println);
        System.out.println();
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
    }
}
