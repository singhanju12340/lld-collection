package com.machineCode.trafficControl;

import com.machineCode.trafficControl.trafficStates.GreenState;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 23/02/25 and 12:43 AM
 */
public class TrafficController {
    private final Map<String, Road> roads;
    private TrafficTimeStrategy strategy;
    private static TrafficController controller;


    public static synchronized TrafficController getInstant(){
        if(controller == null)
            return new TrafficController();
        return controller;
    }

    public TrafficController() {
        this.roads = new HashMap<>();
        strategy = new FixedTimeStrategy();
    }

    public void addRoads(Road road){
        roads.put(road.getId(), road);
    }


    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        if (road != null) {
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.setCurrentState(new GreenState());
            // Perform emergency handling logic
            // ...
        }
    }

    public void startTrafficControl() {
        for (Road road : roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(trafficLight.signalTime.get(trafficLight.getCurrentState().getStateName()));
                        trafficLight.switchState();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
