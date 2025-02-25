package com.machineCode.designPatterns.creational.prototype;

/**
 * @author anju
 * @created on 25/02/25 and 1:07 PM
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        House house = new House(2,3);
        house.addFeature("garden");
        house.addFeature("pool");

        House houseNew = house.deepClone();
        houseNew.addFeature("lawn");

        System.out.println(house.toString());

        System.out.println(houseNew.toString());


    }
}
