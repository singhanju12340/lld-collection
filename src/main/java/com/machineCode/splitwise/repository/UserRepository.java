package com.machineCode.splitwise.repository;

import com.machineCode.splitwise.models.User;

import java.util.Map;

/**
 * @author anju
 * @created on 05/05/25 and 3:19 PM
 */
public class UserRepository {
    private Map<String, User> userMap;

    public Map<String, User> getAllUser(){
        return this.userMap;
    }

    public void addUser(User user){
         this.userMap.put(user.getId(), user);
    }

}
