package com.machineCode.designPatterns.creational.factory;

/**
 * @author anju
 * @created on 25/02/25 and 12:26 PM
 */
public class FactoryDemo {
    public static void main(String[] args) {
        // Get a Bus instance from the factory and use it.
        Transport bus = TransportFactory.getTransport("BUS");
        if (bus != null) {
            bus.deliver();
        }

        // Get a Car instance from the factory and use it.
        Transport car = TransportFactory.getTransport("CAR");
        if (car != null) {
            car.deliver();
        }
    }
}
