package com.learn.reflect;

/**
 * @author windyStreet
 * @codetime 2021-04-12 11:12
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * JAVA反射机制：在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制
 */
public class ReflectTest {

    @Test
    public void test() {

        //1、创建Person对象
        Person person = new Person("tom", 12);
        // 通过对象调用内部的属性、方法
        person.setAge(13);
        System.out.println(person.toString());
        person.age = 14;
        System.out.println(person.toString());
        person.show();

        // 在Person 类外部，不可以通过Person类的对象调用其内部私有化结构
        // 比如 name showNational 以及私有构造器

    }

    //反射操作 Person

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        // 1、 通过反射，创建Person类的对象
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("tom", 12);
        Person person = (Person) obj;
        System.out.println(person.toString());
        // 2、通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(person, 13);
        System.out.println(person.toString());
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        // 通过反射，可以调用Person类的私有结构，比如 私有构造器、方法、属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object obj1 = cons1.newInstance("jerry");
        Person p1 = (Person) obj1;
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "tina");
        System.out.println(p1);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "中国");

    }


    /**
     * 疑问： 直接new的方式或反射的方式都可以调用公共的结构，开发中用那个？
     * 建议直接new的凡是
     * 什么时候用反射：反射的特征:动态性
     * 疑问：反射机制与面向对象的封装行是不是矛盾的？如何看待这两个技术？
     * 不矛盾
     * 封装体现的是在静态代码中，建议代码隔离和提供更优的解决方案，比如私有化的方法、属性是不建议直接操作和使用的
     * 反射是在动态的代码中，为了生成对象的解密，获取内部信息
     * <p>
     * <p>
     * Class 对应着一个运行时实例
     */

    // 获取Class的实例的方式
    // 加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过
    // 不同的方式来获取运行时类
    @Test
    public void test2() throws ClassNotFoundException {
        // 方式一、调用运行时类的属性
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方式二、通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class<? extends Person> personClass1 = person.getClass();
        System.out.println(personClass1);

        //方式三、调用Class的静态方法：forName(String classPath)
        Class<?> aClass = Class.forName("com.learn.reflect.Person");
//            Class<? extends Class> aClass1 = aClass.getClass();
        System.out.println(aClass);

        // 方式四、使用类的加载器 ClassLoader
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class<?> aClass1 = classLoader.loadClass("com.learn.reflect.Person");
        System.out.println(aClass1);

        System.out.println(personClass == personClass1);
        System.out.println(personClass == aClass);
        System.out.println(personClass == aClass1);
        System.out.println(personClass1 == aClass);
        System.out.println(personClass1 == aClass1);
        System.out.println(aClass == aClass1);

    }

}
