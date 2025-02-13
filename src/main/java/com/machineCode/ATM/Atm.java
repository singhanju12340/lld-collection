package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:18 PM
 */
public interface Atm {

    public double checkBalance(String accountNo);

    public void withdraw(String accountNo, double amount);

    public void deposit(String accountNo, double amount);

    public boolean authenticateUser(Card cardDetails);

    public boolean validateTxn(String accountNo, double amount);


}
