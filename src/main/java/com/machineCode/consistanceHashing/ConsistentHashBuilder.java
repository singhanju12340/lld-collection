package com.machineCode.consistanceHashing;

/**
 * @author anju
 * @created on 14/01/25 and 7:49 PM
 */
public class ConsistentHashBuilder {

    public int replicaCount = 3;
    public int maxHashCount = 1000;
    public HashAlgoStrategy hashAlgo = new HashAlsoMod(maxHashCount);
    public ConsistentHasRing consistentHasRing;

    public ConsistentHashBuilder setReplicaCount(int count){
        this.replicaCount = count;
        return this;
    }

    public ConsistentHashBuilder setMaxHashCount(int count){
        this.maxHashCount = count;
        return this;
    }

    public ConsistentHashBuilder setConsistenceHashingService( HashAlgoStrategy hashAlgo){
        this.hashAlgo = hashAlgo;
        return this;
    }

    public ConsistentHashBuilder setConsistenceHashingRing( ConsistentHasRing ring){
        this.consistentHasRing = ring;
        return this;
    }

    public ConsistentHashingImpl build() {
        return new ConsistentHashingImpl(consistentHasRing, replicaCount, hashAlgo);
    }



}
