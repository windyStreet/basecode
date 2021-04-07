package com.learn.generic;

import org.junit.Test;

/**
 * @author windyStreet
 * @codetime 2021-04-07 15:15
 */

/**
 * 1、关于自定义泛型类、泛型接口
 * 泛型方法:在方法中国出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
 * ==> 泛型方法所属的类是不是泛型类都没有关系
 * 泛型防范，可以声明为静态的。因为:泛型参数是在调用方法时确定的，并非在实例化类的时候确定。
 */
public class GenericTest1 {
    @Test
    public void test() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型

        //要求：如果大家定义了类是带泛型的，建议在实例化是要指明类的泛型
        Order order = new Order();
        order.setOrderT("123");
        order.setOrderT(56);

        // 建议:实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA", 15, "orderAT");
        order1.setOrderT("新的值");
        System.out.println(order1.toString());

    }

    @Test
    public void test1(){
        SubOrder subOrder = new SubOrder();
        // 由于子类在冀衡带泛型的父类时，指明了泛型类型，则实例化子类对象时，不在需要指明泛型
        subOrder.setOrderT(126);
        System.out.println(subOrder.toString());

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("suborder1 仍是泛型类");
        System.out.println(sub2.toString());
    }



}
