package com.machineCode.keyValueStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 15/01/25 and 10:59 PM
 */

// for encapsulating ttl expiration handling
public class TTLManager<K> {

    private final PriorityQueue<KeyExpiration<K>> ttlQueue;
    ConcurrentHashMap<K, Long> expirationMap;
    Long TTL;

    public TTLManager( long TTL) {
        this.ttlQueue = new PriorityQueue<>(Comparator.comparingLong(key->key.expiration));
        expirationMap = new ConcurrentHashMap<>();
        this.TTL = TTL;
    }

    public synchronized void addTtlEntry(K key, long expirationTime){
        long expireAt = System.currentTimeMillis() + expirationTime;
        ttlQueue.add(new KeyExpiration<>(key, expireAt));
        expirationMap.put(key, expireAt);
    }



    public K getExpiredKey() {

        if (ttlQueue.peek().expiration <= System.currentTimeMillis()) {
            return ttlQueue.peek().key;
        }
        return null;

    }

    public synchronized void removeKey(K key){
        this.ttlQueue.remove(key);
        this.expirationMap.remove(key);
    }


    public Boolean isEmpty(){
        return this.ttlQueue.isEmpty();
    }

    public List<K> getExpiredKeys(){
        List<K> expiredRemoved = new ArrayList<>();
        int count = ttlQueue.size();
        while (count >=0){
            if((ttlQueue.peek().expiration <= System.currentTimeMillis())){
                expiredRemoved.add(ttlQueue.peek().key);
                count--;
            }else{
                break;
            }
        }
        return expiredRemoved;
    }





}
