package jdkclass;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by nick on 2017/5/16.
 */
public class TestSemaphore<T> {
    private final Set<T> set;
    private final Semaphore sem;
    private int a;

    public TestSemaphore(int bound) {
        set = new HashSet();
        sem = new Semaphore(bound);
    }

    public boolean add(T object) {
        try {
            sem.acquire();
            boolean res = false;
            try {
                res = set.add(object);
                return res;
            } finally {
                if (!res) {
                    sem.release();
                }
            }
        } catch (InterruptedException ie) {

        }
        return false;
    }

    public boolean remove(T object) {
        boolean res = set.remove(object);
        if (res) {
            sem.release();
        }
        return res;
    }
}
