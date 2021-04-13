package com.learn.reflect;

/**
 * @author windyStreet
 * @codetime 2021-04-12 17:43
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class RefTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException {


        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        // 获取指定属性
//        Field name = clazz.getField("name");
        Field name = clazz.getField("hobby");
        /**
         * 设置当前属性的值
         *
         * set() 参数1：指明设置那个对象的属性
         * 参数2 将此属性值设置为多少
         */
        name.set(p, "tom");

        /**
         * 获取当前属性的值,声明为public
         * get() 参数1 获取那个对象的当前属性值
         */

        String name_str = (String) name.get(p);
        System.out.println(name_str);


    }

    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class<?> clazz = Class.forName("com.learn.reflect.Person");
        //创建运行是类的对象
        Object o = clazz.newInstance();
        Person p = (Person) o;

        // 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性是可以访问的
        name.setAccessible(true);

        //设置、获取指定对象的此属性值
        name.set(p, "jerry");
        System.out.println(name.get(p));


    }

    /**
     * 如何操作运行时类中指定的方法
     */
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.learn.reflect.Person");
        //创建运行是类的对象
        Object o = clazz.newInstance();
        Person p = (Person) o;

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        // 保证当期方法是可以访问的
        showNation.setAccessible(true);
        /**
         * invoke()
         * 参数一 方法的调用者
         * 参数二 给方法形参赋值的实参
         *  返回值：即为对应类中方法的返回值
         */
        Object read_book = showNation.invoke(p, "eeee");
        System.out.println(read_book);

        /**调用静态方法************/
        System.out.println("调用静态方法************/");
        Method showDes = clazz.getDeclaredMethod("showDes");
        showDes.setAccessible(true);
//        Object invoke = showDes.invoke(p);
//        Object invoke = showDes.invoke(null);
        Object invoke = showDes.invoke(Person.class);
        System.out.println(invoke);
    }


    /**
     * 如何操作运行时类中指定的构造器
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.learn.reflect.Person");
        //创建运行是类的对象
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person kity = (Person) declaredConstructor.newInstance("kity");
        System.out.println(kity.toString());
    }

}
