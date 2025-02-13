package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.chainOfResponsibility;

/**
 * @author anju
 * @created on 12/02/25 and 7:18 PM
 */
public class ProcessOrderHandler extends Handler{

    @Override
    public void setNext(Handler handler) {
        super.nextHandler = handler;
    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println(" process order "+ request.name);
        if(this.nextHandler !=null)
             this.nextHandler.handle(request);
    }


}
