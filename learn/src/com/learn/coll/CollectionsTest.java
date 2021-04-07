package com.learn.coll;

import org.junit.Test;

import java.util.*;

/**
 * @author windyStreet
 * @codetime 2021-04-07 9:48
 */
public class CollectionsTest {
    @Test
    public void test() {

        List list = new ArrayList();
        list.add(23);
        list.add(231);
        list.add(231);
        list.add(123);
        list.add(223);
        list.add(323);
        list.add(323);
        list.add(323);

        System.out.println(list);

        System.out.println("-------------");
//        Collections.reverse(list); // 反转
//        Collections.shuffle(list); // 随机转换
//        Collections.swap(list,1,2);  // 交换 角标为1 和 2  的两个元素
//        Collections.sort(list); // 自然排序
//        System.out.println(Collections.max(list)); // 最大值
//        System.out.println(Collections.min(list)); // 最小值
//        System.out.println(Collections.frequency(list,323));// 323 元素在list出现的次数
//        List dest = new ArrayList(20);
        System.out.println(list);
        System.out.println("-------------");
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest, list);
        System.out.println(dest);
        dest.set(2, 0);
        System.out.println(dest);
        System.out.println("-------------");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int compare = Integer.compare((Integer) o2, (Integer) o1);
                return compare;
            }
        });
        System.out.println(list);
        System.out.println("-------------");
    }

    /**
     * Collections 提供多个 synchronizedXXX() 方法，该方法可以使执行集合包装成线程同步的集合，
     * 从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(23);
        list.add(231);
        list.add(231);
        list.add(123);
        list.add(223);
        list.add(323);
        list.add(323);
        list.add(323);
        List syn_list = Collections.synchronizedList(list);
        System.out.println(syn_list);

    }

}
