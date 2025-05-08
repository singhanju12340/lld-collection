package com.machineCode.splitwise.services.strategy;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 05/05/25 and 3:14 PM
 */
public class ExactSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> split(Expense expense) {
        return null;
    }


    @Override
    public boolean validate(Expense expense) {
        double totalAmount=expense.getTotalAmount();
        double currentTotal = 0;
        for (Split split: expense.getSplitList()) {
            currentTotal =currentTotal + split.getAmount();
        }
        return (totalAmount==currentTotal);
    }
}
