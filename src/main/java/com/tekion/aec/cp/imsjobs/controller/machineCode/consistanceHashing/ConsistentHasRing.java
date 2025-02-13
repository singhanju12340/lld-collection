package com.tekion.aec.cp.imsjobs.controller.machineCode.consistanceHashing;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author anju
 * @created on 14/01/25 and 8:06 PM
 */

// encapsulate ring implementation
public class ConsistentHasRing {

    private TreeMap<Integer, String> ring;

    public ConsistentHasRing() {
        this.ring = new TreeMap<>();
    }

    public void addInRing(Integer key, String value){
        this.ring.put(key, value);
    }

    public void removeFromRing(Integer key){
        this.ring.remove(key);
    }

    public Boolean isRingEmpty(){
        return ring.isEmpty();
    }

    public String search(int key){
        Map.Entry<Integer, String> resultNode = ring.ceilingEntry(key);

        if(resultNode == null){
            return ring.firstEntry().getValue();
        }

        return resultNode.getValue();
    }



}
