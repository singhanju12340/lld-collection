package com.machineCode.eCommerceAppImproved.service.factory;

/**
 * @author anju
 * @created on 24/04/25 and 2:39 PM
 */
public class OrderFactory {
    private static OrderFactory instance;
    public OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }
        return instance;
        }

    public OrderAmountCalculator getOrder(String type) {
        if (type.equalsIgnoreCase("gift")) {
            return new PriceForGiftOrder();
        } else if (type.equalsIgnoreCase("express")) {
            return new ExpressOrder();
        } else if (type.equalsIgnoreCase("normal")) {
            return new BaseOrderServiceImpl();
        }
        return null;
    }

}
