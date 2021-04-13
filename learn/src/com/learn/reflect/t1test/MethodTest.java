package com.learn.reflect.t1test;

/**
 * @author windyStreet
 * @codetime 2021-04-12 15:55
 */

import com.learn.reflect.t1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 */
public class MethodTest {

    @Test
    public void test() {
        Class<Person> personClass = Person.class;
        // getMethods() 获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        //getDeclaredMethods() 获取当前运行时类中声明的所有方法
        System.out.println();
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method f : declaredMethods) {
            System.out.println(f);
        }
    }

    /**
     * @XXX 权限修饰符 返回值类型 方法名（参数类型1 形参名1 , ...
     */
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method f : declaredMethods) {
            // 注解
            Annotation[] annotations = f.getAnnotations();
            for (Annotation ann : annotations) {
                System.out.println(ann);
            }

            System.out.println();
            // 权限修饰符

            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println();
            // 返回值类型

            Class<?> returnType = f.getReturnType();
            System.out.println(returnType);

            // 方法名
            System.out.println(f.getName());

            // 形参类表

            Class<?>[] parameterTypes = f.getParameterTypes();
            if (parameterTypes == null | parameterTypes.length == 0)
                System.out.println("空参");
            else {
                System.out.print("(");
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
                System.out.print(")");
            }

            System.out.println();
            System.out.println("抛出异常");
            Class<?>[] exceptionTypes = f.getExceptionTypes();
            for (Class c: exceptionTypes) {
                System.out.println(c.getName());

            }
            System.out.println("-------------------------");

        }


    }

}
