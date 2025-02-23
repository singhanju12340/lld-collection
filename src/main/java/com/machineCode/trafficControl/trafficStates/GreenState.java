package com.machineCode.trafficControl.trafficStates;

import com.machineCode.trafficControl.Signal;
import com.machineCode.trafficControl.TrafficLight;

import static com.machineCode.trafficControl.Signal.GREEN;

/**
 * @author anju
 * @created on 23/02/25 and 12:01 AM
 */
public class GreenState implements TrafficLightState {
    @Override
    public void switchState(TrafficLight light) {
        System.out.println("Switching from GREEN to YELLOW"+ light.name);
        light.setCurrentState(new YellowState());
    }

    @Override
    public Signal getStateName() {
        return GREEN;
    }
}
