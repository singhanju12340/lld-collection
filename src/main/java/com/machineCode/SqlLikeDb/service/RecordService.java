package com.machineCode.SqlLikeDb.service;

import com.machineCode.SqlLikeDb.model.Column;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 10:45 PM
 */

@Deprecated
public interface RecordService {

    public void updateColumn(List<Column> columns);

    public void getAllColumn();


}
