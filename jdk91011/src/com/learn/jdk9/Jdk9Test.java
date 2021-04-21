

package com.learn.jdk9;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author windyStreet
 * @codetime 2021-04-19 17:19
 */
public class Jdk9Test {
    public static void main(String[] args) {
        /**
         * 钻石操作符的升级使用
         */
        // jdk7 的特性，类型推断
        ArrayList<String> list = new ArrayList<>();

        //jkd8 的写法 钻石操作符号和匿名内部类不能共存
        Comparator<Object> com1 = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //jdk 9 的写法
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        /**
         * String 存储结果变更
         */
        // 底层修改为byte[] ，由于大量数据使用，但是大部分请情况下使用的字符只需要一个byte就足够存储
        // 需要多个byte存储的情况就使用多个，可以在一定程度上节省内存
        String s = new String();
    }

}
