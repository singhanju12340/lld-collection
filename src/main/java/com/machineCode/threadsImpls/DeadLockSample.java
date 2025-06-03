package com.machineCode.threadsImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anju
 * @created on 02/04/25 and 5:52 PM
 */
public class DeadLockSample {

    /***
     *  Creating a deadlock involves two or more threads waiting for each other to release a resource they need.
     * Create two threads, each trying to lock two resources in a different order
     *
     * Ensure that one thread locks resource A first and then tries to lock resource B, while the other thread locks resource B first and then tries to lock resource A
     *
     * This will result in a situation where each thread is waiting for the other to release the resource it needs, causing a deadlock
     */

    private static List<String> array = new ArrayList<>();
    private static List<String> array2 = new ArrayList<>();

     static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                array.add("anju");
                System.out.println("T1 aquired lock1");
                try {
                    Thread.sleep(100);
                    lock2.lock();
                    array2.add("anju");
                    System.out.println("T1 aquired lock2");


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                lock1.lock();
                lock2.unlock();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock2.lock();
                array2.add("anju t2");
                System.out.println("T2 aquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                lock1.lock();
                array.add("anju t2 ");
                System.out.println("T2 aquired lock1");


                lock2.unlock();
                lock1.unlock();
            }
        });

        t1.start();
//        Thread.sleep(10000);  // no dead loack when gap between thread start is more than 100ms
        t2.start();


        System.out.println("Main thread: Waiting for threads to complete (they might deadlock)...");
        if (t1.isAlive() && t2.isAlive()) {
            System.out.println("\n💥 Deadlock likely occurred!");
            System.out.println("Thread-1 state: " + t1.getState());
            System.out.println("Thread-2 state: " + t2.getState());
            System.out.println("Thread-1 is likely holding lockA and waiting for lockB.");
            System.out.println("Thread-2 is likely holding lockB and waiting for lockA.");
            System.out.println("You may need to manually stop the program (e.g., Ctrl+C or stop button in IDE).");
        } else if (t1.isAlive()) {
            System.out.println("\nThread-1 is still alive. State: " + t1.getState());
        } else if (t2.isAlive()) {
            System.out.println("\nThread-2 is still alive. State: " + t2.getState());
        } else {
            System.out.println("\nBoth threads completed (this is unexpected if deadlock was intended and timing was right).");
        }

        // stop thread by manually call thread join after timeout

        System.exit(1);
    }
}
