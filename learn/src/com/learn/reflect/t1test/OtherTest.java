package com.learn.reflect.t1test;

import com.learn.reflect.t1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author windyStreet
 * @codetime 2021-04-12 17:22
 */
public class OtherTest {

    /**
     * 获取构造器
     */

    @Test
    public void test() {

        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        // 获取当前运行时类公开的构造器
        for (Constructor cons : constructors
        ) {

            System.out.println(cons);
        }
        System.out.println("--------------------------");
        // 获取当前运行时类所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors
        ) {
            System.out.println(cons);

        }
    }

    /**
     * 获取运行时类的父类（带泛型）
     */
    @Test
    public void test1() {

        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /**
     * 获取运行时类的带泛型的父类的泛型（
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();

        ParameterizedType parType = (ParameterizedType) genericSuperclass;
        // 获取泛型
        Type[] actualTypeArguments = parType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行时类实现的接口
     */

    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class cl : interfaces) {
            System.out.println(cl.getName());
        }
        //获取运行时类父类实现的接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class c : interfaces1

        ) {
            System.out.println(c.getName());

        }
    }

        /**
         * 获取运行时类的包
         */

        @Test
        public void test4() {
            Class<Person> personClass = Person.class;
            Package aPackage = personClass.getPackage();
            System.out.println(aPackage);
        }


    /**
     * 获取运行时类声明的注解
     */

    @Test
    public void test5() {
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation ann :annotations)
        {
            System.out.println(ann);
        }
    }


}
