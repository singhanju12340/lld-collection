package com.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:28 PM
 */
public class SeasonalPriceCalculatorVisitor implements CartVisitor{


    @Override
    public void visit(Ac ac) {
        System.out.println(" calculate seasonal pricing for ac brand "+ ac.brand);
    }

    @Override
    public void visit(Orange orange) {
        System.out.println("calculate seasonal pricing for orange belonging from "+ orange.origin);
    }
}
