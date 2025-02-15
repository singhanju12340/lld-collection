package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;
import com.machineCode.ATM.Card;

/**
 * @author anju
 * @created on 13/02/25 and 9:31 PM
 */
public abstract class Validator {
    Validator nextValidator;

    public boolean validate(Account account, double amount){
        return false;
    }

    public boolean validate(Card card, String pin){
        return false;
    }



    public void setNext( Validator validator){
        nextValidator = validator;
    }


}


