package com.machineCode.trafficControl.trafficStates;

import com.machineCode.trafficControl.Signal;
import com.machineCode.trafficControl.TrafficLight;

/**
 * @author anju
 * @created on 23/02/25 and 12:01 AM
 */
public class YellowState implements TrafficLightState {
    @Override
    public void switchState(TrafficLight light) {
        System.out.println("Switching from YELLOW to RED"+ light.name);
        light.setCurrentState(new RedState());
    }

    @Override
    public Signal getStateName() {
        return Signal.YELLOW;
    }
}
