package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;

/**
 * @author anju
 * @created on 13/02/25 and 9:26 PM
 */
public class DepositLimitValidator extends Validator{
    @Override
    public boolean validate(Account account, double amount) {
        if (amount > 5000)
            return false;
        return true;
    }
}
