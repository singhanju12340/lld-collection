package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:27 PM
 */
public class Orange implements CartItem{
    int price;
    String origin;

    public Orange(int price, String origin) {
        this.price = price;
        this.origin = origin;
    }

    @Override
    public void accept(CartVisitor visitor) {
        visitor.visit(this);
    }
}
