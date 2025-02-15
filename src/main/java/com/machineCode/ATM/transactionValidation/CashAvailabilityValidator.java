package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;
import com.machineCode.ATM.AtmCashDispenser;

/**
 * @author anju
 * @created on 15/02/25 and 8:28 PM
 */
public class CashAvailabilityValidator extends Validator{
    @Override
    public boolean validate(Account account, double amount) {
        if((amount< AtmCashDispenser.getCashInAtm()))
            if(nextValidator!= null){
                return nextValidator.validate(account, amount);
            }else{
                return true;
            }
        throw new IllegalArgumentException("Insufficient cash available in the ATM.");
    }
}
