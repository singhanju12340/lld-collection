package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.command;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.ExpenseDataManager;

/**
 * @author anju
 * @created on 01/08/24 and 4:48 PM
 */
public class ViewUserExpense extends SplitCommand {
    private static ViewUserExpense viewUserExpense;


    // Singleton class
    public static synchronized ViewUserExpense getInstance(ViewUserExpense viewUserExpense){
        if(viewUserExpense == null)
             viewUserExpense = new ViewUserExpense();
        return viewUserExpense;
    }

    public void execute(ExpenseDataManager manager, String[] inputs){

    }

    @Override
    public boolean validate(String[] inputs) {
        return inputs.length == 2;
    }


}
