package com.machineCode.designPatterns.creational.singleton;

/**
 * @author anju
 * @created on 25/02/25 and 11:13 AM
 */
public class SingletonDemo {

    public static void main(String[] args) {
        DBConnectionSingleton instance = DBConnectionSingleton.getInstance();
        instance.accessDb();

        DBConnectionSingleton instance1 = DBConnectionSingleton.getInstance();
        instance1.accessDb();

    }
}
