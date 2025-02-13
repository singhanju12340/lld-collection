package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.command;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.ExpenseDataManager;

/**
 * @author anju
 * @created on 01/08/24 and 4:48 PM
 */
public class ExitCommand extends SplitCommand {
    private static ExitCommand exitCommand;
    public static synchronized ExitCommand getInstance(){
        if(exitCommand == null){
            exitCommand = new ExitCommand();
        }
        return exitCommand;
    }

    public void execute(ExpenseDataManager manager, String[] inputs){
        System.out.println("Command execution is over");

    }

    @Override
    public boolean validate(String[] inputs) {
        // validate each index as string and int or double value based on the definition
        //Add_Expense Cable 100 1 1 3 Exact 1 2 3 40 50 10
        return true;
    }


}
