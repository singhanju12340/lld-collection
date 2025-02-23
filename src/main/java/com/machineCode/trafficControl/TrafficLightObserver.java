package com.machineCode.trafficControl;

import com.machineCode.trafficControl.trafficStates.TrafficLightState;

/**
 * @author anju
 * @created on 23/02/25 and 12:13 AM
 */
public interface TrafficLightObserver {
    void update(Signal state);
}
