package com.machineCode.designPatterns.creational.singleton;

/**
 * @author anju
 * @created on 25/02/25 and 11:10 AM
 */
public class DBConnectionSingleton {
    private static DBConnectionSingleton dbConnectionSingleton;

    private DBConnectionSingleton(){

    }

    public static DBConnectionSingleton getInstance(){
        if(dbConnectionSingleton == null){
            dbConnectionSingleton = new DBConnectionSingleton();
        }
        return dbConnectionSingleton;
    }

    public void accessDb(){
        System.out.println("DB access" + dbConnectionSingleton);
    }

}
