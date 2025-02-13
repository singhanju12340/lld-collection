package com.machineCode.designPatterns.behavioral.chainOfResponsibility;

/**
 * @author anju
 * @created on 12/02/25 and 7:16 PM
 */
public class CacheHandler extends Handler{

    @Override
    public void setNext(Handler handler) {
        super.nextHandler = handler;

    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println(" check if request is cached "+ request.name);
        if(this.nextHandler !=null)
            this.nextHandler.handle(request);    }
}
