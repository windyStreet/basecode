package com.learn.jdk8;

/**
 * @author windyStreet
 * @codetime 2021-04-16 17:07
 */

import com.learn.reflect.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *      抽象方法的返回值类型即为构造器所属的类的类型
 * 数组引用
 *      可以把数组看成一个特殊的类，和构造器引用相同
 */
public class ConstructorRefTest {

    // 构造器引用
    // Supplier 中的T get()

    @Test
    public void test() {
        Supplier<Person> sup = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(sup.get());
        System.out.println("*******************");
        Supplier<Person> sup1 = () -> new Person();
        System.out.println(sup1.get());
        System.out.println("**************");
        Supplier<Person> sup2 = Person::new;
        System.out.println(sup2.get());
    }

    //Function 中的 R apply(T t)
    @Test
    public void test1() {
        Function<Integer, Person> fun = id -> new Person(id);
        System.out.println(fun.apply(15).getAge());
        System.out.println("*******************");
        Function<Integer, Person> fun1 = Person::new;
        System.out.println(fun1.apply(16).getAge());
    }

    // BiFunction 中的 R apply(T t, U  u)
    @Test
    public void test2() {
        BiFunction<String, Integer, Person> bif1 = (str, age) -> new Person(str, age);
        System.out.println(bif1.apply("tonm", 23).toString());
        BiFunction<String, Integer, Person> bif = Person::new;
        System.out.println(bif.apply("jerry", 20).toString());
    }

    // 数组引用
    // Function 中 R apply(T t)
    @Test
    public void test3(){
        Function<Integer,String[]> func1 = length->new String[length];
        String[] arr = func1.apply(2);
        System.out.println(Arrays.toString(arr));

        Function<Integer,String[]> func2 = String[]::new;
        System.out.println(func2.apply(26).length);

    }
}
