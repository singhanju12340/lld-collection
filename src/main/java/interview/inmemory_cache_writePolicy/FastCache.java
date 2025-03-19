package interview.inmemory_cache_writePolicy;

/**
 * @author anju
 * @created on 25/02/25 and 6:39 PM
 */
public interface FastCache<K,V>{
    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
}
