package com.machineCode.ATM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 13/02/25 and 3:23 PM
 */

public class SBIBankService{

    Map<String, Account> accountList = new ConcurrentHashMap<>();
    private static SBIBankService sbiBankService;

    public static SBIBankService getInstance(){
        if(sbiBankService == null)
            return new SBIBankService();
        return sbiBankService;
    }



    public double fetchAccountBalance(String accoNo){
        return accountList.get(accoNo).accountBalance;
    }



    public void createAccount(String accountNumber, double initialBalance) {
        accountList.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accountList.get(accountNumber);
    }


    public void processTransaction(AtmTransaction transaction) {
        transaction.execute();
    }

}
