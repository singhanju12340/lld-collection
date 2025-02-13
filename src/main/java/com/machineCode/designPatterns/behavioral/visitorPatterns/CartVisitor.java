package com.machineCode.designPatterns.behavioral.visitorPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 4:26 PM
 */
public interface CartVisitor {
    void visit(Ac ac);
    void visit(Orange orange);
}
