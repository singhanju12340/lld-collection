package com.machineCode.SqlLikeDb.model.constraint;

/**
 * @author anju
 * @created on 17/04/25 and 11:17 PM
 */
public class IntegerConstraints implements Constraints{
    @Override
    public boolean validate(Object object) {
        return object.getClass().equals(Integer.class) && (int)(object) <=1024 && (int)(object) >=-1024;
    }
}
