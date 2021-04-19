package com.learn.jdk8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author windyStreet
 * @codetime 2021-04-19 15:19
 */
public class OptionalTest {

    /**
     * Optional 为了在程序中避免出现空指针异常
     * Optional.of(T t) 创建一个Optional 实例，t必须非空
     * Optional.empty() 返回一个Optional 实例
     * Optional.ofNullable(T t); t可以为空
     */
    @Test
    public void test() {
        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.of(girl);
        Optional<Object> empty = Optional.empty();
        Optional<Object> o = Optional.ofNullable(null);


        girl = null;
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        //Optional 内部封装的t是非空的，返回内部的t
        // 如果内部的t是空的，则返回orElse() 方法中的参数t1
        Girl girl3 = girl2.orElse(new Girl("小红"));
        System.out.println(girl3);
    }


    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test1() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    public String getGirlName1(Boy boy) {

        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("小张")));
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("小红"));
        return girl1.getName();
    }

    @Test
    public void test2() {
        Boy boy = new Boy();  // getGirlName1  == 小红
        boy = null; // getGirlName1 ==小张
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
}
