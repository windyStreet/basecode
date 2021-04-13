package com.learn.reflect.t1test;

import com.learn.reflect.t1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author windyStreet
 * @codetime 2021-04-12 15:45
 */
public class FiledTest {

    @Test
    public void test() {
        //getFields();
        //获取当前运行时类及其父类中声明为public访问权限的属性
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println();

        //获取当前运行时类中声明的所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("权限");
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers));
            System.out.println("类型");

            Class<?> type = f.getType();
            System.out.println(type);
            System.out.println("变量名");
            String name = f.getName();
            System.out.println(name);
            System.out.println();
        }


    }
}
