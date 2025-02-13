package com.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 9:11 PM
 */
public interface BloomFilterArray {

    public void set(Integer value);

    public Boolean get(Integer value);

    public int getSize();
}
