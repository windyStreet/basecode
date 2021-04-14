package com.learn.dynamic.staticagent;

/**
 * @author windyStreet
 * @codetime 2021-04-14 11:07
 */ // 被代理类
public class LiningClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("lining 工厂生产衣服");
    }
}
