package com.learn.io.stream;

import java.io.Serializable;

/**
 * @author windyStreet
 * @codetime 2021-04-09 16:28
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -684974470754667711L;
    private String name;
    private int age;
    private int sex;
    private transient Account acc;

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Person(String name, int age, int sex, Account acc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.acc = acc;
    }

    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
