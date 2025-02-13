package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;

/**
 * @author anju
 * @created on 13/02/25 and 9:31 PM
 */
public abstract class Validator {
    Validator nextValidator;

    public abstract boolean validate(Account account, double amount);

    public void setNext( Validator validator){
        nextValidator = validator;
    }
}


