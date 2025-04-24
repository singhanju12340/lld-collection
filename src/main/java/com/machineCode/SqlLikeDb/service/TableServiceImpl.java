package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Column;
import com.machineCode.SqlLikeDb.model.Record;
import com.machineCode.SqlLikeDb.model.SqlIndex;
import com.machineCode.SqlLikeDb.model.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 11:04 PM
 */

@Data
public class TableServiceImpl implements TableService{
   Table table;

//   public TableServiceImpl(Table table){
//      this.table = table;
//   }

   public void setTable(Table table){
      this.table = table;
   }

   @Override
   public Table getTable() {
      return table;
   }

   public void addTable(Table table){
      this.table = table;
   }


   @Override
   public boolean insertRecord(Record record) {
      table.getRecords().put(record.getId(), record);
      //if anything fails return false and log exception
      return true;
   }

   @Override
   public boolean updateRecord(String recordId, Record record) {
      table.getRecords().put(recordId, record);
      return true;
   }

   @Override
   public boolean createIndex(SqlIndex index) {
      this.table.getIndices().add(index);
      return false;
   }

   @Override
   public List<Record> getAllRecord() {
      return new ArrayList<Record>(this.table.getRecords().values());
   }

   @Override
   public List<Column> readColumn(String recordId) {
      return this.table.getRecords().get(recordId).getColumnList();
   }

   @Override
   public boolean emptyAllRecord(){
      this.table.setRecords(new HashMap<>());
      return true;
   }

}
