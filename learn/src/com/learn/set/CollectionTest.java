package com.learn.set;

/**
 * @author windyStreet
 * @codetime 2021-03-31 16:30
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合、数组 都是对多个数据进行存储操作的结构，简称java容器
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 * 1、数组在存储多个数据方面的特点
 * ① 一旦初始化，其长度就确定了
 * ②数组定义好了，元素类型也就确定了。
 * 2、数组在存储多个数据方面的缺点
 * ① 一旦初始化，其长度就不可以修改
 * ② 数据维护困难 插入、删除、添加，效率低
 * ③ 数组存储数据的特点 有序、可重复。对于无序的、不可重复的需求，处理困难
 * <p>
 * 1、collection
 * 2、
 */
public class CollectionTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add("AAA");
        coll.add("AAA");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll.size());
        Collection coll1 = new ArrayList();
        coll1.add(236);
        coll.add(new String("888"));
        System.out.println("^^^^^^^^^^^^^");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll.isEmpty());
        System.out.println("---------------");
        coll.clear();
        System.out.println(coll.size());
        System.out.println(coll.isEmpty());
    }
}
