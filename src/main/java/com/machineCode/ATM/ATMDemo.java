package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:26 PM
 */
public class ATMDemo {

    public static void main(String[] args) {

        SBIBankService bankService = new SBIBankService();
        bankService.createAccount("anju", 10000);
        bankService.createAccount("santosh", 1000);


        AtmService atmService = new AtmService(bankService);
        atmService.checkBalance("anju");
    }
}

