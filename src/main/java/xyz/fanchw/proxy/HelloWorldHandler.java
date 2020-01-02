package xyz.fanchw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloWorldHandler implements InvocationHandler {
    private Object hello;

    public HelloWorldHandler(Object hello) {
        this.hello = hello;
    }

    public Object proxyInstance() {
        return Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Proxy Start......");
        Object result = method.invoke(this.hello, args);
        System.out.println("JDK Proxy End......");
        return result;
    }
}
