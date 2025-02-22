package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:26 PM
 */
public class ATMDemo {

    public static void main(String[] args) {

        SBIBankService bankService = SBIBankService.getInstance();

        bankService.createAccount("anju", 10000);
        bankService.createAccount("santosh", 1000);



        AtmService atmService = AtmService.getInstance();
        atmService.setBankService(SBIBankService.getInstance());


        atmService.checkBalance("anju");
        atmService.withdraw("anju", 500);
        atmService.checkBalance("anju");


    }
}

