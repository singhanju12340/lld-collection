package com.tekion.aec.cp.imsjobs.controller.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 8:48 PM
 */

public class HashAlgoMod implements HashAlgoStrategy {

    @Override
    public Integer getHash(String key, int seed, int filterSize) {
       return Math.abs((key+seed).hashCode()) % filterSize;
    }

}
