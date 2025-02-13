package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.strategyPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 1:44 PM
 */
public class TravelByBusStrategy implements Strategy{

    @Override
    public void execute() {
        System.out.println("TravelByBusStrategy getting executed");
    }
}
