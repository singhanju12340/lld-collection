package com.machineCode.inmemory_cache;

/**
 * @author anju
 * @created on 25/02/25 and 6:54 PM
 */
public class CacheValue<V> {
    private V value;
    private long lastAccessedTime;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }
}
