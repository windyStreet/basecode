package com.learn.dynamic.dynamicagent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author windyStreet
 * @codetime 2021-04-14 11:08
 */
class MyInvocationHandler implements InvocationHandler {

    private Object obj;  // 需要使用被代理类的对象进行复制

    // 当通过代理类的对象，调用方法a时，就会自动调用如下的方法 invoke()
    // 将被代理类要执行的方法a的功能就声明在invoke() 中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        // method 即为代理类对象调用的方法，此方法也就作为被代理类对象调用的方法
        // obj:被代理对象
        Object returnObj = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中的invoke()的返回值

        humanUtil.method2();
        return returnObj;
    }

    public void bind(Object obj) {
        this.obj = obj;
    }
}
