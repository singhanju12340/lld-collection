package com.machineCode.designPatterns.behavioral.strategyPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 2:08 PM
 */
public class RouteStrategyDemo {


    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        context.setCurrentStrategy(new TravelByBusStrategy());


        context.executeStrategy();

        context.setCurrentStrategy(new TravelByWalkStrategy());
        context.executeStrategy();


    }
}
