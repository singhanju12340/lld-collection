package com.machineCode.ATM.transactionValidation;

import com.machineCode.ATM.Account;
import com.machineCode.ATM.Card;

/**
 * @author anju
 * @created on 15/02/25 and 8:22 PM
 */
public class PinValidator extends Validator{


    @Override
    public boolean validate(Card card, String pin) {
        return false;
    }
}
