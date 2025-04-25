package com.machineCode.eCommerceAppImproved.service.factory;

import com.machineCode.eCommerceAppImproved.model.Order;
import com.machineCode.eCommerceAppImproved.model.PaymentMode;

/**
 * @author anju
 * @created on 24/04/25 and 1:08 PM
 */
public interface OrderAmountCalculator {

    public double calculateTotal(double amount);
//    public Order createOrder(String id, double amount, String userId, String productId, int quantity, PaymentMode paymentMode, long date, String userPinCode);

    public default Order createOrder(String id, double amount, String userId, String productId, int quantity, PaymentMode paymentMode, long date, String userPinCode) {
        Order order =  Order.builder()
                .orderId(id)
                .billAmount(calculateTotal(amount))
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .paymentMode(paymentMode)
                .date(date)
                .userPinCode(userPinCode)
                .build();
        return order;
    }
}
