package com.machineCode.threadsImpls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Create5Thread {
    static ExecutorService executorService = Executors.newFixedThreadPool(5);


    // newVirtualThreadPerTaskExecutor create light weight threads that are managed by the JVM, allowing for a large number of concurrent tasks without the overhead of traditional threads.
// and others executors are added in obs
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        // other ways of creating threads

        for(int i=0;i<5;i++){
            executorService.execute(new ABC());
        }

        executorService.shutdown();


        // using thread class
        ABC abc = new ABC();

        Thread t1 = new Thread(abc);
        t1.start();
    }




    static class ABC implements Runnable{
        @Override
        public void run() {
            System.out.println("sadasdas" + Thread.currentThread().getName());
        }
    }
}
