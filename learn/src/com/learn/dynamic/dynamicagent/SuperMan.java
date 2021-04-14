package com.learn.dynamic.dynamicagent;

/**
 * @author windyStreet
 * @codetime 2021-04-14 11:08
 */ // 被代理人
class SuperMan implements Human {

    @Override
    public String getHobby() {
        System.out.println("拯救地球");
        return null;
    }

    @Override
    public void eat(String food) {
        System.out.println("我来吃点" + food);
    }
}
