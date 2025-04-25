package com.machineCode.eCommerceAppImproved.service;

import com.machineCode.eCommerceAppImproved.model.AmazonUser;

/**
 * @author anju
 * @created on 23/04/25 and 7:39 PM
 */
public interface AmazonUserService {
    public void addUser(AmazonUser user);
    public AmazonUser getUser(String id);

}
