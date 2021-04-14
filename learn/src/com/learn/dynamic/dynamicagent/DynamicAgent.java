package com.learn.dynamic.dynamicagent;

import com.learn.dynamic.staticagent.ClothFactory;
import com.learn.dynamic.staticagent.LiningClothFactory;

/**
 * 实现动态代理，需要解决的问题
 * 1、如果根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 2、当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */


public class DynamicAgent {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        proxyInstance.getHobby();
        proxyInstance.eat("麻辣烫");

        System.out.println("00000000000000000000");
        LiningClothFactory liningClothFactory = new LiningClothFactory();

        ClothFactory proxyFactory = (ClothFactory) ProxyFactory.getProxyInstance(liningClothFactory);
        proxyFactory.produceCloth();
    }
}
