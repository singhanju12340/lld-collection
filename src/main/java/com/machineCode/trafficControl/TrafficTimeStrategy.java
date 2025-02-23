package com.machineCode.trafficControl;

/**
 * @author anju
 * @created on 23/02/25 and 12:17 AM
 */
public interface TrafficTimeStrategy {
    public int getTimeDuration(Signal state);
}
