package com.machineCode.eCommerceApp.repository;

import com.machineCode.eCommerceApp.exception.ECommerceException;
import com.machineCode.eCommerceApp.model.ErrorCode;
import com.machineCode.eCommerceApp.model.Product;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.machineCode.eCommerceApp.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 7:34 PM
 */

@Data
public class ProductRepository {
    Map<String, Product> products = new HashMap<>();

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
