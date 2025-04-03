package com.machineCode.paymentGatewayIntegration;

import com.machineCode.paymentGatewayIntegration.dto.PaymentRequest;
import com.machineCode.paymentGatewayIntegration.dto.PaymentResponse;

import java.util.Map;

/**
 * @author anju
 * @created on 03/04/25 and 6:15 PM
 */
public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentRequest creditCardRequest = new PaymentRequest();
        creditCardRequest.setAmount(99.99);
        creditCardRequest.setCurrency("USD");
        creditCardRequest.setPaymentMethod("CREDIT_CARD");
        creditCardRequest.setDetails(Map.of("cardNumber", "4111111111111111", "expiry", "12/25", "cvv", "123"));

        PaymentResponse response = processor.processPayment(creditCardRequest);
        System.out.println("Payment Status: " + response.isSuccess() + ", Transaction ID: " + response.getTransactionId());
    }
}
