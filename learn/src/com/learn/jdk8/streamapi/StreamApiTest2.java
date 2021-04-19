package com.learn.jdk8.streamapi;

/**
 * @author windyStreet
 * @codetime 2021-04-19 14:13
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream 终止操作
 */
public class StreamApiTest2 {
    // 1、匹配与查找
    // allMath(Predicate p) 检查是否匹配所有元素。
    // anyMath(Predicate p) 检查是否至少有一个匹配元素
    // noneMath(Predicate p) 检查是否没有匹配的元素
    // findFirst 返回第一个元素
    // findAny 返回任意一个元素
    // count 返回流中元素的总个数
    // max(Comparator c) min(Comparator c) 返回流中对最大、最小值
    // forEach(Consumer c)内衬布迭代

    @Test
    public void test() {

        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        System.out.println();

        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 50000);
        System.out.println(anyMatch);
        System.out.println();

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("天"));
        System.out.println(noneMatch);
        System.out.println();

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        System.out.println("****************");
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        Optional<Employee> any1 = employees.parallelStream().findAny();
        System.out.println(any1);

        System.out.println("****************");
        long count = employees.stream().filter(e -> e.getSalary() > 30000).count();
        System.out.println(count);
        System.out.println("****************");
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max);

        System.out.println("****************");
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getAge));
        Optional<Employee> min2 = employees.stream().min((e1, e2) -> Double.compare(e1.getAge(), e2.getAge()));
        System.out.println(min);
        System.out.println(min2);
        System.out.println("****************");
        employees.stream().forEach(System.out::println);
    }


    // 归约
    @Test
    public void test1(){
        //reduce(T identity,BinaryOperator) -
        // 可以将流中元素反复结合其起来得到一个值。返回
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        // reduce(BinaryOperator)
        // 可以将流中元素反复结合起来，得到一个值，返回 Optional<T t>
        List<Employee> employees = EmployeeData.getEmployees();
        Double sum1 = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println(sum1);
    }

    //收集
    @Test
    public void test2(){
        // collect(Collector c)  将流转换为其他形式，接收一个Collector 接口的实现，用于给Stream

        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        list.forEach(System.out::println);
        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
