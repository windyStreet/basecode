package com.learn.reflect.t1;

/**
 * @author windyStreet
 * @codetime 2021-04-12 15:30
 */

@MyAnnotation
public class Person extends Creature<String> implements Comparable<String>, MyInterface {


    private String name;
    int age;


    public int id;

    public Person() {
    }


    @MyAnnotation(value="private person()")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    private String showNation(String nation) throws NullPointerException,ClassCastException{
        System.out.println("国籍是:" + nation);
        return nation;
    }

    @MyAnnotation(value="public display()")
    public String display(String interests){
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("一个人");
    }
}
