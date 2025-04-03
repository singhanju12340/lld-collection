package com.machineCode.threadsImpls;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anju
 * @created on 21/03/25 and 6:54 PM
 */
public class TestReenterantLock {
    private final ReentrantLock lock = new ReentrantLock();
    private  static int counter = 0;

    static Executor executor = Executors.newFixedThreadPool(5);

    public void updateCounter() {
        if (lock.tryLock()) { // non-blocking attempt
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        } else {
            // fallback: perhaps log or try an alternative approach
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            executor.execute(()->{
                new TestReenterantLock().updateCounter();
            });
        }

        System.out.println(counter);


    }
}
