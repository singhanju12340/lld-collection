package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Database;
import com.machineCode.SqlLikeDb.model.Table;

import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 19/04/25 and 7:33 PM
 */
public class SqlService {
    Map<String,Database> databases;

    private static SqlService sqlService;

    DatabaseService databaseService;
    TableService tableService;

    public static SqlService getInstance(){
        if(null == sqlService)
        {
            sqlService = new SqlService();
        }
        return sqlService;
    }

    public void initiaseSql(String type){
        this.databaseService = new DatabaseServiceImpl();
        this.tableService = new TableServiceImpl();

    }




    public void addDatabase(Database database){
        databases.put(database.getName(), database);
    }

    public Database getDatabase(String dbName) throws Exception {
        Database database = databases.get(dbName);
        if(database==null){
            throw new Exception("Db does not exist");
        }
        return database;
    }

    public void addTable(String dbName, Table table) throws Exception {
        Database database = databases.get(dbName);
        if(database==null){
            throw new Exception("Db does not exist");
        }
        database.getTableHashMap().put(table.getName(), table);
    }




}
