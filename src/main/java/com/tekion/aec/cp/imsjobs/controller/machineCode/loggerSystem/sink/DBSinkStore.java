package com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.sink;

import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anju
 * @created on 01/02/25 and 10:54 AM
 */
public class DBSinkStore implements SinkProcessor{

    LinkedHashSet<String> data;  // queue maintaining data ordering

    ExecutorService executor = Executors.newFixedThreadPool(5);


    // assumed message is stored in DB
    private static DBSinkStore dbSinkStore;

    public  static DBSinkStore getInstance(){
        if(dbSinkStore == null)
        {
            dbSinkStore = new DBSinkStore();
            dbSinkStore.data = new LinkedHashSet<>(10);
        }
        return dbSinkStore;
    }


    @Override
    public void add(String message) {
        // run  multiple  threads to connect to DB and store


        this.dbSinkStore.data.add(message);  // this add message to queue

        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("DB sink message " + message);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

        );

    }

    @Override
    public void clear() {
        this.dbSinkStore.data = new LinkedHashSet<>();
    }

    @Override
    public void close() {
        dbSinkStore = null;
    }
}
