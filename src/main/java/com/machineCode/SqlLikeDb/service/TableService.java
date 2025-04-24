package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Column;
import com.machineCode.SqlLikeDb.model.Record;
import com.machineCode.SqlLikeDb.model.SqlIndex;
import com.machineCode.SqlLikeDb.model.Table;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 10:40 PM
 */
public interface TableService {

    public Table getTable();

    public void addTable(Table table);

    public boolean insertRecord(Record record);
    public boolean updateRecord(String recordId, Record record);
    public boolean createIndex(SqlIndex index);
    public List<Record> getAllRecord();

    public List<Column> readColumn(String recordId);
    public boolean emptyAllRecord();


}
