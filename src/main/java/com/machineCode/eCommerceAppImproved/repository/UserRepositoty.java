package com.machineCode.eCommerceAppImproved.repository;

import com.machineCode.eCommerceAppImproved.model.AmazonUser;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 23/04/25 and 7:33 PM
 */

@Data
public class UserRepositoty {
    Map<String, AmazonUser> buyers = new ConcurrentHashMap<>();



    public void addUSer(AmazonUser user){
        buyers.put(user.getId(), user);
    }

    public AmazonUser getUSer(String userId){
        return buyers.get(userId);
    }

}
