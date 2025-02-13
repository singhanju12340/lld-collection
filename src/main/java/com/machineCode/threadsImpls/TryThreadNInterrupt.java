package com.machineCode.threadsImpls;

/**
 * @author anju
 * @created on 28/11/24 and 2:48 PM
 */
public class TryThreadNInterrupt {

    public static void main(String[] args) {
        // Create a new thread
        Thread workerThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + ": Worker thread is running...");
                    // Simulate work by sleeping
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " :Worker thread was interrupted during sleep.");
                // Preserve the interrupt status
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread() + " :Worker thread is exiting.");
        });

        // Start the thread
        workerThread.start();

        // Allow the thread to run for a few seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Interrupt the worker thread
        System.out.println("Main thread is interrupting the worker thread.");
        workerThread.interrupt();
    }
}

