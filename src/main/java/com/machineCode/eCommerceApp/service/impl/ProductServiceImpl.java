package com.machineCode.eCommerceApp.service.impl;

import com.machineCode.eCommerceApp.exception.ECommerceException;
import com.machineCode.eCommerceApp.model.ErrorCode;
import com.machineCode.eCommerceApp.model.Product;
import com.machineCode.eCommerceApp.repository.ProductRepository;
import com.machineCode.eCommerceApp.service.ProductService;
import lombok.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

import static com.machineCode.eCommerceApp.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 10:06 PM
 */
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    @Override
    public Product getProduct(String productId) {
        return repository.getProduct(productId);
    }

    @Override
    @Synchronized
    public Boolean checkInventory(Integer orderQuantity, String productId) {
        Product product = repository.getProduct(productId);

       if(null != product){
           if(product.getQuantity()-orderQuantity >=0)
           {
               product.setQuantity(product.getQuantity()-orderQuantity);
               return true;
           }else{
               return false;
           }
       }
       throw new ECommerceException(ErrorCode.INVALID_PRODUCT, errorCodeStringMap.get(ErrorCode.INVALID_PRODUCT));
    }
}
