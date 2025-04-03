package com.machineCode.paymentGatewayIntegration.service;

import com.machineCode.paymentGatewayIntegration.PaymentException;
import com.machineCode.paymentGatewayIntegration.dto.PaymentRequest;
import com.machineCode.paymentGatewayIntegration.dto.PaymentResponse;

/**
 * @author anju
 * @created on 03/04/25 and 5:54 PM
 */
public interface PaymentGatewayService {

    public PaymentResponse processPayment(PaymentRequest request) throws PaymentException;
}
