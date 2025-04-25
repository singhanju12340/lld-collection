package com.machineCode.eCommerceAppImproved.service;

import com.machineCode.eCommerceAppImproved.model.Product;

/**
 * @author anju
 * @created on 23/04/25 and 7:40 PM
 */
public interface ProductService {
    public void addProduct(Product product);
    public Product getProduct(String productId);

    // talk about synchronisation needed on changing the quantity in muti threaded env. Also talk about dictributed locks
    // in distributed and multinode system as synchronisation will not help in acceiving atomicity in distribution systems.
    // talk about Redis distributed locks or locks as Database level
    public Boolean checkInventory(Integer orderQuantity, String productId);


}
