package xyz.fanchw.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProxyTest {
    private Enhancer enhancer = new Enhancer();

    @Test
    public void cglibHelloWorld() {
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib start......");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("cglib end......");
                return result;
            }
        });
        Hello hello = (Hello) enhancer.create();
        hello.sayHelloWorld();
    }

    @Test
    public void jdkProxy() {
        Lock lock=new ReentrantLock();
        HelloWorldHandler helloWorldHandler = new HelloWorldHandler(new Hello());
        One one = (One) new HelloWorldHandler(new Hello()).proxyInstance();
        one.sayHelloWorld();
    }

    @Test
    public void cglibFixed() {
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "cglib fixed";
            }
        });
        Hello hello= (Hello) enhancer.create();
        System.out.println("hello.test() = " + hello.test());
        System.out.println("hello.toString() = " + hello.toString());
    }
}
