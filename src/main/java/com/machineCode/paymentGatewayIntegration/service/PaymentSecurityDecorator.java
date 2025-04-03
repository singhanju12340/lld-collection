package com.machineCode.paymentGatewayIntegration.service;

import com.machineCode.paymentGatewayIntegration.PaymentException;
import com.machineCode.paymentGatewayIntegration.dto.PaymentRequest;
import com.machineCode.paymentGatewayIntegration.dto.PaymentResponse;

/**
 * @author anju
 * @created on 03/04/25 and 5:58 PM
 */
public class PaymentSecurityDecorator implements PaymentGatewayService{
    private final PaymentGatewayService delegate;

    public PaymentSecurityDecorator(PaymentGatewayService delegate) {
        this.delegate = delegate;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) throws PaymentException {
        // 1. Validate and encrypt sensitive data.
        secureRequest(request);
        // 2. Log the request details (without sensitive info).
        logRequest(request);
        // Delegate the actual processing.
        PaymentResponse response = delegate.processPayment(request);
        // Optionally, perform additional security logging or checks on the response.
        logResponse(response);
        return response;
    }

    private void secureRequest(PaymentRequest request) {
        // Encrypt sensitive fields, validate request authenticity, etc.
        System.out.println("Securing payment request...");
    }

    private void logRequest(PaymentRequest request) {
        // Log non-sensitive details for auditing.
        System.out.println("Logging payment request...");
    }

    private void logResponse(PaymentResponse response) {
        // Log the response for security audits.
        System.out.println("Logging payment response...");
    }
}
