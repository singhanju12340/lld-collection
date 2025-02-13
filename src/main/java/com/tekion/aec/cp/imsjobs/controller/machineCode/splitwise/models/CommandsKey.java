package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models;

/**
 * @author anju
 * @created on 01/08/24 and 5:07 PM
 */
public enum CommandsKey {
    Add_User,
    Add_Expense,
    Show_All_User_Balance,
    Show_User_Data,
    Exit,
    Show_User_Expense;

    public CommandsKey getCommand(String key){
        return CommandsKey.valueOf(key);
    }
}
