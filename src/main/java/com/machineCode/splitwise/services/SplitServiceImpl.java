package com.machineCode.splitwise.services;

import com.machineCode.splitwise.ExpenseDataManager;
import com.machineCode.splitwise.Util;
import com.machineCode.splitwise.dto.GroupDetail;
import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;
import com.machineCode.splitwise.models.UserGroup;
import com.machineCode.splitwise.services.strategy.SplitFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author anju
 * @created on 05/05/25 and 3:07 PM
 */
public class SplitServiceImpl implements SplitService{
    private SplitFactory factory;
    private GroupTxnService groupTxnService;
    private Util util;


    public SplitServiceImpl(){
            factory = new SplitFactory();
            ExpenseDataManager.loadUser();
            groupTxnService = new GroupTxnService();
            util = new Util(groupTxnService);

    }



    @Override
    public List<Split> split(Expense expense) {
        if(factory.getStrategy(expense.getType()).validate(expense)){
            List<Split> splits = factory.getStrategy(expense.getType()).split(expense);
            expense.setSplitList(splits); // set split in group
            groupTxnService.addExpenceToGroup(expense, expense.getGroupId()); // add expences to group
            // update user due and balances as per current split via syncronised
        }
        return null;
    }

    @Override
    public Set<GroupDetail> getUserProfile(String userId) {
        // fetch user all group and overall balance
        return util.createGroupDetails(userId);
    }



    @Override
    public List<Expense> getUserGroupExpenseList(String userId, String groupId) {
        // fetch all txn of a user and group
        List<Expense> allGroupExpences = groupTxnService.getUserGroupTxn(groupId);
        return allGroupExpences;
    }

}
