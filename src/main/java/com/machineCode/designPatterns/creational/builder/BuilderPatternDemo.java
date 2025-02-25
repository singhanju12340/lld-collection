package com.machineCode.designPatterns.creational.builder;

/**
 * @author anju
 * @created on 25/02/25 and 11:57 AM
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        House myHouse = new House.HouseBuilder()  // 3 rooms and 2 bathrooms are required
                .withRoom(2)
                .withBathRoom(3)
                .withGarage(true)
                .withGarden(true)
                .withSwimmingPool(false)
                .build();

        House myHouse2 = new House.HouseBuilder()  // 3 rooms and 2 bathrooms are required
                .withRoom(1)
                .withBathRoom(1)
                .withGarage(false)
                .withGarden(true)
                .withSwimmingPool(false)
                .build();


        System.out.println(myHouse);
        System.out.println(myHouse2);

    }
}
