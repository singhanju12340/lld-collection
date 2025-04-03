package com.machineCode.paymentGatewayIntegration;

/**
 * @author anju
 * @created on 03/04/25 and 5:59 PM
 */
public class PaymentException extends Throwable{

    PaymentException(String message){
        super(message);
    }

    PaymentException(String message, Throwable throwable){
        super(message, throwable);
    }

}
