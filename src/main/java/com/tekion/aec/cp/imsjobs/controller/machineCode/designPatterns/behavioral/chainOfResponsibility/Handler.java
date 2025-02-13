package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.chainOfResponsibility;

/**
 * @author anju
 * @created on 12/02/25 and 7:15 PM
 */
public abstract class Handler {
    Handler nextHandler;

    public void setNext(Handler handler){
        this.nextHandler = handler;
    }

    public abstract void handle(OrderRequest request);

}
