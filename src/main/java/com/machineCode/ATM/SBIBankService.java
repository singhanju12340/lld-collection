package com.machineCode.ATM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 13/02/25 and 3:23 PM
 */
public class SBIBankService {

    Map<String, Account> accountList = new ConcurrentHashMap<>();




    public double fetchAccountBalance(String accoNo){
        return accountList.get(accoNo).accountBalance;
    }

    public double setAccountBalance(String accountNo, double amount){
        accountList.get(accountNo).accountBalance = amount;
        return amount;
    }

    public void createAccount(String accountNumber, double initialBalance) {
        accountList.put(accountNumber, new Account(accountNumber, initialBalance));
    }


    public void processTransaction(AtmTransaction transaction) {

        transaction.execute();
    }

}
