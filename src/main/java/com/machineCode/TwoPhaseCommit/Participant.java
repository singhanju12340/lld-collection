package com.machineCode.TwoPhaseCommit;

/**
 * @author anju
 * @created on 27/02/25 and 12:38 PM
 */
public interface Participant {

    public boolean reserve();
    public void commit();
    public void rollBack();
}
