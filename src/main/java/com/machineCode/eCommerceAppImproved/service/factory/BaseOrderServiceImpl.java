package com.machineCode.eCommerceAppImproved.service.factory;

import com.machineCode.eCommerceAppImproved.model.Order;

/**
 * @author anju
 * @created on 24/04/25 and 2:38 PM
 */
public class BaseOrderServiceImpl implements OrderAmountCalculator {

    @Override
    public double calculateTotal(double amount) {
        return amount + 0;
    }
}
