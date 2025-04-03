package interview.old.inmemory_cache_writePolicy;



/**
 * @author anju
 * @created on 25/02/25 and 7:20 PM
 */
public class FastCacheDemo {

    public static void main(String[] args) throws InterruptedException {
        FastLRUCache<String, String> myFastCache = FastLRUCache.getInstance();
        myFastCache.put("Key1", "Value1");
        myFastCache.put("Key2", "Value2");
        System.out.println(myFastCache.get("key2")); // return null
        System.out.println(myFastCache.get("Key2")); // return value for key2

        myFastCache.put("Key3", "Value3");
        myFastCache.put("Key4", "Value4");
        System.out.println(myFastCache.get("Key1"));


        myFastCache.removeExpiredKeys();

        Thread.sleep(10);
        System.out.println( myFastCache.get("Key3"));



    }


}
