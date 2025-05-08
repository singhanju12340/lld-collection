package com.machineCode.splitwise;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.User;
import com.machineCode.splitwise.models.UserGroup;
import com.machineCode.splitwise.repository.UserGroupRepository;
import com.machineCode.splitwise.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author anju
 * @created on 01/08/24 and 3:33 PM
 */
public class ExpenseDataManager {

    private static ExpenseDataManager expenseDataManager;
    private static UserRepository userRepository;
    private static UserGroupRepository userGroupRepository;


    public synchronized static ExpenseDataManager getInstance(){
        if(expenseDataManager == null)
            expenseDataManager = new ExpenseDataManager();
        return expenseDataManager;
    }

    List<Expense> expenses;
    // userMap: userId to User

    public ExpenseDataManager() {
        this.expenses = new ArrayList<Expense>();
        userRepository = new UserRepository();
        userGroupRepository = new UserGroupRepository();
    }

    public static void loadUser(){
        userRepository.addUser(new User("user1", "anju"));
        userRepository.addUser(new User("user2", "manju"));
        userRepository.addUser(new User("user3", "sanju"));
    }

    public Set<UserGroup> getAllUserGroups(String userId){
        return userGroupRepository.getAllGroupOfUser(userId);
    }

}
