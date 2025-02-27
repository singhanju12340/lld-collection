package com.machineCode.inmemory_cache;

/**
 * @author anju
 * @created on 25/02/25 and 7:20 PM
 */
public class FastCacheDemo {

    public static void main(String[] args) {
        FastLRUCache<String, String> myFastCache = FastLRUCache.getInstance();
        myFastCache.put("Key1", "Value1");
        myFastCache.put("Key2", "Value2");
        System.out.println(myFastCache.get("key2")); // return null
        System.out.println(myFastCache.get("Key2")); // return value for key2

        myFastCache.put("Key3", "Value3");
        myFastCache.put("Key4", "Value4");
        System.out.println(myFastCache.get("Key1"));




    }
}
