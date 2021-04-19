package com.learn.jdk8.optional;

/**
 * @author windyStreet
 * @codetime 2021-04-19 15:22
 */
public class Boy {
    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }


    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
