package com.machineCode.ATM.atm_states;

import com.machineCode.ATM.AtmService;
import com.machineCode.ATM.SBIBankService;

/**
 * @author anju
 * @created on 18/02/25 and 7:36 PM
 */
public class AtmStateFactoryImpl implements AtmStateFactory{
    AtmService atmService;
    SBIBankService bankService;

    public AtmStateFactoryImpl(AtmService atmService, SBIBankService bankService) {
        this.atmService = atmService;
        this.bankService = bankService;
    }

    @Override
    public ATMStateService createState(ATMStates stateType) {
        switch(stateType) {
            case IDLE:
                return new IdleState(atmService);
            case CARD_INSERTED:
                return new CardInsertedState(atmService);
            case AUTHENTICATED:
                return new CardAuthenticatedState(atmService, bankService);
            default:
                throw new IllegalArgumentException("Unknown state type: " + stateType);
        }
    }
}
