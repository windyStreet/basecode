package com.learn.annotation;

/**
 * @author windyStreet
 * @codetime 2021-03-31 15:09
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的作用
 * 程序员在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 * <p>
 * 使用示例
 * 1、生成文档相关的注解
 * 2、编译时进行格式检查（JDK内置的三个基本注解）
 *
 * @Override 限定重写父类方法，该注解只能用于方法
 * @SuppressWarnings 抑制编译器警告
 * @Deprecated 用于表示修饰的元素（类、方法）等已过时，通常应为修饰的结构危险或存在缺陷
 * <p>
 * <p>
 * 自定义注解
 * 注解声明为@interface
 * 内部定义成员，通常使用value
 * 可以指定成员的默认值，使用default定义
 * 如果自定义注解没有成员，表名是一个标识作用
 * 如果注解有成员，使用注解是，需要致命成员的值
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 * <p>
 * jdk 提供的四种元注解【对现有注解进行及时说明的注解】
 * jdk5.0 meta-annotation
 * Retention 指定所修的Annotation 的生命周期
 * SOURCE、CLASS （默认行为） 在编译和加载过程被抛弃
 * RUNTIME  只有这种方式，才能通过反射获取
 * Target 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 * Documented 表示所修饰的注解在被javadoc 解析时，保留注解信息
 * Inherited 被它修饰的Annotation 将具有继承性
 * <p>
 * 自定义注解通常会使用 Retention Target
 * <p>
 * <p>
 * 通过反射 获取注解新
 * <p>
 * jdk 8 新特性
 * 可重复注解
 * 1、在MyAnnotation 上声明 @Repeatable,成员值为 在MyAnnotations.class
 * 2、在MyAnnotation 的 Target、Retention 和 MyAnnotations 一致
 * <p>
 * 类型注解
 * TYPE_PARAMETER,TYPE_USE
 */
public class AnnotationTest {
    @Test
    public void test() {
        Guard guard = new Guard("AA", 12);
        guard.skill();
        guard.show();
    }

    @Test
    public void test1() {
        Date date = new Date(2020, 10, 11);
        System.out.println(date);
    }

    @Test
    public void test2() {
        @SuppressWarnings("unused")
        int num = 10;

        int number = 11;
    }

    @Test
    public void test3() {
        Class<Guard> guardClass = Guard.class;
        Annotation[] annotations = guardClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }


    }
}

// 类型注解
class Gen<@MyAnnotation() T> {
    public void show() {
        ArrayList<@MyAnnotation String> o = new ArrayList<String>();
    }
}
//@MyAnnotation(value = "1111")
//@MyAnnotation

/**
 * jdk8 之前
 *
 * @MyAnnotations({@MyAnnotation(value = "1111"),@MyAnnotation(value = "222")})
 */

@MyAnnotation(value = "1111")
@MyAnnotation(value = "222")
class Person {
    private String name;
    private int age;

    //    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    @MyAnnotation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void skill() {
        System.out.println("alive");
    }

    public void show() {
        System.out.println("show person");
    }
}


interface Info {
    void show();
}

class Guard extends Person implements Info {

    public Guard(String name, int age) {
        super(name, age);
    }

    @Override
    public void skill() {
        super.skill();
        System.out.println("fixed flower");
    }

    @Override
    public void show() {
        System.out.println("show guard");
    }
}