package com.machineCode.splitwise.services;

import com.machineCode.splitwise.dto.GroupDetail;
import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;
import com.machineCode.splitwise.models.UserGroup;

import java.util.List;
import java.util.Set;

/**
 * @author anju
 * @created on 31/07/24 and 6:31 PM
 */

public interface SplitService {

    public List<Split> split(Expense expense);

    public Set<GroupDetail> getUserProfile(String userId);

    public List<Expense> getUserGroupExpenseList(String userId, String groupId);


}
