package com.machineCode.eCommerceAppImproved.service.decorator;

import com.machineCode.eCommerceAppImproved.model.Product;

/**
 * @author anju
 * @created on 24/04/25 and 1:17 PM
 */
public class GiftProductPriceDecoratorImpl implements ProductPriceDecorator {



    @Override
    public double getPrice(Product product) {
        return product.getPrice() + (0.05 * product.getPrice());
    }
}
