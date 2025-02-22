package com.machineCode.ATM.atm_states;

import com.machineCode.ATM.AtmService;
import com.machineCode.ATM.Card;

/**
 * @author anju
 * @created on 18/02/25 and 5:24 PM
 */
public class CardInsertedState implements ATMStateService {
    AtmService atmService;

    public CardInsertedState(AtmService atmService) {
        this.atmService = atmService;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card is already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected. Transitioning to IDLE state.");
        atmService.changeCurrentState(ATMStates.IDLE);
    }

    @Override
    public void enterPin(int pin) {
        if(atmService.authenticateUser(new Card("card", "exp", String.valueOf(pin)))) {
            System.out.println("PIN accepted. Transitioning to AUTHENTICATED state.");
            atmService.changeCurrentState(ATMStates.AUTHENTICATED);
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        System.out.println("Enter PIN first before withdrawing funds.");
    }

    @Override
    public void deposit(String accountNo, double amount) {
        System.out.println("Enter PIN first before depositing funds.");
    }
}
