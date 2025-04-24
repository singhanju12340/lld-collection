package com.machineCode.SqlLikeDb.service.filter;

import org.springframework.context.annotation.FilterType;

/**
 * @author anju
 * @created on 17/04/25 and 11:24 PM
 */
public class EqualFilter extends FilterService{
    FilterType type;
    @Override
    public boolean apply(Object filterValue, Object value) {
        return (filterValue.equals(value)|| filterValue == value);
    }
}
