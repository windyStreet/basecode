package com.learn.generic;

/**
 * @author windyStreet
 * @codetime 2021-04-07 14:35
 */

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1、jdk5 新特性
 * 2、在集合中使用泛型
 * 总结
 * A、集合接口或结合类在jdk5.0时都修改为带泛型的结构
 * B、在实例化集合类时，可以致命具体的泛型类型
 * C、指明完以后，在集合类或接口中凡是定义类或接口时，内部及结构（方法、构造器、属性）
 * 比如：add(E e) --> 实例化以后  add（Integer e）
 * D、注意点|泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，拿到包装类替换
 * E、如果实例化时，没有指明泛型的类型，默认为java.lang.Object 类型
 *
 * 3、如何自定泛型结构：泛型类、泛型接口；泛型方法
 *
 * 使用场景：
 * 在类、接口或者方法中，
 * 代码中可扩展和推断出多种类型情况，
 * 在功能一致，类型不确定的情况下，
 * 考虑使用泛型进行规避重复编码
 *
 */
public class GenericTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(56);
        list.add(56);
        list.add(89);
        list.add(76);
        list.add(95);
        // 问题一、类型不安全
        list.add("36");
        list.add("gogo");

        for (Object score : list) {
            // 问题二、强转是 可能出现ClassCastException
            int _i_score = (int) score;
            System.out.println(_i_score);
        }

    }

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(56);
        list.add(56);
        list.add(89);
        list.add(76);
        list.add(95);
        // 问题一、类型不安全
//        list.add("36"); // 编译阶段不通过
//        list.add("gogo");// 编译阶段不通过

        for (Integer score : list) {
            // 问题二、强转是 可能出现ClassCastException
            System.out.println(score);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"jerry");
        map.put(2,"tome");
        map.put(3,"jack");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();


    }
}
