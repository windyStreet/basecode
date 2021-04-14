package com.learn.dynamic.dynamicagent;

import java.lang.reflect.Proxy;

/**
 *
 */

class ProxyFactory {
    // 调用此方法，返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj); //绑定对象到 MyInvocationHandler
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}
