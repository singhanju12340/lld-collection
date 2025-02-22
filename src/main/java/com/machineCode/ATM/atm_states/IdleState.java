package com.machineCode.ATM.atm_states;

import com.machineCode.ATM.AtmService;
import com.machineCode.ATM.Card;

/**
 * @author anju
 * @created on 18/02/25 and 5:24 PM
 */
public class IdleState implements ATMStateService {
    AtmService atmService;

    public IdleState(AtmService atmService) {
        this.atmService = atmService;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println(" currently ATM is in ideal status, card not inserted, inser card");
        atmService.changeCurrentState(ATMStates.CARD_INSERTED);
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("No card inserted. Cannot enter PIN.");
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        System.out.println("No card inserted. Cannot withdraw funds.");
    }

    @Override
    public void deposit(String accountNo, double amount) {
        System.out.println("No card inserted. Cannot deposit funds.");

    }
}
