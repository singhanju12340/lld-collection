package com.machineCode.ATM;

import com.machineCode.ATM.transactionValidation.CashAvailabilityValidator;
import com.machineCode.ATM.transactionValidation.DepositLimitValidator;
import com.machineCode.ATM.transactionValidation.SufficientBalanceValidator;

/**
 * @author anju
 * @created on 13/02/25 and 3:27 PM
 */
public class AtmService implements Atm{
    private SBIBankService bankService;
    private AtmCashDispenser atmCachDispenser;


    DepositLimitValidator depositLimitValidator;
    SufficientBalanceValidator sufficientBalanceValidator;
    CashAvailabilityValidator cashAvailabilityValidator;


    public AtmService(SBIBankService bankService) {
        this.bankService = bankService;

        cashAvailabilityValidator = new CashAvailabilityValidator();
        sufficientBalanceValidator = new SufficientBalanceValidator();

        sufficientBalanceValidator.setNext(null);
        cashAvailabilityValidator.setNext(sufficientBalanceValidator);

        depositLimitValidator = new DepositLimitValidator();
        depositLimitValidator.setNext(null);

        atmCachDispenser = new AtmCashDispenser();
    }

    @Override
    public double checkBalance(String accountNo) {
        System.out.println("Account balanc for account  "+ accountNo +": "+ bankService.fetchAccountBalance(accountNo));
        return bankService.fetchAccountBalance(accountNo);
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        Account account = bankService.accountList.get(accountNo);
       if( account!=null &&  cashAvailabilityValidator.validate(account, amount)){
           bankService.processTransaction(new WithdrawTransaction("txnID", 500.0, account));
           AtmCashDispenser.debitCashInAtm(amount);

        }
    }

    @Override
    public void deposit(String accountNo, double amount) {
        Account account = bankService.accountList.get(accountNo);
        if( account!=null &&  depositLimitValidator.validate(account, amount)) {
            bankService.processTransaction(new DepositTransaction("txnID", 500.0, account));
            AtmCashDispenser.debitCashInAtm(amount);
        }
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


}
