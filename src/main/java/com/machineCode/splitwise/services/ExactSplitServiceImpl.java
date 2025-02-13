package com.machineCode.splitwise.services;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 31/07/24 and 7:33 PM
 */

public class ExactSplitServiceImpl implements SplitService{

    private static ExactSplitServiceImpl exactSplitService;
    public synchronized static ExactSplitServiceImpl getInstance(){
        if(exactSplitService == null)
            exactSplitService = new ExactSplitServiceImpl();
        return exactSplitService;
    }

    @Override
    public List<Split> split(Expense expense) {
        // split given amount equally
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
