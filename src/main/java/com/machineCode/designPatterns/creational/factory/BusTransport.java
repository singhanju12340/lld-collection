package com.machineCode.designPatterns.creational.factory;

/**
 * @author anju
 * @created on 25/02/25 and 12:22 PM
 */
public class BusTransport implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivery by bus transport");
    }
}
