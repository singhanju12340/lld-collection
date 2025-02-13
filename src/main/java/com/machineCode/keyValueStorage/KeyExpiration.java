package com.machineCode.keyValueStorage;

/**
 * @author anju
 * @created on 15/01/25 and 11:04 PM
 */
public class KeyExpiration<K> {

    K key;
    long expiration;

    public KeyExpiration(K key, long erpiration) {
        this.key = key;
        this.expiration = erpiration;
    }
}
