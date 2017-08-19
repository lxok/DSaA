package jdkclass;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nick on 2017/5/16.
 */
public class TestCountDownLatch {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        try {
                            task.run();
                        }
                        finally {
                            end.countDown();
                        }
                    } catch (InterruptedException ie) {

                    }
                }
            });
            t.start();
        }
        long stime = System.nanoTime();
        start.countDown();
        end.await();
        long etime = System.nanoTime();
        return etime - stime;
    }

    public static void main(String[] args) throws InterruptedException {
        TestCountDownLatch tc = new TestCountDownLatch();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 100000; i++) {
                    sum += i;
                }
            }
        };
        long res = tc.timeTasks(10, r);
        System.out.println(res);
    }
}
