package com.learn.reflect;

/**
 * @author windyStreet
 * @codetime 2021-04-12 11:14
 */
public class Person {

    private String name;
    public int age;
    public String hobby;


    public Person() {
        System.out.println("person() constructor method ...");
    }

    public Person(int age) {
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("我是谁？" + this.toString());
    }

    private String showNation(String nation) {
        System.out.println("我来自" + nation);
        return nation;
    }

    private static void  showDes() {
        System.out.println("person void showDes()---------");
    }
}
