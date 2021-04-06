package com.learn.coll.map;

/**
 * @author windyStreet
 * @codetime 2021-04-06 11:40
 */

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * 1、Map的底层实现
 * |---- Map: 双列数据，存储key-value 对的数据
 *      |---- HashMap 1.2 作为Map的主要实现类 线程不安全全，效率高 存储 null 的key 和value
 *          |---- LinkedHashMap 1.4 保证遍历map元素时，可以按照添加的顺序实现遍历
 *                          原因:在原有的HashMap 底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                          对于频繁的遍历操作，此类执行效率高于HashMap
 *      |---- TreeMap 保证添加的key-value对，进行排序，实现排序遍历。此时考虑key的自然排序和定制排序
 *                      底层使用的红黑树
 *      |---- HashTable 1.0 线程安全，效率低 不能存储 null 的key和 value
 *          |----  Properties 常用来处理配置文件。 key 和value 都是String 类型
 *
 *
 * HashMap的底层：  数组+链表 （jdk7之前）
 *                 数组+链表+红黑树（jdk8）
 *
 *
 * HashTable 和 HashMap的异同
 * CurrentHashMap 和 HashTable的异同（分段锁）
 *
 * 2、Map结构的理解
 *  Map中的key：无序的、不可重复的，使用Set存储所有key  --> key 所在类要重写equals() 和 hashCode()  HashMap 为例
 *  Map中的value： 无序的、可重复的，使用Collection存储所有的Value --> values 所在类要重写equals()
 *  一个键值对：key-value 构成一个entry对象
 *  Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *
 *
 *  3、HashMap的底层实现原理
 *  jdk7
 *      HashMap map = new HashMap();
 *         在实例化以后，底层创建了长度是16的一位数组 Entry[] table
 *         .... 执行多次put...
 *         map.put(key1,value1)
 *         首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种计算后，得到Entry数组中的存放位置
 *         如果此位置上的数据为空，此时key1-value1 添加成功 --->情况1
 *         如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多个数据的哈希值
 *              如果key1的哈希值与已经存在的数据的哈希值不同，此时key1-value1添加成功 --->情况2
 *              如果key1的哈希值和已经存在的某个数据的哈希值相同，继续比较，调用key1所在类的equals()方法，比较：L
 *                  如果equals()返回false，此时key1-value1 添加成功 --->情况3
 *                  如果equals()返回true，使用value1替换value2【表现为修改的特征】
 *
 *        补充：
 *          情况2 和 情况3，此时key1-value1 和原来的数据以链表的方式存储
 *          在不断添过程中，会涉及到扩容问题，当超出临界值且新添加的元素对应的位置不为空，扩容
 *          默认的扩容方式为，扩容为原来容量的2倍，并将原来的数据复制过来
 *  jdk8
 *      不同于jdk7
 *      1、new HashMap() 底层没有创建一个长度为16的数组
 *      2、jdk8底层的数组是 Node[],而非Entry[]
 *      3、在首次调用put()方法时，底层创建长度为16的数组
 *      4、jdk7底层结构只有，数组+链表。jdk7中底结构为：数组+链表+红黑树
 *          当数组的某个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
 *          此时索引位置上的所有数据改为红黑树存储
 *
 *      DEFAULT_INITIAL_CAPACITY 默认容量 16
 *      DEFAULT_LOAD_FACTOR 默认加载因子 0.75
 *      threshold 扩容的临界值 = 容量 * 加载因子 16 * 0.75 = 12
 *      TREEIFY_THRESHOLD Bucket 中链表长度大于该默认值，转化为红黑树 8
 *      MIN_TREEIFY_CAPACITY 桶中的Node被树化时最小的hash表容量 64
 *
 *  4、LinkedHashMap 的底层实现原理
 *
 *  ------------Node 结构----------------
 *      static class Node<K,V> implements Map.Entry<K,V> {
 *         final int hash;
 *         final K key;
 *         V value;
 *         Node<K,V> next;
 *
 *         Node(int hash, K key, V value, Node<K,V> next) {
 *             this.hash = hash;
 *             this.key = key;
 *             this.value = value;
 *             this.next = next;
 *         }
 *
 *         -------------------------------------------
 *
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 * 5、Map 接口中定义的方法
 *
 *  @Override
 *     public int size() {
 *         return 0;
 *     }
 *
 *     @Override
 *     public boolean isEmpty() {
 *         return false;
 *     }
 *
 *     @Override
 *     public boolean containsKey(Object key) {
 *         return false;
 *     }
 *
 *     @Override
 *     public boolean containsValue(Object value) {
 *         return false;
 *     }
 *
 *     @Override
 *     public Object get(Object key) {
 *         return null;
 *     }
 *
 *     @Override
 *     public Object put(Object key, Object value) {
 *         return null;
 *     }
 *
 *     @Override
 *     public Object remove(Object key) {
 *         return null;
 *     }
 *
 *     @Override
 *     public void putAll(Map m) {
 *
 *     }
 *
 *     @Override
 *     public void clear() {
 *
 *     }
 *
 *     @Override
 *     public Set keySet() {
 *         return null;
 *     }
 *
 *     @Override
 *     public Collection values() {
 *         return null;
 *     }
 *
 *     @Override
 *     public Set<Entry> entrySet() {
 *         return null;
 *     }
 *
 */

public class MapTest {
    @Test
    public void test(){
        HashMap map = new HashMap();
        map.put(1,"AAAA");
        map.put(2,"DDDD");
        map.put(3,"CCC");
        map.put(4,"VBVB");
        map.put(5,"JAVA");
        map.put("ana","G+DOG");
        map.put("PI",3.141592757);
        for (Object s: map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }


        System.out.println(":::::::::::::::::");
        for (Object entry:map.entrySet()){
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey());
            System.out.println(entry1.getValue());
        }

        map.clear();
        map.containsKey(7);
        map.containsValue("SASS");

    }
}


class MapTe implements Map{

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}