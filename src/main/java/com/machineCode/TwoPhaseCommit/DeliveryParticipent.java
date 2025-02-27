package com.machineCode.TwoPhaseCommit;

/**
 * @author anju
 * @created on 27/02/25 and 12:44 PM
 */
public class DeliveryParticipent implements Participant {
    @Override
    public boolean reserve() {
        return true;
    }

    @Override
    public void commit() {

    }

    @Override
    public void rollBack() {

    }
}
