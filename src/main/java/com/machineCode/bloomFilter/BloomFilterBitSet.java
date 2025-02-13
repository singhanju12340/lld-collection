package com.machineCode.bloomFilter;

import java.util.BitSet;

/**
 * @author anju
 * @created on 14/01/25 and 8:37 PM
 */

// encapsulate bitarray implementation

public class BloomFilterBitSet implements BloomFilterArray{

    public final BitSet bitSet;
    public final int size;

    public BloomFilterBitSet(int size) {
        this.size = size;
        this.bitSet = new BitSet(size);
    }

    public void set(Integer value){
        bitSet.set(value);
    }

    public Boolean get(Integer value){
       return bitSet.get(value);
    }

    public int getSize() {
        return size;
    }




}
