package com.machineCode.designPatterns.creational.abstractFactory;

/**
 * @author anju
 * @created on 25/02/25 and 12:43 PM
 */
public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
