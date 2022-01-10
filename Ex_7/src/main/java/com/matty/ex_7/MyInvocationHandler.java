package com.matty.ex_7;

import com.matty.ex_7.util.AnimalUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        AnimalUtil util = new AnimalUtil();
        util.start();
        Object returnValue = method.invoke(obj, args);
        util.end();
        return returnValue;
    }
}
