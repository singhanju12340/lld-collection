package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:27 PM
 */
public class AtmService implements Atm{
    private SBIBankService bankService;
    private double totalCashWithAtm;

    public AtmService(SBIBankService bankService) {
        this.bankService = bankService;
        this.totalCashWithAtm = 1000000;
    }

    @Override
    public double checkBalance(String accountNo) {
        System.out.println("Account balanc for account  "+ accountNo +": "+ bankService.fetchAccountBalance(accountNo));
        return bankService.fetchAccountBalance(accountNo);
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        Account account = bankService.accountList.get(accountNo);
       if( account!=null && validateTxn(accountNo, amount)){

           bankService.processTransaction(new WithdrawTransaction("txnID", 500.0, account));
           totalCashWithAtm = totalCashWithAtm - amount;
        }
    }

    @Override
    public void deposit(String accountNo, double amount) {
        double newBalance = bankService.accountList.get(accountNo).accountBalance + amount;
        bankService.setAccountBalance(accountNo, newBalance);

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
