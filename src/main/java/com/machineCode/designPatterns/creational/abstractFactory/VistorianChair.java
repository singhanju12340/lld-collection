package com.machineCode.designPatterns.creational.abstractFactory;

/**
 * @author anju
 * @created on 25/02/25 and 12:40 PM
 */
public class VistorianChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("sit on VictorianChair");

    }
}
