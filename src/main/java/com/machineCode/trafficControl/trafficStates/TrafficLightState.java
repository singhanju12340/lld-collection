package com.machineCode.trafficControl.trafficStates;

import com.machineCode.trafficControl.Signal;
import com.machineCode.trafficControl.TrafficLight;

/**
 * @author anju
 * @created on 22/02/25 and 11:59 PM
 */
public interface TrafficLightState {

    public void switchState(TrafficLight light);


    public Signal getStateName();

}
