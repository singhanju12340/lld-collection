package com.machineCode.eCommerceAppImproved.model;

import com.machineCode.eCommerceAppImproved.model.PaymentMode;
import lombok.Builder;
import lombok.Data;

/**
 * @author anju
 * @created on 23/04/25 and 7:23 PM
 */

@Data
@Builder
public class Order {
    private String orderId;
    private final String userId;
    private final String productId;
    private final Integer quantity;
    private Double billAmount;
    private final PaymentMode paymentMode;
    private final Long date;
    private final String userPinCode;

    public void setOrderId(String newId) {
        this.orderId = newId;
    }

}
