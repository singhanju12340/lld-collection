package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:55 PM
 */
public interface CartItem {
    void accept(CartVisitor visitor);
}
