package com.machineCode.eCommerceAppImproved.model;

import com.machineCode.eCommerceAppImproved.model.PaymentMode;
import lombok.Data;

/**
 * @author anju
 * @created on 23/04/25 and 8:39 PM
 */

@Data
public class PinPaymentAvailability {
    private final String pinCode; // where product can be delivered
    private final PaymentMode paymentMode; // what payment mode can be accepted for the product

}
