package com.machineCode.designPatterns.structural.facade;

/**
 * @author anju
 * @created on 25/02/25 and 1:56 PM
 */
public class FacadeDemo {

    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("ACC123", "PROD456", 2, 99.99, "123 Main St, City, Country");
    }
}
