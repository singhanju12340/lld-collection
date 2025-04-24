package com.machineCode.ticTacToe.service.gameStrategy;

import com.machineCode.ticTacToe.service.ComputerStrategy;

/**
 * @author anju
 * @created on 17/04/25 and 9:08 PM
 */
public class ComputerStrategyFactory {
    RandomComputerStrategy randomComputerStrategy;
    CustomStrategy customStrategy;

    public ComputerStrategy getStrategy(String type){
        switch (type){
            case "RANDOM":
                return randomComputerStrategy;
            case "CUSTOM":
                return customStrategy;
            default:
                System.out.println("no matching strategy");
                return null;
        }
    }
}
