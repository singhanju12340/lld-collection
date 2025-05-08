package com.machineCode.splitwise.services.strategy;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 05/05/25 and 3:11 PM
 */
public class DefaultSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> split(Expense expense) {
        return null;
    }

    @Override
    public boolean validate(Expense expense) {
        return false;
    }
}
