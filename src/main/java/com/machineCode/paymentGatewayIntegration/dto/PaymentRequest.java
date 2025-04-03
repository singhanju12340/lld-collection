package com.machineCode.paymentGatewayIntegration.dto;

import java.util.Map;

/**
 * @author anju
 * @created on 03/04/25 and 5:55 PM
 */
public class PaymentRequest {

    private double amount;
    private String currency;
    private String paymentMethod; // e.g., "CREDIT_CARD", "DIGITAL_WALLET"
    private Map<String, String> details; // e.g., cardNumber, expiry, token, etc.

    public PaymentRequest(double amount, String currency, String paymentMethod, Map<String, String> details) {
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
