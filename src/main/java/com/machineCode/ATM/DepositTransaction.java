package com.machineCode.ATM;

/**
 * @author anju
 * @created on 15/02/25 and 8:36 PM
 */
public class DepositTransaction extends AtmTransaction {
    public DepositTransaction(String txnID, double amount, Account account) {
        super(txnID, amount, account);
    }

    public  void execute(){
        // call validator based on withdrawal txn
        this.account.credit(this.amount);
    }


}