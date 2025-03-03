package com.machineCode.trafficControl;

/**
 * @author anju
 * @created on 22/02/25 and 11:59 PM
 */
public class TrafficControlDemo {


    public static void main(String[] args) throws InterruptedException {
    

        TrafficController trafficController = TrafficController.getInstant();

        // Create roads
        Road road1 = new Road("R1", "Main Street");
        Road road2 = new Road("R2", "Broadway");
        Road road3 = new Road("R3", "Park Avenue");
        Road road4 = new Road("R4", "Elm Street");

        // Create traffic lights
        TrafficLight trafficLight1 = new TrafficLight("L1", 6000, 3000, 9000);
        trafficLight1.registerObserver(new TrafficSensor());

        TrafficLight trafficLight2 = new TrafficLight("L2", 6000, 3000, 9000);
        TrafficLight trafficLight3 = new TrafficLight("L3", 6000, 3000, 9000);
        TrafficLight trafficLight4 = new TrafficLight("L4", 6000, 3000, 9000);

        // Assign traffic lights to roads
        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        // Add roads to the traffic controller
        trafficController.addRoads(road1);
        trafficController.addRoads(road2);
        trafficController.addRoads(road3);
        trafficController.addRoads(road4);


        // Start traffic control
        trafficController.startTrafficControl();

        // Simulate an emergency on a specific road
        trafficController.handleEmergency("R2");

    }
}
