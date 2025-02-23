package com.machineCode.trafficControl;

/**
 * @author anju
 * @created on 23/02/25 and 12:18 AM
 */
public class FixedTimeStrategy implements TrafficTimeStrategy {
    @Override
    public int getTimeDuration(Signal state) {
        switch(state) {
            case RED:
                return 30;
            case GREEN:
                return 45;
            case YELLOW:
                return 5;
            default:
                return 10;
        }
    }
}
