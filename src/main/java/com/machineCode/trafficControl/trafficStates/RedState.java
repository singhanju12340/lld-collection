package com.machineCode.trafficControl.trafficStates;

import com.machineCode.trafficControl.Signal;
import com.machineCode.trafficControl.TrafficLight;

import static com.machineCode.trafficControl.Signal.RED;

/**
 * @author anju
 * @created on 23/02/25 and 12:00 AM
 */
public class RedState implements TrafficLightState {
    @Override
    public void switchState(TrafficLight light) {
        System.out.println("Switching from RED to GREEN for light "+ light.name);
        light.setCurrentState(new GreenState());
    }

    @Override
    public Signal getStateName() {
        return RED;
    }


}
