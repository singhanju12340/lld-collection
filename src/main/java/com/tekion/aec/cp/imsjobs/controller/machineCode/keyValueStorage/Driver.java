package com.tekion.aec.cp.imsjobs.controller.machineCode.keyValueStorage;

/**
 * @author anju
 * @created on 15/01/25 and 11:32 PM
 */
public class Driver {



    public static void main(String[] args) throws InterruptedException {
        InMemoryKeyValueStoreImpl<String, Object> inMemoryKeyValueStore = new InMemoryKeyValueStoreBuilder<String, Object>()
                .setStorageManager(new StorageManager<>())
                .setTtlManager(new TTLManager<String>(1000))
                .setScheduler()
                .build();

        inMemoryKeyValueStore.put("asdas", 1234235);
        inMemoryKeyValueStore.put("asdas2", 1234235);
        inMemoryKeyValueStore.put("asdas3", 1234235);

        inMemoryKeyValueStore.schedule();

        Thread.sleep(1000);

        System.out.println(inMemoryKeyValueStore.get("asdas"));
        inMemoryKeyValueStore.shutdown();
    }
}
