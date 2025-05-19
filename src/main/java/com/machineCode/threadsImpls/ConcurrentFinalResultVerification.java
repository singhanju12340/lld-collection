package com.machineCode.threadsImpls;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class ConcurrentFinalResultVerification {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Thread t1 = new Thread(()->{
            map.put("key1", "value1");
            System.out.println(map.get("key1"));
            try {
                Thread.sleep(1000);
//                System.out.println(map.get("key1"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            map.put("key1", "value2");
            System.out.println(map.get("key1"));

        });
        t1.start();

        t2.start();




        // result is
        // varying value 2, value2 / value 1, value 2 / value 2, value1
    }
}
