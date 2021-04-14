package com.learn.dynamic.staticagent;


public class StaticAgent {
    public static void main(String[] args) {
        // 创建被代理类对象
        LiningClothFactory liningClothFactory = new LiningClothFactory();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(liningClothFactory);
        proxyClothFactory.produceCloth();
    }
}
