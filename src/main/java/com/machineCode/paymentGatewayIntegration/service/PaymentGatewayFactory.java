package com.machineCode.paymentGatewayIntegration.service;

/**
 * @author anju
 * @created on 03/04/25 and 5:56 PM
 */
public class PaymentGatewayFactory {

    public static PaymentGatewayService getGateway(String type) {
        PaymentGatewayService gateway;
        switch (type) {
            case "CREDIT_CARD":
                gateway = new CreditCardGatewayImpl();
                break;
            case "DIGITAL_WALLET":
                gateway = new WalletGatewayImpl();
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
        // Wrap the gateway with a security decorator.
        return new PaymentSecurityDecorator(gateway);
    }
}
