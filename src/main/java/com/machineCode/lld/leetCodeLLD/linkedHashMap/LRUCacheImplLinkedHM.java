package com.machineCode.lld.leetCodeLLD.linkedHashMap;

import java.util.LinkedHashMap;

public class LRUCacheImplLinkedHM {

    LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>(10, 0.75f ,true); // enable access = true, maintains accecss order

    public String getEvictionKey() {
        // get first key ion the linked hashmap
        return linkedHashMap.keySet().iterator().next();
    }

    public void updateOnAccess(String key) {
        linkedHashMap.put(key, true);

    }

    public void updateOnInsert(String key) {
        linkedHashMap.put(key, true);
    }
}
