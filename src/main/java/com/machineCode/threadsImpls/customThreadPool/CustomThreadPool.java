package com.machineCode.threadsImpls.customThreadPool;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author anju
 * @created on 21/01/25 and 12:34 PM
 */
public class CustomThreadPool {


    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] workers;
    private volatile boolean isStopped = false;

    // Constructor
    public CustomThreadPool(int numThreads) throws InterruptedException {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new WorkerThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            workers[i] = new WorkerThread(taskQueue);
            workers[i].start();
        }

        Thread.sleep(10000);


    }

    // Submit a task to the pool
    public void execute(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("Thread pool is stopped");
        }
        taskQueue.add(task);
    }


    // Gracefully stop the thread pool
    public void shutdown() {
        isStopped = true;
        for (WorkerThread worker : workers) {
            worker.stopWorker();
        }
    }



}
