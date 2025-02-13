package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.services;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.Expense;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.Split;

import java.util.List;

/**
 * @author anju
 * @created on 31/07/24 and 6:31 PM
 */

public interface SplitService {

    public List<Split> split(Expense expense);

    public boolean validate(Expense expense);

}
