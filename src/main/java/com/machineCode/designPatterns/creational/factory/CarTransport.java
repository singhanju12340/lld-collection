package com.machineCode.designPatterns.creational.factory;

/**
 * @author anju
 * @created on 25/02/25 and 12:21 PM
 */
public class CarTransport implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivery by car transport");
    }
}
