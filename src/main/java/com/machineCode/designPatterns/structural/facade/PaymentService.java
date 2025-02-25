package com.machineCode.designPatterns.structural.facade;

/**
 * @author anju
 * @created on 25/02/25 and 1:55 PM
 */
public class PaymentService {

    public boolean processPayment(String accountId, double amount) {
        System.out.println("Processing payment of $" + amount + " for account " + accountId);
        // Simulate payment processing
        return true;
    }
}
