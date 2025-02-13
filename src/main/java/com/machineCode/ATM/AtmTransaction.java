package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 4:26 PM
 */
public abstract class AtmTransaction {
    String txnId;
    double amount;
    Account account;

    public AtmTransaction(String txnId, double amount, Account account) {
        this.txnId = txnId;
        this.amount = amount;
        this.account = account;
    }

    public void execute(){

    }


}
