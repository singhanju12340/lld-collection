package com.machineCode.trafficControl;

/**
 * @author anju
 * @created on 23/02/25 and 12:14 AM
 */
public class TrafficSensor implements TrafficLightObserver{

    @Override
    public void update(Signal state) {
        System.out.println("sensor observed change in traffic signal state: "+ state);
    }
}
