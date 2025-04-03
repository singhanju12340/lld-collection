package com.machineCode.threadsImpls;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anju
 * @created on 21/03/25 and 1:26 PM
 */
public class ConcurrentHashMapDemo {

    private static final int NUM_THREAD = 5;
    private static final int NUM_INSERT = 100;
    static HashMap<String, Integer> map = new HashMap<>();

    static ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);
        for(int i=0;i< NUM_THREAD; i++){
            executorService.execute(insert());
        }

        executorService.shutdown();

        if(!executorService.isTerminated()){
            Thread.sleep(1000);
        }

//        System.out.println(map.size());
        System.out.println(map2.size());

    }

    private static Runnable insert(){
        return ()->{
            Long currentTime = System.currentTimeMillis();
            for(int i=0;i<NUM_INSERT;i++){
                map2.put(i+Thread.currentThread().getName(), i);
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("time taken by 1 thread "+ (endTime-currentTime));

        };
    }
}
