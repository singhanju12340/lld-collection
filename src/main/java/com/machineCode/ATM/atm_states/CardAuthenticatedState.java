package com.machineCode.ATM.atm_states;

import com.machineCode.ATM.*;
import com.machineCode.ATM.transactionValidation.CashAvailabilityValidator;
import com.machineCode.ATM.transactionValidation.DepositLimitValidator;
import com.machineCode.ATM.transactionValidation.SufficientBalanceValidator;

/**
 * @author anju
 * @created on 18/02/25 and 5:26 PM
 */
public class CardAuthenticatedState implements ATMStateService {
    AtmService atmService;
    SBIBankService sbiBankService;


    DepositLimitValidator depositLimitValidator;
    SufficientBalanceValidator sufficientBalanceValidator;
    CashAvailabilityValidator cashAvailabilityValidator;

    public CardAuthenticatedState(AtmService atmService, SBIBankService sbiBankService) {
        this.atmService = atmService;
        this.sbiBankService = sbiBankService;

        cashAvailabilityValidator = new CashAvailabilityValidator();
        sufficientBalanceValidator = new SufficientBalanceValidator();

        sufficientBalanceValidator.setNext(null);
        cashAvailabilityValidator.setNext(sufficientBalanceValidator);

        depositLimitValidator = new DepositLimitValidator();
        depositLimitValidator.setNext(null);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted and authenticated.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected. Transitioning to IDLE state.");
        atmService.changeCurrentState(ATMStates.IDLE);
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Already authenticated.");

    }

    @Override
    public void withdraw(String accountNo, double amount) {
        System.out.println("Processing withdrawal...");
        Account account = SBIBankService.getInstance().getAccount(accountNo);
        if( account!=null &&  cashAvailabilityValidator.validate(account, amount)){
            sbiBankService.processTransaction(new WithdrawTransaction("txnID", 500.0, account));
            AtmCashDispenser.debitCashInAtm(amount);

        }
    }

    @Override
    public void deposit(String accountNo, double amount) {
        System.out.println("Processing deposit...");
        Account account = SBIBankService.getInstance().getAccount(accountNo);
        if( account!=null &&  depositLimitValidator.validate(account, amount)) {
            sbiBankService.processTransaction(new DepositTransaction("txnID", 500.0, account));
            AtmCashDispenser.debitCashInAtm(amount);
        }
    }
}
