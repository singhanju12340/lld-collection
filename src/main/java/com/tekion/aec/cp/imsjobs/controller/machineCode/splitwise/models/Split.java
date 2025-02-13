package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models;

import lombok.Data;

/**
 * @author anju
 * @created on 01/08/24 and 11:06 AM
 */

@Data
public class Split {

    String userId;
    double amount;

    Split(String userId, double amount){
        this.amount = amount;
        this.userId = userId;
    }
}
