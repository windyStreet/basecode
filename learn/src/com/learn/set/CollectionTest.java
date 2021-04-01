package com.learn.set;

/**
 * @author windyStreet
 * @codetime 2021-03-31 16:30
 */

import org.junit.Test;

import java.util.*;

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
 * 向collection 接口的实现类的对象中添加obj是，建议重写equals方法
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
        System.out.println("****************");

        coll.add(new Goods("AA", 12));
        coll.add(123);
        coll.add("ABC");
        coll.add(new String("qwer"));

        System.out.println(coll.contains(234));
        System.out.println(coll.contains(123));
        System.out.println(coll.contains("ABC"));
        System.out.println(coll.contains(new String("qwer")));
        System.out.println(coll.contains(new Goods("AA", 12)));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));

        System.out.println(coll.contains(234));
        System.out.println(coll.contains(123));
        System.out.println(coll.contains("ABC"));
        System.out.println(coll.contains(new String("qwer")));
        //重写equals 执行的次数与找到的次数有关
        System.out.println(coll.contains(new Goods("AA", 12)));
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(123);
        objects.add("ABC");
        objects.add(new String("qwer"));
        objects.add(new Goods("AA", 12));

        // 判断形参objects 中的所有元素是否都存在于当前集合中
        System.out.println(coll.containsAll(objects));
        System.out.println(objects.containsAll(coll));
    }

    @Test
    public void test3() {
        //从当前集合中移除obj元素
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        System.out.println(coll.remove(123));
        System.out.println(coll.remove(1234));
        System.out.println(coll);
        Collection coll1 = Arrays.asList(123, 1235);
        coll.removeAll(coll1); // coll 的差集
        System.out.println(coll);

    }

    @Test
    public void test4() {
        //从当前集合中移除obj元素
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        Collection coll1 = Arrays.asList(123, 1235, "TTTT");
        coll.retainAll(coll1);  // coll 与 coll1的交集
        System.out.println(coll); // 保留一样的
    }

    @Test
    public void test5() {
        // 返回true ，需要当前集合和形参集合的元素都相同
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));

        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(1235);
        coll1.add("ABC");
        coll.add(new String("qwer"));
        coll1.add(new Goods("AA", 12));

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test6() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        // 返回当前对象的hash值
        System.out.println(coll.hashCode());
        // 集合可以转换为数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        // 数组转化为集合
        Collection objects1 = Arrays.asList(objects);
        Collection objects2 = Arrays.asList(new int[]{22, 33, 66, 99});
        System.out.println(objects2);
        System.out.println(objects2.size());

        System.out.println("！！！！！！！！！！！！！！！！");
        Collection objects3 = Arrays.asList(new Integer[]{22, 33, 66, 99});
        System.out.println(objects3);
        System.out.println(objects3.size());

        Iterator it = objects3.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

