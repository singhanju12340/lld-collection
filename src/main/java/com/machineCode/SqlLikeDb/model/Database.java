package com.machineCode.SqlLikeDb.model;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

/**
 * @author anju
 * @created on 17/04/25 and 9:59 PM
 */

@Data
public class Database {
    private String name;
    private HashMap<String, Table> tableHashMap;
    private Date createdAt;

    public Database(String name) {
        this.name = name;
        this.tableHashMap = new HashMap<>();
        this.createdAt = new Date();
    }
}
