package com.machineCode.splitwise.services;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;
import com.machineCode.splitwise.models.SplitType;

import java.util.List;
import java.util.Map;

import static com.machineCode.splitwise.models.SplitType.*;

/**
 * @author anju
 * @created on 02/08/24 and 12:44 PM
 */
public class SplitServiceFactory{
    private static SplitServiceFactory serviceFactory;

    public synchronized static SplitServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new SplitServiceFactory();
        }
        return serviceFactory;
    }

    private Map<SplitType, SplitService> splitServiceMap;

    SplitServiceFactory(){
        splitServiceMap.put(EQUAL, EqualSplitServiceImpl.getInstance());
        splitServiceMap.put(EXACT, ExactSplitServiceImpl.getInstance());
        splitServiceMap.put(PERCENT, PercentageSplitServiceImpl.getInstance());
    }

    public List<Split> execute(SplitType type, Expense expense) throws Exception {
        if(!splitServiceMap.containsKey(type))
            throw new Exception("Invalid split type");
        return splitServiceMap.get(type).split(expense);
    }



}
