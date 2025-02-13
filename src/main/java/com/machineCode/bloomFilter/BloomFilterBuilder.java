package com.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 8:51 PM
 */
public class BloomFilterBuilder {

    BloomFilterArray bloomFilterArray;
    HashAlgoStrategy hashAlgo;
    int numberOfHashFun;

    public BloomFilterBuilder setBloomFilterArray(BloomFilterBitSet bloomFilterArray) {
        this.bloomFilterArray = bloomFilterArray;
        return this;
    }

    public BloomFilterBuilder setHashAlgo(HashAlgoStrategy hashAlgo) {
        this.hashAlgo = hashAlgo;
        return this;
    }

    public BloomFilterBuilder setNumberOfHashFun(int numberOfHashFun) {
        this.numberOfHashFun = numberOfHashFun;
        return this;
    }

    public BloomFilterServiceImpl build(){
        return new BloomFilterServiceImpl(bloomFilterArray, hashAlgo, numberOfHashFun);
    }
}
