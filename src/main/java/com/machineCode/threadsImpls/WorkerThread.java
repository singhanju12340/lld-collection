package com.machineCode.threadsImpls;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

/**
 * @author anju
 * @created on 21/01/25 and 2:13 PM
 */
class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isStopped = false;

    public WorkerThread(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @SneakyThrows
    public void run() {
        System.out.println("workeer has started");

        while (!isStopped) {
            System.out.println("workeer has started, waiting for data from queue");

            try {
                // Fetch a task from the queue and execute it
                Runnable task = this.taskQueue.take();
                task.run();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopWorker() {
        isStopped = true;
        this.interrupt(); // Interrupt the thread if it's waiting for tasks
    }
}
