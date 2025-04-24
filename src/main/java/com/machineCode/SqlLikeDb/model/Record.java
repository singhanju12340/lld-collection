package com.machineCode.SqlLikeDb.model;

import com.machineCode.SqlLikeDb.model.constraint.Constraints;
import lombok.Data;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 9:59 PM
 */

@Data
public class Record {
    List<Column> columnList;
    String id;
}
