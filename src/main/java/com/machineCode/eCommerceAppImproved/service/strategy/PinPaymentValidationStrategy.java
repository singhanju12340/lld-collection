package com.machineCode.eCommerceAppImproved.service.strategy;

import com.machineCode.eCommerceAppImproved.model.PaymentMode;

/**
 * @author anju
 * @created on 24/04/25 and 12:22 PM
 */
public interface PinPaymentValidationStrategy {

    public void addPinCode(String sourcePin, String destinationPin, PaymentMode paymentMode);

    public boolean validate(String productionPin, String userLocationPin, PaymentMode userPaymentMode);
}
