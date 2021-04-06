package com.learn.coll.map;

/**
 * @author windyStreet
 * @codetime 2021-04-06 17:35
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 向 TreeMap 中添加 key-value ,要求key必须是由同一个类创建的对象
 * 因为 需要按照key进行排序：自然排序 、定制排序
 */

class Pet implements Comparable {

    int age;
    String name;

    public Pet(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Pet) {
            int sub = this.age - ((Pet) o).age;
            if (sub == 0) {
                return  this.name.compareTo(((Pet) o).name);
            }
            return sub;
        }
        return 0;
    }
}

public class TreeMapTest {
    @Test
    public void test()
    {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Pet && o2 instanceof Pet){
                    return  -(Integer.compare(((Pet) o1).age,((Pet) o2).age) ==0 ? ((Pet) o1).name.compareTo(((Pet) o2).name) :Integer.compare(((Pet) o1).age,((Pet) o2).age));
                }
                return 0;
            }
        };
//        TreeMap map = new TreeMap();
        TreeMap map = new TreeMap(com);
        Pet pet1 = new Pet(12, "mini");
        Pet pet2 = new Pet(3, "tiki");
        Pet pet3 = new Pet(1, "sona");
        Pet pet4 = new Pet(66, "moba");
        Pet pet5 = new Pet(12, "gg");
        Pet pet6 = new Pet(4, "sese");

        map.put(pet1, "11");
        map.put(pet2, "11");
        map.put(pet3, "11");
        map.put(pet4, "11");
        map.put(pet5, "11");
        map.put(pet6, "11");

        for (Object o : map.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            Pet pet = (Pet) en.getKey();
            System.out.println(pet.age + "---"+pet.name + ":" + en.getValue());
        }
    }

}
