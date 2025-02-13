package com.tekion.aec.cp.imsjobs.controller.machineCode.bloomFilter;

/**
 * @author anju
 * @created on 14/01/25 and 8:35 PM
 */
public interface HashAlgoStrategy {
    public Integer getHash(String key,int seed, int filterSize);

}
