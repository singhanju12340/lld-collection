package com.machineCode.eCommerceApp.service;

import com.machineCode.eCommerceApp.model.PaymentMode;

/**
 * @author anju
 * @created on 23/04/25 and 8:40 PM
 */


public interface PinCodeService {
    public void addPinCode(String sourcePin, String destinationPin, PaymentMode paymentMode);
    public Boolean checkIfPinAndPaymentModeValid(String  sourcePin, String destinationPin, PaymentMode paymentMode);


}
