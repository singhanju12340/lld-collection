package com.machineCode.splitwise.services.strategy;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 05/05/25 and 3:01 PM
 */
public interface SplitStrategy {

    public List<Split> split(Expense expense);

    public boolean validate(Expense expense);

}
