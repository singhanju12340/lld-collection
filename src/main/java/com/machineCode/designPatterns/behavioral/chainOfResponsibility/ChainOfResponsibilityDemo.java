package com.machineCode.designPatterns.behavioral.chainOfResponsibility;

/**
 * @author anju
 * @created on 12/02/25 and 7:33 PM
 */
public class ChainOfResponsibilityDemo {



    public static void main(String[] args) {
        AuthenticationHandler authenticationHandler = new AuthenticationHandler();
        CacheHandler cacheHandler = new CacheHandler();
        ValidationHandler validationHandler = new ValidationHandler();
        ProcessOrderHandler processOrderHandler = new ProcessOrderHandler();

        authenticationHandler.setNext(validationHandler);
        validationHandler.setNext(cacheHandler);
        cacheHandler.setNext(processOrderHandler);
        processOrderHandler.setNext(null);

        authenticationHandler.handle(new OrderRequest(" : for anju order"));

    }


}
