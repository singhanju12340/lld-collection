package com.machineCode.eCommerceAppImproved.service.impl;

import com.machineCode.eCommerceAppImproved.exception.ECommerceException;
import com.machineCode.eCommerceAppImproved.model.ErrorCode;
import com.machineCode.eCommerceAppImproved.model.Product;
import com.machineCode.eCommerceAppImproved.repository.ProductRepository;
import com.machineCode.eCommerceAppImproved.service.ProductService;
import com.machineCode.eCommerceAppImproved.service.decorator.GiftProductPriceDecoratorImpl;
import com.machineCode.eCommerceAppImproved.service.decorator.ProductPriceDecorator;
import lombok.Synchronized;

import static com.machineCode.eCommerceApp.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 10:06 PM
 */
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductPriceDecorator productPriceService;  // decorator pattern

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
        this.productPriceService = new GiftProductPriceDecoratorImpl();
    }

    @Override
    public void addProduct(Product product) {
        product.setPrice(productPriceService.getPrice(product));
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
