package com.matty.ex_7;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
