package com.learn.jdk8.optional;

/**
 * @author windyStreet
 * @codetime 2021-04-19 15:23
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
