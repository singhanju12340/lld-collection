package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 4:27 PM
 */
public class WithdrawTransaction extends AtmTransaction {
    public WithdrawTransaction(String txnID, double amount, Account account) {
        super(txnID, amount, account);
    }

    public  void execute(){
        // call validator based on withdrawal txn
        this.account.debit(this.amount);
    }


}
