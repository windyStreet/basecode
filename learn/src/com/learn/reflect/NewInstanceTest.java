package com.learn.reflect;

/**
 * @author windyStreet
 * @codetime 2021-04-12 15:10
 */

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射的方式创建运行时类的对象
 */
public class NewInstanceTest {

    /**
     * @throws IllegalAccessException
     * @throws InstantiationException newInstance
     *                                创建运行时类的对象
     *                                必须提供空参的构造器
     *                                空参的构造器的访问权限必须足够。通常设置为 public
     *                                <p>
     *                                <p>
     *                                在javabean中，要求提供一个public 的空参构造器
     *                                1、便于反射，创建运行时类的对象
     *                                2、便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
     */
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance(); // 默认 公开可调用的空参的构造器
        System.out.println(person);
    }

    @Test

    public void test1() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.learn.reflect.Person";
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String claassPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(claassPath);
        return clazz.newInstance();
    }
}
