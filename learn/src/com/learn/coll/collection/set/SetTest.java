package com.learn.coll.collection.set;

import org.junit.Test;

import java.util.*;

/**
 * @author windyStreet
 * @codetime 2021-04-02 16:22
 */

/**
 * set 接口的框架
 * |---- Collection 接口：单列结合，用来存储一个一个对象
 *      |----Set 接口：存储无序的、不可重复的数据 ---> 集合
 *          |---- HashSet 作为Set接口的主要实现类，线程不安全，可以存储null值
 *              |---- LinkedHashSet 作为HashSet 的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *                     对于频繁的遍历操作，LinkedHashSet 效率高于 HashSet
 *          |---- TreeSet 可以按照添加对象的指定属性，进行排序
 *
 * 1、Set 接口中没有额外定义新方法，使用的都是Collection 中声明过的方法
 * 2、要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *      要求：重新的hashCode()和equals()尽可能保持一致性，相等的对象必须具有相等散列码
 *
 */
public class SetTest {
    /**
     * 无序的、不可重复的数据
     * 1、无序性  不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值
     * 2、不可重复性 ：保证添加的元素按照equals() 判断时，不能返true. 即相同的元素只能添加一个
     *
     *
     * 添加元素的过程 以hashSet 为例：
     * 我们向HashSet中添加元素a，首先调用元素a所在类的hashCode() 方法，计算元素
     * a的哈希值，此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：
     * 索引位置），判断数组此位置上是否已经有元素：
     *      如果此位置上没有其元素，则元素a添加成功
     *      如果此位置上有元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值
     *          如果hash值不相同，则元素a添加成功 --情况2
     *          如果hash值相同，进而需要调用元素a所在类的equals()方法：
     *              equals（）返回true，元素a添加失败
     *              equals（）返回false，元素a添加成功 --情况3
     *   对于添加成功的情况2和情况3而言，元素a与已经存在指定索引位置上数据以链表的方式存储
     *   jdk7：元素a放到数组中，指向原来的元素
     *   jdk8：原来的元素在数组中，指向元素a
     *   7上8下
     *
     *   Set的底层结构为:数组加链表
     *
     */
    @Test
    public void test() {

        Set set = new HashSet();
        set.add(123);
        set.add("334");
        set.add("xx");
        set.add("YY");
        set.add(new SetTest());
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    //LinkedHashSet

    /**
     * LinkedHashSet 作为 HashSet 的子类，在添加数据时，还维护了两个引用
     * 记录了此数据的前一个数据和后一个数据
     * 优点：对于频繁的遍历操作，LinkedHashSet 效率高于 HashSet
     */
    @Test
    public void test1() {
        System.out.println("！！！！！！！！！！！！！！");
        Set set = new LinkedHashSet();
        set.add(123);
        set.add("334");
        set.add("xx");
        set.add("YY");
        set.add("YY");
        set.add(new SetTest());
        set.add(129);


//        set.forEach(System.out::println);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 1、向TreeSet 中添加数据，要求是相同类的对象
     * 2、两种排序方式：自然排序（Comparable）和定制排序（Comparator）
     * 3、自然排序中，比较两个对象是否相同的标准为：compareTo() 返回0，不再是equals()返回true
     * 4、定制排序中，比较两个对象是否相同的标准为：compare() 返回0，不再是equals()返回true
     */
    @Test
    public void test2() {

        System.out.println("！！！！！！！！！！！！！！");
        Set set = new TreeSet();
        set.add(123);
        set.add(9923);
        set.add(1);
        set.add(-123);
        set.add(63123);
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
