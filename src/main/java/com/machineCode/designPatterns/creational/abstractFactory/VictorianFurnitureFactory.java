package com.machineCode.designPatterns.creational.abstractFactory;

/**
 * @author anju
 * @created on 25/02/25 and 12:42 PM
 */
public class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new VistorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
