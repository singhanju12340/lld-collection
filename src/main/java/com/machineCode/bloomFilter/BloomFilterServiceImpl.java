package com.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 8:35 PM
 */
public class BloomFilterServiceImpl implements BloomFilterService{

    BloomFilterArray bloomFilterArray;
    HashAlgoStrategy hashAlgo;
    int noOfHashFunction;
    int size;

    public BloomFilterServiceImpl(BloomFilterArray bloomFilterArray, HashAlgoStrategy hashAlgo, int noOfHashFunction) {
        this.bloomFilterArray = bloomFilterArray;
        this.hashAlgo = hashAlgo;
        this.noOfHashFunction = noOfHashFunction;
    }


    @Override
    public void add(String data) {
        for(int i=0;i<noOfHashFunction;i++){
            int hasKey = this.hashAlgo.getHash(data, i, this.bloomFilterArray.getSize());
            bloomFilterArray.set(hasKey);
        }
    }

    @Override
    public boolean mightExist(String data) {

        // if filter value is true for all variations of key created from given key, return true to reduce false positive percentage
        for(int i=0;i<noOfHashFunction;i++){
            int hashKey = this.hashAlgo.getHash(data, i, this.bloomFilterArray.getSize());
            if(!bloomFilterArray.get(hashKey))
                return false;
        }
        return true;
    }
}
