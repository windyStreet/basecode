package com.learn.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author windyStreet
 * @codetime 2021-04-14 15:03
 */

/**
 * Lambda 表达式的使用
 * （o1,o2） -> Integer.compare(o1,o2);
 * 格式：
 * ->: lambda 操作符 或 箭头操作符
 * ->左边 lambda 形参列表（就是借口中的抽象方法的形参列表）
 * ->右边 lambda体（就是重新的抽象方法的方法体）
 * Lambda的表达式的使用：（6种）
 * 总结：
 * 左边：lambda 形参列表 参数类型可以省略
 *      1、只有一个参数数时，小括号可以省略
 * 右边：lambda 体应该使用{} 包裹
 *      1、如果lambda 体只有一条执行语句，可以省略{} 和  return；
 * Lambda 表达式的本质：作为函数式接口的一个实例【接口的具体实现】
 *      要求：接口之能有一个抽象方法
 * @FunctionalInterface 可以检验是否是一个函数式接口
 * 函数式接口：如果一个接口中，只声明了一个抽象方法
 * 应用场景:匿名实现类表示的都可以用Lambda表达式来写
 * java.util.function 包下定义的函数式接口
 */

public class LambdaTest {
    @Test
    public void test() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("北京在哪里？");
            }
        };

        runnable.run();
        System.out.println("*********************");

        // 方式一、无参数、无返回值
        Runnable r2 = () -> System.out.println("武汉在哪里?");
        r2.run();
    }


    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        // Lambda 表达式的写法
        System.out.println("***********************");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(31, 36);
        System.out.println(compare2);

        // 方法应用
        System.out.println("***********************");
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(31, 36);
        System.out.println(compare3);
    }

    @Test
    public void test3() {

        // Lambda 需要一个参数，但是没有返回值

        IConsumer<String> iConsumer = new IConsumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println("收货:" + str);
            }

            public void send(String str) {

            }
        };
        iConsumer.accept("一打衣服");

        System.out.println("*************************");
        IConsumer<String> ic = (String s) -> {
            System.out.println("书本上说:" + s);
        };
        ic.accept("爱是一种美德");


    }

    // 语法格式三:数据类型可以省略，应为可由编译器推断得出，成为类型推断

    @Test
    public void test4() {
        System.out.println("*************************");
        IConsumer<String> ic = (String s) -> {
            System.out.println("书本上说:" + s);
        };
        ic.accept("爱是一种美德");
        System.out.println("*************************");
        IConsumer<String> ic1 = (s) -> {
            System.out.println("书本上说:" + s);
        };
        ic1.accept("爱是一种美德,也是一种包容");
    }

    @Test
    public void test5() {
        ArrayList<String> list = new ArrayList<>(); //<> 中的String 省略，为类型推断
        int[] arr = {1, 3, 3};//推断出类型为int，因为只能放int
    }

    // 语法格式四： 若值需要一个参数时，参数的小括号可以省略
    @Test
    public void test6() {
        System.out.println("*************************");
        IConsumer<String> ic1 = (s) -> {
            System.out.println("书本上说:" + s);
        };
        ic1.accept("爱是一种美德,也是一种包容");
        System.out.println("*************************");
        IConsumer<String> ic2 = s -> {
            System.out.println("书本上说:" + s);
        };
        ic2.accept("没有买卖，就没有杀害");

    }

    // 语法格式五: Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test7() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        com1.compare(12, 23);
        System.out.println("*************************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        com2.compare(12, 23);

    }

    // 语法格式六: Lambda 体只有一条返回去语句时，return 与大括号若有，都可以省略
    @Test
    public void test8() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(36, 23));
        System.out.println("*************************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(38, 23));

    }



}

interface IConsumer<String> {
    public void accept(String str);
//     public void send(String str);
}

