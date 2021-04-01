package com.learn.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author windyStreet
 * @codetime 2021-04-01 17:48
 */
public class IteratorTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        Iterator it = coll.iterator();
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(it.next());
//        }
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test1() {
        // 错误的示例
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        Iterator it = coll.iterator();
        while (it.next() != null) { // 跳过输出
            System.out.println(it.next());
        }

        // 错误方式二
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next()); // 每次循环获得一个新的迭代器，无法机型往下遍历
        }
    }

    //remove 方法
    @Test
    public void test2() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
        System.out.println(coll.size());
        Iterator it = coll.iterator();
        while (it.hasNext()) {
//            System.out.println(it.next());
            Object obj = it.next();
            if ("ABC".equals(obj)) {
                it.remove();
            }
        }
        Iterator it_1 = coll.iterator();
        while (it_1.hasNext()) {
            System.out.println(it_1.next());
        }
        System.out.println(coll.size());

    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(null);
        coll.add(1235);
        coll.add("ABC");
        coll.add(new String("qwer"));
        coll.add(new Goods("AA", 12));
//        Iterator it = coll.iterator();
        for (Object o : coll) {
            if (o == null) {
                System.out.println("null object ");
            }
            System.out.println(o);
        }
    }
}
