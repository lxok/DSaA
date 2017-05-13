package jdkclass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by nick on 2017/4/21.
 */
public class DynamicProxy implements InvocationHandler {
    Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        before();
        Object res = method.invoke(target, args);
        after();
        return res;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        Greeting gr = new GreetingImpl();
        DynamicProxy pro = new DynamicProxy(gr);
        Greeting grProxy = (Greeting) Proxy.newProxyInstance(gr.getClass().getClassLoader(), gr.getClass().getInterfaces(), pro);
        grProxy.say("hi");
    }
}
