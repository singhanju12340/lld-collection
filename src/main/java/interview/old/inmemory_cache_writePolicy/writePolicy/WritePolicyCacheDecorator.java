package interview.old.inmemory_cache_writePolicy.writePolicy;



import interview.old.inmemory_cache_writePolicy.FastCache;
import interview.old.inmemory_cache_writePolicy.PersistenceStorage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author anju
 * @created on 12/03/25 and 11:01 PM
 */
public class WritePolicyCacheDecorator<K,V> implements FastCache<K,V> {

    private final FastCache<K, V> fastCache;
    private final WritePolicy policy;
    private final PersistenceStorage<K, V> database; // its DB
    private final ScheduledExecutorService scheduler;

    public WritePolicyCacheDecorator(FastCache<K, V> fastCache,
                                     WritePolicy policy,
                                     PersistenceStorage<K, V> database) {
        this.fastCache = fastCache;
        this.policy = policy;
        this.database = database;
        // For WRITE_BACK, we schedule asynchronous flushes.
        this.scheduler = (policy == WritePolicy.WRITE_BACK)
                ? Executors.newSingleThreadScheduledExecutor()
                : null;
    }

    @Override
    public void put(K key, V value) {
        fastCache.put(key, value);

        if (policy == WritePolicy.WRITE_THROUGH) {
            database.write(key, value); // write to persistence store along with writing in cache
        } else if (policy == WritePolicy.WRITE_BACK) {
            scheduler.schedule(() -> {
                V currentValue = fastCache.get(key);
                if (currentValue != null) { // Check if still in cache.
                    database.write(key, currentValue);
                }
            }, 100, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public V get(K key) {
        V value = fastCache.get(key);
        if (value == null && database != null) {
            value = database.get(key);
            if (value != null) {
                put(key, value); // update cache to update cache eviction policy data
            }
        }
        return value;
    }

    @Override
    public void remove(K key) {
        fastCache.remove(key);
    }

    public void shutDown() {
        if(scheduler != null){
            scheduler.shutdown();
        }
    }


    public void load(){
        // load full list from database to cache
    }
}
