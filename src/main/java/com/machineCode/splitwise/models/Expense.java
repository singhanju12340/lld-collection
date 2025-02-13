package com.machineCode.splitwise.models;

import lombok.Data;

import java.util.List;

/**
 * @author anju
 * @created on 01/08/24 and 11:03 AM
 */

@Data
public class Expense {
    List<Split> splitList;
    Long date;
    String payId;
    double totalAmount;
    String label;
    SplitType type;

}
