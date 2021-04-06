package com.learn.coll.collection.list;

/**
 * @author windyStreet
 * @codetime 2021-04-02 10:30
 */

import org.junit.Test;

import java.util.*;
/**
 *|---- Collection 接口： 单列集合，用来存储一个一个对象
 *      |---- list  1.2 接口：存储有序、可重复的数据 --》 “动态数组”替换原有数组
 *          |---ArrayList ：1.2 作为 List 接口的主要实现类，线程不安全，效率高，底层是用Object[] elementData存储
 *          |---LinkedList ：1.2  对于频繁的插入和删除操作效率比ArrayList高，底层使用的双向链表存储
 *          |---Vector ：1.0 最古老的的实现类，线程安全，效率低，底层是用Object[] elementData存储
 *
 *
 *  ArrayList 的源码
 *  jdk 7
 *  ArrayList list = new ArrayList(); // 底层创建了一个长度是10的Object[] elementData存储
 *  list.add("xxx");// elementData[0] = new String("xxx");
 *  ...
 *  list.add(123); // 如果此次添加的数据导致底层elementData数组容量不足
 *  // 默认情况下，扩容为原来容量的1.5倍，同时需要将原来的数组中的数据复制到新数组中
 *
 *  建议使用 ArrayList arrayList = new ArrayList(int capacity);
 *
 *  jdk 8中的变化
 *  ArrayList list = new ArrayList(); //底层Object[] 初始化为{}，并没有创建长度为10的数组 节省空间
 *  list.add(123) // 第一次调用add（）时，底层才创建长度为10的数组，并将数据123她添加到element中
 *  ---
 *  后续与jdk7无异
 *  jdk7中的ArrayList的创建对象类似于单例的饿汉式
 *  jdk8中的ArrayList的创建对象类似于单例的懒汉式，延迟了数组的创建，节省内存
 *
 *  LinkedList
 *
 *      LinkedList linkedList = new LinkedList();
 *      //内部声明了Node类型的first和last属性，默认是为null
 *      linkedList.add(123);//将123封装到Node中，创建Node对象
 *      其中，Node定义为，提箱LinkedList的双向链表的说法
 *      private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *  Vector
 *  在jdk7和jdk8中通过Vector() 构造器创建对象时，底层都创建了长度为10的数组
 *  扩容方面，默认扩容为原来数组长度的2倍
 */

/**
 * ArrayList LinkedList Vector 异同点
 *
 * 三个类都是实现了List接口，存储数据的特点相同，存储有序、可重复的数据
 */

/**
 * 鉴于Java中数组用来存储数据的局限性，我们通常用List代替数组
 * List集合中元素有序、且可重复，集合中的每个水元素都是有其对应的顺序索引
 * List容器中的元素都对应一个正整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
 * JDK API中List接口的实现类常用的有 ArrayList LinkedList Vector
 */
public class ListTest {

    @Test
    public void test() {
        ArrayList arrayList = new ArrayList(); // 底层创建了一个长度是10的Object[] elementData存储
        ArrayList arrayList1 = new ArrayList(50); // 底层创建了一个长度是10的Object[] elementData存储
        arrayList.add("123");
        Vector<Object> objects = new Vector<>();

        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add(123);
        linkedList.add(new ListTest());
        linkedList.add("4");
        linkedList.add("5");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
        List list = Arrays.asList(12, 34, 56, 78, 90);
        linkedList.add(123);
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        linkedList.addAll(list);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
        System.out.println("123的indexOf位置" + linkedList.indexOf(123));
        System.out.println("123的lastIndexOf位置" + linkedList.lastIndexOf(123));


        LinkedList llist = new LinkedList();
        llist.add("a");
        llist.add("b");
        llist.add("c");
        llist.add("d");
        llist.add("e");
        llist.add("f");
        llist.add("g");
        llist.add("h");
        llist.add("i");
        System.out.println(llist.subList(2, 5));
        System.out.println(llist);
        llist.remove(3);
        System.out.println(llist.subList(2, 5));
        System.out.println(llist);
        llist.remove("h"); //list 中的存储都是对象，不是基本数据类型
        System.out.println(llist.subList(2, 5));
        System.out.println(llist);
        System.out.println("====");
        Iterator iterator = llist.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("====");
        for (Object obj : llist) {
            System.out.println(obj);
        }
        System.out.println("====");
        for (int i = 0; i < llist.size(); i++) {
            System.out.println(llist.get(i));
        }
    }
}
