package com.machineCode.eCommerceApp.service.impl;

import com.machineCode.eCommerceApp.model.AmazonUser;
import com.machineCode.eCommerceApp.repository.UserRepositoty;
import com.machineCode.eCommerceApp.service.AmazonUserService;
import com.machineCode.splitwise.models.User;

/**
 * @author anju
 * @created on 24/04/25 and 10:43 AM
 */
public class AmazonUserServiceImpl implements AmazonUserService {
    private final UserRepositoty userRepositoty;

    public AmazonUserServiceImpl(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    @Override
    public void addUser(AmazonUser user) {
        userRepositoty.addUSer(user);
    }

    @Override
    public AmazonUser getUser(String id) {
       return userRepositoty.getUSer(id);
    }
}
