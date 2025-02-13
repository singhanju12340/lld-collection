package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;

/**
 * @author anju
 * @created on 13/02/25 and 9:26 PM
 */
public class SufficientBalanceValidator extends Validator{

    @Override
    public boolean validate(Account account, double amount) {
        if(account.getAccountBalance()>=amount) return true;
        return false;
    }
}
