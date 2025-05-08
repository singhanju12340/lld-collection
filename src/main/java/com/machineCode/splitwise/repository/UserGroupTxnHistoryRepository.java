package com.machineCode.splitwise.repository;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.UserGroupTxn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 05/05/25 and 3:33 PM
 */
public class UserGroupTxnHistoryRepository {
    Map<String, List<Expense>> userTxnHistoryMap = new HashMap<>(); // group id, txn lists


    public List<Expense> getGroupTxnHistoryMap(String groupId){
        //add custom filters and methods later
        return userTxnHistoryMap.get(groupId);
    }



    public void addGroupTxn(String groupId, Expense expense){
        //add custom filters and methods later
        List<Expense> existingExpences = userTxnHistoryMap.getOrDefault(groupId, new ArrayList<>());
        existingExpences.add(new Expense(expense));
         userTxnHistoryMap.put(groupId, existingExpences);
    }

}
