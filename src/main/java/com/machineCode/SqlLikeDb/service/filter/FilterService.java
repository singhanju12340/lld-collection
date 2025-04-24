package com.machineCode.SqlLikeDb.service.filter;

/**
 * @author anju
 * @created on 17/04/25 and 10:46 PM
 */
public abstract class FilterService {
    public abstract boolean apply(Object filterValue, Object value);
}
