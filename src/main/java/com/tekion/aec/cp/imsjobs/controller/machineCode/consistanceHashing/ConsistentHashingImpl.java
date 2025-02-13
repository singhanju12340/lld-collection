package com.tekion.aec.cp.imsjobs.controller.machineCode.consistanceHashing;

/**
 * @author anju
 * @created on 14/01/25 and 10:32 AM
 */
public class ConsistentHashingImpl implements ConsistenceHashingService{
    private ConsistentHasRing ring;
    private int replicas;
    private HashAlgoStrategy hashAlgo;


    public ConsistentHashingImpl(ConsistentHasRing ring, int replicas, HashAlgoStrategy hashAlgo) {
        this.ring = ring;
        this.replicas = replicas;
        this.hashAlgo = hashAlgo;
    }

    // Add a node to the hash ring with virtual nodes
    @Override
    public void addNode(String ipAddress) {
        for(int i=0;i<replicas;i++){
            String VirtualReplicaNode = ipAddress + "#" + i;
            int hash = hashAlgo.getHashSlot(VirtualReplicaNode);
            ring.addInRing(hash, VirtualReplicaNode);
            System.out.println("Added virtual node " + VirtualReplicaNode + " with hash " + hash);
        }
    }


    // Remove a node and its virtual nodes from the hash ring
    @Override
    public void removeNode(String ipAddress) {
        for(int i=0;i<replicas;i++){
            String VirtualReplicaNode = ipAddress + "#" + i;
            int hash = hashAlgo.getHashSlot(VirtualReplicaNode);
            ring.removeFromRing(hash);
            System.out.println("Removed virtual node " + VirtualReplicaNode + " with hash " + hash);
        }
    }



    @Override
    public String searchNode(String key) {
        if (this.ring.isRingEmpty()) {
            return null;
        }
        int hash = hashAlgo.getHashSlot(key);
        return this.ring.search(hash);
    }
}
