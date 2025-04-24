package com.machineCode.SqlLikeDb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 17/04/25 and 9:58 PM
 */

@Data
public class Table {
    Map<String, Record> records;

    Schema schema;
    List<SqlIndex> indices;
    String name;


    public Table(Map<String, Record> records, Schema schema, List<SqlIndex> indices, String name) {
        this.records = records;
        this.schema = schema;
        this.indices = indices;
        this.name = name;
    }

    public Table( Schema schema, String name) {
        this.records = new HashMap<>();
        this.schema = schema;
        this.indices = new ArrayList<>();
        this.name = name;
    }


}
