package com.machineCode.splitwise.models;

import lombok.Data;

import java.util.List;

/**
 * @author anju
 * @created on 01/08/24 and 11:03 AM
 */

@Data
public class Expense {
    String id;
    List<Split> splitList;
    Long date;
    String payId;
    double totalAmount;
    String label;
    SplitType type;
    String paidBy;
    String groupId;

    public Expense(){

    }

    public Expense(Expense expense){
        this.id = expense.id;
        this.splitList = expense.splitList;
        this.date = expense.date;
        this.payId = expense.payId;
        this.totalAmount = expense.totalAmount;
        this.label = expense.label;
        this.type = expense.type;
        this.paidBy = expense.paidBy;
        this.groupId = expense.groupId;
    }


}
