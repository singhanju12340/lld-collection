package com.machineCode.splitwise.dto;

import lombok.Data;

/**
 * @author anju
 * @created on 05/05/25 and 10:14 PM
 */

@Data
public class TransactionRecord {
    String payer;
    String payee;
    double amount;
    String expenseId;
}
