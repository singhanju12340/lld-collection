package com.machineCode.ATM.atm_states;

/**
 * @author anju
 * @created on 18/02/25 and 7:33 PM
 */
public interface AtmStateFactory {
    ATMStateService createState(ATMStates stateType);
}
