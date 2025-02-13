package com.machineCode.splitwise.services;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 31/07/24 and 7:33 PM
 */
public class PercentageSplitServiceImpl implements SplitService{

    private static PercentageSplitServiceImpl percentageSplitService;
    public  static synchronized PercentageSplitServiceImpl getInstance(){
        if(percentageSplitService == null)
            percentageSplitService = new PercentageSplitServiceImpl();
        return percentageSplitService;
    }

    @Override
    public List<Split> split(Expense expense) {
        // split given amount equally
        return null;
    }

    @Override
    public boolean validate(Expense expense) {
        double totalPercentage=0;
        for (Split split: expense.getSplitList()) {
            totalPercentage =totalPercentage + split.getAmount();
        }
        return (totalPercentage==100);
    }
}
