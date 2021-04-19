package com.learn.jdk8.streamapi;

/**
 * @author windyStreet
 * @codetime 2021-04-16 18:08
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 关注的是对数据的运算，与cpu打交道
 *          集合关注的是数据的存储，与内存打交道
 * 1、Stream 自己不会存储元素
 * 2、Stream 不会改变源对象，相反，会返回一个持有结果的新Stream
 * 3、Stream 操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 * Stream 执行流程
 * A、Stram 的实例化
 * B、一系类中的操作（过滤、映射...）
 * C、终止操作
 * 说明：
 * 一个中间操作链，岁数据源的数据进行处理
 * 一旦执行终止操作，就执行中间操作链，并产生记过，之后，不会再被使用
 */
public class StreamApiTest {

    // 创建Stream 方式一：通过集合
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream(); //获取一个顺序流
        Stream<Employee> employeeStream = employees.parallelStream();//获取一个并行流
    }
    // 创建Stream 方式二：通过数组
    @Test
    public void test1(){
        int[] ints = {1, 26, 58, 14, 14, 136, 3};
        IntStream stream = Arrays.stream(ints);// 返回一个流

        Employee e1 = new Employee(10010, "联通");
        Employee e2 = new Employee(10086, "移动");
        Employee[] employees = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);

    }

    // 创建Stream 方式三：通过Stream 的of()
    @Test
    public void test2(){

        Stream<Integer> integerStream = Stream.of(20, 15, 25, 17, 369, 54, 74);
    }

    // 创建Stream 方式三：创建无限流

    @Test
    public void test3(){
        //迭代
        //public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
        // 遍历前10个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        // 生成
        //public static<T> Stream<T> generate(Supplier<? extends T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
