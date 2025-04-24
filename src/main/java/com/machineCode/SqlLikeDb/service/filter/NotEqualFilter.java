package com.machineCode.SqlLikeDb.service.filter;

/**
 * @author anju
 * @created on 17/04/25 and 11:26 PM
 */
public class NotEqualFilter extends FilterService{
    @Override
    public boolean apply(Object filterValue, Object value) {
        return (!filterValue.equals(value)|| filterValue != value);
    }
}
