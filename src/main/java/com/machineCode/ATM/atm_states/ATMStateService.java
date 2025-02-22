package com.machineCode.ATM.atm_states;

import com.machineCode.ATM.Card;

/**
 * @author anju
 * @created on 18/02/25 and 5:22 PM
 */
public interface ATMStateService {

    // Called when a card is inserted
    void insertCard(Card card);
    // Called to eject a card
    void ejectCard();
    // Called when the user enters the PIN
    void enterPin(int pin);
    // Called to request a withdrawal
    void withdraw(String accountNo, double amount);
    // Called to request a deposit
    void deposit(String accountNo, double amount);
}
