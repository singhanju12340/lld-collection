package com.machineCode.splitwise.models;

import lombok.Data;

/**
 * @author anju
 * @created on 01/08/24 and 11:06 AM
 */

@Data
public class Split {

    String userId;
    double amount;

    public Split(String userId){
        this.amount = 0.0;
        this.userId = userId;
    }

    Split(String userId, double amount){
        this.amount = amount;
        this.userId = userId;
    }
}
