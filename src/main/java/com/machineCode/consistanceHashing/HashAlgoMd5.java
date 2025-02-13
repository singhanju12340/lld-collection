package com.machineCode.consistanceHashing;

import java.security.MessageDigest;

/**
 * @author anju
 * @created on 14/01/25 and 7:56 PM
 */
public class HashAlgoMd5 implements HashAlgoStrategy {

    private final MessageDigest md;

    public HashAlgoMd5(MessageDigest md) {
        this.md = md;
    }


    @Override
    public int getHashSlot(String key) {
        md.reset();
        md.update(key.getBytes());
        byte[] digest = md.digest();
        int hash = ( (digest[3] & 0xFF) << 24) |
                ((digest[2] & 0xFF) << 16) |
                ( (digest[1] & 0xFF) << 8) |
                ( (digest[0] & 0xFF));
        return hash;
    }
}
