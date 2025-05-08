package com.machineCode.splitwise.services.strategy;

import com.machineCode.splitwise.models.SplitType;

/**
 * @author anju
 * @created on 05/05/25 and 3:08 PM
 */
public class SplitFactory {
    private SplitStrategy splitStrategy;

    public SplitStrategy getStrategy(SplitType splitType){
        switch (splitType){
            case EQUAL:
                return new EqualSplitStrategy();
            default: return new DefaultSplitStrategy();
        }
    }

}
