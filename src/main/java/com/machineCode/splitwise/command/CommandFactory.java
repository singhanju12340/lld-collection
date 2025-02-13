package com.machineCode.splitwise.command;

import com.machineCode.splitwise.ExpenseDataManager;

import java.util.Map;

import static com.machineCode.splitwise.models.CommandsKey.*;

/**
 * @author anju
 * @created on 01/08/24 and 7:22 PM
 */
public class CommandFactory extends SplitCommand{
    private static CommandFactory commandFactory;

    public static synchronized  CommandFactory getInstance(){
        if(commandFactory == null)
            commandFactory = new CommandFactory();
        return commandFactory;
    }

    private Map<String, SplitCommand> commandMap;

    CommandFactory(){
        commandMap.put(Add_User.name(), AddUser.getInstance());
        commandMap.put(Add_Expense.name(), AddExpense.getInstance());
        commandMap.put(Exit.name(), ExitCommand.getInstance());
        commandMap.put(Add_User.name(), AddUser.getInstance());
    }

    public Map<String, SplitCommand> getCommandMap(){
        return  commandMap;
    }

    @Override
    public void execute(ExpenseDataManager expenseDataManager, String[] inputs){
        if(!commandMap.containsKey(inputs[0]))
            throw new RuntimeException("Invalid command");
         commandMap.get(inputs[0]).execute(ExpenseDataManager.getInstance(), inputs);
    }



}
