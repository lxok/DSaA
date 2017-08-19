package jdkclass;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by nick on 2017/5/16.
 */
public class TestCyclicBarrier {
    public void task(int nTread) {
        final CyclicBarrier cb = new CyclicBarrier(nTread, new Runnable() {
            @Override
            public void run() {
                System.out.println("all are finished");
            }
        });
        for (int i = 0; i < nTread; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int sum = 0;
                        for (int j = 0; j < 100000; j++) {
                            sum += j;
                        }
                        cb.await();
                    } catch (Exception e) {

                    }
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) {
        TestCyclicBarrier tc = new TestCyclicBarrier();
        tc.task(10);
    }
}
