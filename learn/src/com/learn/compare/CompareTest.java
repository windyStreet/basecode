package com.learn.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author windyStreet
 * @codetime 2021-03-29 17:24
 */
public class CompareTest {
    @Test
    public void test() {
        String[] arr = new String[]{"AA", "CC", "YY", "HH", "RR" };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test1() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("AA", 15.03);
        arr[1] = new Goods("AX", 5.03);
        arr[2] = new Goods("AY", 75.03);
        arr[3] = new Goods("AZ", 35.03);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"AA", "CC", "YY", "HH", "RR" };
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
//                return 0;
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("AA", 15.03);
        arr[1] = new Goods("AX", 5.03);
        arr[2] = new Goods("AY", 75.03);
        arr[3] = new Goods("AZ", 35.03);
        arr[4] = new Goods("AZ", 35.02);
        arr[5] = new Goods("AX", 35.02);
        Arrays.sort(arr, (o1, o2) -> {
            if (o1 != null && o2 != null) {
                if (o1.getName().equals(o2.getName())) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
            throw new RuntimeException("输入的数据类型不一致");
//                return 0;
        });

//        Arrays.sort(arr, new Comparator<Goods>() {
//            @Override
//            public int compare(Goods o1, Goods o2) {
//                if (o1 != null && o2 != null) {
//                    if (o1.getName().equals(o2.getName())) {
//                        return Double.compare(o1.getPrice(), o2.getPrice());
//                    } else {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                }
//                throw new RuntimeException("输入的数据类型不一致");
////                return 0;
//            }
//        });
        System.out.println(Arrays.toString(arr));
    }

}
