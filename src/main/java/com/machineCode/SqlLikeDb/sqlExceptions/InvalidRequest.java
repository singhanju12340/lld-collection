package com.machineCode.SqlLikeDb.sqlExceptions;

/**
 * @author anju
 * @created on 19/04/25 and 8:16 PM
 */
public class InvalidRequest extends RuntimeException{
    String actionType;

    public InvalidRequest(String message, String actionType){
        super(message);
        this.actionType = actionType;
    }
}
