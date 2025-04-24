package com.machineCode.eCommerceApp.service;

import com.machineCode.eCommerceApp.model.AmazonUser;

/**
 * @author anju
 * @created on 23/04/25 and 7:39 PM
 */
public interface AmazonUserService {
    public void addUser(AmazonUser user);
    public AmazonUser getUser(String id);

}
