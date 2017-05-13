package test;

import com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmException;

/**
 * Created by nick on 2017/4/7.
 */
public class Test {

    static void testStatic() {
        System.out.println("father's static method");
    }

    {
        method();
    }

    public void method() {
        System.out.println("father's method");
    }

    public static void main(String[] args) {
        TestSon ts = new TestSon();
        ts.method();
    }
}

class TestSon extends Test {
    {
        testStatic();
    }

    static void testStatic() {
        System.out.println("son's static method");
    }

    public void method() {
        System.out.println("son's method");
    }
}

