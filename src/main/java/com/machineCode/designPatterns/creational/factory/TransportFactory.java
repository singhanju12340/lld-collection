package com.machineCode.designPatterns.creational.factory;

/**
 * @author anju
 * @created on 25/02/25 and 12:23 PM
 */
public class TransportFactory {
    BusTransport busTransport;
    CarTransport carTransport;


    public static Transport getTransport(String type){
        switch (type){
            case "BUS" : return new BusTransport();
            case "CAR" : return new CarTransport();
            default:
                return new BusTransport();
        }

    }
}
