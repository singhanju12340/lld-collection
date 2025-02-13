package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.command;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.ExpenseDataManager;

/**
 * @author anju
 * @created on 01/08/24 and 4:55 PM
 */
public class ViewAllExpense extends SplitCommand {

    private static ViewAllExpense viewAllExpense;

    public static synchronized ViewAllExpense getInstance(){
        if(viewAllExpense == null)
        {
            viewAllExpense = new ViewAllExpense();
        }
        return viewAllExpense;
    }

    @Override
    public void execute(ExpenseDataManager manager, String[] inputs) {

    }

    @Override
    public boolean validate(String[] inputs) {
        return inputs.length == 1;
    }
}
