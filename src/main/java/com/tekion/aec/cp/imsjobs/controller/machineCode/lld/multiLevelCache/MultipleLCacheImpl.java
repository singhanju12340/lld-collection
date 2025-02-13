package com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache;

import com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.cache.CacheServiceLevelImpl;
import com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.cache.MultiLevelCacheServiceImpl;
import com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.eviction.EvictionLFUServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author anju
 * @created on 03/01/25 and 10:27 PM
 */
public class MultipleLCacheImpl {

    public static void main(String[] args) {
        List<CacheServiceLevelImpl<String, Integer>> cacheServiceLevels = new ArrayList<>();
        cacheServiceLevels.add(new CacheServiceLevelImpl<>(new HashMap<String, Integer>(), 2, new EvictionLFUServiceImpl<>(), "L1"));
        cacheServiceLevels.add(new CacheServiceLevelImpl<>(new HashMap<String, Integer>(), 2, new EvictionLFUServiceImpl<>(), "L2"));
        cacheServiceLevels.add(new CacheServiceLevelImpl<>(new HashMap<String, Integer>(), 2, new EvictionLFUServiceImpl<>(), "L3"));

        MultiLevelCacheServiceImpl<String, Integer> multiLevelCacheService = new MultiLevelCacheServiceImpl<>(cacheServiceLevels);
        multiLevelCacheService.add("A", 1);
        multiLevelCacheService.add("B", 2);
        multiLevelCacheService.add("C", 3);
        multiLevelCacheService.add("D", 4);

    }
}
