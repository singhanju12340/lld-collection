package com.tekion.aec.cp.imsjobs.controller.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 10:31 PM
 */
public class BloomFilterDriver {


    public static void main(String[] args) {
        BloomFilterServiceImpl bloomFilter = new BloomFilterBuilder()
                .setBloomFilterArray(new BloomFilterBitSet(100))
                .setHashAlgo(new HashAlgoMod())
                .setNumberOfHashFun(5)
                .build();

        bloomFilter.add("apple");
        bloomFilter.add("orange");

        System.out.println(bloomFilter.mightExist("apple"));
        System.out.println(bloomFilter.mightExist("pink"));
        System.out.println(bloomFilter.mightExist("blue"));


    }




}
