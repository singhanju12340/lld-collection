package com.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:55 PM
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        CartItem[] cartItems = new CartItem[]{
          new Ac(23000,"voltas"),
          new Orange(230, "nagpur")
        };

        CartVisitor visitor = new SeasonalPriceCalculatorVisitor();

        for (CartItem item: cartItems) {
            item.accept(visitor);
        }

    }
}
