package com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.cache;

import com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.eviction.EvictionData;

import java.util.List;

/**
 * @author anju
 * @created on 03/01/25 and 7:38 PM
 */
public class MultiLevelCacheServiceImpl<K, V> implements CacheService<K, V>{
    List<CacheServiceLevelImpl<K, V>> cacheLevels;

    public MultiLevelCacheServiceImpl(List<CacheServiceLevelImpl<K,V>> cacheLevels) {
        this.cacheLevels = cacheLevels;
    }

    @Override
    public V get(K key) {
        for (CacheServiceLevelImpl<K, V> cacheServiceLevel: cacheLevels) {
            if(cacheServiceLevel.dataStore.containsKey(key)){
                promoteToHigherLevels(key, cacheServiceLevel.dataStore.get(key)); // as key is access recently move it to latest cache
                return cacheServiceLevel.dataStore.get(key);
            }
        }
        return null; // cache miss
    }

    @Override
    public EvictionData add(K key, V value) {
        propagateAdd(key, value, 0);
        return null; // as there is no eviction data
    }

    private void propagateAdd(K key, V value, int levelIndex) {
        if (levelIndex >= cacheLevels.size()) return;

        CacheServiceLevelImpl<K, V> currentLevel = cacheLevels.get(levelIndex);
        EvictionData<K, V> evictionData = currentLevel.add(key, value);

        if(evictionData !=null){
            propagateAdd(evictionData.getKey(), evictionData.getValue(), levelIndex + 1);
        }
    }



    private void promoteToHigherLevels(K key, V value) {
        CacheServiceLevelImpl level = cacheLevels.get(0);
        level.add(key, value);

    }

}
