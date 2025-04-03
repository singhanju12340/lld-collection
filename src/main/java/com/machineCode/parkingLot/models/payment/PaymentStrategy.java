package com.machineCode.parkingLot.models.payment;

/**
 * @author anju
 * @created on 19/03/25 and 3:56 PM
 */
public interface PaymentStrategy {
    void process(Double amount);
}
