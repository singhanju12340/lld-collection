package interview.inmemory_cache_writePolicy;

/**
 * @author anju
 * @created on 03/03/25 and 10:22 AM
 */
public class CacheKey<K> {
    private K key;
    private long lastAccessedTime;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof CacheKey))
            return false;
        CacheKey other = (CacheKey) obj;
        return key != null ? key.equals(other.key) : other.key == null;
    }


    @Override
    public String toString() {
        return "CacheKey{key='" + key + "', lastUpdate=" + lastAccessedTime + "}";
    }
}
