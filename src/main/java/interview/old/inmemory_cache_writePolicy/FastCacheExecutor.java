package interview.old.inmemory_cache_writePolicy;


import interview.old.inmemory_cache_writePolicy.writePolicy.WritePolicy;
import interview.old.inmemory_cache_writePolicy.writePolicy.WritePolicyCacheDecorator;

/**
 * @author anju
 * @created on 12/03/25 and 11:27 PM
 */
public class FastCacheExecutor {

    public static void main(String[] args) throws InterruptedException {

        PersistenceStorage<String, String> persistenceStorage = new PersistenceStorage<>();
        FastLRUCache<String, String> myFastCache = FastLRUCache.getInstance();

        FastCache<String, String> writePolicyCache = new WritePolicyCacheDecorator<>(myFastCache, WritePolicy.WRITE_THROUGH, persistenceStorage);


        writePolicyCache.put("Key1", "Value1");
        writePolicyCache.put("Key2", "Value2");


        System.out.println(writePolicyCache.get("key2")); // return null
        System.out.println(writePolicyCache.get("Key2")); // return value for key2

        writePolicyCache.put("Key3", "Value3");
        writePolicyCache.put("Key4", "Value4");
        System.out.println(writePolicyCache.get("Key1"));


        Thread.sleep(100000);
        System.out.println( writePolicyCache.get("Key3"));




    }
}
