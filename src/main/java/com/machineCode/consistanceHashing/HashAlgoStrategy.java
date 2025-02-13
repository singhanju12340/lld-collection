package com.machineCode.consistanceHashing;

/**
 * @author anju
 * @created on 14/01/25 and 7:55 PM
 */
public interface HashAlgoStrategy {
    public int getHashSlot(String key);
}
