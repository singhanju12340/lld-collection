package com.machineCode.threadsImpls.customThreadPool;

import com.machineCode.threadsImpls.customThreadPool.CustomThreadPool;

/**
 * @author anju
 * @created on 21/01/25 and 2:13 PM
 */
public class ThreadPoolDriver {
    public static void main(String[] args) throws InterruptedException {
        // Example usage
        CustomThreadPool threadPool = new CustomThreadPool(3);

        // Submit tasks
        for (int i = 1; i <= 100000; i++) {
            int taskNumber = i;
            threadPool.execute(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000); // Simulate task execution time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the thread pool
//        threadPool.shutdown();
    }
}
