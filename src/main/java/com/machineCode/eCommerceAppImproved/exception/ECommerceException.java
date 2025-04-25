package com.machineCode.eCommerceAppImproved.exception;

import com.machineCode.eCommerceAppImproved.model.ErrorCode;
import lombok.Data;

/**
 * @author anju
 * @created on 23/04/25 and 7:27 PM
 */

@Data
public class ECommerceException extends RuntimeException{
    ErrorCode errorCode;
    String errorMessage;

    public ECommerceException(ErrorCode errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



}
