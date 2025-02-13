package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.Expense;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 01/08/24 and 3:33 PM
 */
public class ExpenseDataManager {

    private static ExpenseDataManager expenseDataManager;

    public synchronized static ExpenseDataManager getInstance(){
        if(expenseDataManager == null)
            expenseDataManager = new ExpenseDataManager();
        return expenseDataManager;
    }

    List<Expense> expenses;
    // userMap: userId to User
    Map<String, User> userMap;
    Map<User, Map<User, Double>> balanceSheet;

    public ExpenseDataManager() {
        this.expenses = new ArrayList<Expense>();
        this.userMap = new HashMap<String, User>();
        this.balanceSheet = new HashMap<User, Map<User, Double>>();
    }


    public void addExpense(){

    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
    }

    public void showBalanceSheetForUser(){

    }
}
