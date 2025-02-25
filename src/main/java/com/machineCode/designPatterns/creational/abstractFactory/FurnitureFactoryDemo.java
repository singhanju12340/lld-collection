package com.machineCode.designPatterns.creational.abstractFactory;

/**
 * @author anju
 * @created on 25/02/25 and 12:45 PM
 */
public class FurnitureFactoryDemo {
    public static void main(String[] args) {
        FurnitureFactory factory = FurnitureFactoryDemo.getFactory("Victorian");
        factory.createChair().sitOn();

        FurnitureFactory factory2 = FurnitureFactoryDemo.getFactory("Modern");
        factory.createSofa().lieOn();
    }

    public static FurnitureFactory getFactory(String style){
        if ("Victorian".equalsIgnoreCase(style)) {
            return new VictorianFurnitureFactory();
        } else if ("Modern".equalsIgnoreCase(style)) {
            return new ModernFurnitureFactory();
        } else {
            System.out.println("Unknown furniture style: " + style);
            return null;
        }
    }
}
