package com.machineCode.SqlLikeDb.model;

import com.machineCode.SqlLikeDb.Type;
import com.machineCode.SqlLikeDb.model.constraint.Constraints;

import java.util.List;

/**
 * @author anju
 * @created on 17/04/25 and 11:09 PM
 */
public class Column {
    String name;
    List<Constraints> constraints;
    Type type;


}
