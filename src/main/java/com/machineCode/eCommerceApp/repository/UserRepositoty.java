package com.machineCode.eCommerceApp.repository;

import com.machineCode.eCommerceApp.model.AmazonUser;
import lombok.Data;

import java.util.HashMap;

/**
 * @author anju
 * @created on 23/04/25 and 7:33 PM
 */

@Data
public class UserRepositoty {
    HashMap<String, AmazonUser> buyers = new HashMap<>();



    public void addUSer(AmazonUser user){
        buyers.put(user.getId(), user);
    }

    public AmazonUser getUSer(String userId){
        return buyers.get(userId);
    }

}
