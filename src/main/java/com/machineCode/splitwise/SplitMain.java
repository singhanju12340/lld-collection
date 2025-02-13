package com.machineCode.splitwise;

import com.machineCode.splitwise.command.CommandFactory;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.command.*;
import com.machineCode.splitwise.models.CommandsKey;

import java.util.Scanner;

/**
 * @author anju
 * @created on 01/08/24 and 3:31 PM
 */
public class SplitMain {

    ExpenseDataManager expenseDataManager;

    public static void main(String[] args) {

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

        Scanner sc = new Scanner(System.in);
        System.out.println("enter expenses detail in above format or exit");

        ExpenseDataManager expenseDataManager = new ExpenseDataManager();
        while(true){
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")) return;
            String[] inputs = input.split(" ");
            CommandsKey command = CommandsKey.valueOf(inputs[0]);
            CommandFactory.getInstance().execute(expenseDataManager, inputs);
//            command1.execute(expenseDataManager, inputs);
        }

    }
}
