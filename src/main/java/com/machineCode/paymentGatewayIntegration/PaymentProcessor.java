package com.machineCode.paymentGatewayIntegration;

import com.machineCode.paymentGatewayIntegration.dto.PaymentRequest;
import com.machineCode.paymentGatewayIntegration.dto.PaymentResponse;
import com.machineCode.paymentGatewayIntegration.service.PaymentGatewayFactory;
import com.machineCode.paymentGatewayIntegration.service.PaymentGatewayService;

/**
 * @author anju
 * @created on 03/04/25 and 6:13 PM
 */
public class PaymentProcessor {


    public PaymentResponse processPayment(PaymentRequest request){
        PaymentGatewayService gateway = PaymentGatewayFactory.getGateway(request.getPaymentMethod());
        try {
            return gateway.processPayment(request);
        }catch (PaymentException exception){
            System.err.println("Payment processing failed: " + exception.getMessage());
            return new PaymentResponse(false, null, "Payment failed");
        }

    }
}
