package com.machineCode.trafficControl;

import com.machineCode.trafficControl.trafficStates.RedState;
import com.machineCode.trafficControl.trafficStates.TrafficLightState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 23/02/25 and 12:02 AM
 */
public class TrafficLight {
    private TrafficLightState currentState;
    List<TrafficLightObserver> observers;
    Map<Signal, Integer> signalTime;
    public String name;

    public TrafficLight(String name, Integer redTime, Integer yellowTime, Integer greenTime){
        currentState = new RedState();
        observers = new ArrayList<>();
        signalTime = new HashMap<>();
        signalTime.put(Signal.RED,redTime );
        signalTime.put(Signal.GREEN,greenTime );
        signalTime.put(Signal.YELLOW,yellowTime );
        this.name = name;
    }



    // Observer pattern methods.
    public void registerObserver(TrafficLightObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TrafficLightObserver observer) {
        observers.remove(observer);
    }

    public void switchState(){
        System.out.println("calling switch state for traffic light "+ this.name);
        currentState.switchState(this);
        //called observer pattern, when ever state changes sensor observer will be called
        // notify observer
        observers.get(0).update(this.currentState.getStateName());
    }

    public void setCurrentState(TrafficLightState newState){
        this.currentState = newState;
    }

    public Signal getStateName(){
        return currentState.getStateName();
    }


    public TrafficLightState getCurrentState(){
        return currentState;
    }


}
