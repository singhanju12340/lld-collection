package com.machineCode.splitwise;

import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.Split;
import com.machineCode.splitwise.models.SplitType;
import com.machineCode.splitwise.services.SplitService;
import com.machineCode.splitwise.services.SplitServiceImpl;

import java.util.List;

/**
 * @author anju
 * @created on 05/05/25 and 3:39 PM
 */
public class SplitDriver {

    // create users
    // create group
    // 1 user add/modify expenses to group of people with equal/percentage/exact split values
    //
//        Add_User goofie goofie@goofie.com 444
//        Add_Expense Food 200 1 1 3 Equal 1 2 3
//        Add_Expense Cable 100 1 1 3 Exact 1 2 3 40 50 10
//        Add_Expense Hotels 400 4 4 3 Percent 2 3 4 30 50 20
//        Show_All_User_Balance
//        Show_User_Data 2
//        Show_User_Expense 1

//        Add User:
//        (Input Format): Add_User [Name] [Email] [PhoneNumber]
//
//        Add Equal Expense to User Account:
//        (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Equal [User 1 Id] [User 2 Id] ........[User totalUsers Id]
//
//        Add Exact Expense to User Account:
//        (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Exact [User 1 Id] [User 2 Id] ........[User totalUsers Id] [Amount Paid by User 1] [Amount Paid by User 2] ......
//
//        Add Percent Expense to User Account:
//        (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Percent [User 1 Id] [User 2 Id] ........[User totalUsers Id] [Percent Share by User 1] [Percent Share by User 2] .....

    private static Expense createExp1(){
        Expense expense = new Expense();
        expense.setGroupId("group1");
        expense.setId("1");
        expense.setPaidBy("user1");
        expense.setType(SplitType.EQUAL);
        expense.setTotalAmount(1000);
        List<Split> splits = List.of(new Split("user1"), new Split("user2"), new Split("user3"));
        expense.setSplitList(splits);
        return expense;
    }



    public static void main(String[] args) {
        SplitService splitService = new SplitServiceImpl();

        Expense expense = createExp1();
        splitService.split(expense);
        // expense 2
        Expense expense2 = new Expense(expense);
        expense2.setTotalAmount(2000);
        splitService.split(expense2);

        System.out.println(splitService.getUserProfile("1"));

    }
}
