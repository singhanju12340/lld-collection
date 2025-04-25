package com.machineCode.eCommerceAppImproved.repository;

import com.machineCode.eCommerceAppImproved.exception.ECommerceException;
import com.machineCode.eCommerceAppImproved.model.ErrorCode;
import com.machineCode.eCommerceAppImproved.model.Product;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.machineCode.eCommerceAppImproved.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 7:34 PM
 */

@Data
public class ProductRepository {
    ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();

    public Product getProduct(String productId){
        return products.get(productId);
    }

    public void addProduct(Product product){
        if(products.containsKey(product.getId())){
            throw new ECommerceException(ErrorCode.PRODUCTED_ALREADY_ADDED, errorCodeStringMap.get(ErrorCode.PRODUCTED_ALREADY_ADDED));
        }else{
            products.put(product.getId(), product);
        }

    }
}
