package com.learn.dynamic.staticagent;

/**
 * @author windyStreet
 * @codetime 2021-04-14 11:07
 */
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;// 用代理类的对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备工作...");
        factory.produceCloth();
        System.out.println("代理工厂手续工作...");
    }
}
