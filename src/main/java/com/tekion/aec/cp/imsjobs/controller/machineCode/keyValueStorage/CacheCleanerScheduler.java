package com.tekion.aec.cp.imsjobs.controller.machineCode.keyValueStorage;

import java.util.concurrent.*;

/**
 * @author anju
 * @created on 15/01/25 and 11:52 PM
 */
public class CacheCleanerScheduler {
    private final ScheduledExecutorService scheduler;

    public CacheCleanerScheduler(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }

    public void createScheduler(Runnable task){
        scheduler.scheduleAtFixedRate(task, 1, 1 , TimeUnit.MILLISECONDS);
    }

    public void shutDown(){
        scheduler.shutdown();
    }
}
