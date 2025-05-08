package com.machineCode.splitwise.services.strategy;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 05/05/25 and 3:06 PM
 */
public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> split(Expense expense) {
        double total = expense.getTotalAmount();
        List<Split> splitList = expense.getSplitList();
        int size = splitList.size();
        double amount = total / size;
        for (Split split : splitList) {
            split.setAmount(amount);
        }
        return splitList;
    }

    @Override
    public boolean validate(Expense expense) {
        return false;
    }
}
