package com.machineCode.designPatterns.behavioral.strategyPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 2:03 PM
 */
public class TravelByWalkStrategy implements Strategy{

    @Override
    public void execute() {
        System.out.println("TravelByWalkStrategy getting executed");
    }
}
