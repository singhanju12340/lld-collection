package com.machineCode.designPatterns.behavioral.chainOfResponsibility;

/**
 * @author anju
 * @created on 12/02/25 and 7:16 PM
 */
public class AuthenticationHandler extends Handler{


    @Override
    public void handle(OrderRequest request) {
        System.out.println("authenticate request "+ request.name);
        if(this.nextHandler !=null)
            this.nextHandler.handle(request);    }


}
