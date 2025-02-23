package com.machineCode.ATM;

import com.machineCode.ATM.atm_states.*;

/**
 * @author anju
 * @created on 13/02/25 and 3:27 PM
 */
public class AtmService implements Atm{
    private SBIBankService bankService;
    private AtmCashDispenser atmCachDispenser;
    private static AtmService atmService;
    private AtmStateFactoryImpl atmStateFactory;

    private ATMStateService atmState;


    public static final AtmService getInstance(){
        if(atmService == null) {
            atmService = new AtmService();
        }
        return atmService;
    }





    public AtmService() {
        atmCachDispenser = new AtmCashDispenser();
    }


    public void setBankService(SBIBankService bankService) {
        this.bankService = bankService;
        // state state factory
        atmStateFactory = new AtmStateFactoryImpl(this, bankService);
    }

    @Override
    public double checkBalance(String accountNo) {
        System.out.println("Account balanc for account  "+ accountNo +": "+ bankService.fetchAccountBalance(accountNo));
        return bankService.fetchAccountBalance(accountNo);
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        atmState.withdraw(accountNo, amount);
    }

    @Override
    public void deposit(String accountNo, double amount) {
        atmState.deposit(accountNo, amount);
    }

    @Override
    public boolean authenticateUser(Card cardDetails) {
        // validate card and its pin with the saved list of card and pin
        return true;
    }

    @Override
    public boolean validateTxn(String accountNo, double amount) {
        double currentBalance = bankService.fetchAccountBalance(accountNo);
        if(currentBalance >= amount) return true;
        return false;
    }

    @Override
    public void changeCurrentState(ATMStates newState) {
        this.atmState = atmStateFactory.createState(newState);
    }




}
