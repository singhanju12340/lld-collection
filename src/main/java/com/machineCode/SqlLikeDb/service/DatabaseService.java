package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Database;
import com.machineCode.SqlLikeDb.model.Schema;
import com.machineCode.SqlLikeDb.model.Table;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 10:42 PM
 */
public interface DatabaseService {


    public void setDatabase(Database database);
    public boolean addTable(Table table);
    public boolean deleteTable(String tableName);
    public boolean dropTable(String tableName);

    public boolean editTable(String tableName, Schema updatedTableSchema);
    public List<Table> getAllTable();
    public Table getTable(String name);

}
