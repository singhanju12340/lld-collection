package com.tekion.aec.cp.imsjobs.controller.machineCode.consistanceHashing;

import java.security.NoSuchAlgorithmException;

/**
 * @author anju
 * @created on 13/01/25 and 8:49 PM
 */

public class CHDriver {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ConsistentHashingImpl consistenceHashing = new ConsistentHashBuilder()
                .setConsistenceHashingRing(new ConsistentHasRing())
                .setMaxHashCount(1000)
                .setReplicaCount(3)
                .setConsistenceHashingService(new HashAlsoMod(1000)).build();

        consistenceHashing.addNode("server1");
        consistenceHashing.addNode("server2");
        consistenceHashing.addNode("server3");

        System.out.println("key1: is present on server: " + consistenceHashing.searchNode("key1"));
        System.out.println("key67890: is present on server: " + consistenceHashing.searchNode("key67890"));

        consistenceHashing.removeNode("server1");
        System.out.println("After removing server1");

    }
}
