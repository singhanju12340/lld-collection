package com.machineCode.splitwise.services;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.UserGroup;
import com.machineCode.splitwise.repository.UserGroupRepository;
import com.machineCode.splitwise.repository.UserGroupTxnHistoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anju
 * @created on 05/05/25 and 7:16 PM
 */
public class GroupTxnService {
    private static UserGroupTxnHistoryRepository repository;
    private static UserGroupRepository groupRepository;

    public void addExpenceToGroup(Expense expense, String groupId){
        repository.addGroupTxn(groupId, expense);
    }

    public UserGroup getUserGroup(String groupId){
        return groupRepository.getGroupOfUser(groupId);
    }

    public List<Expense> getUserGroupTxn(String groupId){
        return repository.getGroupTxnHistoryMap(groupId);
    }

    public Map<String, List<Expense>> getUserGroupsTxn(String userId){
        Set<UserGroup> userGroups = groupRepository.getAllGroupOfUser(userId);
        Map<String, List<Expense>> result = new HashMap<>();
        for (UserGroup userGroup :userGroups) {
            result.put(userGroup.getId(), getUserGroupTxn(userGroup.getId()));
        }
        return result;
    }

}
