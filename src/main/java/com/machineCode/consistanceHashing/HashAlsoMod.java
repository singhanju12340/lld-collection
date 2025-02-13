package com.machineCode.consistanceHashing;

/**
 * @author anju
 * @created on 14/01/25 and 7:59 PM
 */
public class HashAlsoMod implements HashAlgoStrategy {
    private int hashSlotSize;

    public HashAlsoMod(int size) {
        this.hashSlotSize = size;
    }

    @Override
    public int getHashSlot(String key) {
        return Math.abs(key.hashCode()) % hashSlotSize;
    }
}
