package com.machineCode.paymentGatewayIntegration.service;

import com.machineCode.paymentGatewayIntegration.PaymentException;
import com.machineCode.paymentGatewayIntegration.dto.PaymentRequest;
import com.machineCode.paymentGatewayIntegration.dto.PaymentResponse;

/**
 * @author anju
 * @created on 03/04/25 and 6:10 PM
 */
public class WalletGatewayImpl implements PaymentGatewayService{
    @Override
    public PaymentResponse processPayment(PaymentRequest request) throws PaymentException {
        System.out.println("Processing credit card payment...");

        return new PaymentResponse(true, "TXN12345", "Credit card payment successful");
    }
}
