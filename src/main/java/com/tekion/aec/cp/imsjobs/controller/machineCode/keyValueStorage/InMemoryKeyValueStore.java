package com.tekion.aec.cp.imsjobs.controller.machineCode.keyValueStorage;

import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 15/01/25 and 10:52 PM
 */
public interface InMemoryKeyValueStore<K, V> {

    public void put(K key, V value);

    public V get(K key);

    public void remove(K key);

    public void removeLatestExpired();


    public void removeExpired();

    public void putAll(Map<K , V > entries);

    public  Map<K, V>  getAll(List<K> key);

}
