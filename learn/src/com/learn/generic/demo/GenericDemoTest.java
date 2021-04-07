package com.learn.generic.demo;

/**
 * @author windyStreet
 * @codetime 2021-04-07 16:57
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、泛型在继承方面的体现
 * 2、通配符的使用
 */
public class GenericDemoTest {

    /**
     * 泛型在继承方面的体现
     * 虽然类A是类B的父类，G<A> 和 G<B> ,但是二者不具备子父类关系，二者属于并列关系
     * 补充： 类A 是 类B 的父类，A<G> 是 B<G>的父类
     */

    @Test
    public void test() {
        Object obj = null;
        String str = null;
        obj = str;
//        str = (String) obj;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时的list1 和 list2的类型不具有父子关系
//        list1 = list2; // 编译不通过
//        list2 = list1;// 编译不通过
    }

    @Test
    public void test1() {

        List<String> list1 = null;
        ArrayList<String> list2 = null;
        ArrayList<Object> list3 = null;
        List<Object> list4 = null;
        list1 = list2;
//        list1 = list3; // 编译不通过
//        list1 = list4; // 编译不通过
    }

    /**
     * 通配符的使用
     * 通配符 ？
     * <p>
     * 类A 是类B 的父类，G<A> 和 G<B>是没有关系的，二者共同的父类是:G<?>
     */
    @Test
    public void test2() {
        List<String> list_str = new ArrayList<>();
        list_str.add("12");
        list_str.add("123");
        list_str.add("125");
        list_str.add("126");
        list_str.add("127");
        print(list_str);

        List<Double> list_dou = new LinkedList<>();
        list_dou.add(2.36);
        list_dou.add(1.36);
        list_dou.add(25.36);
        list_dou.add(2.66);
        print(list_dou);
        List<?> list = null;
        list = list_dou;
        // 对于List<?> 就不能向其内部添加数据
        // 除了添加null 之外
        // 允许读取，读取的数据类型为Object
//        list.add(3.6699);
//        list.add("xxx");
//        list.add(new Object());
        list.add(null);

        System.out.println("-------------");

        System.out.println(list.get(1));

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 有限制条件的通配符的使用
     * ？extends Person；
     * ？ super Person
     */
    @Test
    public void test3() {
        List<? extends Person> list1 = null; //Person的子类，小于等于Person的范围
        List<? super Person> list2 = null;//Person的父类，大于等于Person的范围

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5; //GG
//        list2 = list3; //GG
        list2 = list4;
        list2 = list5;
    }

}
