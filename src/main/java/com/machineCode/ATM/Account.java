package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:22 PM
 */
public class Account {

    String accountNumber;
    double accountBalance;
    

    public Account(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void debit(double amount){
        this.accountBalance = this.accountBalance - amount;
    }

    public void credit(double amount){
        this.accountBalance = this.accountBalance + amount;
    }
}
