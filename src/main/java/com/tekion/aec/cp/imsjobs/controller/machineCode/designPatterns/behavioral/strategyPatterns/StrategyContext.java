package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.strategyPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 2:05 PM
 */
public class StrategyContext {

    Strategy currentStrategy;


    public Strategy getCurrentStrategy() {
        return currentStrategy;
    }

    public void setCurrentStrategy(Strategy currentStrategy) {
        this.currentStrategy = currentStrategy;
    }

    public void executeStrategy(){
        currentStrategy.execute();
    }



}
