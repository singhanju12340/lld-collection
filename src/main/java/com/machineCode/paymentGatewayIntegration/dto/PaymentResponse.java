package com.machineCode.paymentGatewayIntegration.dto;

/**
 * @author anju
 * @created on 03/04/25 and 5:55 PM
 */
public class PaymentResponse {
    private boolean success;
    private String transactionId;
    private String message;

    public PaymentResponse(boolean success, String transactionId, String message) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
