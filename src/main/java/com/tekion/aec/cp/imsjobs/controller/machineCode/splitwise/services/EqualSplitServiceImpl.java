package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.services;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.Expense;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 31/07/24 and 7:33 PM
 */
public class EqualSplitServiceImpl implements SplitService{
    private static EqualSplitServiceImpl equalSplitService;

    public synchronized static EqualSplitServiceImpl getInstance(){
        if(equalSplitService == null){
            equalSplitService = new EqualSplitServiceImpl();
        }
        return equalSplitService;
    }


    @Override
    public List<Split> split(Expense expense) {
        // split given amount equally
        return null;
    }

    @Override
    public boolean validate(Expense expense) {
        return true;
    }
}
