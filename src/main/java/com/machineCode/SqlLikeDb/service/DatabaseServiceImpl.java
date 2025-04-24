package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Database;
import com.machineCode.SqlLikeDb.model.Schema;
import com.machineCode.SqlLikeDb.model.Table;
import com.machineCode.SqlLikeDb.sqlExceptions.InvalidRequest;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 10:57 PM
 */
public class DatabaseServiceImpl implements DatabaseService{
    Database database;
    TableService tableService;

    public DatabaseServiceImpl(Database database){
        this.database = database;
    }

    public DatabaseServiceImpl(){

    }

    public void setDatabase(Database database){
        this.database = database;
    }




    @Override
    public boolean addTable(Table table) {
        if(database.getTableHashMap().containsKey(table.getName())){
            throw new InvalidRequest("Error while action: ADD_TABLE", "ADD_TABLE");
        }
        database.getTableHashMap().put(table.getName(), table);
        return true;
    }

    @Override
    public boolean deleteTable(String tableName) {

        Table table = database.getTableHashMap().get(tableName);
        tableService.emptyAllRecord();

        return true;
    }

    @Override
    public boolean dropTable(String tableName){
        database.getTableHashMap().remove(tableName);
        return true;
    }


    @Override
    public boolean editTable(String tableName, Schema updatedTableSchema) {
        return false;
    }

    @Override
    public List<Table> getAllTable() {
        return null;
    }

    public Table getTable(String name) {
        return database.getTableHashMap().get(name);
    }
}
