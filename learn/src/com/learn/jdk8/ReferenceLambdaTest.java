package com.learn.jdk8;

/**
 * @author windyStreet
 * @codetime 2021-04-14 16:50
 */

import com.learn.reflect.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 1、使用情况：当要传递给Lambda 体的操作，已经有实现的方法了，就可以用方法引用
 * 2、方法引用，本质上就是Lambda 表达式，而Lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例
 * 3、使用格式：类（或对象）:: 方法名
 * 4、具体分为如下三种情况：
 * 情况一  对象::非静态方法
 * 情况二  类::静态方法
 * 情况三  类::非静态方法
 * 5、方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同（针对情况一、二）
 */
public class ReferenceLambdaTest {


    //情况一、对象::实例方法
    // Consumer中void accept(T t)
    // PrintStream 中的 void println(T t)
    @Test
    public void test() {
        Consumer<String> con = str -> System.out.println(str);
        System.out.println("(*****************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("tian an men");
    }

    // Supplier 中的T get()
    // Person 中的String getName()
    @Test
    public void test1() {
        Person person = new Person("tom", 12);
        Supplier<String> sup1 = () -> person.getName();
        sup1.get();
        System.out.println(sup1.get());
        System.out.println("***********************");
        Supplier<String> sup2 = person::getName;
        sup2.get();
        System.out.println(sup2.get());

    }

    // 情况二 类::静态方法
    // Comparator 中的 int compare(T t1, T t2)
    // Integer 中的int compare(T t1,T t2)
    @Test
    public void test2() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(10, 50));
        System.out.println("********************************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(23, 45));
    }

    // Function 中的R apply(T t)
    // Math 中的Long round(Double d)
    @Test
    public void test3() {
        Function<Double, Long> fu = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(fu.apply(11.003));
        System.out.println("**************************");
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(10.7));
        System.out.println("*************************");
        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(11.03));
    }

    // 情况三 类:: 实例方法
    // Comparator 的int compare(T t1,T t2)
    // String 中的 int t1.compare(t2)

    @Test
    public void test4() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("AAA", "aaa"));
        System.out.println("*****************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("BBB", "bbb"));
    }

    // BiPredicate 中的boolean test(T t1,T t2)
    // String 中的boolean t1.equals(t2)
    @Test
    public void test5() {
        BiPredicate<String, String> bip = (s1, s2) -> s1.equals(s2);
        System.out.println(bip.test("AAA", "BBB"));
        System.out.println(bip.test("AAA", "AAA"));
        System.out.println("******************");
        BiPredicate<String, String> bip1 = String::equals;
        System.out.println(bip1.test("BBB", "CCC"));
        System.out.println(bip1.test("CCC", "CCC"));

    }

    // Function 中的R apply(T t)
    // Person 中的 String p.getName
    @Test
    public void test6() {
        Person p = new Person("jerry", 25);
        Function<Person, String> f = per -> per.getName();
        System.out.println(f.apply(p));
        System.out.println("****************");
        Function<Person, String> f2 = Person::getName;
        System.out.println(f2.apply(p));

        Function<Person, Integer> f1 = per -> per.getAge();
        System.out.println(f1.apply(p));
        Function<Person, Integer> f3 = Person::getAge;
        System.out.println(f3.apply(p));

    }
}