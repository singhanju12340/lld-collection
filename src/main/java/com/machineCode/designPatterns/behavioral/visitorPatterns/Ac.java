package com.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:27 PM
 */
public class Ac implements CartItem{
    int price;
    String brand;

    public Ac(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    @Override
    public void accept(CartVisitor visitor) {
        visitor.visit(this);
    }
}
