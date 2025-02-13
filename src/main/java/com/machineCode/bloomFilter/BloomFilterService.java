package com.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 10:36 PM
 */
public interface BloomFilterService {

    void add(String data);
    public boolean mightExist(String data);

}
