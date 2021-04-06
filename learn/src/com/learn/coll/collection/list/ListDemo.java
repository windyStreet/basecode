package com.learn.coll.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windyStreet
 * @codetime 2021-04-02 16:19
 */
public class ListDemo {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2); // --1 2 remove(int index)
//        list.remove(new Integer(2)); // -- 1 3 remove(Object o)
    }
}
