package com.learn.jdk8;

/**
 * @author windyStreet
 * @codetime 2021-04-14 16:22
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java 内置的4大核心函数式接口
 * 消费型 Consumer<T> void accept(T t)
 * 供给型 Supplier<T> T get()
 * 函数型 Function<T,R> R apply(T t)
 * 断定型 Predicate<T> boolean test(T t)
 */
public class CoreLambdaTest {
    @Test
    public void test() {
        happyTime(500.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("happy time 花费了" + aDouble);
            }
        });
        System.out.println("**********************");
        happyTime(400.0, money -> System.out.println("二次 happy time 花费了" + money));
    }

    public void happyTime(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("上海", "北京", "南京", "西京", "东京", "深圳");
        ArrayList<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStr);
        System.out.println("*********************");

        ArrayList<String> filterStr1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStr1);
    }

    // 根据给定的规则，过滤集合中的字符串。规则由 Predicate 的方法决定
    public ArrayList<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
